/**
 * ProductManagementService.java
 */
package com.gnv.vnm.selfcare.core.service;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.gnv.vnm.selfcare.core.enums.DisplayOrder;
import com.gnv.vnm.selfcare.core.enums.SubscriberType;
import com.gnv.vnm.selfcare.core.model.Product;
import com.gnv.vnm.selfcare.core.model.ProductCategory;
import com.gnv.vnm.selfcare.core.model.ProductGroup;
import com.gnv.vnm.selfcare.core.model.ShareProduct;

/**
 * @author nandipinto
 *
 */
public interface ProductManagementService {

	public static final String METADATA_NAME_ICON	= "ICON_";
	public static final String METADATA_NAME_IMAGE 	= "IMAGE_";

	List<ProductCategory> getProductCategories(String langCode);
	
	List<ProductGroup> getProductGroupsByCategoryId(Integer categoryId, String langCode, boolean includeHiddenGroups);
	
	List<ProductGroup> getProductGroupsByCategoryCode(String categoryCode, String langCode, boolean includeHiddenGroups);
	
	ProductGroup getProductGroupDetails(Integer productGroupId, String langCode);
	
	List<Product> getProductsByProductGroupId(Integer productGroupId, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts);
	
	List<Product> getProductsByProductGroupCode(String productGroupCode, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts);
	
	Integer createProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Integer id);
	
	Product getProductDetailsById(Integer id, String langCode);
	
	ShareProduct getShareDetailsById(Integer id, String langCode);
	
	Product getProductDetailsByCode(String code, String langCode);
	
	Hashtable<String, String> getProductMetadata(Integer productId, String langCode);
	
	List<Product> getAllProducts(String langCode, boolean includeHiddenProducts);
	
	List<Product> getProductsByCategoryId(Integer categoryId, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts);
	
	List<Product> getProductsByCategoryCode(String categoryCode, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts);
	
	List<Product> searchProducts(String searchTerm, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts);
	
	List<Product> searchProducts(Integer categoryId, String searchTerm, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts);
	
	List<Product> getRecommendedProducts(String langCode);
	
	List<Product> getRecommendedProducts(Integer categoryId, String langCode);
	
	List<Product> getRecommendedProductsForSubscriber(String subscriberId, String langCode);
	
	List<Product> getRecommendedProductsForSubscriber(String subscriberId, Integer categoryId, String langCode);
	
	void promoteProduct(Integer productId, Date startDate, Date endDate);
	
	void promoteProduct(String productCode, Date startDate, Date endDate);
	
	List<Product> getPromotedProducts(Date startDate, Date endDate, String langCode);
	
	List<Product> getPromotedProducts(String langCode);
	
	List<Product> getProductListForChangePackage(String sourceProductCode, String langCode);
	
	/**
	 * Add Post Pad migartion 
	 * */
	List<Product> getProductsByProductGroupCode(String productGroupCode, DisplayOrder orderBy, String langCode, boolean includeHiddenProducts, SubscriberType subscriberType);
	
	List<Product> getRecommendedProducts(String langCode, SubscriberType subscriberType);
}
