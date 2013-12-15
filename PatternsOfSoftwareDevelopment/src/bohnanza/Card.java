package bohnanza;

import interfaces.IBeanType;
import interfaces.ICard;

import java.util.ArrayList;
import java.util.List;

public class Card implements ICard {

	private BeanType type;

	public Card(IBeanType beanType) {
		this.type = (BeanType) beanType;
		
	}
	public BeanType getBeanType()
	{
		return type;
	}

}