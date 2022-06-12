package com.simplilearn.workshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simplilearn.workshop.domain.Todo;
import com.simplilearn.workshop.utils.MySQLDatabaseConnectionUtil;

public class TodoRepositoryImpl implements TodoRepository {

	private static List<Todo> todos = new ArrayList<>();
	private static int counter = 0;

	static {
		todos.add(new Todo(++counter, "simplilearn", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++counter, "simplilearn", "Learn to Cook", new Date(), false));
		todos.add(new Todo(++counter, "simplilearn", "Learn to Skate", new Date(), false));
	}


	@Override
	public List<Todo> findAll() {
		List<Todo> listTodos = new ArrayList<>();
		try(
			Connection conn = MySQLDatabaseConnectionUtil.getConnection();
															// This is Business Logic
			PreparedStatement pStmt = conn.prepareStatement("select * from studentdb.todos");
			ResultSet rSet = pStmt.executeQuery()
		){
			while (rSet.next()) {
				Todo todo = new Todo();
				todo.setId(rSet.getInt("id"));
				todo.setDescription(rSet.getString("description"));
				todo.setUsername(rSet.getString("user"));
				todo.setTargetDate(rSet.getDate("targetdate"));
				todo.setDone(rSet.getBoolean("isDone"));

				listTodos.add(todo);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// This is Business Logic
		return listTodos;
	}

	@Override
	public Todo save(Todo theTodo) {
		// Obtain a Connection
		// Obtain a Statement
		// Prepare a Statement
		// Execute the Statement



		if(theTodo.getId() == -1 || theTodo.getId() == 0) {
			theTodo.setId(++counter);
			todos.add(theTodo);
		}else {
			deleteById(theTodo.getId());
			todos.add(theTodo);
		}
		return theTodo;
	}

	@Override
	public Todo deleteById(long theId) {
		Todo theTodo = findById(theId);
		if(null == theTodo) {
			return null;
		} else if (todos.remove(theTodo)) {
			return theTodo;
		} else {
			return null;
		}
	}

	@Override
	public Todo findById(long theId) {
		for (Todo todo : todos) {
			if(todo.getId() == theId) {
				return todo;
			}
		}
		return null;
	}

}
