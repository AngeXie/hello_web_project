package dao;

import entity.NewsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsDao {
    DbDao dbDao = new DbDao();

    public ArrayList<NewsEntity> getNews_withRange(int range){
        ArrayList<NewsEntity> news = new ArrayList<NewsEntity>();
        String sql = "select * from TB_NEWS";
        String[] objs = {};
        try {
            ResultSet rs = dbDao.getData(sql, objs);
            while (rs.next() && range>0){
                news.add(getNewsEntity(rs));
                range--;
            }
            dbDao.dispose();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return news;
    }

    private NewsEntity getNewsEntity(ResultSet rs) throws SQLException {
        NewsEntity news = new NewsEntity();
        news.setContent(rs.getString("detail"));
        news.setDate(rs.getDate("news_date"));
        news.setId(rs.getString("news_id"));
        news.setIntroduce(rs.getString("intro"));
        news.setTitle(rs.getString("title"));
        return news;
    }
}
