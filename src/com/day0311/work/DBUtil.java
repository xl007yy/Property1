package com.day0311.work;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class DBUtil {
    //Connection connection = null;
    PreparedStatement preparedStatement = null;
    String sql;
    //结果对象集
    ResultSet resultSet = null;
    /**
     * 建立连接的方法
     *  @return Connection 连接对象
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        //创建连接:本质上就是在实例化Connerction对象
        //通过Jdk中提供DriverManager(驱动管理器)的方法创建连接
        //地址:127.0.0.1 / localhost
        //bj186:表示数据库
        String url = "jdbc:mysql://127.0.0.1:3306/bj186?characterEncoding=utf-8&&useSSL=false";
        String username = "root";
        String pwd = "1234";
        Connection connection = DriverManager.getConnection(url,username,pwd);

        return connection;
    }

    /**
     * 获取预编译语句对象的方法
     * @param sql 预编译的SQL命令
     * @return PreparedStatement对象
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException{
        //System.out.println(sql);
        Connection connection = this.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    /**
     * 执行增删改的方法
     * @param prepStat 执行增删改语句的对象
     * @return 返回影响的行数
     * @throws SQLException
     */
    public int execUpdate(PreparedStatement ps) throws SQLException{
        int lines = preparedStatement.executeUpdate();
         return lines;

    }

    /**
     * 执行查询的方法
     * @param prepStat 执行查询语句的对象
     * @return 返回相应的结果集
     * @throws SQLException
     */
    public ResultSet  execQuery(PreparedStatement prepStat) throws SQLException{
        ResultSet resultSet = prepStat.executeQuery();
        return resultSet;

    }


    /**
     *关闭结果集对象
     */
    public void closeSet() throws SQLException{

    }

    /**
     *关闭预编译对象
     */
    public void closePrepStat() throws SQLException{
    }

    /**
     *关闭连接对象
     */
    public void closeConn() throws SQLException{

    }

    /**
     *关闭全部对象
     */
    public void closeAll() throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection.close();
        preparedStatement.close();
        resultSet.close();

    }s
}
