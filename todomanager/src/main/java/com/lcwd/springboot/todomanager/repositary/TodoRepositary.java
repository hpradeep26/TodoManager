package com.lcwd.springboot.todomanager.repositary;

import com.lcwd.springboot.todomanager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class TodoRepositary {

    Logger logger = LoggerFactory.getLogger(TodoRepositary.class);
    JdbcTemplate jdbcTemplate;

    public TodoRepositary(@Autowired JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        String sql = "CREATE TABLE IF NOT EXISTS TODOS (id int primary key,title varchar(100),content varchar(500),status varchar(50),creationDate date,toBeCompleteDate date)";
        int update = jdbcTemplate.update(sql);
        logger.debug("Table Created = {} ",update);
    }

    public Todo save(Todo todo){
        String insertStmt = "INSERT INTO TODOS(Id,title,content,status,creationDate,toBeCompleteDate) values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(insertStmt,todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getCreationDate(),todo.getToBeCompleteDate());
        logger.debug("Todo Saved = {} ",update);
        return todo;
    }

    public Todo getTodo(int todoId) {
        return jdbcTemplate.queryForObject("select * from todos where id=?", new TodoRowMapper(),todoId);
    }

    public List<Todo> getTodos() {
        String stmt = "SELECT * FROM TODOS";
        return jdbcTemplate.query(stmt, new TodoRowMapper());
    }

    public Todo update(int todoId, Todo todo) {
        String stmt = "UPDATE TODOS SET title = ? ,status = ? ,content = ? ,creationDate=?, toBeCompleteDate=? where id=?";
        jdbcTemplate.update(stmt,todo.getTitle(),todo.getStatus(),todo.getContent(),todo.getCreationDate(),todo.getToBeCompleteDate(),todoId);
        return getTodo(todoId);
    }

    public Todo delete(int todoId) {
        Todo todo = getTodo(todoId);
        String stmt = "DELETE * FROM TODOS WHERE id=?";
        int updateCount = jdbcTemplate.update(stmt, todoId);
        logger.debug("row updated = {}",updateCount);
        return todo;
    }


    class TodoRowMapper implements RowMapper< Todo > {
        @Override
        public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Todo t = new Todo();
            t.setId(rs.getInt(1));
            t.setTitle(rs.getString(2));
            t.setContent(rs.getString(3));
            t.setStatus(rs.getString(4));
            t.setCreationDate(rs.getDate(5));
            t.setToBeCompleteDate(rs.getDate(6));
            return t;
        }
    }

}
