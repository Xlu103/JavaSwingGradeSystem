package train.entity;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;

/**
 * 成绩实例
 * @ClassName: Grade
 * @Author: Swy
 * @Date: 2020-06-10 0:03
 **/
public class Grade {
    private String courNum;
    private String courName;
    private String teacherName;
    private String teacherNum;
    private String stuName;
    private String stuNum;
    private String stuGrade;

    public Grade(String courNum, String courName, String teacherName, String teacherNum, String stuName, String stuNum, String stuGrade) {
        this.courNum = courNum;
        this.courName = courName;
        this.teacherName = teacherName;
        this.teacherNum = teacherNum;
        this.stuName = stuName;
        this.stuNum = stuNum;
        this.stuGrade = stuGrade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "courNum='" + courNum + '\'' +
                ", courName='" + courName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                '}';
    }

    public String getCourNum() {
        return courNum;
    }

    public void setCourNum(String courNum) {
        this.courNum = courNum;
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public Grade() {
    }

}
