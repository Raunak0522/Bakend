package com.example.todomanager.services.Implementation;

import com.example.todomanager.Dao.ToDoDao;
import com.example.todomanager.models.ToDo;
import com.example.todomanager.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ToDoDaoServiceImple implements TodoService {

    @Autowired
    private ToDoDao toDoDao;
    @Override
    public ToDo createTodo(ToDo todo) {
        return toDoDao.saveTodo(todo);
    }

    @Override
    public List<ToDo> getALLtodos() {
        return toDoDao.getAllTodo();
    }

    @Override
    public ToDo updateToDO(int todoId, ToDo toDo) {
        return toDoDao.updateTodo(todoId, toDo);
    }

    @Override
    public void deleteToDO(int todoId) {
            toDoDao.deleteTodo(todoId);
    }
}
