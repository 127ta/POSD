package bohnanza;
import interfaces.IState;

public abstract class State implements IState 
{
	public class Plant extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public class DrawTradeDonate extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public class PlantTradedDonated extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public class DrawNew extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	public class Inactive extends State
	{

		@Override
		public String getStateInstruction() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
};

