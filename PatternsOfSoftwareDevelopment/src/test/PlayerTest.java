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
		player.setCoins(4);
		player.addBeanField(new BeanField());
		player.addBeanField(new BeanField());
	}

	@Test
	public void testPlant() {
		player.plant(player.getBeanFieldById(0));
		assertEquals(player.getBeanFieldById(0).getBeanType(), BeanType.BLACKEYED);
	}

	@Test
	public void testNextState() {
		player.nextState();
		assertEquals(player.getPlayState(), State.PLANT);
	}

	@Test
	public void testTrade() {
		player.trade(playerTwo);
		assertEquals(playerTwo.getHand().listOfCards.get(0).getBeanType(), BeanType.BLACKEYED);
		assertEquals(player.getHand().listOfCards.size(), 0);
	}
	
	@Test
	public void testHarvest() {
		player.harvest(player.getBeanFields().get(0));
		assertEquals(player.getBeanFields().get(0).listOfCards.size(), 0);
		assertEquals(player.getCoins(), 5);
	}

	@Test
	public void testBuyThirdField() {
		player.buyThirdField();
		assertEquals(player.getBeanFields().size(), 3);
		assertEquals(player.getCoins(), 1);
	}
}
