# ASIGOCore
It stands for "A SImple Game Of Cards."

## Before getting into the nitty-gritty...
Two things:
1. If any of these rules don't make sense to you, or you otherwise have any questions, please feel free to open an Issue. I will do my best to answer them as best as I can
2. This project had code previously and I decided to do a full wipe of all the code. I was using Java to create this project, but after a while it became evident that Java was not well suited for this project. I will begin working on this project again once I feel more comfortable with Ruby. Until then, you're still welcome to try to contribute (either by asking for rules clarifications in Issues or even attempting to use the vague paragraph of rules that I've given here to try to write some code, though I can't recommend that second one in good faith when I haven't even done it myself. You can also expand on the rules if you'd like; right now they are pretty bare-bones and don't account for a lot of the interactions that I envision, so feel free to open Pull Requests if you'd like)

## What is ASIGOCore?
**ASIGOCore** is meant to serve as the backend for an **ASIGOC** simulator (the C can be silent if you don't like ending with a consonant). **ASIGOC** is a Trading Card Game (similar in style to the *Yu-Gi-Oh! Trading Card Game*) that I made as part of the writing process for **The Many Mysteries of the Land Called Shazehi**, a novel that I wrote some time ago. 

Other Trading Card Games have "simulators," which are programs that serve as tools which accurately replicate the rules of the game, so that you can play the game without owning physical cards and without having to worry about potentially breaking the rules. Such simulators typically have a visual frontend, where the player chooses what cards they want to play, for example, as well as a backend, which controls the rules and logic of the card game itself. **ASIGOCore** is that backend. 

## What are the rules of ASIGOC?
Many of these rules are subject to change (especially as more playtesting occurs), but here are the rules as they stand now. 

### Deckbuilding rules
**ASIGOC** decks are made of exactly 15 cards, with no repeats allowed (that is, you cannot have more than one copy of the same card in your deck). In addition, each player chooses one Ace card (this card does not contribute to the 15 card deck target), which is separated from the deck and placed in the Ace zone at the start of the game. 

### General Information
The game is played between two players, each of whom has a deck that follows the above specifications.  

There are three types of cards: Weapons, Items, and Aces. Weapons and Items make up each individual's deck, and in addition each player has one Ace that sits outside of your deck in its own special Ace Zone, as mentioned above. 

The turn structure is as follows:

1. Draw step
2. Main step
3. Battle step
4. End step

The first player skips their first Battle step. 

#### Starting the game
Each player starts with 10 health. When a player's health drops to 0, that player loses the game.

At the start of the game, each player takes their Ace and places it in the Ace zone (as mentioned above) and then shuffles their 15 card deck. From there, each player draws four cards.

#### Draw step
At the start of the Draw step, the turn player draws a card. 

#### Main step
Most of the action occurs in the Main step.

Each player has two Weapon slots on the field, and each turn, during the Main step, the turn player may move a Weapon from their hand to one of their Weapon slots, or they may take a Weapon currently in one of their Weapon slots and return it to their hand. 

Items have an activation condition directly on the card, but by default, this activation condition is that it is the turn player's Main step (and that the Outlet is empty, we'll get to that in a second). Whenever an Item's activation condition is met and its controller has priority (we'll get to that too), the controller declares that they are using the Item and sends it to their discard pile, and the effect that is written on the card occurs. 

#### Battle step
Each Weapon has an Attack value and a Block value, both of which are relevant during the Battle step. The turn player first chooses a Weapon to attack with, and the opponent chooses if they want to block. If they don't block, they take damage equal to the attack value of the attacking Weapon. If they do block, they must choose which of their Weapons to block with. If they block with a Weapon that has a Block value equal to or greater than the Attack value of the attacking Weapon, they take no damage, and the Block value of the blocking Weapon is permanently decreased by 1. If they block with a Weapon that has a Block value lower than the Attack value of the attacking Weapon, the blocking Weapon is sent to the discard pile and the defending player takes damage equal to the difference between the Attack value of the attacking Weapon and the Block value of the blocking Weapon. 

The turn player may attack with any number of Weapons, and does so one at a time (attack with first weapon is declared -> opponent chooses to block or take it -> damage is calculated and Weapon is destroyed if necessary -> turn player may choose to attack with second Weapon if they can and want to. Otherwise, they pass)

#### End step
The turn player declares that they are ending their turn and the other player begins from the Draw step again. 

### Advanced rules
Although the primary game loop is meant to be relatively straightforward, the game itself is a little bit more complicated than this list would let on. 

#### The Outlet
The Outlet is my implementation of the Chain (from the _Yu-Gi-Oh! Trading Card Game_) into **ASIGOC**. The Outlet is where effects go before they occur. Specifically:
1. On activation of an Item, Ace, or the activated effect of a Weapon, the effect that is written on the card is added to the Outlet
2. Whenever a Weapon is moved onto the field from the hand, an effect is added to the Outlet. For Weapons that have an "On entered effect" written on them, that effect is the one that is added to the Outlet, and for all other Weapons, a blank effect is added to the Outlet (meaning that nothing will occur on resolution).

Once no more effects are being added to the Outlet, resolution occurs, meaning that all effects that are currently in the Outlet occur in the reverse order that they were added. If an effect in the Outlet is nullified (there are certain cards which nullify effects that are currently in the Outlet) then that effect does not occur when it is reached as the Outlet is being resolved. 

Effects cannot be added to the Outlet once it starts resolving, until it is completely empty. 

#### Priority
This one's pretty simple: Whenever an effect is added to the Outlet, the player who did not add that effect has priority when adding the next effect. If they have no effects that they wish to add, they pass priority to the other player, and once both players pass, the Outlet resolves. 

Whenever the turn player wishes to move to the next step, they must also first pass priority to their opponent, who may activate effects. If they choose not to activate effects, the game moves onto the next step, but if they do activate an effect, the standard Outlet rules apply, and after resolution, we do NOT move onto the next step. Instead, the turn player now remains in the original step and may take more actions if they'd like. If they wish to move onto the next step, the entire process repeats itself. 
