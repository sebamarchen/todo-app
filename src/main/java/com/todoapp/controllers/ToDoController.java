package com.todoapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todoapp.domain.ToDoItem;
import com.todoapp.services.ToDoService;

// http://localhost:8080
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToDoController {

	@Autowired
	private ToDoService toDoService;
	
	@GetMapping("/api/todoItems")
	public ResponseEntity<?> fetchAllToDoItems(){
		List<ToDoItem> todoitem = toDoService.fetchAllToDoItems();
		return ResponseEntity.ok(todoitem); //el "ok" es lo mismo que poner "status(HttpStatus.OK).body"
	}
	
	@PostMapping("/api/todoItems")
	public ResponseEntity<?> createNewToDoItem(){
		ToDoItem toDoItem = toDoService.createToDoItem();
		return ResponseEntity.ok(toDoItem);
	}
	
	@PutMapping("/api/todoItems/{id}")
	public ResponseEntity<?> updateToDoItems(@PathVariable Integer id, @RequestBody ToDoItem body){
		ToDoItem updatedToDoItem = toDoService.updateToDoItem(id, body);
		return ResponseEntity.ok(updatedToDoItem);
	}
	
	@DeleteMapping("/api/todoItems/{id}")
	public ResponseEntity<?> deleteToDoItems(@PathVariable Integer id){
		toDoService.deleteToDoItem(id);
		return ResponseEntity.ok(null);
	}
}
