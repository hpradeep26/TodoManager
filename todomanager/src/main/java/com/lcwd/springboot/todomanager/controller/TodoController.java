package com.lcwd.springboot.todomanager.controller;

import com.lcwd.springboot.todomanager.model.Todo;
import com.lcwd.springboot.todomanager.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody Todo todo){
        logger.info("Todo object to save {}" , todo);
        todoService.save(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos(){
        List<Todo> todoList =  todoService.getTodos();
        logger.info("todo list {}", todoList);
        return ResponseEntity.ok(todoList);
    }
    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodo(@PathVariable int todoId){
        Todo todo = todoService.getTodo(todoId);
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }
    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo,@PathVariable int todoId){
        Todo update = todoService.update(todoId, todo);
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable int todoId){
        Todo delete = todoService.delete(todoId);
        return ResponseEntity.status(HttpStatus.OK).body(delete);
    }

   /* @ExceptionHandler
    public ResponseEntity<String> nullPointerException(NullPointerException ex){
        return new ResponseEntity<>("Null pointer Exception "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(value={NullPointerException.class, NumberFormatException.class})
    public ResponseEntity<String> exceptionHandler(Exception ex){
        return new ResponseEntity<>("Exception Occured "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
