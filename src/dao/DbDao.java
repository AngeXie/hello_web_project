package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDao {
	private Connection connection;
	private PreparedStatement ps;
	public static final int EXEC_SUCCESS = 1;
	public static final int EXC_FAIL = 0;
	
	public DbDao(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception e) {
			System.out.println("fail to get Driver!!!!!!!!");
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##hw","123123");
	}

	public ResultSet getData(String sql,Object[] objs) throws SQLException{
			connection=getConnection();
			if (connection == null){
				System.out.println("fail to get connection!!!!!!!!!");
			}
			ps=connection.prepareStatement(sql);
			if(objs!=null && objs.length >0){
				for(int i=1;i<=objs.length;i++){
					ps.setObject(i,objs[i-1]);
				}
			}
			ResultSet rs= ps.executeQuery();
			//dispose();
			return rs;
	}

	public int executeSqlNoneRs(String sql,Object[] objs) throws SQLException{
		connection=getConnection();
		ps=connection.prepareStatement(sql);
		if(objs!=null && objs.length >0){
			for(int i=1;i<=objs.length;i++){
				ps.setObject(i,objs[i-1]);
			}
		}
		int rs= ps.executeUpdate();
		//dispose();
		return rs;
	}

	public void dispose() throws SQLException{
			if(ps!=null){
				ps.close();
			}
			if(connection!=null){
				connection.close();
			}
	}
}
