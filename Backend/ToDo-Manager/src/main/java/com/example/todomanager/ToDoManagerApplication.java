package com.example.todomanager;

import com.example.todomanager.Dao.ToDoDao;
import com.example.todomanager.models.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class ToDoManagerApplication implements CommandLineRunner {
    Logger logger= LoggerFactory.getLogger(ToDoManagerApplication.class);

    @Autowired
    private ToDoDao toDoDao;

    public static void main(String[] args) {
        SpringApplication.run(ToDoManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Application started");
//        JdbcTemplate template=toDoDao.getTemplate();
//        logger.info("Template Object : {} ,{}",template ,template.toString());

//        ToDo todo=new ToDo();
//        todo.setId(12322);
//        todo.setTitle("aaaa");
//        todo.setStatus("Workimg");
//        todo.setContent("succesaa");
//        toDoDao.saveTodo(todo);
//       ToDo todo= toDoDao.getTodo(12322);
//        logger.info("TODO:{}",todo);
//        todo.setTitle("Java");
//        todo.setStatus("Learning");
//        todo.setContent("JDBC connection");
//        toDoDao.updateTodo(12345,todo);

//
        List<ToDo> allTodo=toDoDao.getAllTodo();
        logger.info("TODO:{}",allTodo);

//        toDoDao.deleteTodo(123);
//        toDoDao.deleteAllTodo(new int[]{123,12345});

    }
}
