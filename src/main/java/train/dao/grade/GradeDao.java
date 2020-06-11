package train.dao.grade;

import train.entity.Course;
import train.entity.Grade;
import train.entity.Teacher;
import train.jdbc.connect.JdbcConnect;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @ClassName: GradeEntity
 * @Author: Swy
 * @Date: 2020-06-10 0:07
 **/
public class GradeDao {
    /**
     * 录入成绩
     *
     * @return int 结果为几行，插入几行
     * @Author Swy
     * @Date 0:07 2020-06-10
     * @Param Grade 实例，包含表中所有的信息
     */
    public int insGrade(Grade grade) throws SQLException, ClassNotFoundException {
        int result = 0;
        JdbcConnect jdbcConnect = new JdbcConnect();
        String insSql = "INSERT INTO grade(coursenum,coursename,teachernum,teachername,studentname,studentnum,studentgrade) VALUES(?,?,?,?,?,?,?)";
        String[] param = new String[]{
                grade.getCourNum(), grade.getCourName(),
                grade.getTeacherNum(), grade.getTeacherName(),
                grade.getStuName(), grade.getStuNum(),
                grade.getStuGrade()
        };
        result = jdbcConnect.executeUpdate(insSql, param);
        return result;
    }


    /**
     * 根据课程代码查成绩
     * @Author Swy
     * @Date 15:03 2020-06-11
     * @Param Course 课程
     * @return 返回一个成绩单
    */
    public Grade []selGrade(String courNum) throws SQLException, ClassNotFoundException {
        //这里默认一个班最多200个学生
        Grade [] grades=new Grade[200];
        String selSql = "select * from grade where coursenum=?";
        JdbcConnect jdbc=new JdbcConnect();
        ResultSet rs=  jdbc.executeQuery(selSql, new String[]{courNum});
        int foot=0;
        while (rs.next()) {
            grades[foot] = new Grade();
            grades[foot].setTeacherNum(rs.getString("teachernum"));
            grades[foot].setTeacherName(rs.getString("teachername"));
            grades[foot].setCourNum(rs.getString("coursenum"));
            grades[foot].setCourName(rs.getString("coursename"));
            grades[foot].setStuNum(rs.getString("studentnum"));
            grades[foot].setStuName(rs.getString("studentname"));
            grades[foot].setStuGrade(rs.getString("studentgrade"));
            foot++;
        }
        Grade[] resultGrades = new Grade[foot];
        for (int i = 0; i < foot; i++) {
            resultGrades[i] = grades[i];
        }
        return resultGrades;

    }



}
