package test;

import bohnanza.BeanField;
import bohnanza.BeanType;
import bohnanza.Card;
import bohnanza.Pile;
import bohnanza.Player;
import bohnanza.State;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player, playerTwo;

	@Before
	public void setUp() throws Exception {
		// this method is called before EACH test
		player = new Player();
		playerTwo = new Player();

		player.getHand().push(new Card(BeanType.COCOA));
		player.getTradeArea().push(new Card(BeanType.BLACKEYED));
		playerTwo.getHand().push(new Card(BeanType.COFFEE));
		player.addBeanField(new BeanField());
		player.addBeanField(new BeanField());
		player.setPlayState(new State.Inactive());

		for(int i = 0; i < 8; i++){
			player.getBeanFieldById(0).push(new Card(BeanType.BLUE));
		}
	}

	@Test
	public void testPlant() {
		// test planting on a non existent beanfield
		player.plant(player.getBeanFieldById(2));
		assertEquals(player.getBeanFields().size(), 2);


		// Try planting on a beanfield where planting is not allowed
		player.plant(player.getBeanFieldById(0));
		assertEquals(player.getBeanFieldById(0).listOfCards.get(player.getBeanFieldById(0).listOfCards.size()-1).getBeanType(), BeanType.BLUE);

		// Test planting on an empty beanfield
		player.plant(player.getBeanFieldById(1));
		assertEquals(player.getBeanFieldById(1).listOfCards.get(player.getBeanFieldById(1).listOfCards.size()-1).getBeanType(), BeanType.COCOA);
	}

	@Test
	public void testSetState() {
		// Game states PLANT, DRAWTRADEDONATE, PLANTTRADEDONATED, DRAWNEW, INACTIVE
		// Test for incrementing playState, initially player starts in State.INACTIVE
		
		// Implement test
		
		/*
		player.nextState();
		assertEquals(player.getPlayState(), new State.Plant());
		player.nextState();
		assertEquals(player.getPlayState(), new State.DrawTradeDonate);
		player.nextState();
		assertEquals(player.getPlayState(), State.PLANTTRADEDONATED);
		player.nextState();
		assertEquals(player.getPlayState(), State.DRAWNEW);
		player.nextState();
		assertEquals(player.getPlayState(), State.INACTIVE);
		*/
	}

	@Test
	public void testTrade() {
		// Test trading between two players, check last cards in both players hands
		player.trade(playerTwo, 0, 0);
		assertEquals(playerTwo.getHand().listOfCards.get(playerTwo.getHand().listOfCards.size() - 1).getBeanType(), BeanType.BLACKEYED);
		assertEquals(player.getHand().listOfCards.get(player.getHand().listOfCards.size() - 1).getBeanType(), BeanType.COFFEE);

		// Try trading non-existant card from player
		player.trade(playerTwo, 0, 2);
		assertEquals(playerTwo.getHand().listOfCards.get(playerTwo.getHand().listOfCards.size() - 1).getBeanType(), BeanType.BLACKEYED);
		assertEquals(player.getHand().listOfCards.get(player.getHand().listOfCards.size() - 1).getBeanType(), BeanType.COFFEE);
		
		// Try trading non-existant card from playerTwo
		player.trade(playerTwo, 2, 0);
		assertEquals(playerTwo.getHand().listOfCards.get(playerTwo.getHand().listOfCards.size() - 1).getBeanType(), BeanType.BLACKEYED);
		assertEquals(player.getHand().listOfCards.get(player.getHand().listOfCards.size() - 1).getBeanType(), BeanType.COFFEE);

		// Try trading with nonexistant player
		Player temp = null;
		player.trade(temp, 0, 2);
		assertEquals(player.getHand().listOfCards.get(player.getHand().listOfCards.size() - 1).getBeanType(), BeanType.COFFEE);
	}

	@Test
	public void testHarvest() {
		// Test harvesting of a beanfield, arbitrary beanometer was created in Card initializer
		player.harvest(player.getBeanFieldById(0));
		assertEquals(player.getBeanFieldById(0).listOfCards.size(), 0);
		assertEquals(player.getCoins(), 2);
		// try harvesting an empty beanField
		player.harvest(player.getBeanFieldById(0));
		assertEquals(player.getBeanFieldById(0).listOfCards.size(), 0);
		assertEquals(player.getCoins(), 2);
		// try harvesting a beanfield that doesnt exist
		player.harvest(player.getBeanFieldById(2));
		assertEquals(player.getBeanFields().size(), 2);
		assertEquals(player.getCoins(), 2);
	}

	@Test
	public void testBuyThirdField() {
		// not enough coins
		player.buyThirdField();
		assertEquals(player.getBeanFields().size(), 2);
		assertEquals(player.getCoins(), 0);

		// add enough coins
		for(int i = 0  ; i<5; i++){
			player.getTreasury().push(new Card(BeanType.STINK));
		}
		// legit purchase
		player.buyThirdField();
		assertEquals(player.getBeanFields().size(), 3);
		assertEquals(player.getCoins(), 2);

		// Attempt to purchase a third beanfield twice
		player.buyThirdField();
		assertEquals(player.getBeanFields().size(), 3);
		assertEquals(player.getCoins(), 2);
	}


}
