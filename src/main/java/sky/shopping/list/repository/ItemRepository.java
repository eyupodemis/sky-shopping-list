package sky.shopping.list.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import sky.shopping.list.general.Item;

public class ItemRepository {

	List<Item> itemList = new ArrayList<>();

	public ItemRepository() {
		this.itemList.add(new Item("Headphones", "Audio", new BigDecimal("150.00")));
		this.itemList.add(new Item("Speakers", "Audio", new BigDecimal("85.00")));
		this.itemList.add(new Item("AAA Batteries", "Power", new BigDecimal("0.85")));
		this.itemList.add(new Item("Protein Bars (Box)", "Food", new BigDecimal("25.00")));
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
