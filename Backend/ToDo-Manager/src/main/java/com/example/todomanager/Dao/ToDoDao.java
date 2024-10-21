package com.example.todomanager.Dao;

import com.example.todomanager.models.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Repository
public class ToDoDao {

    Logger logger=LoggerFactory.getLogger(ToDoDao.class);

    private JdbcTemplate template;

    public ToDoDao(JdbcTemplate template) {
        this.template = template;
        logger.info("We are in ToDoDao layer");
//        //create table if table not exist
        String createTable = "CREATE TABLE IF NOT EXISTS todos ("
                + "id INT PRIMARY KEY, "
                + "title VARCHAR(100) NOT NULL, "
                + "content VARCHAR(100) NOT NULL, "
                + "status VARCHAR(1000) NOT NULL);";

        int upd= template.update(createTable);
        logger.info("TODO Table created :{}",upd );

    }

    public JdbcTemplate getTemplate() {
        return this.template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }


    //save todo in database

    public ToDo saveTodo(ToDo toDo){

        String insertQuery=" insert into todos(id,Title,Content,Status) values(?,?,?,?)";
        int rows=template.update(insertQuery, toDo.getId(),toDo.getTitle(),toDo.getContent(),toDo.getStatus());
        logger.info("JDBC Operation :{} inserted",rows);
        return  toDo;
    }

    //get single Todo from database
    public  ToDo getTodo(int id){
        String query="select * from todos WHERE id=?";
        ToDo toDo=template.queryForObject(query,new Todorowmapper(),id);
//        Map<String,Object> newMap=template.queryForMap(query,id);

//        ToDo toDo=new ToDo();
//
//        toDo.setId(((int)newMap.get("id")));
//        toDo.setTitle(((String) newMap.get("title")));
//        toDo.setStatus(((String) newMap.get("status")));
//        toDo.setContent(((String) newMap.get("content")));

        return toDo;
    }

    //get all Todo from database
    public List<ToDo> getAllTodo(){
        String query="select * from todos";
        List<ToDo> toDo=template.query(query,new Todorowmapper());
//        List<Map<String,Object>> maps=template.queryForList(query);
//        List<ToDo> toDos=maps.stream().map((map)->{
//            ToDo toDo=new ToDo();
//
//            toDo.setId(((int)map.get("id")));
//            toDo.setTitle(((String) map.get("title")));
//            toDo.setStatus(((String) map.get("status")));
//            toDo.setContent(((String) map.get("content")));

//            return toDo;
//
//        }).collect(Collectors.toList());
        return toDo;
    }

    //update Todo
    public ToDo updateTodo(int id,ToDo newTodo){
        String query="update todos set title=?,content=?,status=? WHERE id=?";
        int update=template.update(query,newTodo.getTitle(),newTodo.getStatus(),newTodo.getContent(),id);
        logger.info("Updated todo :{}",update);
        newTodo.setId(id);
        return newTodo;

    }

    //delete Todo
    public void deleteTodo(int id){
        String query="delete from todos WHERE id=?";
        int delete=template.update(query,id);
        logger.info("DELETED;{}",delete);
    }

    //delete multiple
    public  void  deleteAllTodo(int ids[]){
        String query="delete from todos where id=?";
        template.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                int id= ids[i];
                ps.setInt(1,id);
            }

            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });
        for(int i:ids){
            logger.info("Deleted {}:",i);
        }
    }

}
