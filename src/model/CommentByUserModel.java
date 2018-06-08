package model;

import entity.CommentEntity;

import java.util.Date;

public class CommentByUserModel {
    private String comment_id;
    private String post_id;
    private String user_id;
    private Date date;
    private String detail;
    private int like_num;
    private String postTiltle;

    public CommentByUserModel(CommentEntity comment, String postTiltle) {
        this.comment_id = comment.getComment_id();
        this.post_id = comment.getPost_id();
        this.user_id = comment.getUser_id();
        this.date = comment.getDate();
        this.detail = comment.getDetail();
        this.like_num = comment.getLike_num();
        this.postTiltle = postTiltle;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String getPostTiltle() {
        return postTiltle;
    }

    public void setPostTiltle(String postTiltle) {
        this.postTiltle = postTiltle;
    }
}
