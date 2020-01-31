package com.siddhesh.business;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;


public class ListTest {

	@Test
	public void lestMockListSizeMethod() {
		//Given - setup
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2);
		//When actual method call
		
		
		//Then asserts
		assertEquals(2, mockList.size());
		assertEquals(2, mockList.size());
		assertEquals(2, mockList.size());
	}
	
	
	@Test
	public void lestMockListSize_ReturnMultipleValues() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, mockList.size());
		assertEquals(3, mockList.size());
		assertEquals(3, mockList.size());
		
	}
	
	@Test
	public void lestMockListGet() {
		List mockList = mock(List.class);
		//Argumnet Matcher
		when(mockList.get(anyInt())).thenReturn("in Mockito");
		assertEquals("in Mockito", mockList.get(0));
		
	}
	
	
	@Test(expected=RuntimeException.class)
	public void lestMockList_throwAnException() {
		List mockList = mock(List.class);
		//Argumnet Matcher
		when(mockList.get(anyInt())).thenThrow(new RuntimeException("Something"));
		mockList.get(0);
		
	}


}
