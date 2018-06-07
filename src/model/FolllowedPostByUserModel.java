package model;

import entity.PostEntity;

import java.util.Date;

public class FolllowedPostByUserModel {
    private String user_id;
    private String user_name;
    private Date pub_date;
    private Date last_date;
    private int like_number;
    private int follow_number;
    private String post_id;
    private String detail;
    private String title;

    public FolllowedPostByUserModel(PostEntity postEntity, String user_name) {
        this.user_id = postEntity.getUser_id();
        this.user_name =user_name;
        this.pub_date = postEntity.getPub_date();
        this.last_date = postEntity.getLast_date();
        this.like_number = postEntity.getLike_number();
        this.follow_number = postEntity.getFollow_number();
        this.post_id = postEntity.getPost_id();
        this.detail = postEntity.getDetail();
        this.title = postEntity.getTitle();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public Date getLast_date() {
        return last_date;
    }

    public void setLast_date(Date last_date) {
        this.last_date = last_date;
    }

    public int getLike_number() {
        return like_number;
    }

    public void setLike_number(int like_number) {
        this.like_number = like_number;
    }

    public int getFollow_number() {
        return follow_number;
    }

    public void setFollow_number(int follow_number) {
        this.follow_number = follow_number;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
