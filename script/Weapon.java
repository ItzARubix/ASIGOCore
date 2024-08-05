public class Weapon extends Card {

	protected int attackVal;
	protected int blockVal;

	protected boolean fieldCondition = true;
	/*
	This bool, fieldCondition, determines when this Weapon is allowed to be moved from hand to field.
	By default, it's always true. 

	As per the game rules, once per turn, during the Main Step, 
	the turn player can move a Weapon from their hand to one of their Weapon Slots on the field. 
	This game action does not get added to the Outlet, as it is not an effect.
	This bool, fieldCondition, is checked when the player attempts to perform this game action.
	This is because some Weapons have conditions that must be met in order for them to be played.
	*/

	protected void onEnteredEffect() {

	}
	/*
	When a player chooses to play their one Weapon per turn, that Weapon is moved from hand to field.
	As established, this action does not go into the Outlet, because it isn't an effect.
	However, some Weapons have effects that go to the Outlet when the Weapon is played in this way.
	This function, onEnteredEffect(), is that effect.
	Not all Weapons have an effect like this, so by default, this method is blank.
	*/

}
