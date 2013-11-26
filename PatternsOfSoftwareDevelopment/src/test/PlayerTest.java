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
		player = new Player();
		playerTwo = new Player();
		player.coins = 4;
		player.beanFields.add(new BeanField());
		player.beanFields.add(new BeanField());
	}

	@Test
	public void testPlant() {
		player.plant(player.beanFields.get(0));
		assertEquals(player.beanFields.get(0).getType(), BeanType.BLACKEYED);
	}

	@Test
	public void testNextState() {
		player.nextState();
		assertEquals(player.playState, State.PLANT);
	}

	@Test
	public void testTrade() {
		player.trade(playerTwo);
		assertEquals(playerTwo.hand.listOfCards.get(0).getBeanType(), BeanType.BLACKEYED);
		assertEquals(player.hand.listOfCards.size(), 0);
	}
	
	@Test
	public void testHarvest() {
		player.harvest(player.beanFields.get(0));
		assertEquals(player.beanFields.size(), 1);
		assertEquals(player.coins, 5);
	}

	@Test
	public void testBuyThirdField() {
		player.buyThirdField();
		assertEquals(player.beanFields.size(), 3);
		assertEquals(player.coins, 1);
	}
}
