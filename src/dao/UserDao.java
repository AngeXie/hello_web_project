package dao;

import entity.UserEntity;
import entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    DbDao dbDao = new DbDao();

    /**
     *  根据用户名获取用户信息
     */
    public UserEntity getUserInfoByName(String name){
        UserEntity user = new UserEntity();
        String sql  = "select * from tb_user where usr_name = ?";
        String[] objs = {name};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            if (rs.next())
                user = getUsrEntity(rs);
            dbDao.dispose();
        }catch (Exception e){
            System.out.println("read name erro!!!");
            System.out.print(e.getMessage());
            return null;
        }
        return user;
    }

    /**
     *  根据用户id 获取该用户信息
     */
    public UserEntity getUserInfoByID(String id){
        UserEntity user = new UserEntity();
        String sql  = "select * from tb_user where usr_id = ?";
        String[] objs = {id};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            if (rs.next())
                user = getUsrEntity(rs);
            dbDao.dispose();
        }catch (Exception e){
            System.out.println("read id erro!!!");
            System.out.print(e.getMessage());
            return null;
        }
        return user;
    }

    /**
     * 根据用户id获取该用户发表过的文章数
     * @param userId
     * @return
     */
    public int getUserArticleCount_byId(String userId) throws SQLException {
        int article_count = 0;
        String sql = "select count(post_id) as post_count from TB_POST where usr_id = ?";
        String[] objs = {userId};
        ResultSet rs = dbDao.getData(sql, objs);
        if (rs.next()) {
            article_count = rs.getInt("post_count");
        }
        dbDao.dispose();
        return article_count;
    }

    /**
     * 根据用户id获取该用户的粉丝数
     * @param userId
     * @return
     */
    public int getUserFollowedCount_byUserId(String userId) throws SQLException {
        int followed_count = 0;
        String sql = "select count(followed_id) as followed_count from TB_FOLLOW_USR where usr_id = ?";
        String[] objs = {userId};
        ResultSet rs = dbDao.getData(sql, objs);
        if (rs.next()) {
            followed_count = rs.getInt("followed_count");
        }
        dbDao.dispose();
        return followed_count;
    }

    /**
     * 取一定数量的用户数据
     * @param range
     * @return
     */
    public ArrayList<UserEntity> getUsers_withRange(int range){
        ArrayList<UserEntity> users = new ArrayList<UserEntity>();
        String sql = "select * from TB_USER";
        String[] objs = {};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next() && range>0){
                users.add(getUsrEntity(rs));
                range--;
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(UserEntity user) throws SQLException {
        String sql = "insert into tb_user  (usr_id,usr_name,usr_pwd,usr_himg,usr_status,usr_email) values(?, ?, ?, ?, ?, ?)";
        String[] objs = {user.getId(), user.getName(), user.getPwd(), user.getHead(), user.getStatus(), user.getEmail()};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    /**
     * 更改指定id用户的名字
     * @param usr_id
     * @param newName
     * @return
     * @throws SQLException
     */
    public int updateUsrInfo_name(String usr_id, String newName) throws SQLException {
        String sql = "update TB_USER set usr_name = ? where usr_id = ?";
        String[] objs = {newName, usr_id};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    /**
     * 更改指定id用户的密码
     * @param usr_id
     * @param newPwd
     * @return
     * @throws SQLException
     */
    public int updateUsrInfo_pwd(String usr_id, String newPwd) throws SQLException {
        String sql = "update TB_USER set usr_pwd = ? where usr_id = ?";
        String[] objs = {newPwd, usr_id};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    /**
     * 更改指定id用户的头像
     * @param usr_id
     * @param newHead
     * @return
     * @throws SQLException
     */
    public int updateUsrInfo_head(String usr_id, String newHead) throws SQLException {
        String sql = "update TB_USER set usr_himg = ? where usr_id = ?";
        String[] objs = {newHead, usr_id};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    /**
     * 更改指定id用户的邮箱
     * @param usr_id
     * @param newEmail
     * @return
     * @throws SQLException
     */
    public int updateUsrInfo_Email(String usr_id, String newEmail) throws SQLException {
        String sql = "update TB_USER set usr_email = ? where usr_id = ?";
        String[] objs = {newEmail, usr_id};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    public UserEntity getUsrEntity(ResultSet rs) throws SQLException {
        UserEntity user = new UserEntity();
        user.setId(rs.getString("usr_id"));
        user.setName(rs.getString("usr_name"));
        user.setPwd(rs.getString("usr_pwd"));
        user.setStatus(rs.getString("usr_status"));
        user.setEmail(rs.getString("usr_email"));
        user.setHead(rs.getString("usr_himg"));
        user.setReported_count(rs.getInt("reported_count"));
        user.setUsr_intro(rs.getString("usr_intro"));
        return user;
    }
}
