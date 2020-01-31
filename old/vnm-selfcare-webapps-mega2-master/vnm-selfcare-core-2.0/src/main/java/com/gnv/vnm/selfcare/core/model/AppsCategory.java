/**
 * 
 */
package com.gnv.vnm.selfcare.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class AppsCategory extends ContentCategory {

	private static final long serialVersionUID = -993233869490204300L;

	private List<AppsContent> contents = new ArrayList<>();
	
	public AppsCategory() {
	}

	/**
	 * @param id
	 * @param parentCategoryId
	 * @param code
	 */
	public AppsCategory(Integer id, Integer parentCategoryId, String code) {
		super(id, parentCategoryId, code);
	}

	/**
	 * @return the contents
	 */
	public List<AppsContent> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<AppsContent> contents) {
		this.contents = contents;
	}

	
}
