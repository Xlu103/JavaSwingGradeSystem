package train.view.succ.teacher;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: TeacherCreateTop
 * @Author: Swy
 * @Date: 2020-06-09 16:59
 **/
public class TeacherCreateTop {

    /**
     * 创建顶部布局
     *
     * @Author Swy
     * @Date 19:22 2020-06-08
     * @Param null
     * @return JPanel 顶部的组件
     */
    public static JPanel createTop() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(0, 50));
        panel.setBackground(new Color(198, 47, 47));

        Image img = null;
        ImageIcon closeIcon1 = new ImageIcon("src/main/resources/images/close1.png");
        ImageIcon closeIcon2 = new ImageIcon("src/main/resources/images/close2.png");
        ImageIcon homeIcon = new ImageIcon("src/main/resources/images/home.png");
        ImageIcon minIcon1 = new ImageIcon("src/main/resources/images/min1.png");
        ImageIcon minIcon2 = new ImageIcon("src/main/resources/images/min2.png");

        //这两行是用来缩放图片
        img = closeIcon1.getImage();
        img = img.getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        closeIcon1.setImage(img);

        //这两行是用来缩放图片
        img = closeIcon2.getImage();
        img = img.getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        closeIcon2.setImage(img);

        //这两行是用来缩放图片
        img = minIcon1.getImage();
        img = img.getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        minIcon1.setImage(img);

        //这两行是用来缩放图片
        img = minIcon2.getImage();
        img = img.getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        //将缩放完的图片再传回来
        minIcon2.setImage(img);

        JButton btnExit = new JButton(closeIcon1);
        JButton btnMin = new JButton(minIcon1);
        JButton btnHome = new JButton(homeIcon);

        btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnMin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnMin.setOpaque(false);
        btnExit.setOpaque(false);
        btnHome.setOpaque(false);
        btnMin.setBorder(null);
        btnHome.setBorder(null);
        btnExit.setBorder(null);
        btnMin.setContentAreaFilled(false);
        btnHome.setContentAreaFilled(false);
        btnExit.setContentAreaFilled(false);

        //设置移过去显示
        btnExit.setRolloverIcon(closeIcon2);
        btnMin.setRolloverIcon(minIcon2);

        btnExit.setBounds(1125 - 35, 15, 16, 16);
        btnMin.setBounds(1125 - 65, 15, 16, 16);
        btnHome.setBounds(20 , 10, 200, 32);

        panel.add(btnMin);
        panel.add(btnExit);
        panel.add(btnHome);

        TeacherCreate.panelHome = TeacherCreateHome.createHome();
        //窗口关闭
        btnExit.addActionListener(e -> System.exit(0));
        //窗口最小化
        btnMin.addActionListener(e -> TeacherCreate.frame.setExtendedState(JFrame.ICONIFIED));
        //主页按钮事件
        btnHome.addActionListener(e->{
            TeacherCreate.frame.remove(TeacherCreate.panelInfo);
            TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
            TeacherCreate.frame.remove(TeacherCreate.panelInsCour);
            TeacherCreate.frame.remove(TeacherCreate.panelSel);
            TeacherCreate.frame.remove(TeacherCreate.panelIns);
            TeacherCreate.frame.remove(TeacherCreate.panelHome);

            TeacherCreate.panelHome=TeacherCreateHome.createHome();
            TeacherCreate.frame.add(TeacherCreate.panelHome, "East");
            TeacherCreate.frame.add(TeacherCreate.panelTop, "North");
            TeacherCreate.frame.add(TeacherCreate.panelLeft, "West");

            TeacherCreate.frame.repaint();
            TeacherCreate.frame.setVisible(true);
        });
        panel.setVisible(true);
        TeacherCreate.panelTop=panel;
        return panel;
    }

}
