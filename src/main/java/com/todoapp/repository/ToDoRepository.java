package com.todoapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.todoapp.domain.ToDoItem;

@Repository
public class ToDoRepository {

	private Integer idCounter = 0;
	private List<ToDoItem> todoitems = new ArrayList<>();
	
	public List<ToDoItem> fetchAllToDoItems(){
		if (todoitems.size()==0) {
			ToDoItem item1 = new ToDoItem();
			item1.setId(idCounter++);
			item1.setDone(true);
			item1.setTask("Tarea 1");
			
			todoitems.add(item1);
		}
		return todoitems;
	}
	
	public ToDoItem save (ToDoItem toDoItem) {
		toDoItem.setId(idCounter++);
		todoitems.add(toDoItem);
		return toDoItem;
	}

	public void delete(Integer id) {
		todoitems = todoitems.stream()
								.filter(ToDoItem -> !ToDoItem.getId().equals(id))
								.collect(Collectors.toList());
					
	}
}
