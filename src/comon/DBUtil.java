package comon;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import comon.MyPorperties;

public class DBUtil {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	/**
	 * 建立连接的方法
	 *  @return Connection 连接对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		try {
			MyPorperties myPorperties = new MyPorperties("db.properties");
			Class.forName(myPorperties.getProp("driver"));
			String url = myPorperties.getProp("url");
			String username = myPorperties.getProp("username");
			String password = myPorperties.getProp("password");
			connection =  DriverManager.getConnection(url, username,password);
			return connection;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取预编译语句对象的方法
	 * @param sql 预编译的SQL命令
	 * @return PreparedStatement对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
		return getConnection().prepareStatement(sql);
	}
	
	/**
	 * 执行增删改的方法
	 * @param ps 执行增删改语句的对象
	 * @return 返回影响的行数
	 * @throws SQLException
	 */
	public int execUpdate(PreparedStatement ps) throws SQLException{
		 return  ps.executeUpdate();
	}
	
	/**
	 * 执行查询的方法
	 * @param prepStat 执行查询语句的对象
	 * @return 返回相应的结果集
	 * @throws SQLException
	 */
	public ResultSet  execQuery(PreparedStatement prepStat) throws SQLException{
		return prepStat.executeQuery();
	}
	
	
	/**
	*关闭结果集对象
	*/
	public void closeSet() throws SQLException{
		if(resultSet!=null){
			resultSet.close();
		}
	}
	
	/**
	*关闭预编译对象
	*/
	public void closePrepStat() throws SQLException{
		if(resultSet!=null){
			resultSet.close();
		}
	}
	
	/**
	*关闭连接对象
	*/
	public void closeConn() throws SQLException{
		if(resultSet!=null){
			resultSet.close();
		}
	}
	
	/**
	*关闭全部对象
	*/
	public void closeAll() throws SQLException{
		closeSet();
		closePrepStat();
		closeConn();
	}
}
