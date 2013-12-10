package bohnanza;

import java.util.List;

import interfaces.IGameFactory;

public class GameFactory implements IGameFactory {

	private Game game;
	private List<Player> players;
	private List<State> playStates;
	private Pile deck;
	
	public GameFactory(){
		game = new Game();
		
	}
	
}
