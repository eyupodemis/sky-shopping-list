package sky.shopping.list.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sky.shopping.list.general.Promotion;

public class PromotionRepository {

	List<Promotion> promotionList = new ArrayList<>();
	
	public PromotionRepository() {
		this.promotionList.add(new Promotion("type","Audio","30% discount on price","price",30));
		this.promotionList.add(new Promotion("item","AAA Batteries","3 for the price of 2 ","quantity",3));	
	}

	public List<Promotion> getPromotionList() {
		return promotionList;
	}

	public void setPromotionList(List<Promotion> promotionList) {
		this.promotionList = promotionList;
	}
}
