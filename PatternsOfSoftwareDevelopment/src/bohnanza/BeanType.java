package bohnanza;
import interfaces.IBeanType;

public class BeanType implements IBeanType {
	//COFFEE, WAX, BLUE, CHILLI, STINK, GREEN, SOY, BLACKEYED, RED, GARDEN, COCOA
	private String name;
	private BeanometerEntry[] beanometerValues;
	private int amountInDeck;
	
	public BeanType(String _name, BeanometerEntry[] beanometerValues, int amountInDeck){
		this.name = _name;
		this.beanometerValues = beanometerValues;
		this.amountInDeck = amountInDeck;
	}
	
	public BeanometerEntry[] getBeanometer(){
		return beanometerValues;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAmountInDeck(){
		return amountInDeck;
	}
}