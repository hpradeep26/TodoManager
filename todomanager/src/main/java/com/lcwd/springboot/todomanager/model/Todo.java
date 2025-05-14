package com.lcwd.springboot.todomanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Todo {

    private int id;
    private String title;

    private String content;

    private String status;

    private Date creationDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date toBeCompleteDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Todo(int id, String title, String content, String status, Date creationDate, Date toBeCompleteDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.creationDate = creationDate;
        this.toBeCompleteDate = toBeCompleteDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getToBeCompleteDate() {
        return toBeCompleteDate;
    }

    public void setToBeCompleteDate(Date toBeCompleteDate) {
        this.toBeCompleteDate = toBeCompleteDate;
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
                ", creationDate=" + creationDate +
                ", toBeCompleteDate=" + toBeCompleteDate +
                '}';
    }
}
