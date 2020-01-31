/**
 * GamifyGetMonsterResponse.java
 */
package com.gnv.vnm.selfcare.core.adapter.gamify;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nandipinto
 *
 */
public class GamifyGetMonsterResponse implements Serializable {

	private static final long serialVersionUID = 1733274157446520837L;

	private GamifyResponse result;
	private MonsterData data;
	
	/**
	 * @return the result
	 */
	public GamifyResponse getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(GamifyResponse result) {
		this.result = result;
	}

	/**
	 * @return the data
	 */
	public MonsterData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(MonsterData data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GamifyGetMonsterResponse [result=");
		builder.append(result);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}


	public class MonsterData{
		
		private List<GamifyMonster> monsters = new ArrayList<>();

		/**
		 * @return the monsters
		 */
		public List<GamifyMonster> getMonsters() {
			return monsters;
		}

		/**
		 * @param monsters the monsters to set
		 */
		public void setMonsters(List<GamifyMonster> monsters) {
			this.monsters = monsters;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MonsterData [monsters=");
			builder.append(monsters);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
}
