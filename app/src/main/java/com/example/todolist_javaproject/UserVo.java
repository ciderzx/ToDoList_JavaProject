package com.example.todolist_javaproject;

import java.io.Serializable;
import java.util.Date;

public class UserVo implements Serializable {
    private int userId;
    private String userName;
    private String loginId;
    private String password;
    private String companyName;
    private int completeCnt;
    private int todoCnt;
    private Date regDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCompleteCnt() {
        return completeCnt;
    }

    public void setCompleteCnt(int completeCnt) {
        this.completeCnt = completeCnt;
    }

    public int getTodoCnt() {
        return todoCnt;
    }

    public void setTodoCnt(int todoCnt) {
        this.todoCnt = todoCnt;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public UserVo(int userId, String userName, String loginId, String companyName, int completeCnt, int todoCnt) {
        this.userId = userId;
        this.userName = userName;
        this.loginId = loginId;
        this.companyName = companyName;
        this.completeCnt = completeCnt;
        this.todoCnt = todoCnt;
    }

    public UserVo() {
    }
}

