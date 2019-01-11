package sky.shopping.list.general;

public class Promotion {

	private String promotionObject; // type, item
	private String promotionName; // Audio, AAA Batteries
	private String promotionDefinition;
	private String promotionType; //  price, quantity
	private int promotionAmount; 
	
	public Promotion(String promotionObject, String promotionName, String promotionDefinition, String promotionType, int promotionAmount ) {
		this.promotionObject = promotionObject;
		this.promotionName = promotionName;
		this.promotionDefinition = promotionDefinition;
		this.promotionType = promotionType;
		this.promotionAmount = promotionAmount;
	} 
	
	public String getPromotionObject() {
		return promotionObject;
	}
	public void setPromotionObject(String promotionObject) {
		this.promotionObject = promotionObject;
	}
	public String getPromotionDefinition() {
		return promotionDefinition;
	}
	public void setPromotionDefinition(String promotionDefinition) {
		this.promotionDefinition = promotionDefinition;
	}
	public String getPromotionType() {
		return promotionType;
	}
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}
	public int getPromotionAmount() {
		return promotionAmount;
	}
	public void setPromotionAmount(int promotionAmount) {
		this.promotionAmount = promotionAmount;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	
}
