package test;
import bohnanza.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	Pile deck;
	Game game;
	@Before
	public void setUp() throws Exception 
	{
		game = new Game();
		game.initialize(4);
		for(int i = 0; i < 5; i++)
		{
			game.pushToDeck(new Card(BeanType.SOY));
		}
		for(int i = 0; i < 5; i++)
		{
			game.pushToDeck(new Card(BeanType.STINK));
		}
		for(int i = 0; i < 5; i++)
		{
			game.pushToDeck(new Card(BeanType.BLUE));
		}
		for(int i = 0; i < 5; i++)
		{
			game.pushToDeck(new Card(BeanType.RED));
		}
	}

	@Test
	public void testInitialize() 
	{
		//?
	}

	@Test
	public void testShuffle() 
	{
		//does not need testing since List type contains a shuffle method
	}

	@Test
	public void testDeal() 
	{
		boolean allRedBeans = true;
		boolean allBlueBeans = true;
		boolean allStinkBeans = true;
		boolean allSoyBeans = true;
		for(int i = 0; i < 5; i++)
		{
			if(allRedBeans) allRedBeans = game.getListOfPlayers().get(0).getHand().pop().getBeanType() == BeanType.RED;
			if(allBlueBeans) allBlueBeans = game.getListOfPlayers().get(1).getHand().pop().getBeanType() == BeanType.BLUE;
			if(allStinkBeans) allStinkBeans = game.getListOfPlayers().get(2).getHand().pop().getBeanType() == BeanType.STINK;
			if(allSoyBeans) allSoyBeans = game.getListOfPlayers().get(3).getHand().pop().getBeanType() == BeanType.SOY;
		}
		assertEquals("After dealing, PLayer 1 should have 5 BeanType.RED cards", true, allRedBeans);
		assertEquals("After dealing, PLayer 2 should have 5 BeanType.BLUE cards", true, allBlueBeans);
		assertEquals("After dealing, PLayer 3 should have 5 BeanType.STINK cards", true, allStinkBeans);
		assertEquals("After dealing, PLayer 4 should have 5 BeanType.SOY cards", true, allSoyBeans);
	}

}
