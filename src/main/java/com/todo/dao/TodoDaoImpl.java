package com.todo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.todo.TodoException;
import com.todo.vo.TodoVO;

@Repository
public class TodoDaoImpl implements TodoDao {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	final String INSERT_QUERY = "insert into TODO (name, status) values (:name, :status)";
	final String DELETE_QUERY = "delete from TODO where id=:id";
	final String UPDATE_QUERY="update TODO set status=:status where id=:id";
	public List<TodoVO> getAllTodos() throws TodoException
	{
		try{
		String sql="select * from TODO";
		return jdbcTemplate.query(sql,new RowMapper<TodoVO>() {
			@Override
			public TodoVO mapRow(ResultSet arg0, int arg1) throws SQLException {
				TodoVO todoVO = new TodoVO();
				todoVO.setId(arg0.getLong("id"));
				todoVO.setName(arg0.getString("NAME"));
				todoVO.setStatus(arg0.getString("status"));
				return todoVO;
			}
		});
		}
		catch(Exception e)
		{
			throw new TodoException("unable to get Todos"+e.getMessage());
		}
	}
	public List<TodoVO> insertTodo(TodoVO todoVO) throws TodoException
	{
		try{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", todoVO.getName());
		paramMap.put("status", todoVO.getStatus());
		int count=jdbcTemplate.update(INSERT_QUERY, paramMap);
		if(count<1)throw new TodoException("unable to insert Todo ");
		return getAllTodos();
		}
		catch (Exception e) {
			throw new TodoException("unable to insert Todo "+e.getMessage());
		}
	}
	public List<TodoVO> deleteTodo(Long id) throws TodoException
	{
		try{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);		
		int count=jdbcTemplate.update(DELETE_QUERY, paramMap);
		if(count<1)throw new TodoException("unable to delete Todo ");
		return getAllTodos();
		}
		catch (Exception e) {
			throw new TodoException("unable to delete Todo "+e.getMessage());
		}
	}
	public List<TodoVO> updateTodo(TodoVO todoVO) throws TodoException
	{
		try
		{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", todoVO.getId());
		paramMap.put("status", todoVO.getStatus());
		int count=jdbcTemplate.update(UPDATE_QUERY, paramMap);
		if(count<1)throw new TodoException("unable to update Todo ");
		return getAllTodos();
		}
		catch(Exception e)
		{
			throw new TodoException("unable to update Todo "+e.getMessage());
		}
	}
	
	

}
