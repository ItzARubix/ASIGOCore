package Cards;

public abstract class Weapon extends Card {

	public abstract String name;
	public abstract int attackVal;
	public abstract int blockVal;

	public boolean fieldCondition = true;
	/*
	This bool, fieldCondition, determines when this Weapon is allowed to be moved from hand to field.
	By default, it's always true. 

	As per the game rules, once per turn, during the Main Step, 
	the turn player can move a Weapon from their hand to one of their Weapon Slots on the field. 
	This game action does not get added to the Outlet, as it is not an effect.
	This bool, fieldCondition, is checked when the player attempts to perform this game action.
	This is because some Weapons have conditions that must be met in order for them to be played
	*/

	public boolean activatedEffectCondition = false;
	//If a Weapon has an activated effect, the activation condition would be checked here. 

	public void activatedEffect() {

	}
	//You know the drill. This effect goes in the Outlet. 

}
