package dao;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    DbDao dbDao = new DbDao();

    /**
     *  根据用户名获取用户信息
     */
    public User getUserInfoByName(String name){
        User user = new User();
        String sql  = "select * from tb_user where usr_name = ?";
        String[] objs = {name};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            if (rs.next())
                user = getUsrEntity(rs);
            dbDao.dispose();
        }catch (Exception e){
            System.out.println("read erro!!!");
            System.out.print(e.getMessage());
            return null;
        }
        return user;
    }

    /**
     * 取一定数量的用户数据
     * @param range
     * @return
     */
    public ArrayList<User> getUsers_withRange(int range){
        ArrayList<User> users = new ArrayList<User>();
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
    public int addUser(User user) throws SQLException {
        String sql = "insert into tb_user values(?, ?, ?, ?, ?, ?)";
        String[] objs = {user.getId(), user.getName(), user.getPwd(), user.getHead(), user.getStatus(), user.getEmail()};
        dbDao.executeSqlNoneRs(sql, objs);
        dbDao.dispose();
        return DbDao.EXEC_SUCCESS;
    }

    public User getUsrEntity(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getString("usr_id"));
        user.setName(rs.getString("usr_name"));
        user.setPwd(rs.getString("usr_pwd"));
        user.setStatus(rs.getString("usr_status"));
        user.setEmail(rs.getString("usr_email"));
        user.setHead(rs.getString("usr_himg"));
        return user;
    }
}
