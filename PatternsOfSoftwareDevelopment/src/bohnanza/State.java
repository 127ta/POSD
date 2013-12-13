package bohnanza;
import interfaces.IState;

public abstract class State implements IState 
{
	public static class Plant extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void play() {
			System.out.println("Plant state");
			System.console().readLine();
			
		}
		
	}
	public static class DrawTradeDonate extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void play() {
			System.out.println("DrawTradeDonate state");
			System.console().readLine();
			
		}
		
	}
	public static class PlantTradedDonated extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void play() {
			System.out.println("PlantTradedDonated state");
			System.console().readLine();
			
		}
		
	}
	public static class DrawNew extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void play() {
			System.out.println("DrawNew state");
			System.console().readLine();
			
		}
		
	}
	public static class Inactive extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void play() {
			System.out.println("Inactive state");
			System.console().readLine();
			
		}
		
	}
};

