package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.TodoException;
import com.todo.dao.TodoDaoImpl;
import com.todo.vo.TodoVO;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	TodoDaoImpl todoDao;
	
	public List<TodoVO> getAllTodos() throws  TodoException
	{
		return todoDao.getAllTodos();
	}
	public List<TodoVO> insertTodo(TodoVO todoVO) throws  TodoException
	{
		return todoDao.insertTodo(todoVO);
	}
	public List<TodoVO> deleteTodo(Long id) throws  TodoException
	{
		return todoDao.deleteTodo(id);
	}
	public List<TodoVO> updateTodo(TodoVO todoVO) throws  TodoException
	{
		return todoDao.updateTodo(todoVO);
	}

}
