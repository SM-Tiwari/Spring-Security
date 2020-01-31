package com.siddhesh.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.siddhesh.data.api.TodoService;
import com.siddhesh.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("dummy");
		assertEquals(2, filteredTodos.size());
	}

}
