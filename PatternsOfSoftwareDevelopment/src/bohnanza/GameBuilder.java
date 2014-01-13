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
		game = Game.getInstance();
		setPlayers(new ArrayList<Player>());
		setPlayStates(new ArrayList<State>());
		setBeanTypes(new ArrayList<IBeanType>());
		rules = new GameRules();
		InitializeGame(); //commented out for testing purposes
	}
	
	public List<IBeanType> getBeanTypes() {
		return beanTypes;
	}

	public void InitializeGame(){

		// for now try to add maximum amount of players
		// this has to be replaced
		for(int i = 0; i < rules.MAXPLAYERS; i++){
			addPlayer("Player" + i,i);
		}

		// PLANT, DRAWTRADEDONATE, PLANTTRADEDONATED, DRAWNEW, INACTIVE
		getPlayStates().add(new State.Plant());
		getPlayStates().add(new State.DrawTradeDonate());
		getPlayStates().add(new State.PlantTradedDonated());
		getPlayStates().add(new State.DrawNew());
		getPlayStates().add(new State.Inactive());
		
		// add beantypes
		setBeanTypes(new ArrayList<IBeanType>());
		getBeanTypes().add(new BeanType("Coffee", 	 Arrays.asList(new BeanometerEntry(4,1), new BeanometerEntry(7,2), new BeanometerEntry(10,3), new BeanometerEntry(12,4)),24));
		getBeanTypes().add(new BeanType("Wax", 		 Arrays.asList(new BeanometerEntry(4,1), new BeanometerEntry(7,2), new BeanometerEntry(9,3), new BeanometerEntry(11,4)),22));
		getBeanTypes().add(new BeanType("Blue", 		 Arrays.asList(new BeanometerEntry(4,1), new BeanometerEntry(6,2), new BeanometerEntry(8,3), new BeanometerEntry(10,4)),20));
		getBeanTypes().add(new BeanType("Chili", 	 Arrays.asList(new BeanometerEntry(3,1), new BeanometerEntry(6,2), new BeanometerEntry(8,3), new BeanometerEntry(9,4)),18));
		getBeanTypes().add(new BeanType("Stink", 	 Arrays.asList(new BeanometerEntry(3,1), new BeanometerEntry(5,2), new BeanometerEntry(7,3), new BeanometerEntry(8,4)),16));
		getBeanTypes().add(new BeanType("Green", 	 Arrays.asList(new BeanometerEntry(3,1), new BeanometerEntry(5,2), new BeanometerEntry(6,3), new BeanometerEntry(7,4)),14));
		getBeanTypes().add(new BeanType("Soy", 		 Arrays.asList(new BeanometerEntry(2,1), new BeanometerEntry(4,2), new BeanometerEntry(6,3), new BeanometerEntry(7,4)),12));
		getBeanTypes().add(new BeanType("Black-Eyed", Arrays.asList(new BeanometerEntry(2,1), new BeanometerEntry(4,2), new BeanometerEntry(5,3), new BeanometerEntry(6,4)),10));
		getBeanTypes().add(new BeanType("Red", 		 Arrays.asList(new BeanometerEntry(2,1), new BeanometerEntry(3,2), new BeanometerEntry(4,3), new BeanometerEntry(5,4)),8));
		getBeanTypes().add(new BeanType("Garden", 	 Arrays.asList(new BeanometerEntry(2,2), new BeanometerEntry(3,3)),6));
		getBeanTypes().add(new BeanType("Cacao", 	 Arrays.asList(new BeanometerEntry(2,2), new BeanometerEntry(3,3), new BeanometerEntry(4,4)),4));
		
		//game = new Game(players, playStates, getDeck(), rules);
		Game.getInstance().setPlayers(getPlayers());
		Game.getInstance().setPlayStates(getPlayStates());
		Game.getInstance().setDeck(getDeck());
		Game.getInstance().setRules(rules);
		
	}

	public void addPlayer(String name, int id){
		if(getPlayers().size() < rules.MAXPLAYERS)getPlayers().add(new Player(name, id));
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
			this.getDeck().push(card);
		}
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<State> getPlayStates() {
		return playStates;
	}

	public void setPlayStates(List<State> playStates) {
		this.playStates = playStates;
	}

	public void setDeck(Pile deck) {
		this.deck = deck;
	}

	public void setBeanTypes(List<IBeanType> beanTypes) {
		this.beanTypes = beanTypes;
	}
	
	public GameRules getRules() {
		return rules;
	}

	public void setRules(GameRules rules) {
		this.rules = rules;
	}

}
