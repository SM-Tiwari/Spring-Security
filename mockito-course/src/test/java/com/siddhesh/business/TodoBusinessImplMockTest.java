package com.siddhesh.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.siddhesh.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		//Given
		TodoService mockTodoService = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn to Dance", "Learn Spring");
		when(mockTodoService.retrieveTodos("dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		
		//When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");
		
		
		//Then 
		
		
		
		
		
		assertEquals(2, filteredTodos.size());
	}
	

}
