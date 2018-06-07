package dao;

import entity.PostEntity;
import entity.PostEntity;
import javafx.geometry.Pos;
import model.FolllowedPostByUserModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostDao {
    DbDao dbDao = new DbDao();

    /**
     * 根据用户id查询该用户发过的帖子
     * @param usr_id
     * @return
     */
    public ArrayList<PostEntity> getPosts_byUsrId(String usr_id) throws SQLException {
        ArrayList<PostEntity> posts = new ArrayList<PostEntity>();
        String sql = "select * from tb_post where usr_id = ?";
        String[] objs = {usr_id};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()) {
            posts.add(getPostEntity(rs));
        }
        dbDao.dispose();
        return posts;
    }

    /**
     * 根据用户id查询该用户收藏的帖子
     * @param usr_id
     * @return
     */
    public ArrayList<FolllowedPostByUserModel> getFollowedPosts_byUserid(String usr_id) throws SQLException {
        ArrayList<FolllowedPostByUserModel> models = new ArrayList<FolllowedPostByUserModel>();
        String sql  = "select tp.*,tu.usr_name from TB_POST tp, TB_USER tu " +
                "where tp.usr_id=tu.usr_id and tp.post_id in (select post_id from TB_FOLLOW_POST tfp where tfp.usr_id = ?)";
        String[] objs = {usr_id};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()) {
            models.add(new FolllowedPostByUserModel(getPostEntity(rs), rs.getString("usr_name")));
        }
        dbDao.dispose();
        return models;
    }

    /**
     * 根据帖子id读取帖子
     * @param id
     * @return
     */
    public PostEntity getPost_byid(String id){
        PostEntity post = new PostEntity();
        String sql = "select * from TB_POST where post_id = ?";
        String[] objs = {id};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            if (rs.next())
                post = getPostEntity(rs);
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return post;
    }

    /**
     * 根据帖子id读取帖子的收藏数
     * @param postId
     * @return
     */
    public int getFollowedCount_byPostId(String postId) throws SQLException {
        int followed_count = 0;
        String sql = "select count(usr_id) as followed_count from TB_FOLLOW_POST where post_id = ?";
        String[] objs = {postId};
        ResultSet rs = dbDao.getData(sql, objs);
        if (rs.next()) {
            followed_count = rs.getInt("followed_count");
        }
        dbDao.dispose();
        return followed_count;
    }

    /**
     * 读取一定数量的post数据
     * @param range
     * @return
     */
    public ArrayList<PostEntity> getPosts_withRange(int range){
        ArrayList<PostEntity> posts = new ArrayList<PostEntity>();
        String sql = "select * from TB_POST";
        String[] objs = {};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next() && range>0){
                posts.add(getPostEntity(rs));
                range--;
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return posts;
    }

    /**
     *更改指定id帖子的喜欢数
     * @param post_id
     * @param isAdd(加1  true  减1    false)
     * @return
     */
    public int updatePostInfo_likeNum(String post_id, boolean isAdd) throws SQLException {
        String sql = "update TB_POST set like_num = ";
        sql = sql+(isAdd ? "(like_num+1)":"(like_num-1)")+"where post_id=?";
        String[] objs = {post_id};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    /**
     * 更改指定id帖子的收藏数
     * @param post_id
     * @param isAdd(加1  true  减1    false)
     * @return
     * @throws SQLException
     */
    public int updatePostInfo_FollowNum(String post_id, boolean isAdd) throws SQLException {
        String sql = "update TB_POST set follow_num = ";
        sql = sql+(isAdd ? "(follow_num+1)":"(follow_num-1)")+"where post_id=?";
        String[] objs = {post_id};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    private PostEntity getPostEntity(ResultSet rs) throws SQLException {
        PostEntity post = new PostEntity();
        post.setUser_id(rs.getString("usr_id"));
        post.setPub_date(rs.getDate("pub_date"));
        post.setLast_date(rs.getDate("last_date"));
        post.setLike_number(rs.getInt("like_num"));
        post.setFollow_number(rs.getInt("follow_num"));
        post.setPost_id(rs.getString("post_id"));
        post.setDetail(rs.getString("detail"));
        post.setTitle(rs.getString("title"));
        return post;
    }
}
