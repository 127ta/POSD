package bohnanza;

import interfaces.IGame;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {

	private int maxPlayers;
	private int minPlayers;
	private int numOfBeanCards;
	private List<Player> players;
	private List<State> playStates;
	private Player activePlayer;
	private Pile drawPile;
	private Pile discardPile;
	private Pile deck;
	private int drawDeckExhaust;
	private int drawDeckShuffles;
	private int maxNumOfCardsInHand;


	public void initialize(int numOfPlayers) 
	{
		// most of this should be done in GameFactory
		maxPlayers = GameRules.MAXPLAYERS;
		minPlayers = GameRules.MINPLAYERS;
		numOfBeanCards = GameRules.NUMOFBEANCARDS;
		drawDeckExhaust = GameRules.NUMOFDRAWDECKEXHAUST;
		maxNumOfCardsInHand = GameRules.MAXNUMOFCARDSINHAND;
		playStates = new ArrayList<State>();
		
		// PLANT, DRAWTRADEDONATE, PLANTTRADEDONATED, DRAWNEW, INACTIVE
		playStates.add(new State.Plant());
		playStates.add(new State.DrawTradeDonate());
		playStates.add(new State.PlantTradedDonated());
		playStates.add(new State.DrawNew());
		playStates.add(new State.Inactive());
		
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
		for(int i = 0  ; i <players.size();i++){
			for(int y = 0 ; y < maxNumOfCardsInHand; y++){
				players.get(i).getHand().push(deck.pop());
			}
		}
	}
	public List<Player> getListOfPlayers()
	{
		return players;
	}
	public void pushToDeck(Card card)
	{
		deck.push(card);
	}
	
	public void nextPlayState(){
		List<State> tempList = getPlayStates();
		activePlayer.setPlayState(tempList.get((tempList.indexOf(activePlayer.getPlayState()) + 1) % tempList.size()));
	}
	
	public List<State> getPlayStates(){
		return playStates;
	}
	
	/**
	 * Walks through the Bohnanza game logic for current state.
	 * 
	 */
	
	public void Play(){
		while(!activePlayer.isFinished()){
			activePlayer.getPlayState().play();
			nextPlayState();
		}
		
	}
	
	/*
	public void Play(){
		// PLANT, DRAWTRADEDONATE, PLANTTRADEDONATED, DRAWNEW, INACTIVE
		switch(playState){
			case PLANT:
				boolean type = false;
				for(int i = 0; i < getBeanFields().size(); i++){
					if(hand.getListOfCards().get(0).getBeanType() == getBeanFieldById(i).getBeanType()){
						type = true;
					}
				}
				
				if(type){
					// prompt the player to select in which beanfield he wishes to plant the next card
					
				} else {
					// prompt the player to select which beanfield he wishes to sell
					// plant card in the now empty field
					
				}
				
				// player may choose to plant one more card
				
				
				type = false;
				for(int i = 0; i < getBeanFields().size(); i++){
					if(hand.getListOfCards().get(0).getBeanType() == getBeanFieldById(i).getBeanType()){
						type = true;
					}
				}
				
				if(type){
					// prompt the player to select in which beanfield he wishes to plant the next card
					
				} else {
					// prompt the player to select which beanfield he wishes to sell
					// plant card in the now empty field
					
				}
				
				break;
			case DRAWTRADEDONATE:
				// push two cards to players hand (or trade area)? from the draw pile
				
				// prompt to trade / offer / donate, must involve active player. Must trade two fresh cards and/or cards from the rest of the hand
				// nonactive player may only trade cards from his hand
				
				
				
				break;
			case PLANTTRADEDONATED:
				// all players plant cards they received in trades or donations, active player plants cards he drew and kept
				// 3rd field may be bought
				break;
			case DRAWNEW:
				// active draws 3 cards to his hand
				
				// turn over
				break;
			default:
				break;
		}
		
		System.out.println(playState);
		nextState();
	} */
}
