package train.dao;

import train.dao.course.CourseDao;
import train.dao.grade.GradeDao;
import train.dao.student.StudentDao;
import train.dao.teacher.TeacherDao;
import train.entity.Course;
import train.entity.Grade;

import java.util.Arrays;
/**
 * 测试类
 * @ClassName: DaoTest
 * @Author: Swy
 * @Date: 2020-06-08 14:11
 **/
public class DaoTest {
    public static void main(String[] args) throws Exception {
        int result=0;

        //测试学生DAO
        System.out.println(Arrays.toString(new StudentDao().selectAllStudent()));
        //测试老师DAO
        System.out.println(new TeacherDao().selectTeacher("771", "000000"));
        //测试成绩DAO
        Grade grade=new Grade("GE002", "Java程序设计", "张老师", "771", "张三", "1840707001", "80");
        result = new GradeDao().insGrade(grade);
        System.out.println(grade);
        System.out.println(result);

        //测试课程DAO
        Course course = new Course();
        course.setName("HTML5网页设计基础");
        course.setNum("GE001");
        course.setTeacherName("王老师");
        course.setTeacherNum("772");

        System.out.println(course);
        result=new CourseDao().insCourse(course);
        System.out.println(result);
    }
}
