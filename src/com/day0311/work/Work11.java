package com.day0311.work;

import java.sql.*;
import java.util.Scanner;

public class Work11 {

    public static void main(String[] args) {
        tianjia();

    }

    public static void tianjia() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //结果对象集
        ResultSet resultSet = null;
        //引入驱动(将核心的驱动类加载到虚拟机中)
        //将*.class 文件加载到虚拟机中,使用Class.
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
            //System.out.println("连接成功");
            //通过用户指定添加操作
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入名字");
            String uname= scanner.next();
            System.out.println("请输入年龄");
            int age= scanner.nextInt();
            System.out.println("请输入性别");
            String gender= scanner.next();
            System.out.println("请输入电话号码");
            String phoneNumber= scanner.next();
            String sql = "insert into users values(null,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,uname);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,gender);
            preparedStatement.setString(4,phoneNumber);
            //执行sql
            int lines = preparedStatement.executeUpdate();
            System.out.println(lines);
        } catch (ClassNotFoundException e) {
            System.out.println("没有相关的驱动~~~");
        } catch (SQLException e) {
            System.out.println("数据库加载失败");
        }finally {
            //回收资源
            if (preparedStatement != null){
                //
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

