package dao;

import entity.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsDao {
    DbDao dbDao = new DbDao();

    public ArrayList<News> getNews_withRange(int range){
        ArrayList<News> news = new ArrayList<News>();
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

    private News getNewsEntity(ResultSet rs) throws SQLException {
        News news = new News();
        news.setContent(rs.getString("detail"));
        news.setDate(rs.getDate("news_date"));
        news.setId(rs.getString("news_id"));
        news.setIntroduce(rs.getString("intro"));
        news.setTitle(rs.getString("title"));
        return news;
    }
}
