package bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private static final Exception TypeError = null;
	private String name;
	private int id;
	private Pile treasury;
	private Pile hand;
	private List<BeanField> beanFields;
	private Pile tradeArea;
	private State playState;
	private int coins;
	private Pile aside;

	/**
	 * 
	 * @param BeanField
	 */
	public Player(){
		name 		= "unnamed";
		id 			= -1;
		treasury 	= new Pile();
		hand 		= new Pile();
		beanFields 	= new ArrayList<BeanField>();
		tradeArea 	= new Pile();
		playState 	= State.INACTIVE;
		coins 		= 0;
		aside 		= new Pile();
				
	}
	
	public void plant(BeanField _beanField) {
		// if field is of the same type or no type has been specified
		if(hand.listOfCards.get(0).getBeanType() == _beanField.getBeanType() || _beanField.getBeanType() == null){
			_beanField.push(hand.pop());
		} else { // Replace with throws?
			System.out.println("Planting failed! Tried to plant " + hand.listOfCards.get(0).getBeanType() + " on a " + _beanField.getBeanType() + " beanfield.");
		}
		
	}

	public void nextState() {
		playState = State.values()[(playState.ordinal() + 1) % State.values().length]; // state++ % states length
	}

	/**
	 * 
	 * @param Player
	 */
	public void trade(Player _player, int tradeId, int handId) {
		// ADD BOUNDARY CHECKING! Do not trust arbitrary input from users
		// move card from tradeArea to foreign players hand
		_player.hand.push(this.tradeArea.listOfCards.get(tradeId));
		this.tradeArea.listOfCards.remove(tradeId);
		
		// move card from foreign players hand to current players hand
		this.hand.push(_player.hand.listOfCards.get(handId));
		_player.hand.listOfCards.remove(handId);
	}

	/**
	 * 
	 * @param BeanField
	 */
	public void harvest(BeanField _beanField) {
		Card temp = _beanField.pop(); // Get a reference card to read beanometer, read next comment
		_beanField.push(temp);
		
		for(int i = 0; i < temp.getBeanometer().size(); i++){
			// Do we want to store beanometer in each card instead of storing one for each card type?
			if((_beanField.listOfCards.size()) < temp.getBeanometer().get(i).getCardsNecessary() && i > 0){ // if harvested cards have any value
				for(int u = 0; u < temp.getBeanometer().get(i-1).getProfit(); u++){ // loop for profit
					treasury.push(_beanField.pop()); // add the cards to treasury
				}
			}
		}
		while(_beanField.listOfCards.size() > 0){ // if cards still left in the beanfield
			_beanField.pop(); // these should be thrown to the discard pile
		}
		
		coins = treasury.listOfCards.size(); // the player has as many coins as he has cards in his treasury	
	}

	public void buyThirdField() {
		if(beanFields.size() == 2 && getCoins() > 2){ // if player has only two beanfields and enough money
			beanFields.add(new BeanField());
			for(int i = 0 ; i < 3; i++){
				treasury.pop(); // put to discard pile!
			}
		}
	}
	
	// Interfaces for private methods
	// NO VALIDATION YET!
	// Alternatively we could consider using reflections inside test classes
	// http://tutorials.jenkov.com/java-reflection/private-fields-and-methods.html
	public void setCoins(int _coin){
		coins = _coin;
	}
	
	public void addBeanField(BeanField _beanField){
		beanFields.add(_beanField);
	}
	
	public BeanField getBeanFieldById(int _id){
		return beanFields.get(_id);
	}
	
	public Pile getTradeArea(){
		return tradeArea;
	}
	
	public State getPlayState(){
		return playState;
	}
	
	public Pile getHand(){
		return hand;
	}
	
	public List<BeanField> getBeanFields(){
		return beanFields;
	}
	
	public int getCoins(){
		coins = treasury.listOfCards.size(); // the player has as many coins as he has cards in his treasury
		return coins;
	}

	public Pile getTreasury() {
		return treasury;
	}

}