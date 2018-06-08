package dao;

import entity.ResourceEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResourceDao {
    DbDao dbDao = new DbDao();

    /**
     * 根据keyword关键字模糊查询
     * @param keyword
     * @return
     * @throws SQLException
     */
    public ArrayList<ResourceEntity> getResource_byNameLike(String keyword) throws SQLException {
        ArrayList<ResourceEntity> resources = new ArrayList<ResourceEntity>();
        String sql = "select * from tb_resource where lower(title) like ? or lower(re_detail) like ?";
        keyword = "%"+keyword.toLowerCase()+"%";
        String[] objs = {keyword, keyword};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()){
            resources.add(getResourceEntity(rs));
        }
        dbDao.dispose();
        return resources;
    }

    /**
     *根据一定数量读取数据
     * @return
     */
    public ArrayList<ResourceEntity> getResource_byRange(int range){
        ArrayList<ResourceEntity> resourcs = new ArrayList<ResourceEntity>();
        String sql = "select * from TB_RESOURCE";
        String[] objs = {};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next() && range>0){
                resourcs.add(getResourceEntity(rs));
                range--;
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resourcs;
    }


    private ResourceEntity getResourceEntity(ResultSet rs) throws SQLException {
        ResourceEntity resource = new ResourceEntity();
        resource.setId(rs.getString("re_id"));
        resource.setUser_id(rs.getString("usr_id"));
        resource.setTitle(rs.getString("title"));
        resource.setUrl(rs.getString("re_url"));
        resource.setType(rs.getString("re_type"));
        resource.setDate(rs.getDate("re_date"));
        resource.setDetail(rs.getString("re_detail"));
        return resource;
    }
}
