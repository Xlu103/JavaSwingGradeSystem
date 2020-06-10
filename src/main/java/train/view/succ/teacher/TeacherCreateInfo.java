package train.view.succ.teacher;

import train.dao.teacher.TeacherDao;
import train.entity.Teacher;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.sql.SQLException;

/**
 * 个人信息类，用于创建信息面板
 * @ClassName: TeacherCreateInfo
 * @Author: Swy
 * @Date: 2020-06-09 17:01
 **/
public class TeacherCreateInfo {

    /**
     * 获得个人信息面板
     *
     * @Author Swy
     * @Date 22:57 2020-06-08
     * @Param null
     * @return JPanel
     */
    public static JPanel createInfo(Teacher teacher) throws SQLException, ClassNotFoundException {

        //面板初始化
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //标题标签
        JLabel lTitle = new JLabel("编辑个人信息");
        JLabel lName = new JLabel("姓名:");
        JLabel lIntroduce = new JLabel("介绍:");
        JLabel lSex = new JLabel("性别:");

        //标题字体
        Font fTitle = new Font("等线", Font.PLAIN, 20);
        Font fAllLeft = new Font("等线", Font.PLAIN, 14);
        lTitle.setFont(fTitle);
        lName.setFont(fAllLeft);
        lIntroduce.setFont(fAllLeft);
        lSex.setFont(fAllLeft);
        JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));
        lLine.setBounds(20,50,850,30);

        //姓名输入框
        JTextField tfName = new JTextField(100);
        JTextArea taIntroduce = new JTextArea(3, 30);

        //单选框性别
        JRadioButton jrbMale = new JRadioButton("男");
        JRadioButton jrbFemale = new JRadioButton("女");
        ButtonGroup bgSex = new ButtonGroup();
        bgSex.add(jrbMale);
        bgSex.add(jrbFemale);

        //按钮保存跟取消
        JButton btnConfig = new JButton("保存");
        JButton btnCancel = new JButton("取消");

        btnConfig .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel .setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        //将老师的是信息显示出来
        tfName.setText(teacher.getName());
        taIntroduce.setText(teacher.getIntroduce());

        //如果一开始是男的，就将男选框选上
        if ("男".equals(teacher.getSex())) {
            jrbMale.setSelected(true);
        } else {
            jrbFemale.setSelected(true);
        }

        //字体颜色设置
        lName.setForeground(new Color(136, 136, 136));
        lIntroduce.setForeground(new Color(136, 136, 136));
        lSex.setForeground(new Color(136, 136, 136));

        //边框样式
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
        tfName.setBorder(border);
        taIntroduce.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

        lTitle.setBounds(40, 20, 200, 20);

        //姓名标签跟输入框
        lName.setBounds(40, 100, 50, 20);
        tfName.setBounds(90, 95, 400, 30);

        //简介跟简介框
        lIntroduce.setBounds(40, 140, 50, 60);
        taIntroduce.setBounds(90, 155, 400, 100);

        //性别跟性别框
        lSex.setBounds(40, 280, 50, 20);
        jrbMale.setBounds(90, 280, 40, 20);
        jrbFemale.setBounds(150, 280, 40, 20);

        //按钮
        btnConfig.setBounds(90, 380, 80, 30);
        btnCancel.setBounds(200, 380, 80, 30);

        //添加标题到面板里
        panel.add(lTitle);
        panel.add(lLine);
        //姓名添加到面板
        panel.add(tfName);
        panel.add(lName);
        //简介添加到面板
        panel.add(lIntroduce);
        panel.add(taIntroduce);
        //性别跟选款
        panel.add(lSex);
        panel.add(jrbMale);
        panel.add(jrbFemale);
        //按钮
        panel.add(btnConfig);
        panel.add(btnCancel);

        btnConfig.addActionListener(e -> {
            String name = tfName.getText();
            String introduce = taIntroduce.getText();
            String sex = null;
            if (jrbFemale.isSelected()) {
                sex = "女";
            } else {
                sex = "男";
            }
            teacher.setSex(sex);
            teacher.setIntroduce(introduce);
            teacher.setName(name);
            try {
                TeacherCreate.teacher=teacher;

                int result = new TeacherDao().updateTeacher(teacher);
                if (result == 0) {
                    JOptionPane.showMessageDialog(null, "保存失败，请检查！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "保存成功!", "成功提示！", JOptionPane.PLAIN_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("有异常保存失败,保存失败");
            }

        });

        return panel;
    }

}
