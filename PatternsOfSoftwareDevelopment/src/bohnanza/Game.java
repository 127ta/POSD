package bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int maxPlayers;
	private int minPlayers;
	private int numOfBeanCards;
	private List<Player> players;
	private Player activePlayer;
	private Pile drawPile;
	private Pile discardPile;
	private Pile deck;
	private int drawDeckExhaust;
	private int drawDeckShuffles;
	private int maxNumOfCardsInHand;

	/**
	 * 
	 * @param String
	 */
	public static void main(String args[]) {
		throw new UnsupportedOperationException();
	}

	public void initialize(int numOfPlayers) 
	{
		maxPlayers = GameRules.MAXPLAYERS;
		minPlayers = GameRules.MINPLAYERS;
		numOfBeanCards = GameRules.NUMOFBEANCARDS;
		drawDeckExhaust = GameRules.NUMOFDRAWDECKEXHAUST;
		maxNumOfCardsInHand = GameRules.MAXNUMOFCARDSINHAND;
		
		players = new ArrayList<Player>();
		for(int i = 0; i < numOfPlayers; i++)
		{
			players.add(new Player());
		}
		
		drawDeckShuffles = 0;
		drawPile = new Pile();
		discardPile = new Pile();
		deck = new Pile();
	}

	/**
	 * 
	 * @param Pile
	 */
	public Pile shuffle(int Pile) {
		return new Pile();
	}

	public void deal() {

	}
	public List<Player> getListOfPlayers()
	{
		return players;
	}
	public void pushToDeck(Card card)
	{
		
	}
}