package com.example.todomanager.controllers;

import com.example.todomanager.models.ToDo;
//import com.example.todomanager.services.Implementation.ToDoService;
import com.example.todomanager.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class ToDoControllers {

    Logger logger= LoggerFactory.getLogger(ToDoControllers.class);
    @Autowired
    private TodoService toDoServices;
    Random random=new Random();
    //create todo

    @PostMapping
    public ResponseEntity<ToDo> createTodOhandler(@RequestBody ToDo todo){
       int id=random.nextInt(99999);
       todo.setId(id);
        logger.info("create ToDo");
     ToDo todo1=toDoServices.createTodo(todo);
     return new ResponseEntity<>(todo1, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAlltodo(){
        List<ToDo> alLtodos=toDoServices.getALLtodos();
        return  new ResponseEntity<>(alLtodos,HttpStatus.OK);
    }

    @PutMapping({"/{todoId}"})
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo todowithNew ,@PathVariable int todoid){
       ToDo toDo1= toDoServices.updateToDO(todoid,todowithNew);
       return ResponseEntity.ok(toDo1);
    }

    @DeleteMapping({"/todoId"})
    public ResponseEntity<String> deleteToDo(@PathVariable int todoId){
        logger.info("Deleting ToDO");
            toDoServices.deleteToDO(todoId);
            return ResponseEntity.ok("ToDo succesfully deleted");

    }
}
