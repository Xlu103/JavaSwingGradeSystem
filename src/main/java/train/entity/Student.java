package train.entity;

/**
 * 学生实体类
 *
 * @ClassName: Student
 * @Author: Swy
 * @Date: 2020-06-08 14:37
 **/
public class Student {
    private String number;
    private String name;
    private String department;
    private String password;
    private String sex;
    private String introduce;

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Student(String number, String name, String department, String password, String sex, String introduce) {
        this.number = number;
        this.name = name;
        this.department = department;
        this.password = password;
        this.sex = sex;
        this.introduce = introduce;
    }

    public Student() {
    }

}
