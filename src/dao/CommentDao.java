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
        ArrayList<CommentEntity> comments = new ArrayList<CommentEntity>();
        String sql = "select * from TB_COMMENT where post_id = ? Order By com_date Desc";
        String[] objs = {post_id};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next()){
                comments.add(getCommentEntity(rs));
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return comments;
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
     * 分页查询某张帖子的评论数据
     * @param page_size
     * @param post_id
     * @return
     * @throws SQLException
     */
    public ArrayList<ArrayList<CommentEntity>> getComments_byPage(int page_size, String post_id) throws SQLException {
        ArrayList<ArrayList<CommentEntity>> pages = new ArrayList<ArrayList<CommentEntity>>();
        ArrayList<CommentEntity> page_contents;
        int data_size = getCommentCount_byPostId(post_id);
        if (data_size == 0)
            return null;
        ArrayList<CommentEntity> datas = getComment_byPostId(post_id);
        int page_num = (data_size%page_size) == 0 ? data_size/page_size : (data_size/page_size + 1);
        int write_count = 0;
        for (int i=0; i<page_num && write_count<data_size; i++){
            page_contents = new ArrayList<CommentEntity>();
            for (int j=0; j<page_size && write_count<data_size; j++){
                page_contents.add(datas.get(i*page_size + j));
                write_count++;
            }
            pages.add(page_contents);
        }
        return pages;
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
        CommentEntity comment = new CommentEntity();
        comment.setComment_id(rs.getString("com_id"));
        comment.setDate(rs.getDate("com_date"));
        comment.setDetail(rs.getString("detail"));
        comment.setLike_num(rs.getInt("like_num"));
        comment.setPost_id(rs.getString("post_id"));
        comment.setUser_id(rs.getString("usr_id"));
        return comment;
    }
}
