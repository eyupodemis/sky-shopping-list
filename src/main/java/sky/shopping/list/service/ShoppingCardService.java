package sky.shopping.list.service;

import java.util.List;

import sky.shopping.list.general.Item;
import sky.shopping.list.general.Promotion;
import sky.shopping.list.general.ShoppingCard;

public interface ShoppingCardService {
	
	public List<ShoppingCard>  calculatePriceForShoppingCard(List<ShoppingCard> shoppingCardList, List<Item> itemList);
	
	public List<ShoppingCard>  calculatePromotedPriceForShoppingCard(List<ShoppingCard> shoppingCardList, List<Promotion> promotionList, List<Item> itemList);
	
}
