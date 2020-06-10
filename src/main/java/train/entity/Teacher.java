package train.entity;

/**
 * 教师实体类
 *
 * @ClassName: Teacher
 * @Author: Swy
 * @Date: 2020-06-08 23:02
 **/
public class Teacher {
    private String num;
    private String name;
    private String password;
    private String introduce;
    private String sex;

    public Teacher( ) {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", introduce='" + introduce + '\'' +
                ", sex='" + sex + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Teacher(String num, String name, String password, String introduce, String sex) {
        this.num = num;
        this.name = name;
        this.password = password;
        this.introduce = introduce;
        this.sex = sex;
    }
}
