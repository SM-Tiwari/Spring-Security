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
public class MovieCategory extends ContentCategory {

	private static final long serialVersionUID = -993233869490204300L;

	private List<MovieContent> contents = new ArrayList<>();
	
	public MovieCategory() {
	}

	/**
	 * @param id
	 * @param parentCategoryId
	 * @param code
	 */
	public MovieCategory(Integer id, Integer parentCategoryId, String code) {
		super(id, parentCategoryId, code);
	}

	/**
	 * @return the contents
	 */
	public List<MovieContent> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<MovieContent> contents) {
		this.contents = contents;
	}

	
}
