package com.example.todomanager.services.Implementation;

import com.example.todomanager.models.ToDo;
import com.example.todomanager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ToDoServicesImple implements TodoService {
    Logger logger=LoggerFactory.getLogger(ToDoServicesImple.class);
    List<ToDo> TDo=new ArrayList<ToDo>();
    public ToDo createTodo(ToDo todo){
        //create
        TDo.add(todo);
        logger.info("ToDp {}",this.TDo);
        return  todo;
    }

    public List<ToDo> getALLtodos() {
        return TDo;
    }

    public ToDo updateToDO(int todoId,ToDo toDo){
       List<ToDo> newUpdateList= TDo.stream().map(t->{
            if(t.getId() ==todoId){
                t.setTitle(toDo.getTitle());
                t.setContent(toDo.getContent());
                t.setStatus(toDo.getStatus());
                return  t;
            }
            else {
                return t;
            }
        }).collect(Collectors.toList());
       TDo=newUpdateList;
       toDo.setId(todoId);
       return toDo;
    }

    public void deleteToDO(int todoId) {
       List<ToDo> newList= TDo.stream().filter(t->t.getId()!=todoId).collect(Collectors.toList());
       TDo=newList;
    }
}
