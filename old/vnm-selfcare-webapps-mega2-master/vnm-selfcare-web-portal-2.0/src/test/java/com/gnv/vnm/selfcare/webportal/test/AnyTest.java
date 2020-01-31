package com.gnv.vnm.selfcare.webportal.test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gnv.vnm.selfcare.core.model.KeyValue;
import com.gnv.vnm.selfcare.core.utils.AppUtils;

public class AnyTest {
	
	static final String MONSTER_IMG_LEVEL1 = "Level_1.png";
	static final String MONSTER_IMG_LEVEL2 = "Level_2.png";
	static final String MONSTER_IMG_LEVEL3 = "Level_3.png";
	static final String MONSTER_IMG_LEVEL4 = "Level_4.png";
	static final String MONSTER_IMG_LEVEL5 = "Level_5.png";
	static final String MONSTER_IMG_LEVEL6 = "Level_6.png";


	static Map<String, List<KeyValue>> maps = new Hashtable<>();
	public static void main(String[] args) {
		
		/*
		int pts = 5;
		for (int i = 0; i <= 50; i++) {
			pts = (pts - 5) / 5  + (i * 20); //pts + (i * 10);
			System.out.println("pts= " + pts + ", img= " + getMonsterImageName(pts));
		}
		*/
		List<KeyValue> list1 = new ArrayList<>();
		List<KeyValue> list2 = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list1.add(new KeyValue("key_1_" + i * 2, i));
			list2.add(new KeyValue("key_2_" + i * 3, i));
		}
		maps.put("KEY1", list1);
		maps.put("KEY2", list2);
		
		try {
			ObjectMapper om = new ObjectMapper();
			System.out.println(om.writeValueAsString(maps));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String getMonsterImageName(int points) {
		
		if (points >= 10) {
			if (points >= 20) {
				if (points >= 40) {
					if (points >= 100) {
						if (points >= 1000) {
							return MONSTER_IMG_LEVEL6;
						} else {
							return MONSTER_IMG_LEVEL5;
						}
					} else {
						return MONSTER_IMG_LEVEL4;
					}
				} else {
					return MONSTER_IMG_LEVEL3;
				}
			} else {
				return MONSTER_IMG_LEVEL2;
			}
		}
		
		return MONSTER_IMG_LEVEL1;
	}
	

}
