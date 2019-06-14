package com.day0311.work;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        String sql = "insert into stuffs values(null,'jjj','123456')";
        try {
            PreparedStatement preparedStatement = dbUtil.getPreparedStatement(sql);
            dbUtil.execUpdate(preparedStatement);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
