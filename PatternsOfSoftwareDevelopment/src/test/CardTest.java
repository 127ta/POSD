package test;

import static org.junit.Assert.*;
import interfaces.IBeanType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bohnanza.BeanType;
import bohnanza.BeanometerEntry;
import bohnanza.Card;
import bohnanza.Pile;

public class CardTest {
	
	Card card;
	List<IBeanType> beanTypes;
	
	@Before
	public void setUp() throws Exception {
		// from gameFactory, we should look into making this more modular or mock it
		beanTypes = new ArrayList<IBeanType>();
		beanTypes.add(new BeanType("Coffee", 	 Arrays.asList(new BeanometerEntry(4,1), new BeanometerEntry(7,2), new BeanometerEntry(10,3), new BeanometerEntry(12,4)),24));
		beanTypes.add(new BeanType("Wax", 		 Arrays.asList(new BeanometerEntry(4,1), new BeanometerEntry(7,2), new BeanometerEntry(9,3), new BeanometerEntry(11,4)),22));
		beanTypes.add(new BeanType("Blue", 		 Arrays.asList(new BeanometerEntry(4,1), new BeanometerEntry(6,2), new BeanometerEntry(8,3), new BeanometerEntry(10,4)),20));
		beanTypes.add(new BeanType("Chili", 	 Arrays.asList(new BeanometerEntry(3,1), new BeanometerEntry(6,2), new BeanometerEntry(8,3), new BeanometerEntry(9,4)),18));
		beanTypes.add(new BeanType("Stink", 	 Arrays.asList(new BeanometerEntry(3,1), new BeanometerEntry(5,2), new BeanometerEntry(7,3), new BeanometerEntry(8,4)),16));
		beanTypes.add(new BeanType("Green", 	 Arrays.asList(new BeanometerEntry(3,1), new BeanometerEntry(5,2), new BeanometerEntry(6,3), new BeanometerEntry(7,4)),14));
		beanTypes.add(new BeanType("Soy", 		 Arrays.asList(new BeanometerEntry(2,1), new BeanometerEntry(4,2), new BeanometerEntry(6,3), new BeanometerEntry(7,4)),12));
		beanTypes.add(new BeanType("Black-Eyed", Arrays.asList(new BeanometerEntry(2,1), new BeanometerEntry(4,2), new BeanometerEntry(5,3), new BeanometerEntry(6,4)),10));
		beanTypes.add(new BeanType("Red", 		 Arrays.asList(new BeanometerEntry(2,1), new BeanometerEntry(3,2), new BeanometerEntry(4,3), new BeanometerEntry(5,4)),8));
		beanTypes.add(new BeanType("Garden", 	 Arrays.asList(new BeanometerEntry(2,2), new BeanometerEntry(3,3)),6));
		beanTypes.add(new BeanType("Cacao", 	 Arrays.asList(new BeanometerEntry(2,2), new BeanometerEntry(3,3), new BeanometerEntry(4,4)),4));
		card = new Card(beanTypes.get(0));
	}

	@Test
	public void testCard() {
		card = new Card(beanTypes.get(1));
		assertEquals(card.getBeanType(), beanTypes.get(1));
		assertEquals(card instanceof Card, true);
	}

	@Test
	public void testGetBeanType() {
		assertEquals(card.getBeanType(), beanTypes.get(0));
	}

}
