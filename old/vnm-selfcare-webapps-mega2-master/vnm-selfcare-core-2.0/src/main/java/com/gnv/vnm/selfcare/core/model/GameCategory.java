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
public class GameCategory extends ContentCategory {

	private static final long serialVersionUID = -993233869490204300L;

	private List<GameContent> contents = new ArrayList<>();
	
	public GameCategory() {
	}

	/**
	 * @param id
	 * @param parentCategoryId
	 * @param code
	 */
	public GameCategory(Integer id, Integer parentCategoryId, String code) {
		super(id, parentCategoryId, code);
	}

	/**
	 * @return the contents
	 */
	public List<GameContent> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<GameContent> contents) {
		this.contents = contents;
	}

	
}