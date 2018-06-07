package dao;

import entity.NewsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsDao {
    DbDao dbDao = new DbDao();

    public ArrayList<NewsEntity> getNews_withRange(int range){
        ArrayList<NewsEntity> newsEntities = new ArrayList<NewsEntity>();
        String sql = "select * from TB_NEWS";
        String[] objs = {};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next() && range>0){
                newsEntities.add(getNewsEntity(rs));
                range--;
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return newsEntities;
    }

    private NewsEntity getNewsEntity(ResultSet rs) throws SQLException {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setContent(rs.getString("detail"));
        newsEntity.setDate(rs.getDate("news_date"));
        newsEntity.setId(rs.getString("news_id"));
        newsEntity.setIntroduce(rs.getString("intro"));
        newsEntity.setTitle(rs.getString("title"));
        return newsEntity;
    }
}
