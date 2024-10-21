package com.example.todomanager.services;

import com.example.todomanager.models.ToDo;

import java.util.List;

public interface TodoService {

    public ToDo createTodo(ToDo todo);

    public List<ToDo> getALLtodos();

    public ToDo updateToDO(int todoId,ToDo toDo);

    public void deleteToDO(int todoId);
}
