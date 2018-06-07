package dao;

import entity.CommentEntity;
import model.CommentByUserModel;
import util.IDGenerator;
import java.sql.*;
import java.util.ArrayList;

public class CommentDao {
    DbDao dbDao = new DbDao();

    /**
     * 根据帖子id查询该贴的评论(新->旧)
     * @param post_id
     */
    public ArrayList<CommentEntity> getComment_byPostId(String post_id){
        ArrayList<CommentEntity> commentEntities = new ArrayList<CommentEntity>();
        String sql = "select * from TB_COMMENT where post_id = ? Order By com_date Desc";
        String[] objs = {post_id};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next()){
                commentEntities.add(getCommentEntity(rs));
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return commentEntities;
    }

    /**
     * 根据帖子id查询该贴的评论数
     * @param postId
     * @return
     */
    public int getCommentCount_byPostId(String postId) throws SQLException {
        int comment_count = 0;
        String sql = "select count(com_id) as comment_count from TB_COMMENT where post_id = ?";
        String[] objs = {postId};
        ResultSet rs = dbDao.getData(sql, objs);
        if (rs.next()) {
            comment_count = rs.getInt("comment_count");
        }
        dbDao.dispose();
        return comment_count;
    }

    /**
     * 根据用户id查询该用户的评论
     * @return comments
     */
    public ArrayList<CommentByUserModel> getComments_byUsrId(String usrId) throws SQLException {
        ArrayList<CommentByUserModel> comments = new ArrayList<CommentByUserModel>();
        String sql = "select tc.*,tp.title from TB_COMMENT tc, TB_POST tp where tc.post_id=tp.post_id and tc.usr_id = ?";
        String[] objs = {usrId};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()) {
            comments.add(new CommentByUserModel(getCommentEntity(rs), rs.getString("title")));
        }
        dbDao.dispose();
        return comments;
    }


    /**
     * 根据用户id和帖子id插入评论
     * @param comment_detail
     * @param post_id
     * @param user_id
     * @return
     */
    public int addComment_byUserIdPostsId(String comment_detail, String post_id, String user_id) throws SQLException {
        String sql = "insert into TB_COMMENT (com_id, post_id, usr_id, detail) values(?, ?, ?, ?)";
        String comment_id = (new IDGenerator()).generate();
        String[] objs = {comment_id, post_id, user_id,comment_detail};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }


    private CommentEntity getCommentEntity(ResultSet rs) throws SQLException {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment_id(rs.getString("com_id"));
        commentEntity.setDate(rs.getDate("com_date"));
        commentEntity.setDetail(rs.getString("detail"));
        commentEntity.setLike_num(rs.getInt("like_num"));
        commentEntity.setPost_id(rs.getString("post_id"));
        commentEntity.setUser_id(rs.getString("usr_id"));
        return commentEntity;
    }
}
