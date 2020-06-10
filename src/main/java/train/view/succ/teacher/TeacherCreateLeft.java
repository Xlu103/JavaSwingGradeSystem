package train.view.succ.teacher;

import train.entity.Teacher;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * @ClassName: TeacherCreateLeft
 * @Author: Swy
 * @Date: 2020-06-09 17:00
 **/
public class TeacherCreateLeft {
    /**
     * 创建左边导航条
     *
     * @return 左边导航条
     * @Author Swy
     * @Date 22:56 2020-06-08
     * @Param 主窗体
     */
    public static JPanel createLeft(Teacher teacher) throws SQLException, ClassNotFoundException {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(200, 0));
        panel.setBackground(new Color(245, 245, 247));


        Image img = null;
        ImageIcon infoIcon1 = new ImageIcon("src/main/resources/images/Info1.png");
        ImageIcon infoIcon2 = new ImageIcon("src/main/resources/images/info2.png");
        ImageIcon insIcon1 = new ImageIcon("src/main/resources/images/ins1.png");
        ImageIcon insIcon2 = new ImageIcon("src/main/resources/images/ins2.png");
        ImageIcon selIcon1 = new ImageIcon("src/main/resources/images/sel1.png");
        ImageIcon selIcon2 = new ImageIcon("src/main/resources/images/sel2.png");
        ImageIcon pwdIcon1 = new ImageIcon("src/main/resources/images/pwd1.png");
        ImageIcon pwdIcon2 = new ImageIcon("src/main/resources/images/pwd2.png");
        ImageIcon insCourIcon1 = new ImageIcon("src/main/resources/images/insCour1.png");
        ImageIcon insCourIcon2 = new ImageIcon("src/main/resources/images/insCour2.png");


        //这两行是用来缩放图片
        img = infoIcon1.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        infoIcon1.setImage(img);


        //这两行是用来缩放图片
        img = infoIcon2.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        infoIcon2.setImage(img);

        //这两行是用来缩放图片
        img = insIcon1.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        insIcon1.setImage(img);

        //这两行是用来缩放图片
        img = insIcon2.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        insIcon2.setImage(img);

        //这两行是用来缩放图片
        img = selIcon1.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        selIcon1.setImage(img);

        //这两行是用来缩放图片
        img = selIcon2.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        selIcon2.setImage(img);

        //这两行是用来缩放图片
        img = pwdIcon1.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        pwdIcon1.setImage(img);

        //这两行是用来缩放图片
        img = pwdIcon2.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        pwdIcon2.setImage(img);

        //这两行是用来缩放图片
        img = insCourIcon1.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        insCourIcon1.setImage(img);

        //这两行是用来缩放图片
        img = insCourIcon2.getImage();
        img = img.getScaledInstance(160, 40, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        insCourIcon2.setImage(img);


        JButton btnInfo = new JButton(infoIcon1);
        JButton btnIns = new JButton(insIcon1);
        JButton btnSel = new JButton(selIcon1);
        JButton btnPwd = new JButton(pwdIcon1);
        JButton btnInsCour = new JButton(insCourIcon1);
        //设置鼠标移过去就变手
        btnInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnIns.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnPwd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnInsCour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //设置鼠标移过去变图片
        btnInfo.setRolloverIcon(infoIcon2);
        btnIns.setRolloverIcon(insIcon2);
        btnSel.setRolloverIcon(selIcon2);
        btnPwd.setRolloverIcon(pwdIcon2);
        btnInsCour.setRolloverIcon(insCourIcon2);

        //设置背景透明，边框取消，内容不可见
        btnInfo.setOpaque(false);
        btnInfo.setBorder(null);
        btnInfo.setContentAreaFilled(false);

        btnIns.setOpaque(false);
        btnIns.setBorder(null);
        btnIns.setContentAreaFilled(false);

        btnSel.setOpaque(false);
        btnSel.setBorder(null);
        btnSel.setContentAreaFilled(false);

        btnPwd.setOpaque(false);
        btnPwd.setBorder(null);
        btnPwd.setContentAreaFilled(false);

        btnInsCour.setOpaque(false);
        btnInsCour.setBorder(null);
        btnInsCour.setContentAreaFilled(false);


        //个人信息按钮
        btnInfo.addActionListener(e -> {
            System.out.println("个人信息");
            try {
                TeacherCreate.panelInfo = TeacherCreateInfo.createInfo(TeacherCreate.teacher);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("个人信息获取失败,密码错误！");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

            TeacherCreate.frame.add(TeacherCreate.panelInfo, "East");
            TeacherCreate.frame.remove(TeacherCreate.panelHome);
            TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
            TeacherCreate.frame.remove(TeacherCreate.panelIns);
            TeacherCreate.frame.remove(TeacherCreate.panelSel);

            //以下两行起到刷新效果
            TeacherCreate.frame.repaint();
            TeacherCreate.frame.setVisible(true);
        });
        //导入成绩
        btnIns.addActionListener(e -> {
            System.out.println("录入成绩");
            TeacherCreate.panelIns = TeacherCreateIns.createIns(TeacherCreate.teacher);
            TeacherCreate.frame.remove(TeacherCreate.panelHome);
            TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
            TeacherCreate.frame.remove(TeacherCreate.panelInfo);
            TeacherCreate.frame.remove(TeacherCreate.panelSel);
            TeacherCreate.frame.add(TeacherCreate.panelIns, "East");
            //以下两行起到刷新效果
            TeacherCreate.frame.repaint();
            TeacherCreate.frame.setVisible(true);
        });
        btnSel.addActionListener(e -> {
            System.out.println("查询成绩");
            TeacherCreate.panelSel = TeacherCreateSel.createSel(TeacherCreate.teacher);
            TeacherCreate.frame.add(TeacherCreate.panelSel, "East");
            TeacherCreate.frame.remove(TeacherCreate.panelHome);
            TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
            TeacherCreate.frame.remove(TeacherCreate.panelInfo);
            TeacherCreate.frame.remove(TeacherCreate.panelIns);
            //以下两行起到刷新效果
            TeacherCreate.frame.repaint();
            TeacherCreate.frame.setVisible(true);
        });
        //修改密码事件
        btnPwd.addActionListener(e -> {
            TeacherCreate.panelUpdatePwd = TeacherCreatePwd.createUpdatePwd(TeacherCreate.teacher);
            System.out.println("修改密码");
            TeacherCreate.frame.add(TeacherCreate.panelUpdatePwd, "East");
            try {
                //把原有的删掉再添加后面的
                TeacherCreate.frame.remove(TeacherCreate.panelInfo);
            } catch (Exception ex) {
                System.out.println("消息面板还没创建");
            }

            try {
                TeacherCreate.frame.remove(TeacherCreate.panelHome);
            } catch (Exception ex) {
                System.out.println("消息面板还没创建");
            }
            try {
                TeacherCreate.frame.remove(TeacherCreate.panelIns);
            } catch (Exception ex) {
                System.out.println("插入面板还没创建");
            }
            try {
                TeacherCreate.frame.remove(TeacherCreate.panelSel);
            } catch (Exception ex) {
                System.out.println("查询面板还没创建");
            }

            //界面重新显示起到刷新效果
            TeacherCreate.frame.repaint();
            TeacherCreate.frame.setVisible(true);

        });

        //图片大小 50*200
        btnInfo.setBounds(0, 30, 160, 40);
        btnInsCour.setBounds(0, 80, 160, 40);
        btnIns.setBounds(0, 130, 160, 40);
        btnSel.setBounds(0, 180, 160, 40);
        btnPwd.setBounds(0, 230, 160, 40);

        panel.add(btnInfo);
        panel.add(btnIns);
        panel.add(btnSel);
        panel.add(btnPwd);
        panel.add(btnPwd);
        panel.add(btnInsCour);
        TeacherCreate.panelLeft = panel;
        return panel;
    }

}
