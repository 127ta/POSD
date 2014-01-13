package test;
import interfaces.IBeanType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bohnanza.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BeanFieldTest {
	
	BeanField coffeeField;
	BeanField waxField;
	BeanField blueField;
	BeanField chilliField;
	BeanField stinkField;
	BeanField greenField;
	BeanField soyField;
	BeanField blackeyedField;
	BeanField redField;
	BeanField gardenField;
	BeanField cocoaField;
	List<IBeanType> beanTypes;
	
	@Before
	public void setUp() throws Exception 
	{
		coffeeField = new BeanField();
		waxField = new BeanField();
		blueField = new BeanField();
		chilliField = new BeanField();
		stinkField = new BeanField();
		greenField = new BeanField();
		soyField = new BeanField();
		blackeyedField = new BeanField();
		redField = new BeanField();
		gardenField = new BeanField();
		cocoaField = new BeanField();
		
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
		
		for(int i = 0; i < 5; i++)
		{
			// Have to add boundary checking for the amount of cards
			coffeeField.push(new Card(beanTypes.get(0)));
			waxField.push(new Card(beanTypes.get(1)));
			blueField.push(new Card(beanTypes.get(2)));
			chilliField.push(new Card(beanTypes.get(3)));
			stinkField.push(new Card(beanTypes.get(4)));
			greenField.push(new Card(beanTypes.get(5)));
			soyField.push(new Card(beanTypes.get(6)));
			blackeyedField.push(new Card(beanTypes.get(7)));
			redField.push(new Card(beanTypes.get(8)));
			gardenField.push(new Card(beanTypes.get(9)));
			// this should not be possible
			cocoaField.push(new Card(beanTypes.get(10)));
		}
	}

	@Test
	public void testGetHarvestValue() {
		assertEquals("coffeeField.getHarvestValue()", 1, coffeeField.getHarvestValue());
		assertEquals("waxField.getHarvestValue()", 1, waxField.getHarvestValue());
		assertEquals("blueField.getHarvestValue()", 1, blueField.getHarvestValue());
		assertEquals("chilliField.getHarvestValue()", 1, chilliField.getHarvestValue());
		assertEquals("stinkField.getHarvestValue()", 2, stinkField.getHarvestValue());
		assertEquals("greenField.getHarvestValue()", 2, greenField.getHarvestValue());
		assertEquals("soyField.getHarvestValue()", 2, soyField.getHarvestValue());
		assertEquals("blackeyedField.getHarvestValue()", 3, blackeyedField.getHarvestValue());
		assertEquals("redField.getHarvestValue()", 4, redField.getHarvestValue());
		assertEquals("gardenField.getHarvestValue()", 3, gardenField.getHarvestValue());
		assertEquals("cocoaField.getHarvestValue()", 4, cocoaField.getHarvestValue());
		
	}

}
