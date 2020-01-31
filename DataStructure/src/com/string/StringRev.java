package com.string;


public class StringRev {
	
	private String reverseString11(String str) {
		int len = str.length();
		int l = len/2;
		char arr[] = str.toCharArray();
		for(int i=0;i<l;i++) {
			char temp= arr[i];
			arr[i]=arr[len-i-1];
			arr[len-i-1]=temp;
		}
		return new String(arr);
		
	}
	
	public static void main(String args[]) {
		String str ="Hello";
		StringRev sr = new StringRev();
		System.out.println(sr.reverseString11(str));

	}

}
