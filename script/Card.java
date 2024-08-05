public abstract class Card {

    protected String name;
    protected String controller;
    protected boolean activationCondition;

    protected void activatedEffect() {
        //Weapons, Items, and Aces all have activated effects
        //This effect can be activated as long as this.activationCondition is true
        //Despite this, activationCondition will not be checked here, it'll be checked elsewhere. 
    }

}
