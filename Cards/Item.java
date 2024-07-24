package Cards;

public abstract class Item extends Card {

	public String name;
	public String controller;

	public boolean activationCondition;
	//public boolean activationCondition = (GameManager.Phase == "main" && GameManager.Turn == controller);
	
	
}
