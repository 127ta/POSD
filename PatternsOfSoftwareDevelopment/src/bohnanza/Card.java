package bohnanza;

import java.util.List;

public class Card {

	private List<BeanometerEntry> beanometer;
	private BeanType type;
	public Pile _unnamed_Pile_;

	public Card(BeanType type) {
		this.type = type;
	}
	public BeanType getBeanType()
	{
		return type;
	}

}