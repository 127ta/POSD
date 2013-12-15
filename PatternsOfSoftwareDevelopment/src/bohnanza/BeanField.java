package bohnanza;
import bohnanza.BeanType;
// confirm this is the way we want to implement a subclass
public class BeanField extends Pile {

	private BeanType type;

	public int getHarvestValue() {
		int harvestValue = 0;
		int amountOfCards = listOfCards.size();
		
		if(amountOfCards > 0) // If there are cards
		{
			Card harvestCard = listOfCards.get(0);
			for(int i = 0; i < harvestCard.getBeanType().getBeanometer().size(); i++){
				if(amountOfCards < harvestCard.getBeanType().getBeanometer().get(i).getCardsNecessary() && i > 0){ // if harvested cards have any value
					for(int u = 0; u < harvestCard.getBeanType().getBeanometer().get(i-1).getProfit(); u++){ // loop for profit
						harvestValue++;
					}
				}
			}
		}
		return harvestValue;
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