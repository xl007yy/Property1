package comon;

import java.io.Serializable;

//MyBatis逆向生成工具
// powerDesigner

//规范1: 实现Serializable序列化接口
public class Student implements Serializable {
    //规范2: 字段的规范
    // 声明字段和数据表中的字段保持一致(类型/字段名)
    // 数据类型采用封装类型
    private String sid;
    private String sname;
    private Integer sage;
    private String s
    private String szhuanye;sex;

    //规范3: 一定要存在空参的构造方法(默认的也可以)
    public Student(String sid, String sname, Integer sage, String ssex, String szhuanye) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.ssex = ssex;
        this.szhuanye = szhuanye;
    }

    //规范4: 生成对应的getter和setter
    public Student() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSzhuanye() {
        return szhuanye;
    }

    public void setSzhuanye(String szhuanye) {
        this.szhuanye = szhuanye;
    }

    //方便调试,添加toString()

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", ssex='" + ssex + '\'' +
                ", szhuanye='" + szhuanye + '\'' +
                '}';
    }
}
