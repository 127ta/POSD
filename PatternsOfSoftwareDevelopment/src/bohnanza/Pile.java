package bohnanza;
import bohnanza.Card;

import java.util.ArrayList;
import java.util.List;

public class Pile {

	public List<Card> listOfCards;
	private int maxNumOfCards;

	public Pile()
	{
		listOfCards = new ArrayList<Card>();
	}
	public Card pop() {
		// not sure if this works
		Card temp = listOfCards.remove(0);
		return temp;
	}

	/**
	 * 
	 * @param Card
	 */
	public void push(Card card) {
		listOfCards.add(card);
	}
	
	public List<Card> getListOfCards(){
		return listOfCards;
	}

}