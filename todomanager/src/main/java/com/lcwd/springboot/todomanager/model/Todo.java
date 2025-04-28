package com.lcwd.springboot.todomanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Todo {

  private int id;
    private String title;

    private String content;

    private String status;

    private Date creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date toBeCompletionDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Todo(int id, String title, String content, String status, Date creationDate, Date toBeCompletionDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.creationDate = creationDate;
        this.toBeCompletionDate = toBeCompletionDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getToBeCompletionDate() {
        return toBeCompletionDate;
    }

    public void setToBeCompletionDate(Date toBeCompletionDate) {
        this.toBeCompletionDate = toBeCompletionDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Todo() {
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
