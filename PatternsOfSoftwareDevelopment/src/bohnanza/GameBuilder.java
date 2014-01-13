package bohnanza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import interfaces.IGameBuilder;
import interfaces.IBeanType;

public class GameBuilder implements IGameBuilder {

	private Game game;
	private List<Player> players;
	private List<State> playStates;
	private Pile deck;
	private List<IBeanType> beanTypes;
	private GameRules rules;

	public GameBuilder(){
		//InitializeGame(); commented out for testing purposes
		players = new ArrayList<Player>();
		playStates = new ArrayList<State>();
		beanTypes = new ArrayList<IBeanType>();
		rules = new GameRules();
	}
	
	public List<IBeanType> getBeanTypes() {
		return Collections.unmodifiableList(beanTypes);
	}

	public void InitializeGame(){

		// for now try to add maximum amount of players
		// this has to be replaced
		for(int i = 0; i < rules.MAXPLAYERS; i++){
			addPlayer("Player" + i,i);
		}

		// PLANT, DRAWTRADEDONATE, PLANTTRADEDONATED, DRAWNEW, INACTIVE
		playStates.add(new State.Plant());
		playStates.add(new State.DrawTradeDonate());
		playStates.add(new State.PlantTradedDonated());
		playStates.add(new State.DrawNew());
		playStates.add(new State.Inactive());
		
		// add beantypes
		beanTypes = new ArrayList<IBeanType>();
		//beanTypes.add(new BeanType("Coffee Bean", new int[] { 4, 7, 10, 12 }, 24));
		//beanTypes.add(new BeanType("Wax Bean", new int[] { 4, 7, 9, 11 }, 22));
		//beanTypes.add(new BeanType("Blue Bean", new int[] { 4, 6, 8, 10 }, 20));
		//beanTypes.add(new BeanType("Chili Bean", new int[] { 3, 6, 8, 9 }, 18));
		//beanTypes.add(new BeanType("Stink Bean", new int[] { 3, 5, 7, 8 }, 16));
		//beanTypes.add(new BeanType("Green Bean", new int[] { 3, 5, 6, 7 }, 14));
		//beanTypes.add(new BeanType("Soy Bean", new int[] { 2, 4, 6, 7 }, 12));
		//beanTypes.add(new BeanType("Black-eyed Bean", new int[] { 2, 4, 5, 6 }, 10));
		//beanTypes.add(new BeanType("Red Bean", new int[] { 2, 3, 4, 5 }, 8));
		//beanTypes.add(new BeanType("Garden Bean", new int[] { 0, 2, 3, 0 }, 6));
		//beanTypes.add(new BeanType("Cacoa Bean", new int[] { 0, 2, 3, 4 }, 4));
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
		
		//game = new Game(players, playStates, getDeck(), rules);
		Game.getInstance().setPlayers(players);
		Game.getInstance().setPlayStates(playStates);
		Game.getInstance().setDeck(getDeck());
		Game.getInstance().setRules(rules);
		
	}

	public void addPlayer(String name, int id){
		if(players.size() < rules.MAXPLAYERS)players.add(new Player(name, id));
	}
	
	public Pile getDeck(){
		if (this.deck == null) {
			this.deck = new Pile();

			// Add beancards
			for (IBeanType beanType : getBeanTypes())
				this.addBeanCards(beanType);
			
		}
		return this.deck;
	}
	
	public Game getGame(){
		// convert to singleton
		return this.game;
	}

	private void addBeanCards(IBeanType beanType) {
		for (int i = 1; i <= beanType.getAmountInDeck(); i++) {
			Card card = new Card(beanType);
			this.deck.push(card);
		}
	}

}
