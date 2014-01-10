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
	private boolean gameHasEnded;
	private GameRules rules;
	private static Game gameInstance;
	
	/*public Game(List<Player> players, List<State> playStates, Pile deck, GameRules rules){
		this.players = players;
		this.playStates = playStates;
		this.deck = deck;
		this.rules = rules;
		initialize(players.size());
	}*/
	private Game()
	{
		
	}
	
	public static Game getInstance()
	{
		if(gameInstance == null)
		{
			gameInstance = new Game();
		}
		return gameInstance;
	}


	public void initialize() 
	{
		// most of this should be done in GameFactory
		maxPlayers = rules.MAXPLAYERS;
		minPlayers = rules.MINPLAYERS;
		numOfBeanCards = rules.NUMOFBEANCARDS;
		drawDeckExhaust = rules.NUMOFDRAWDECKEXHAUST;
		maxNumOfCardsInHand = rules.MAXNUMOFCARDSINHAND;
		drawDeckShuffles = 0;
		
		deal();
		drawPile = new Pile();
		discardPile = new Pile();
		
		// put leftover cards from deck to drawpile
		while(deck.getListOfCards().size() > 0){
			drawPile.push(deck.pop());
		}
		
		gameHasEnded = false;
	}
	public void setPlayers(List<Player> players)
	{
		this.players = players;
	}
	public void setPlayStates(List<State> playStates)
	{
		this.playStates = playStates;
	}
	public void setDeck(Pile deck)
	{
		this.deck = deck;
	}
	public void setRules(GameRules rules)
	{
		this.rules = rules;
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
	
	public Pile getDrawPile(){
		// convert to singleton
		return drawPile;
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
		activePlayer = (players.size() > 0) ? players.get(0) : null;
		while(!gameHasEnded && activePlayer != null)
		{
			while(!activePlayer.isFinished())
			{
				activePlayer.getPlayState().play();
				nextPlayState();
			}
			// Switch to the next player in the list
			activePlayer = players.get((players.indexOf(activePlayer) + 1) % players.size());
			// Set the new active players playstate to the first state in the list.
			activePlayer.setPlayState(getPlayStates().get(0));
		}
		System.out.println("Game has ended!");
		
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
		
	}*/
}
