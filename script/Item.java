public abstract class Item extends Card {

	protected boolean activationCondition;
	//protected boolean activationCondition = (GameManager.Phase == "main" && GameManager.Turn == controller);

	protected void activatedEffect() {
		//Empty by default
	}
	
}
