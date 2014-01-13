package bohnanza;

public class BeanometerEntry {

	private int cardsNecessary;
	private int profit;
	
	public BeanometerEntry(int _cardsNecessary, int _profit){
		cardsNecessary = _cardsNecessary;
		profit = _profit;
	}
	
	public int getCardsNecessary(){
		return cardsNecessary;
	}
	
	public int getProfit(){
		return profit;
	}

}