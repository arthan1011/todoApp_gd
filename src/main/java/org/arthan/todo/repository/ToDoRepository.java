package org.arthan.todo.repository;

import org.arthan.todo.model.ToDoItem;

import java.util.List;

/**
 * Created by ashamsiev on 03.11.2016
 */
public interface ToDoRepository {

    List<ToDoItem> findAll();
    ToDoItem findById(Long id);
    Long insert(ToDoItem toDoItem);
    void update(ToDoItem toDoItem);
    void delete(ToDoItem toDoItem);
}
