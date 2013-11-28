package test;
import bohnanza.*;
import static org.junit.Assert.*;

import org.junit.*;

public class PileTest {
	
	Pile pile;

	@Before
	public void setUp() throws Exception {
		pile = new Pile();
		pile.push(new Card(BeanType.BLUE));
		pile.push(new Card(BeanType.CHILLI));
	}

	@Test
	public void testPop() {
		assertEquals("pile.pop().getBeanType", BeanType.CHILLI, pile.pop().getBeanType());
		assertEquals("pile.pop().getBeanType", BeanType.BLUE, pile.pop().getBeanType());

	}

	@Test
	public void testPush() {
		pile.push(new Card(BeanType.WAX));
		pile.push(new Card(BeanType.SOY));
		assertEquals("pile.pop().getBeanType", BeanType.SOY, pile.pop().getBeanType());
		assertEquals("pile.pop().getBeanType", BeanType.WAX, pile.pop().getBeanType());
	}

}
