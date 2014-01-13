package bohnanza;

import interfaces.IGameRules;

public class GameRules implements IGameRules {

	// Hold play states and proceed the game accordingly?
	public static final int MAXPLAYERS = 7;
	public static final int MINPLAYERS = 2;
	public static final int NUMOFBEANCARDS = 124;
	public static final int NUMOFDRAWDECKEXHAUST = 3;
	public static final int BEANFREQUENCY = 1000;
	public static final int MAXNUMOFCARDSINHAND = 5;
	
	public void strategicMethod(){
		// Implementation for the strategy pattern
	}
}