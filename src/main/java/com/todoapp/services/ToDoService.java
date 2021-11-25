package com.todoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.domain.ToDoItem;
import com.todoapp.repository.ToDoRepository;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepo;
	
	public List<ToDoItem> fetchAllToDoItems () {
		return toDoRepo.fetchAllToDoItems();
	}

	public ToDoItem updateToDoItem(Integer id, ToDoItem toDoItem) {
		Optional<ToDoItem> toDoOpt = toDoRepo.fetchAllToDoItems()
												.stream()
												.filter(item -> item.getId().equals(id))
												.findAny();
		if(toDoOpt.isPresent()) {
			ToDoItem item = toDoOpt.get();
			item.setDone(toDoItem.isDone());
			item.setTask(toDoItem.getTask());
			return item;
		}
		return null;
	}

	public ToDoItem createToDoItem() {
		ToDoItem toDoItem = new ToDoItem();
		toDoItem.setDone(false);
		toDoItem = toDoRepo.save(toDoItem);
		toDoItem.setTask("Tarea #"+toDoItem.getId());
		return toDoItem;
	}

	public void deleteToDoItem(Integer id) {
		toDoRepo.delete(id);
	}
}
