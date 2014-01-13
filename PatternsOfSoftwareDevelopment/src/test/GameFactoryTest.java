package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bohnanza.GameBuilder;

public class GameFactoryTest {
	GameBuilder gm;
	
	@Before
	public void setup(){
		gm = new GameBuilder();
	}

	@Test
	public void test() {
		gm.InitializeGame();
	}

}
