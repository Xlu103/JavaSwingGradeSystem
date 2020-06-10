package train.dao.course;

import train.entity.Course;
import train.jdbc.connect.JdbcConnect;

import java.sql.SQLException;

/**
 * @ClassName: CourseDao
 * @Author: Swy
 * @Date: 2020-06-11 0:11
 **/
public class CourseDao {

    /**
     * 添加课程
     *
     * @return int 是否成功
     * @Author Swy
     * @Date 0:11 2020-06-11
     * @Param Course 课程实例
     */
    public int insCourse(Course course) throws SQLException, ClassNotFoundException {
        int result=0;
        String insSql = "INSERT INTO course(num,name,teachernum,teachername) VALUES(?,?,?,?)";
        String[] params = new String[]{course.getNum(),course.getName(),course.getTeacherNum(),course.getTeacherName()};
        JdbcConnect jdbc = new JdbcConnect();
        result=jdbc.executeUpdate(insSql, params);
        return result;
    }
}
