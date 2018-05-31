package entity;

import java.util.Date;

public class Report {
    private String id;
    private String beReport_id;
    private String user_id;
    private String type;
    private String detail;
    private Date date;

    public Report(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeReport_id() {
        return beReport_id;
    }

    public void setBeReport_id(String beReport_id) {
        this.beReport_id = beReport_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
