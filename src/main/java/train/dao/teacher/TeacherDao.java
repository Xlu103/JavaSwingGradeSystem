package train.dao.teacher;

import train.entity.Teacher;
import train.jdbc.connect.JdbcConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: DaoTeacher
 * @Author: Swy
 * @Date: 2020-06-08 23:04
 **/
public class TeacherDao {

    /**
     * 根据老师的工号跟密码查询教师信息
     *
     * @Author Swy
     * @Date 23:05 2020-06-08
     * @Param 账号跟密码
     * @return 返回一个老师实例
    */
    public Teacher selectTeacher(String num, String pwd) throws SQLException, ClassNotFoundException {
        Teacher teacherResult = new Teacher();
        String selSql = "select * from teacher where number=? and password = ?";
        JdbcConnect JdbcConnect = new JdbcConnect();
        ResultSet resultSet=JdbcConnect.executeQuery(selSql, new String[]{num, pwd});
        while (resultSet.next()) {
            teacherResult.setNum(resultSet.getString("number"));
            teacherResult.setName(resultSet.getString("name"));
            teacherResult.setPassword(resultSet.getString("password"));
            teacherResult.setSex(resultSet.getString("sex"));
            teacherResult.setIntroduce(resultSet.getString("introduce"));
        }
        return teacherResult;
    }

    /**
     * 修改老师信息
     *
     * @return 是否成功
     * @Author Swy
     * @Date 15:22 2020-06-09
     * @Param Teacher
     */
    public int updateTeacher(Teacher teacher) throws SQLException, ClassNotFoundException {
        int result=0;
        JdbcConnect jdbcConnect=new JdbcConnect();
        String updateSql="UPDATE teacher set name=?,sex=?,introduce=? where number=?";
        result=jdbcConnect.executeUpdate(updateSql, new String[]{teacher.getName(), teacher.getSex(), teacher.getIntroduce(), teacher.getNum()});
        return result;
    }


    /**
     * 修改密码
     *
     * @return int 是否成功
     * @Author Swy
     * @Date 15:37 2020-06-09
     * @Param number password 账号跟密码
     */
    public int updatePassword(String number, String password) throws SQLException, ClassNotFoundException {
        int result=0;
        JdbcConnect jdbcConnect=new JdbcConnect();
        String updateSql="UPDATE teacher set password=? where number=?";
        result = jdbcConnect.executeUpdate(updateSql, new String[]{password, number});
        return result;
    }
}
