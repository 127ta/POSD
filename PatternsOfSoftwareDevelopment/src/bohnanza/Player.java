package bohnanza;

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
	public void plant(int BeanField) {
		throw new UnsupportedOperationException();
	}

	public void nextState() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Player
	 */
	public void trade(int Player) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param BeanField
	 */
	public void harvest(int BeanField) {
		throw new UnsupportedOperationException();
	}

	public void buyThirdField() {
		throw new UnsupportedOperationException();
	}
	
	public Pile getHand()
	{
		return hand;
	}
}