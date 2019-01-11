package sky.shopping.list.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sky.shopping.list.general.Item;
import sky.shopping.list.general.Promotion;
import sky.shopping.list.general.ShoppingCard;
import sky.shopping.list.serviceImp.ShoppingCardServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCardServiceImplTest {

	@Autowired
	ShoppingCardServiceImpl shoppingCardServiceImpl;
	
	List<ShoppingCard> initialShoppingCardList;
	List<ShoppingCard> calculatedShoppingCardList;
	List<ShoppingCard> calculatedShoppingCardListWithPromotion;
	List<Promotion> promotionList;
	List<Item> itemList;
	
	@Before
	public void initial() {
		initialShoppingCardList = new ArrayList<ShoppingCard>(shoppingCardServiceImpl.getShoppingCardList());
		promotionList = new ArrayList<Promotion>(shoppingCardServiceImpl.getPromotionList());
		itemList = new ArrayList<Item>(shoppingCardServiceImpl.getItemList());
		calculatedShoppingCardList = shoppingCardServiceImpl.calculatePriceForShoppingCard(initialShoppingCardList, itemList);
		calculatedShoppingCardListWithPromotion = shoppingCardServiceImpl.calculatePromotedPriceForShoppingCard(calculatedShoppingCardList, promotionList, itemList); 	
	}
	
	@Test
	public void shoppingCardItemNumberTest() {
        assertEquals(3, initialShoppingCardList.size()); 
	}

	@Test
	public void shoppingCardCalculatePriceWithoutPromotionTest() {
        assertEquals(new BigDecimal("85.00"),calculatedShoppingCardList.get(0).getPriceBeforePromotion()); 
	}

	@Test
	public void shoppingCardCalculatePriceWithPromotionTest() {
        assertEquals(new BigDecimal("3.40"), calculatedShoppingCardListWithPromotion
        		                                 .get(1)
        		                                 .getPriceAfterPromotion()); 
	}
	
	@Test
	public void shoppingCardTotalCalculatePriceWithPromotionTest() {
		calculatedShoppingCardListWithPromotion
            .forEach(x-> System.out.println(x.getPriceAfterPromotion()));
		
		BigDecimal totalAmount = calculatedShoppingCardListWithPromotion
				                       .stream()
				                       .map(card -> card.getPriceAfterPromotion())
				                       .reduce((x,y) -> x.add(y))
				                       .get();
        assertEquals(new BigDecimal("112.90"), totalAmount); 
		
	}

}
