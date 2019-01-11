package sky.shopping.list.general;

import java.math.BigDecimal;

public class ShoppingCard {
	private String name;
	private int quantity;
	private BigDecimal priceBeforePromotion;
	private BigDecimal priceAfterPromotion;
	
	public ShoppingCard(){}

	public ShoppingCard(String name, int quantity){
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getPriceBeforePromotion() {
		return priceBeforePromotion;
	}

	public void setPriceBeforePromotion(BigDecimal priceBeforePromotion) {
		this.priceBeforePromotion = priceBeforePromotion;
	}

	public BigDecimal getPriceAfterPromotion() {
		return priceAfterPromotion;
	}

	public void setPriceAfterPromotion(BigDecimal priceAfterPromotion) {
		this.priceAfterPromotion = priceAfterPromotion;
	}


}
