package org.arthan.todo.repository;

import org.arthan.todo.model.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ashamsiev on 03.11.2016
 */
public class InMemoryToDoRepository implements ToDoRepository {

    private AtomicLong currentId = new AtomicLong();
    private ConcurrentMap<Long, ToDoItem> toDos = new ConcurrentHashMap<>();

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> toDoItems = new ArrayList<>(toDos.values());
        Collections.sort(toDoItems);
        return toDoItems;
    }

    @Override
    public ToDoItem findById(Long id) {
        return toDos.get(id);
    }

    @Override
    public Long insert(ToDoItem toDoItem) {
        long newId = currentId.incrementAndGet();
        toDoItem.setId(newId);
        toDos.putIfAbsent(newId, toDoItem);
        return newId;
    }

    @Override
    public void update(ToDoItem toDoItem) {
        toDos.replace(toDoItem.getId(), toDoItem);
    }

    @Override
    public void delete(ToDoItem toDoItem) {
        toDos.remove(toDoItem.getId());
    }
}
