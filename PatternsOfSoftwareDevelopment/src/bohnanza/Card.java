package bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Card {

	private List<BeanometerEntry> beanometer;
	private BeanType type;

	public Card(BeanType type) {
		this.type = type;
		beanometer = new ArrayList<BeanometerEntry>();
		for(int i = 0 ;i < 4; i++){
			BeanometerEntry temp = new BeanometerEntry(i*3, i);
			beanometer.add(temp);
		}
	}
	public BeanType getBeanType()
	{
		return type;
	}
	
	public List<BeanometerEntry> getBeanometer(){
		return beanometer;
	}

}