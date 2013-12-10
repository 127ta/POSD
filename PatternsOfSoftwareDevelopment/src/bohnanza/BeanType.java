package bohnanza;
import java.util.List;

import interfaces.IBeanType;

public class BeanType implements IBeanType {
	//COFFEE, WAX, BLUE, CHILLI, STINK, GREEN, SOY, BLACKEYED, RED, GARDEN, COCOA
	private String name;
	private List<BeanometerEntry> beanometerValues;
	private int amountInDeck;
	
	public BeanType(String _name, List<BeanometerEntry> beanometerValues, int amountInDeck){
		this.name = _name;
		this.beanometerValues = beanometerValues;
		this.amountInDeck = amountInDeck;
	}
	
	public List<BeanometerEntry> getBeanometer(){
		return beanometerValues;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAmountInDeck(){
		return amountInDeck;
	}
}