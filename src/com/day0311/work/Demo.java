package com.day0311.work;

public class Demo {
    public static void main(String[] args) {
        int djy = 2;
        int mys = 10;
        String sql = "select * from course limit ("+djy+"-1)*"+mys+","+mys+"";
        System.out.println(sql);

    }
}
