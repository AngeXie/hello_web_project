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
        ArrayList<ResourceEntity> resourceEntities = new ArrayList<ResourceEntity>();
        String sql = "select * from tb_resource where lower(title) like ? or lower(re_detail) like ?";
        keyword = "%"+keyword.toLowerCase()+"%";
        String[] objs = {keyword, keyword};
        ResultSet rs = dbDao.getData(sql, objs);
        while (rs.next()){
            resourceEntities.add(getResourceEntity(rs));
        }
        dbDao.dispose();
        return resourceEntities;
    }

    /**
     *根据一定数量读取数据
     * @return
     */
    public ArrayList<ResourceEntity> getResource_byRange(int range){
        ArrayList<ResourceEntity> resourceEntities = new ArrayList<ResourceEntity>();
        String sql = "select * from TB_RESOURCE";
        String[] objs = {};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next() && range>0){
                resourceEntities.add(getResourceEntity(rs));
                range--;
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resourceEntities;
    }


    private ResourceEntity getResourceEntity(ResultSet rs) throws SQLException {
        ResourceEntity resourceEntity = new ResourceEntity();
        resourceEntity.setId(rs.getString("re_id"));
        resourceEntity.setUser_id(rs.getString("usr_id"));
        resourceEntity.setTitle(rs.getString("title"));
        resourceEntity.setUrl(rs.getString("re_url"));
        resourceEntity.setType(rs.getString("re_type"));
        resourceEntity.setDate(rs.getDate("re_date"));
        resourceEntity.setDetail(rs.getString("re_detail"));
        return resourceEntity;
    }
}
