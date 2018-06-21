package serivce;

import dao.CommentDao;
import dao.PostDao;
import dao.UserDao;
import entity.PostEntity;
import entity.UserEntity;
import model.CommentByUserModel;
import model.FolllowedPostByUserModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class Test {
    public int test_updateUsrName(String id, String name){
        int r = 0;
        try {
            r = (new UserDao()).updateUsrInfo_name(id, name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int test_updateUsrPwd(String id, String pwd){
        int r = 0;
        try {
            r = (new UserDao()).updateUsrInfo_pwd(id, pwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int test_updateUsrHead(String id, String head){
        int r = 0;
        try {
            r = (new UserDao()).updateUsrInfo_head(id, head);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int test_updateUsrEmail(String id, String email){
        int r = 0;
        try {
            r = (new UserDao()).updateUsrInfo_Email(id, email);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int test_updatePostLikeNum(String id, boolean isAdd){
        int r = 0;
        try {
            r = (new PostDao()).updatePostInfo_likeNum(id, isAdd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int test_updatePostFollowNum(String id, boolean isAdd){
        int r = 0;
        try {
            r = (new PostDao()).updatePostInfo_FollowNum(id, isAdd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return r;
    }

    public int test_getArticle_count(String user_id){
        int count = 0;
        try {
            count = (new UserDao()).getUserArticleCount_byId(user_id);
        } catch (SQLException e) {
            System.out.println("fail to test_getArticle_count\n"+e.getMessage());
        }
        return count;
    }

    public int test_getFollowed_count(String user_id){
        int count = 0;
        try {
            count = (new UserDao()).getUserFollowedCount_byUserId(user_id);
        } catch (SQLException e) {
            System.out.println("fail to test_getFollowed_count\n"+e.getMessage());
        }
        return count;
    }

    public int test_getCommentCount_byPostId(String post_id){
        int count = 0;
        try {
            count = (new CommentDao()).getCommentCount_byPostId(post_id);
        } catch (SQLException e) {
            System.out.println("fail to test_getCommentCount_byPostId\n"+e.getMessage());
        }
        return count;
    }

    public int test_getFollowedCount_byPostId(String post_id){
        int count = 0;
        try {
            count = (new PostDao()).getFollowedCount_byPostId(post_id);
        } catch (SQLException e) {
            System.out.println("fail to test_getFollowedCount_byPostId\n"+e.getMessage());
        }
        return count;
    }

    public void test_getComments_byUsrId(String usr_id){
        try {
            ArrayList<CommentByUserModel> comments = new CommentDao().getComments_byUsrId(usr_id);
            for (CommentByUserModel model : comments){
                println(model.getComment_id());
                println(model.getDate());
                println(model.getPostTiltle());
                println("-----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("fail to test_getComments_byUsrId"+e.getMessage());
        }
    }

    public void test_getFollowedPosts_byUserid(String usr_id){
        try {
            ArrayList<FolllowedPostByUserModel> models = new PostDao().getFollowedPosts_byUserid(usr_id);
            for (FolllowedPostByUserModel model : models){
                println(model.getTitle());
                println(model.getAuthor_name());
                println(model.getPub_date().toString());
                println("-----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("fail to test_getFollowedPosts_byUserid"+e.getMessage());
        }
    }

    /**
     * 给陈祥梅用的示例：显示关注的人列表（每个关注的人：名字/粉丝数/发表文章数/）
     * @param usr_id
     */
    public void test_getFollowingUser_byUserId(String usr_id){
        try {
            ArrayList<UserEntity> users = new UserDao().getFollowingUser_byUserId(usr_id);
            for (UserEntity user : users){
                System.out.println(user.getName());
                System.out.println(new UserDao().getUserFollowedCount_byUserId(user.getId()));
                System.out.println(new UserDao().getUserArticleCount_byId(user.getId()));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void test_getPosts_byKeyword(String keyword){
        try {
            ArrayList<PostEntity> posts = new PostDao().getPosts_byKeyword(keyword);
            for (PostEntity post : posts){
                System.out.println("post title: "+post.getTitle());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void test_getUsers_byKeyword(String keyword){
        try {
            ArrayList<UserEntity> users = new UserDao().getUsers_byKeyword(keyword);
            for (UserEntity user : users){
                System.out.println("user name: "+user.getName());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private void println(Object o){
        System.out.println(o);
    }
}
