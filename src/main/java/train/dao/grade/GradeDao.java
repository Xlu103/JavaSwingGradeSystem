package train.dao.grade;

import train.entity.Grade;
import train.jdbc.connect.JdbcConnect;

import java.awt.*;
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



}
