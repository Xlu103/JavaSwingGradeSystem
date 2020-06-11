package train.dao.course;

import train.entity.Course;
import train.entity.Teacher;
import train.jdbc.connect.JdbcConnect;

import java.sql.ResultSet;
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
        int result = 0;
        String insSql = "INSERT INTO course(num,name,teachernum,teachername,credit) VALUES(?,?,?,?,?)";
        String[] params = new String[]{course.getNum(), course.getName(), course.getTeacherNum(), course.getTeacherName(), course.getCredit()};
        JdbcConnect jdbc = new JdbcConnect();
        result = jdbc.executeUpdate(insSql, params);
        return result;
    }


    /**
     * 根据教师工号在课程表中找到所有课程
     *
     * @return 课程数组 课程字符串数组
     * @Author Swy
     * @Date 15:34 2020-06-11
     * @Param teacherNum 教师工号
     */
    public Course[] selCourse(Teacher teacher) throws SQLException, ClassNotFoundException {
        Course[] courseArr = new Course[10];
        JdbcConnect jdbc = new JdbcConnect();
        String selSql = "select * from course where teachernum=?";
        ResultSet rs = jdbc.executeQuery(selSql, new String[]{teacher.getNum()});
        int foot = 0;
        while (rs.next()) {
            courseArr[foot] = new Course();
            courseArr[foot].setName(rs.getString("name"));
            courseArr[foot].setNum(rs.getString("num"));
            courseArr[foot].setCredit(rs.getString("credit"));
            courseArr[foot].setTeacherName(teacher.getName());
            courseArr[foot].setTeacherNum(teacher.getNum());
            foot++;
        }
        Course[] results = new Course[foot];
        for (int i = 0; i < foot; i++) {
            results[i] = courseArr[i];
        }
        return results;
    }
}
