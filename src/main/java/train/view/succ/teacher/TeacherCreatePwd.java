package train.view.succ.teacher;

import train.dao.teacher.TeacherDao;
import train.entity.Teacher;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * @ClassName: TeacherCreatePwd
 * @Author: Swy
 * @Date: 2020-06-09 17:02
 **/
public class TeacherCreatePwd {


    /**
     * 创建修改密码面板
     *
     * @return JPanel 修改密码面板
     * @Author Swy
     * @Date 16:06 2020-06-09
     * @Param null
     */
    public static JPanel createUpdatePwd(Teacher teacher) {
        //面板初始化
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //标题标签
        JLabel lTitle = new JLabel("修改密码");
        JLabel lOldPwd = new JLabel("旧密码:");
        JLabel lNewPwd1 = new JLabel("新密码:");
        JLabel lNewPwd2 = new JLabel("重复新密码:");

        JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));
        //标题字体
        Font fTitle = new Font("等线", Font.PLAIN, 24);
        Font fAllLeft = new Font("等线", Font.PLAIN, 14);
        lTitle.setFont(fTitle);
        lOldPwd.setFont(fAllLeft);
        lNewPwd1.setFont(fAllLeft);
        lNewPwd2.setFont(fAllLeft);

        //输入框
        JPasswordField tfOld = new JPasswordField(20);
        JPasswordField tfNew1 = new JPasswordField(20);
        JPasswordField tfNew2 = new JPasswordField(20);

        //按钮保存跟取消
        JButton btnConfig = new JButton("确认");
        JButton btnCancel = new JButton("取消");

        //设置鼠标变手
        btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        //字体颜色设置
        lNewPwd1.setForeground(new Color(136, 136, 136));
        lNewPwd2.setForeground(new Color(136, 136, 136));
        lOldPwd.setForeground(new Color(136, 136, 136));

        //边框样式
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
        tfOld.setBorder(border);
        tfNew1.setBorder(border);
        tfNew2.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

        lTitle.setBounds(40, 35, 200, 24);
        //分割线
        lLine.setBounds(20, 50, 850, 30);
        //旧密码跟输入框
        lOldPwd.setBounds(40, 120, 50, 20);
        tfOld.setBounds(130, 115, 400, 30);

        //新密码跟输入框
        lNewPwd1.setBounds(40, 180, 50, 20);
        tfNew1.setBounds(130, 175, 400, 30);
        lNewPwd2.setBounds(40, 240, 100, 20);
        tfNew2.setBounds(130, 235, 400, 30);

        //按钮
        btnConfig.setBounds(130, 350, 80, 30);
        btnCancel.setBounds(280, 350, 80, 30);

        //添加标题到面板里
        panel.add(lTitle);
        panel.add(lLine);
        panel.add(lOldPwd);
        panel.add(tfOld);
        panel.add(lNewPwd1);
        panel.add(tfNew1);
        panel.add(lNewPwd2);
        panel.add(tfNew2);

        //按钮
        panel.add(btnConfig);
        panel.add(btnCancel);
        //确认修改密码按钮事件
        btnConfig.addActionListener(e -> {
            if (teacher.getPassword().equals(tfOld.getText())) {
                if (!"".equals(tfNew1.getText())) {
                    if (!"".equals(tfNew2.getText())) {
                        if (tfNew2.getText().equals(tfNew1.getText())) {
                            try {
                                int result = new TeacherDao().updatePassword(teacher.getNum(), tfNew2.getText());
                                if (result == 1) {
                                    JOptionPane.showMessageDialog(null, "修改密码成功!", "成功提示！", JOptionPane.PLAIN_MESSAGE);
                                    TeacherCreate.teacher = new TeacherDao().selectTeacher(teacher.getNum(), tfNew2.getText());
                                    tfOld.setText("");
                                    tfNew2.setText("");
                                    tfNew1.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(null, "修改密码失败,请确认旧密码是否正确！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "新密码不一致！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "新密码不能为空！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "新密码不能为空！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "旧密码错误！", "错误提示！", JOptionPane.ERROR_MESSAGE);

            }

        });
        return panel;
    }

}
