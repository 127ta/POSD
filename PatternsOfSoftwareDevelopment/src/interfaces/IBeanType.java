package interfaces;

import java.util.List;

import bohnanza.BeanometerEntry;
public interface IBeanType {
	
	public List<BeanometerEntry> getBeanometer();
	public String getName();
	public int getAmountInDeck();
	
}
