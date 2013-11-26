package test;
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
		for(int i = 0; i < 5; i++)
		{
			coffeeField.push(new Card(BeanType.COFFEE));
			waxField.push(new Card(BeanType.WAX));
			blueField.push(new Card(BeanType.BLUE));
			chilliField.push(new Card(BeanType.CHILLI));
			stinkField.push(new Card(BeanType.STINK));
			greenField.push(new Card(BeanType.GREEN));
			soyField.push(new Card(BeanType.SOY));
			blackeyedField.push(new Card(BeanType.BLACKEYED));
			redField.push(new Card(BeanType.RED));
			gardenField.push(new Card(BeanType.GARDEN));
			cocoaField.push(new Card(BeanType.COCOA));
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
		assertEquals("gardenField.getHarvestValue()", 4, gardenField.getHarvestValue());
		assertEquals("cocoaField.getHarvestValue()", 4, cocoaField.getHarvestValue());
		
	}

}
