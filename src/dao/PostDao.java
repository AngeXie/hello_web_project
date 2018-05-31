package dao;

import entity.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//待测试
public class PostDao {
    DbDao dbDao = new DbDao();

    /**
     * 根据用户id查询该用户发过的帖子
     * @param usr_id
     * @return
     */
    public ArrayList<Post> getPosts_byUsrId(String usr_id) throws SQLException {
        ArrayList<Post> posts = new ArrayList<Post>();
        String sql = "select * from tb_post where usr_id = ?";
        String[] objs = {usr_id};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()) {
            posts.add(getPostEntity(rs));
        }
        dbDao.dispose();
        return posts;
    }

    private Post getPostEntity(ResultSet rs) throws SQLException {
        Post post = new Post();
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
