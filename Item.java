public abstract class Item extends Card {

	public boolean activationCondition;
	//public boolean activationCondition = (GameManager.Phase == "main" && GameManager.Turn == controller);

	public void activatedEffect() {
		//Empty by default
	}
	
}
