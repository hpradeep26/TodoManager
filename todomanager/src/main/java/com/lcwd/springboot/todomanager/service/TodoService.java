package com.lcwd.springboot.todomanager.service;

import com.lcwd.springboot.todomanager.exception.ResourceNotFoundException;
import com.lcwd.springboot.todomanager.model.Todo;
import com.lcwd.springboot.todomanager.repositary.TodoRepositary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);
    @Autowired
    TodoRepositary todoRepositary;
    List<Todo> todoList = new ArrayList<>();

    Random random = new Random();
    public void save(Todo todo){
        Todo savedTodo = todoRepositary.save(todo);
        logger.debug("Saved Todo = {}",savedTodo);
    }

    public List<Todo> getTodos(){
        todoList = todoRepositary.getTodos();
        return todoList;
    }

    public Todo getTodo(int todoId){
        return todoRepositary.getTodo(todoId);
    }

    public Todo update(int todoId, Todo todo) {
        return todoRepositary.update(todoId,todo);

    }

    public Todo delete(int todoId) {
      return todoRepositary.delete(todoId);
    }
}
