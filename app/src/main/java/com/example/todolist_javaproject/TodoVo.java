package com.example.todolist_javaproject;

import java.util.Date;

public class TodoVo {
    private static final long serialVersionUID = 1L;
    private int todoId;
    private String dateId;
    private int userId;
    private String todoTitle;
    private String todoData;
    private String completeFlag;
    private String deleteFlag;
    private Date regDate;

    public TodoVo() {

    }

    public TodoVo(int todoId, String dateId, int userId, String todoTitle, String todoData, String completeFlag, String deleteFlag, Date regDate) {
        this.todoId = todoId;
        this.dateId = dateId;
        this.userId = userId;
        this.todoTitle = todoTitle;
        this.todoData = todoData;
        this.completeFlag = completeFlag;
        this.deleteFlag = deleteFlag;
        this.regDate = regDate;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getDateId() {
        return dateId;
    }

    public void setDateId(String dateId) {
        this.dateId = dateId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoData() {
        return todoData;
    }

    public void setTodoData(String todoData) {
        this.todoData = todoData;
    }

    public String getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(String completeFlag) {
        this.completeFlag = completeFlag;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
