package interfaces;

import bohnanza.BeanometerEntry;

public interface IBeanType {
	
	public BeanometerEntry[] getBeanometer();
	public String getName();
	public int getAmountInDeck();
	
}
