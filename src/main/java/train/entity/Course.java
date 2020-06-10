package train.entity;

/**
 * 课程实体类
 *
 * @ClassName: Course
 * @Author: Swy
 * @Date: 2020-06-10 22:17
 **/
public class Course {
    private  String num;
    private  String name;
    private String teacherNum;
    private String teacherName;

    @Override
    public String toString() {
        return "Course{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(String teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Course(String num, String name, String teacherNum, String teacherName) {
        this.num = num;
        this.name = name;
        this.teacherNum = teacherNum;
        this.teacherName = teacherName;
    }
}
