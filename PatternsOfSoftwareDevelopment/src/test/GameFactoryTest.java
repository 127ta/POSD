package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bohnanza.GameFactory;

public class GameFactoryTest {
	GameFactory gm;
	
	@Before
	public void setup(){
		gm = new GameFactory();
	}

	@Test
	public void test() {
		gm.InitializeGame();
	}

}
