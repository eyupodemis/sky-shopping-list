package sky.shopping.list.repository;

import java.util.ArrayList;
import java.util.List;

import sky.shopping.list.general.ShoppingCard;

public class ShoppingCardRepository {
	
	List<ShoppingCard> shoppingCardList = new ArrayList<>();

	
	public ShoppingCardRepository(){
		this.shoppingCardList.add(new ShoppingCard("Speakers", 1));
		this.shoppingCardList.add(new ShoppingCard("AAA Batteries", 5));
		this.shoppingCardList.add(new ShoppingCard("Protein Bars (Box)", 2));
	}

	public List<ShoppingCard> getShoppingCardList() {
		return shoppingCardList;
	}

	public void setShoppingCardList(List<ShoppingCard> shoppingCardList) {
		this.shoppingCardList = shoppingCardList;
	}


}
