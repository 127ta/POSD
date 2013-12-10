package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bohnanza.BeanType;
import bohnanza.BeanometerEntry;

public class BeanTypeTest {

	@Test
	public void test() {
		List<BeanometerEntry> tempList = new ArrayList<BeanometerEntry>();
		BeanType temp = new BeanType("a", tempList, 10);
	}

}
