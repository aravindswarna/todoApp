package com.todo.service;

import java.util.List;

import com.todo.TodoException;
import com.todo.vo.TodoVO;

public interface TodoService {
	
	public List<TodoVO> getAllTodos()throws  TodoException;
	public List<TodoVO> insertTodo(TodoVO todoVO)throws  TodoException;
	public List<TodoVO> deleteTodo(Long id)throws  TodoException;
	public List<TodoVO> updateTodo(TodoVO todoVO)throws  TodoException;

}
