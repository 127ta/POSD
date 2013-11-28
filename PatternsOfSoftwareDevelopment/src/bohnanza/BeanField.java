package bohnanza;
import bohnanza.BeanType;
public class BeanField extends Pile {

	private BeanType type;

	public int getHarvestValue() {
		return 0;
	}

	public BeanType getBeanType() {
		return type;
	}
	
	public void push(Card card) {
		listOfCards.add(card);
		if(listOfCards.size() == 1){
			type = card.getBeanType();
		}
	}

}