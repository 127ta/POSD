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
		tempList.add(new BeanometerEntry(1, 1));
		tempList.add(new BeanometerEntry(2, 2));
		tempList.add(new BeanometerEntry(3, 3));
		tempList.add(new BeanometerEntry(4, 4));
		BeanType temp = new BeanType("a", tempList, 10);
	}

}
