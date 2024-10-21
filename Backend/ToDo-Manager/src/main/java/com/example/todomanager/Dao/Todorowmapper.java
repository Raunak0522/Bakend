package com.example.todomanager.Dao;

import com.example.todomanager.models.ToDo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Todorowmapper implements RowMapper<ToDo> {
    @Override
    public ToDo mapRow(ResultSet rs, int rowNum) throws SQLException {
        //rs is the result set
        ToDo toDo=new ToDo();

        toDo.setId((rs.getInt("id")));
        toDo.setTitle((rs.getString("title")));
        toDo.setStatus((rs.getString("status")));
        toDo.setContent((rs.getString("content")));

        return toDo;
    }
}
