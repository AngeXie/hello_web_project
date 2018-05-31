package dao;

import entity.Resource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResourceDao {
    DbDao dbDao = new DbDao();

    public ArrayList<Resource> getResource_byNameLike(String keyword) throws SQLException {
        ArrayList<Resource> resources = new ArrayList<Resource>();
        String sql = "select * from tb_resource where title like ?";
        keyword = "%"+keyword+"%";
        String[] objs = {keyword};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()){
            resources.add(getResourceEntity(rs));
        }
        dbDao.dispose();
        return resources;
    }
    public Resource getResourceEntity(ResultSet rs) throws SQLException {
        Resource resource = new Resource();
        resource.setId(rs.getString("re_id"));
        resource.setUser_id(rs.getString("usr_id"));
        resource.setTitle(rs.getString("title"));
        resource.setUrl(rs.getString("re_url"));
        resource.setType(rs.getString("re_type"));
        resource.setDate(rs.getDate("re_date"));
        return resource;
    }
}
