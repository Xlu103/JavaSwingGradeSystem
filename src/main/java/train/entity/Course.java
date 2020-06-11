package train.entity;

/**
 * 课程实体类
 *
 * @ClassName: Course
 * @Author: Swy
 * @Date: 2020-06-10 22:17
 **/
public class Course {
    /**
     * 课程代码
     * 课程名称
     * 教师工号
     * 教师姓名
     * */
    private  String num;
    private  String name;
    private String teacherNum;
    private String teacherName;
    private  String credit;

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

    @Override
    public String toString() {
        return "Course{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", teacherNum='" + teacherNum + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", credit='" + credit + '\'' +
                '}';
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Course(String num, String name, String teacherNum, String teacherName, String credit) {
        this.num = num;
        this.name = name;
        this.teacherNum = teacherNum;
        this.teacherName = teacherName;
        this.credit = credit;
    }

    public Course() {

    }

}
