package serivce;

import dao.CommentDao;
import dao.PostDao;
import dao.UserDao;
import model.CommentByUserModel;

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



    private void println(Object o){
        System.out.println(o);
    }
}
