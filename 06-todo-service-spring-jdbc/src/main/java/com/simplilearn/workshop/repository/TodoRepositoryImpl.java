package com.simplilearn.workshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.simplilearn.workshop.domain.Todo;

@Repository(value = "todoRepository")
public class TodoRepositoryImpl implements TodoRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int getTodosCount() {
		int count = this.jdbcTemplate.queryForObject("select count(*) from todos", Integer.class);
		return count;
	}


	private final RowMapper<Todo> rowMapper = (rSet, rowNum) -> {
		Todo todo = new Todo();
		todo.setId(rSet.getInt("id"));
		todo.setDescription(rSet.getString("description"));
		todo.setUsername(rSet.getString("user"));
		todo.setTargetDate(rSet.getDate("targetdate"));
		todo.setDone(rSet.getBoolean("isDone"));

		return todo;
	};


	@Override
	public List<Todo> findAll() {
		List<Todo> listTodos = this.jdbcTemplate.query("select * from todos", rowMapper);

		return listTodos;
	}

	@Override
	public Todo save(Todo theTodo) {
//		int result =
//			this.jdbcTemplate.update(
//				"insert into todos(username, description, isDone, targetdate) values (?, ?, ?, ?)",
//				theTodo.getUsername(),
//				theTodo.getDescription(),
//				theTodo.isDone(),
//				theTodo.getTargetDate());
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement("insert into todos(username, description, isDone, targetdate) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		        statement.setString(1, theTodo.getUsername());
		        statement.setString(2, theTodo.getDescription());
		        statement.setBoolean(3, theTodo.isDone());
		        statement.setDate(4, new java.sql.Date(theTodo.getTargetDate().getTime()));
		        return statement;
			}
		}, holder);

		theTodo.setId(holder.getKey().longValue());
		return theTodo;
	}

	@Override
	public Todo deleteById(long theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo findById(long theId) {
		Todo todo = this.jdbcTemplate.queryForObject("select * from todos where id = ?", rowMapper, theId);
		return todo;
	}



}
