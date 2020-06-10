package train.dao;

import train.dao.grade.GradeDao;
import train.dao.student.StudentDao;
import train.dao.teacher.TeacherDao;
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
        System.out.println(Arrays.toString(new StudentDao().selectAllStudent()));
        System.out.println(new TeacherDao().selectTeacher("771", "000000"));
        Grade grade=new Grade("GE002", "Java程序设计", "孙老师", "771", "张三", "1840707001", "80");
        int result = new GradeDao().insGrade(grade);
        System.out.println(grade);
        System.out.println(result);

    }
}
