package com.company;

import java.sql.*;

public class JdbjDemo4 {

    public static void main(String[] args) {
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
            String sql = "select * from  stuffs";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet1 = preparedStatement.executeQuery();
            //System.out.println(resultSet1.next());
            System.out.println("编号 \t用户名 \t密码");
                while (resultSet1.next()){
                int sid = resultSet1.getInt("sid");
                String name = resultSet1.getString("sname");
                String password = resultSet1.getString("password");
                System.out.println(sid+"\t"+name+"\t"+"   "+password);
            }
            //执行sql

            //int lines = preparedStatement.executeUpdate();
            //System.out.println(lines);
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

