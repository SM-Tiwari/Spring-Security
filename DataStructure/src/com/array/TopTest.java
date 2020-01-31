package com.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopTest {
	
public List<Integer> topKFrequent(int[] nums, int k) {
        
        int len = nums.length;
        int maxFreq = 0;   
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            maxFreq = Math.max(maxFreq, map.get(nums[i]));
        }
        
        List<Integer> [] bucketList = new LinkedList[maxFreq+1];
        
        for(int i=0; i<= maxFreq; i++) {
            bucketList[i] = new LinkedList<>();
        }
        
        for(Integer key : map.keySet()) {
            int freq = map.get(key);
            bucketList[freq].add(key);
        }
      
        int ct = 0;
        List<Integer> ans = new LinkedList<>();
        
        for(int i=maxFreq; i>=0; i--) {
            List<Integer> currentList = bucketList[i];
            for(Integer j: currentList) {
                if(ct < k) {
                    ans.add(j);   
                    ct++;
                } else {
                    return ans;
                }
            }    
            
        }
        
        return ans;
    }


	public static void main(String[] args) {
		TopTest tt = new TopTest();
		int arr[]= {5, 3, 4, 3 , 5, 3, 4};
		int k =2;
		System.out.println(tt.topKFrequent(arr, k));
		
	}

}
