package com.company;

// 1. 引入
import java.sql.*;
import java.util.Scanner;

// alt+enter 快速纠错
public class DBDemo5 {

    public static void main(String[] args) {
        // 2.声明对象
        //2.1 声明连接对象
        Connection connection = null;
        // 2.2 预编译语句对象
        // 语句对象: Statement(不使用)
        PreparedStatement preparedStatement = null;
        //2.3 结果集对象
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接:本质上就是在实例化Connerction对象
            //通过Jdk中提供DriverManager(驱动管理器)的方法创建连接
            //地址:127.0.0.1 / localhost
            //bj186:表示数据库
            String url = "jdbc:mysql://127.0.0.1:3306/bj186?characterEncoding=utf-8&&useSSL=false";
            String username = "root";
            String pwd = "1234";
            connection = DriverManager.getConnection(url,username,pwd);
            // 通过用户指定要添加的记录
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入名字");
            String uname= scanner.next();
            System.out.println("请输入年龄");
            int age= scanner.nextInt();
            System.out.println("请输入性别");
            String gender= scanner.next();
            System.out.println("请输入电话号码");
            String phoneNumber= scanner.next();
            //采用预编译方式(数据统一用?作为占位符,和类型无关)
            // 使用预编译的优势; 1.可以提高执行效率(比Statement) 2. 防止SQL注入
            String sql = "insert into users values(null,,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);  // 使用带有占位符的sql语句生成预编译语句对象
            //配置参数: 给对应位置的?赋对应的值
            preparedStatement.setString(1,uname);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            preparedStatement.setString(4,phoneNumber);

            int lines = preparedStatement.executeUpdate();

            //7. 执行查询
            System.out.println("影响的行数:"+lines);
        } catch (ClassNotFoundException e) {
            System.out.println("没有相关的驱动");
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }finally{
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
