package com.todo.dao;

import java.util.List;

import com.todo.TodoException;
import com.todo.vo.TodoVO;

public interface TodoDao {

	public List<TodoVO> getAllTodos() throws  TodoException;
	public List<TodoVO> insertTodo(TodoVO todoVO)throws  TodoException;
	public List<TodoVO> deleteTodo(Long id)throws  TodoException;
	public List<TodoVO> updateTodo(TodoVO todoVO)throws  TodoException;
	
}
