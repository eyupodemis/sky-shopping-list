package sky.shopping.list.serviceImp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import sky.shopping.list.general.Item;
import sky.shopping.list.general.Promotion;
import sky.shopping.list.general.ShoppingCard;
import sky.shopping.list.repository.ItemRepository;
import sky.shopping.list.repository.PromotionRepository;
import sky.shopping.list.repository.ShoppingCardRepository;
import sky.shopping.list.service.ShoppingCardService;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {
	
	private ShoppingCardRepository shoppingRep = new ShoppingCardRepository();
	
	private PromotionRepository promotionRep = new PromotionRepository();
	
	private ItemRepository itemRep = new ItemRepository();
	
	
	private BigDecimal calculatePrice(ShoppingCard shoppingCard, List<Item> itemList ) {
		BigDecimal totalPrice = BigDecimal.ZERO;
	
		for(Item item : itemList) 
    		if (item.getName().contentEquals(shoppingCard.getName())) 
    			totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(shoppingCard.getQuantity()))); 

        return totalPrice; 
	}

	
    private BigDecimal calculatePromotionPrice(ShoppingCard shoppingCard, List<Promotion> promotionList, List<Item> itemList) {
    	BigDecimal totalPrice = BigDecimal.ZERO;
    	for(Promotion promotion : promotionList ) { 
    		for(Item item : itemList) { 
    		   if (((promotion.getPromotionObject().equals("item") && item.getName().equals(promotion.getPromotionName())) ||
    				(promotion.getPromotionObject().equals("type") && item.getType().equals(promotion.getPromotionName()))
    				) && (shoppingCard.getName().equals( item.getName())) 
    			  ) {
    			   if(promotion.getPromotionType().equals("price")) { 
    				   totalPrice = totalPrice.add(shoppingCard.getPriceBeforePromotion().multiply(new BigDecimal((float)(100-promotion.getPromotionAmount())/100)).setScale(2, RoundingMode.CEILING));    
    			   }else {
    		    	   totalPrice = totalPrice.add(shoppingCard.getPriceBeforePromotion()
   					                               .subtract(item.getPrice().multiply(new BigDecimal((float)(shoppingCard.getQuantity()/promotion.getPromotionAmount())
   					                            		                                            )
   					                            		                             )
						   					                 ).setScale(2, RoundingMode.CEILING)
    		                                       );  
    		       }
    		   }
    		}
    	}
        return totalPrice.equals(BigDecimal.ZERO)? shoppingCard.getPriceBeforePromotion() : totalPrice ;

        
	}
	
    @Override
	public List<ShoppingCard>  calculatePriceForShoppingCard(List<ShoppingCard> shoppingCardList, List<Item> itemList) {	
		for(ShoppingCard shoppingCard : shoppingCardList)
			shoppingCard.setPriceBeforePromotion(calculatePrice(shoppingCard, itemList));
		return shoppingCardList;
	}
	
    @Override
	public List<ShoppingCard>  calculatePromotedPriceForShoppingCard(List<ShoppingCard> shoppingCardList, List<Promotion> promotionList, List<Item> itemList) {	
		for(ShoppingCard shoppingCard : shoppingCardList)
			shoppingCard.setPriceAfterPromotion(calculatePromotionPrice(shoppingCard, promotionList,itemList));
		return shoppingCardList;
	}
	
	public List<ShoppingCard> getShoppingCardList() {
		return shoppingRep.getShoppingCardList();
	}

	public List<Promotion> getPromotionList() {
		return promotionRep.getPromotionList();
	}
	
	public List<Item> getItemList() {
		return itemRep.getItemList();
	}
}
