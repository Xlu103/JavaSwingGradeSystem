package train.view.succ.teacher;

import train.entity.Teacher;
import train.view.util.JTextFieldHintListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * 用于创建新增课程组件
 *
 * @ClassName: TeacherCreateInsCour
 * @Author: Swy
 * @Date: 2020-06-10 15:21
 **/
public class TeacherCreateInsCour {
    public static JPanel createInsCour(Teacher teacher) {
        //面板初始化
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //其他组件
        JLabel lTitle = new JLabel("新增课程");
        JLabel lCourNum = new JLabel("课程代码:");
        JLabel lCourName = new JLabel("课程名称:");
        JLabel lCourCredit = new JLabel("课程学分:");
        JLabel lTeacherNum = new JLabel("教师工号:");
        JLabel lTeacherName = new JLabel("教师名称:");

        JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));

        //输入框
        JTextField tfTeacherName = new JTextField(20);
        JTextField tfTeacherNum = new JTextField(20);
        JTextField tfCourNum = new JTextField(20);
        JTextField tfCourName = new JTextField(20);
        JTextField tfCourCredit = new JTextField(20);

        //按钮保存跟取消
        JButton btnConfig = new JButton("增加");
        JButton btnCancel = new JButton("取消");

        //设置字体
        Font fTitle = new Font("等线", Font.PLAIN, 24);
        Font fAllLeft = new Font("等线", Font.PLAIN, 14);
        Font fBtn = new Font("等线", Font.PLAIN, 16);
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

        //输入框边框样式
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
        tfTeacherName.setBorder(border);
        tfTeacherNum.setBorder(border);
        tfCourNum.setBorder(border);
        tfCourName.setBorder(border);
        tfCourCredit.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

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
        tfCourCredit.setBounds(120,235,200,30);

        //按钮
        btnConfig.setBounds(120, 350, 80, 30);
        btnCancel.setBounds(280, 350, 80, 30);

        //文本框初始值
        tfTeacherNum.setText(teacher.getNum());
        tfTeacherName.setText(teacher.getName());

        //设置文本框不能被输入
        tfTeacherNum.setEnabled(false);
        tfTeacherName.setEnabled(false);

        //设置默认提示字体

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

        return panel;
    }
}
