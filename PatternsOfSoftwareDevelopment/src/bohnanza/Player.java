package bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Player {

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
		_beanField.push(hand.pop());
	}

	public void nextState() {
		playState = State.values()[(playState.ordinal() + 1) % State.values().length]; // get next state % states length
	}

	/**
	 * 
	 * @param Player
	 */
	public void trade(Player _player) {
		_player.hand.push(this.hand.pop());
	}

	/**
	 * 
	 * @param BeanField
	 */
	public void harvest(BeanField _beanField) {
		_beanField.pop(); // this should be a reference and thus affect the object stored in beanFields
		coins++;
	}

	public void buyThirdField() {
		if(beanFields.size() == 2 && coins > 2){
			beanFields.add(new BeanField());
			coins -= 3;
		}
	}
	
	// Interfaces for private methods
	// NO VALIDATION YET!
	// Alternatively we could consider using reflections
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
		return coins;
	}

}