package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bohnanza.BeanType;
import bohnanza.Card;
import bohnanza.Pile;

public class CardTest {
	
	Card card;
	
	@Before
	public void setUp() throws Exception {
		card = new Card(BeanType.values()[0]);
	}

	@Test
	public void testCard() {
		card = new Card(BeanType.values()[1]);
		assertEquals(card.getBeanType(), BeanType.values()[1]);
		assertEquals(card instanceof Card, true);
	}

	@Test
	public void testGetBeanType() {
		assertEquals(card.getBeanType(), BeanType.values()[0]);
	}

}
