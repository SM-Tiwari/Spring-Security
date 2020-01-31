package com.oneclick.siddhesh;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class ProductCatalog {
	
	public List<String> getProductCategories(){
		
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Chair");
		categories.add("Mobiles");
		categories.add("Movies");
		return categories;
		
	}

}
