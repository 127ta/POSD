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
		return new Card(BeanType.BLACKEYED);
	}

	/**
	 * 
	 * @param Card
	 */
	public void push(Card card) {
		listOfCards.add(card);
	}

}