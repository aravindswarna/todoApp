package com.todo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo.TodoException;
import com.todo.dao.TodoDaoImpl;
import com.todo.service.TodoService;
import com.todo.vo.TodoVO;

@RestController
public class TodoController {
	
	@Autowired
	TodoService todoService;
	@CrossOrigin
	@RequestMapping(value="/api/todo",method=RequestMethod.GET)
	public List<TodoVO> getTodo() throws  TodoException
	{
		return todoService.getAllTodos();
	}
	@CrossOrigin
	@RequestMapping(value="/api/todo",method=RequestMethod.POST)
	public List<TodoVO> createTodo(@RequestBody TodoVO todoVO) throws  TodoException
	{
		return todoService.insertTodo(todoVO);
	}
	@CrossOrigin
	@RequestMapping(value="/api/todo/{id}",method=RequestMethod.DELETE)
	public List<TodoVO> deleteTodo(@PathVariable("id") Long id) throws  TodoException
	{
		return todoService.deleteTodo(id);
	}
	@CrossOrigin
	@RequestMapping(value="/api/todo",method=RequestMethod.PUT) 
	public List<TodoVO> updateTodo(@RequestBody TodoVO todoVO)throws  TodoException
	{
		return todoService.updateTodo(todoVO);
	}

}
