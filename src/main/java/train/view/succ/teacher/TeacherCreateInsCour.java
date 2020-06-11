package train.view.succ.teacher;

import org.apache.cxf.common.i18n.Message;
import train.dao.course.CourseDao;
import train.entity.Course;
import train.entity.Teacher;


import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.SQLException;

/**
 * 用于创建新增课程组件
 *
 * @ClassName: TeacherCreateInsCour
 * @Author: Swy
 * @Date: 2020-06-10 15:21
 **/
public class TeacherCreateInsCour {

    protected static JLabel lTitle = new JLabel("新增课程");
    protected static JLabel lCourNum = new JLabel("课程代码:");
    protected static JLabel lCourName = new JLabel("课程名称:");
    protected static JLabel lCourCredit = new JLabel("课程学分:");
    protected static JLabel lTeacherNum = new JLabel("教师工号:");
    protected static JLabel lTeacherName = new JLabel("教师名称:");

    protected static JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));
    protected static JTextField tfTeacherName = new JTextField(20);
    protected static JTextField tfTeacherNum = new JTextField(20);
    protected static JTextField tfCourNum = new JTextField(20);
    protected static JTextField tfCourName = new JTextField(20);
    protected static JTextField tfCourCredit = new JTextField(20);

    protected static JButton btnConfig = null;
    protected static JButton btnCancel = null;

    protected static Font fTitle = new Font("等线", Font.PLAIN, 24);
    protected static Font fAllLeft = new Font("等线", Font.PLAIN, 14);
    protected static Font fBtn = new Font("等线", Font.PLAIN, 16);
    protected static MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));

    protected static Teacher teacher;

    public static JPanel createInsCour(Teacher teacher) {

        //面板初始化
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //教师初始化
        teacherInit(teacher);

        //其他组件初始化
        itemInit();

        //标题位置
        lTitle.setBounds(40, 35, 200, 24);
        lLine.setBounds(20, 50, 850, 30);

        //教师名称和教师工号
        lTeacherName.setBounds(40, 120, 100, 20);
        tfTeacherName.setBounds(120, 115, 200, 30);
        lTeacherNum.setBounds(360, 120, 100, 20);
        tfTeacherNum.setBounds(440, 115, 200, 30);

        //课程名称跟课程代码
        lCourName.setBounds(40, 180, 100, 20);
        tfCourName.setBounds(120, 175, 200, 30);
        lCourNum.setBounds(360, 180, 100, 20);
        tfCourNum.setBounds(440, 175, 200, 30);

        //课程学分
        lCourCredit.setBounds(40, 240, 100, 20);
        tfCourCredit.setBounds(120, 235, 200, 30);

        //按钮
        btnConfig.setBounds(120, 350, 80, 30);
        btnCancel.setBounds(280, 350, 80, 30);


        //添加标题到面板里
        panel.add(lTitle);
        panel.add(lLine);
        panel.add(lTitle);
        panel.add(lTeacherName);
        panel.add(tfTeacherName);
        panel.add(lTeacherNum);
        panel.add(tfTeacherNum);
        panel.add(lCourName);
        panel.add(lCourCredit);
        panel.add(tfCourName);
        panel.add(tfCourCredit);
        panel.add(lCourNum);
        panel.add(tfCourNum);
        panel.add(btnCancel);
        panel.add(btnConfig);

        //确认按钮事件
        btnConfig.addActionListener(e -> saveCourse());
        return panel;
    }


    /**
     * 按钮事件
     *
     * @return void
     * @Author Swy
     * @Date 14:18 2020-06-11
     * @Param null
     */
    public static void saveCourse() {
        String courName = tfCourName.getText();
        String courNum = tfCourNum.getText();
        String teacherName = teacher.getName();
        String teacherNum = teacher.getNum();
        String credit = tfCourCredit.getText();
        if (!"".equals(courName)) {
            if (!"".equals(courNum)) {
                //新建一个课程实例
                Course course = new Course();
                course.setName(courName);
                course.setNum(courNum);
                course.setTeacherNum(teacherNum);
                course.setTeacherName(teacherName);
                course.setCredit(credit);
                try {
                    int result = new CourseDao().insCourse(course);
                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "保存成功！", "成功提示！", JOptionPane.PLAIN_MESSAGE);
                        tfCourCredit.setText("");
                        tfCourName.setText("");
                        tfCourNum.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "保存失败！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "课程代码已存在，请更换！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "课程代码不允许为空！", "错误提示！", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "课程名称不允许为空！", "错误提示！", JOptionPane.ERROR_MESSAGE);
        }


    }


    /**
     * 教师初始化
     *
     * @return void
     * @Author Swy
     * @Date 14:20 2020-06-11
     * @Param Teacher 教师实例
     */
    public static void teacherInit(Teacher teacher) {
        TeacherCreateInsCour.teacher = teacher;
    }

    /**
     * 其他组件的初始化
     *
     * @return void
     * @Author Swy
     * @Date 14:16 2020-06-11
     * @Param null
     */
    public static void itemInit() {

        btnConfig = new JButton("增加");
        btnCancel = new JButton("取消");

        lTitle.setFont(fTitle);
        lCourNum.setFont(fAllLeft);
        lCourName.setFont(fAllLeft);
        lCourCredit.setFont(fAllLeft);
        lTeacherNum.setFont(fAllLeft);
        lTeacherName.setFont(fAllLeft);
        btnCancel.setFont(fBtn);
        btnConfig.setFont(fBtn);

        //设置鼠标变手
        btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //字体颜色设置
        lCourNum.setForeground(new Color(136, 136, 136));
        lTeacherNum.setForeground(new Color(136, 136, 136));
        lCourName.setForeground(new Color(136, 136, 136));
        lCourCredit.setForeground(new Color(136, 136, 136));
        lTeacherName.setForeground(new Color(136, 136, 136));

        tfTeacherName.setBorder(border);
        tfTeacherNum.setBorder(border);
        tfCourNum.setBorder(border);
        tfCourName.setBorder(border);
        tfCourCredit.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

        //文本框初始值
        tfTeacherNum.setText(teacher.getNum());
        tfTeacherName.setText(teacher.getName());

        //设置文本框不能被输入
        tfTeacherNum.setEnabled(false);
        tfTeacherName.setEnabled(false);

    }
}
