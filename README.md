# ASIGOCore
It stands for "A SImple Game Of Cards."

## What is ASIGOCore?
**ASIGOCore** is meant to serve as the backend for an **ASIGOC** simulator (the C can be silent if you don't like ending with a consonant). **ASIGOC** is a Trading Card Game (similar in style to the *Yu-Gi-Oh! Trading Card Game*) that I made as part of the writing process for **The Many Mysteries of the Land Called Shazehi**, a novel that I wrote some time ago. 

Other Trading Card Games have "simulators," which are programs that serve as tools which accurately replicate the rules of the game, so that you can play the game without owning physical cards and without having to worry about potentially breaking the rules. Such simulators typically have a visual frontend, where the player chooses what cards they want to play, for example, as well as a backend, which controls the rules and logic of the card game itself. **ASIGOCore** is that backend. 

## What are the rules of ASIGOC?
Many of these rules are subject to change (especially as more playtesting occurs), but here are the rules as they stand now. 

### Deckbuilding rules
**ASIGOC** decks are made of exactly 15 cards, with no repeats allowed (that is, you cannot have more than one copy of the same card in your deck). In addition, each player chooses one Ace card (this card does not contribute to the 15 card deck target), which is separated from the deck and placed in the Ace zone at the start of the game. 

### Primary game loop
I'll finish this later