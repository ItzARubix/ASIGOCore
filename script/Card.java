public abstract class Card {

    protected String name;
    protected String controller;
    protected boolean activationCondition;

    protected void activatedEffect() {
        //Weapons, Items, and Aces all have activated effects
        //This effect can be activated as long as this.activationCondition is true
        if(!this.activationCondition) {
            System.out.println("Cannot be activated (condition not met)");
        } else {
            //I'll figure it out lol
        }
    }

}
