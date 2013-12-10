package bohnanza;

import interfaces.ICard;

import java.util.ArrayList;
import java.util.List;

public class Card implements ICard {

	private BeanType type;

	public Card(BeanType type) {
		this.type = type;
		
	}
	public BeanType getBeanType()
	{
		return type;
	}

}