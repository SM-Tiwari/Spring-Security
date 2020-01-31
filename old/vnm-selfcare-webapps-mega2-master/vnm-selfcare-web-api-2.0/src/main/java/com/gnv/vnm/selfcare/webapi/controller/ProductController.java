/**
 * ProductController.java
 */
package com.gnv.vnm.selfcare.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gnv.vnm.selfcare.core.enums.DefaultProductCategory;
import com.gnv.vnm.selfcare.core.enums.DisplayOrder;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.model.ProductCategory;
import com.gnv.vnm.selfcare.core.model.ProductGroup;
import com.gnv.vnm.selfcare.core.model.ShareProduct;
import com.gnv.vnm.selfcare.core.service.ProductManagementService;

/**
 * @author nandipinto
 *
 */

@RestController
@RequestMapping("/product")
public class ProductController extends BaseRestController {

	@Autowired
	private ProductManagementService productManagementService;

	@GetMapping(value = "/banner/{lang}")
	public ResponseEntity<?> getMainProductBanner(@PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getPromotedProducts(lang), HttpStatus.OK);
	}

	@GetMapping(value = "/categories/{lang}")
	public ResponseEntity<?> getProductCatagories(@PathVariable String lang) {

		return new ResponseEntity<List<ProductCategory>>(productManagementService.getProductCategories(lang),
				HttpStatus.OK);
	}

	@GetMapping(value = "/groups/{categoryId}/{lang}")
	public ResponseEntity<?> getProductGroups(@PathVariable int categoryId, @PathVariable String lang, 
			@RequestParam(defaultValue = "false") boolean includeSpecialGroups) {

		return new ResponseEntity<List<ProductGroup>>(
				productManagementService.getProductGroupsByCategoryId(categoryId, lang, includeSpecialGroups), HttpStatus.OK);
	}

	@GetMapping(value = "/list/bygroup/{groupId}/{orderBy}/{lang}")
	public ResponseEntity<?> getProductsByGroupId(@PathVariable int groupId, @PathVariable String orderBy,
			@PathVariable String lang, @RequestParam(defaultValue = "false") boolean includeSpecialProducts) {
		return new ResponseEntity<List<Product>>(
				productManagementService.getProductsByProductGroupId(groupId, displayOrder(orderBy), lang, includeSpecialProducts),
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/bygroupcode/{groupCode}/{orderBy}/{lang}")
	public ResponseEntity<?> getProductsByGroupCode(@PathVariable String groupCode, @PathVariable String orderBy,
			@PathVariable String lang, @RequestParam(defaultValue = "false") boolean includeSpecialProducts) {
		return new ResponseEntity<List<Product>>(
				productManagementService.getProductsByProductGroupCode(groupCode, displayOrder(orderBy), lang, includeSpecialProducts),
				HttpStatus.OK);
	}

	@GetMapping(value = "/list/bycategory/{categoryId}/{orderBy}/{lang}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable int categoryId, @PathVariable String orderBy,
			@PathVariable String lang, @RequestParam(defaultValue = "false") boolean includeSpecialProducts) {

		return new ResponseEntity<List<Product>>(
				productManagementService.getProductsByCategoryId(categoryId, displayOrder(orderBy), lang, includeSpecialProducts),
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/bycategorycode/{categoryCode}/{orderBy}/{lang}")
	public ResponseEntity<?> getProductsByCategory(@PathVariable String categoryCode, @PathVariable String orderBy,
			@PathVariable String lang, @RequestParam(defaultValue = "false") boolean includeSpecialProducts) {

		return new ResponseEntity<List<Product>>(
				productManagementService.getProductsByCategoryCode(categoryCode, displayOrder(orderBy), lang, includeSpecialProducts),
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/voicensms/{orderBy}/{lang}")
	public ResponseEntity<?> getVoiceAndSmsProducts(@PathVariable String orderBy, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getProductsByCategoryCode(
				DefaultProductCategory.VOICE_N_SMS.name(), displayOrder(orderBy), lang, false), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/voice/{orderBy}/{lang}")
	public ResponseEntity<?> getVoiceProducts(@PathVariable String orderBy, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getProductsByCategoryCode(
				DefaultProductCategory.VOICE_N_SMS.name(), displayOrder(orderBy), lang, false), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/sms/{orderBy}/{lang}")
	public ResponseEntity<?> getSmsProducts(@PathVariable String orderBy, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getProductsByCategoryCode(
				DefaultProductCategory.VOICE_N_SMS.name(), displayOrder(orderBy), lang, false), HttpStatus.OK);
	}
	
	@GetMapping(value = "/list/data/{orderBy}/{lang}")
	public ResponseEntity<?> getDataProducts(@PathVariable String orderBy, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getProductsByCategoryCode(
				DefaultProductCategory.DATA.name(), displayOrder(orderBy), lang, false), HttpStatus.OK);
	}

	@GetMapping(value = "/list/vas/{orderBy}/{lang}")
	public ResponseEntity<?> getVasProducts(@PathVariable String orderBy, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getProductsByCategoryCode(
				DefaultProductCategory.VAS.name(), displayOrder(orderBy), lang, false), HttpStatus.OK);
	}
	
	@GetMapping(value = "/recommended/{lang}")
	public ResponseEntity<?> getRecommendedProducts(@PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getRecommendedProducts(lang), HttpStatus.OK);
	}

	@GetMapping(value = "/recommended/{categoryId}/{lang}")
	public ResponseEntity<?> getRecommendedProductsByCategory(@PathVariable int categoryId, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getRecommendedProducts(categoryId, lang),
				HttpStatus.OK);
	}

	@GetMapping(value = "/details/{productId}/{lang}")
	public ResponseEntity<?> getProductDetails(@PathVariable int productId, @PathVariable String lang) {
		return new ResponseEntity<Product>(productManagementService.getProductDetailsById(productId, lang),
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/sharedetails/{productId}/{lang}")
	public ResponseEntity<?> getShareDetails(@PathVariable int productId, @PathVariable String lang) {
		ShareProduct response =  productManagementService.getShareDetailsById(productId, lang);
		ArrayList<ShareProduct> listArry=new ArrayList<ShareProduct>();
		listArry.add(response);
		return new ResponseEntity<ArrayList<ShareProduct>>(listArry,
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/detailsbycode/{productCode}/{lang}")
	public ResponseEntity<?> getProductDetails(@PathVariable String productCode, @PathVariable String lang) {
		return new ResponseEntity<Product>(productManagementService.getProductDetailsByCode(productCode, lang),
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/listforchange/{sourceProductCode}/{lang}")
	public ResponseEntity<?> getPurchaseableProductList(@PathVariable String sourceProductCode, @PathVariable String lang) {
		return new ResponseEntity<List<Product>>(productManagementService.getProductListForChangePackage(sourceProductCode, lang), HttpStatus.OK);
	}

	private DisplayOrder displayOrder(String name) {
		DisplayOrder order = null;
		try {
			order = DisplayOrder.valueOf(name.toUpperCase());
		} catch (Exception e) {
			order = DisplayOrder.TITLE_ASC;
		}
		return order;
	}

}
