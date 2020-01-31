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
public class MusicCategory extends ContentCategory {

	private static final long serialVersionUID = -993233869490204300L;

	private List<MusicContent> contents = new ArrayList<>();
	
	public MusicCategory() {
	}

	/**
	 * @param id
	 * @param parentCategoryId
	 * @param code
	 */
	public MusicCategory(Integer id, Integer parentCategoryId, String code) {
		super(id, parentCategoryId, code);
	}

	/**
	 * @return the contents
	 */
	public List<MusicContent> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(List<MusicContent> contents) {
		this.contents = contents;
	}

	
}
