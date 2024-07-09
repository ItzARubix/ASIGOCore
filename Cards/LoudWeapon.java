package Cards;

public abstract class LoudWeapon extends Weapon {

    public abstract String name;
	public abstract int attackVal;
	public abstract int blockVal;

	//fieldCondition, activatedEffectCondition, and activatedEffect() are all inherited from Weapon.
	//Any LoudWeapons will be allowed to change those to fit the card's needs.

    public void onEnteredEffect() {

	}
	/*
	When a player chooses to play their one Weapon per turn, that Weapon is moved from hand to field.
	As established, this action does not go into the Outlet, because it isn't an effect.
	However, some Weapons have effects that go to the Outlet when the Weapon is played in this way.
	This function, onEnteredEffect(), is that effect.
	Not all Weapons have an effect like this, so by default, this method is blank.
	*/

}
