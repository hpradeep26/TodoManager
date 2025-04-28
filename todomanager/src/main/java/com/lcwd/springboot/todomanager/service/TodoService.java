package com.lcwd.springboot.todomanager.service;

import com.lcwd.springboot.todomanager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {

    Logger logger = LoggerFactory.getLogger(TodoService.class);
    List<Todo> todoList = new ArrayList<>();

    Random random = new Random();
    public void save(Todo todo){
        logger.info("todo {} ",todo);
        int i = random.nextInt(1000);
        todo.setId(i);
        Date currentDate = new Date();
        todo.setCreationDate(currentDate);
        todoList.add(todo);
    }

    public List<Todo> getTodos(){
        return todoList;
    }

    public Todo getTodo(int todoId){
        return todoList.stream()
                .filter(t -> t.getId() == todoId)
                .findAny()
                .get();

    }

    public Todo update(int todoId, Todo todo) {
        List<Todo> updatedList = todoList.stream()
                .map(t -> {
                    if (t.getId() == todoId) {
                        t.setTitle(todo.getTitle());
                        t.setContent(todo.getContent());
                        t.setStatus(todo.getStatus());
                        return t;
                    } else {
                        return t;
                    }
                }).collect(Collectors.toList());

        return getTodo(todoId);

    }

    public Todo delete(int todoId) {
        Todo todo = getTodo(todoId);
        todoList = todoList.stream()
                .filter(t-> t.getId()!=todoId)
                .collect(Collectors.toList());

        return todo;
    }
}
