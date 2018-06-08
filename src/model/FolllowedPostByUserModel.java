package model;

import entity.PostEntity;

import java.util.Date;

public class FolllowedPostByUserModel {
    private String author_id;
    private String author_name;
    private Date pub_date;
    private Date last_date;
    private int like_number;
    private int follow_number;
    private String post_id;
    private String detail;
    private String title;

    public FolllowedPostByUserModel(PostEntity post, String author_name) {
        this.author_id = post.getUser_id();
        this.author_name = author_name;
        this.pub_date = post.getPub_date();
        this.last_date = post.getLast_date();
        this.like_number = post.getLike_number();
        this.follow_number = post.getFollow_number();
        this.post_id = post.getPost_id();
        this.detail = post.getDetail();
        this.title = post.getTitle();
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
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
