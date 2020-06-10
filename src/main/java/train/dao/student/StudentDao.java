package train.dao.student;
import train.entity.Student;
import train.jdbc.connect.JdbcConnect;

import java.sql.ResultSet;

/**
 * 学生类与数据库的关系
 * @ClassName: StudentDao
 * @Author: Swy
 * @Date: 2020-06-08 14:35
 **/
public class StudentDao {
    /**
     * 查询所有学生
     * @Author xlu
     * @Date 14:40 2020-06-08
     * @Param null
     * @return  学生数组
    */
    public Student[] selectAllStudent() throws Exception{
        //jdbc连接
        JdbcConnect jdbc = new JdbcConnect();
        //返回的学数组
        Student[] students = new Student[100];
        //下标
        int foot=0;
        //计算学生多少个
        int count;
        //查询所有学生信息
        String sql = "select * from student";
        ResultSet rs = jdbc.executeQuery(sql, null);
        while (rs.next()) {
            students[foot] = new Student();
            students[foot].setNumber(rs.getString("num"));
            students[foot].setName(rs.getString("name"));
            students[foot].setDepartment(rs.getString("department"));
            students[foot].setPassword(rs.getString("password"));
            students[foot].setSex(rs.getString("sex"));
            students[foot].setIntroduce(rs.getString("introduce"));
            foot++;
        }
        for (count = 0; students[count] != null; count++) {
        }
        Student [] studentsResult= new Student[count];
        for (int i = 0; i < count; i++) {
            studentsResult[i] = students[i];
        }
        return studentsResult;
    }

}
