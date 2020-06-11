package train.view.succ.teacher;

import javax.swing.*;
import java.awt.*;


/**
 * 开发手记
 * 13:51 2020-06-11
 * 导航栏逐个切换没问题，双击时会出现问题，未修复。
 */

/**
 * @ClassName: TeacherCreateLeft
 * @Author: Swy
 * @Date: 2020-06-09 17:00
 **/
public class TeacherCreateLeft {
    protected static ImageIcon infoIcon1 = new ImageIcon("src/main/resources/images/Info1.png");
    protected static ImageIcon infoIcon2 = new ImageIcon("src/main/resources/images/info2.png");
    protected static ImageIcon insIcon1 = new ImageIcon("src/main/resources/images/ins1.png");
    protected static ImageIcon insIcon2 = new ImageIcon("src/main/resources/images/ins2.png");
    protected static ImageIcon selIcon1 = new ImageIcon("src/main/resources/images/sel1.png");
    protected static ImageIcon selIcon2 = new ImageIcon("src/main/resources/images/sel2.png");
    protected static ImageIcon pwdIcon1 = new ImageIcon("src/main/resources/images/pwd1.png");
    protected static ImageIcon pwdIcon2 = new ImageIcon("src/main/resources/images/pwd2.png");
    protected static ImageIcon insCourIcon1 = new ImageIcon("src/main/resources/images/insCour1.png");
    protected static ImageIcon insCourIcon2 = new ImageIcon("src/main/resources/images/insCour2.png");
    protected static JButton btnInfo = null;
    protected static JButton btnIns = null;
    protected static JButton btnSel = null;
    protected static JButton btnPwd = null;
    protected static JButton btnInsCour = null;

    /**
     * 创建左边导航条
     *
     * @return 左边导航条
     * @Author Swy
     * @Date 22:56 2020-06-08
     * @Param 主窗体
     */
    public static JPanel createLeft() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(200, 0));
        panel.setBackground(new Color(245, 245, 247));
        //按钮初始化
        btnInit();

        //个人信息按钮
        btnInfo.addActionListener(e -> onInfo());
        //导入成绩
        btnIns.addActionListener(e -> onInsGrade());
        //查询成绩
        btnSel.addActionListener(e -> onSel());
        //修改密码
        btnPwd.addActionListener(e -> onPwd());
        //新增课程
        btnInsCour.addActionListener(e -> onInsCourse());

        //图片大小 50*200
        btnInfo.setBounds(0, 35, 200, 35);
        btnInsCour.setBounds(0, 70, 200, 35);
        btnIns.setBounds(0, 105, 200, 35);
        btnSel.setBounds(0, 140, 200, 35);
        btnPwd.setBounds(0, 175, 200, 35);

        panel.add(btnInfo);
        panel.add(btnIns);
        panel.add(btnSel);
        panel.add(btnPwd);
        panel.add(btnPwd);
        panel.add(btnInsCour);
        TeacherCreate.panelLeft = panel;
        return panel;
    }


    /**
     * 当前窗口在个人信息窗口上
     *
     * @return void
     * @Author Swy
     * @Date 12:47 2020-06-11
     * @Param null
     */
    public static void onInfo() {
        System.out.println("个人信息");

        //其他按钮图片
        btnIns.setIcon(insIcon1);
        btnSel.setIcon(selIcon1);
        btnPwd.setIcon(pwdIcon1);
        btnInsCour.setIcon(insCourIcon1);
        btnInfo.setIcon(new ImageIcon("src/main/resources/images/onInfo.png"));

        //设置鼠标移过去变图片
        btnIns.setRolloverIcon(insIcon2);
        btnSel.setRolloverIcon(selIcon2);
        btnPwd.setRolloverIcon(pwdIcon2);
        btnInsCour.setRolloverIcon(insCourIcon2);
        btnInfo.setRolloverIcon(null);


        TeacherCreate.frame.remove(TeacherCreate.panelHome);
        TeacherCreate.frame.remove(TeacherCreate.panelInsCour);
        TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
        TeacherCreate.frame.remove(TeacherCreate.panelIns);
        TeacherCreate.frame.remove(TeacherCreate.panelSel);
        TeacherCreate.frame.remove(TeacherCreate.panelInfo);

        TeacherCreate.panelInfo = TeacherCreateInfo.createInfo(TeacherCreate.teacher);
        TeacherCreate.frame.add(TeacherCreate.panelInfo, "East");

        //以下两行起到刷新效果
        TeacherCreate.frame.repaint();
        TeacherCreate.frame.setVisible(true);
    }


    /**
     * 当导航栏在查询成绩上，这里是一个事件
     *
     * @return void
     * @Author Swy
     * @Date 13:02 2020-06-11
     * @Param null
     */
    public static void onSel() {
        System.out.println("查询成绩");

        btnInfo.setIcon(infoIcon1);
        btnIns.setIcon(insIcon1);
        btnPwd.setIcon(pwdIcon1);
        btnInsCour.setIcon(insCourIcon1);
        btnSel.setIcon(new ImageIcon("src/main/resources/images/onSel.png"));

        btnInfo.setRolloverIcon(infoIcon2);
        btnIns.setRolloverIcon(insIcon2);
        btnPwd.setRolloverIcon(pwdIcon2);
        btnInsCour.setRolloverIcon(insCourIcon2);
        btnSel.setRolloverIcon(null);


        TeacherCreate.frame.remove(TeacherCreate.panelHome);
        TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
        TeacherCreate.frame.remove(TeacherCreate.panelInsCour);
        TeacherCreate.frame.remove(TeacherCreate.panelInfo);
        TeacherCreate.frame.remove(TeacherCreate.panelIns);
        TeacherCreate.frame.remove(TeacherCreate.panelSel);

        TeacherCreate.panelSel = TeacherCreateSel.createSel(TeacherCreate.teacher);
        TeacherCreate.frame.add(TeacherCreate.panelSel, "East");
        TeacherCreate.frame.repaint();
        TeacherCreate.frame.setVisible(true);
    }


    /**
     * 当导航栏在修改密码上，这是一个事件
     *
     * @return void
     * @Author Swy
     * @Date 13:03 2020-06-11
     * @Param null
     */
    public static void onPwd() {
        System.out.println("修改密码");

        btnInfo.setIcon(infoIcon1);
        btnIns.setIcon(insIcon1);
        btnSel.setIcon(selIcon1);
        btnInsCour.setIcon(insCourIcon1);
        btnPwd.setIcon(new ImageIcon("src/main/resources/images/onPwd.png"));

        //设置鼠标移过去变图片
        btnInfo.setRolloverIcon(infoIcon2);
        btnSel.setRolloverIcon(selIcon2);
        btnInsCour.setRolloverIcon(insCourIcon2);
        btnIns.setRolloverIcon(insIcon2);
        btnPwd.setRolloverIcon(null);

        //把原有的删掉再添加后面的
        TeacherCreate.frame.remove(TeacherCreate.panelInfo);
        TeacherCreate.frame.remove(TeacherCreate.panelHome);
        TeacherCreate.frame.remove(TeacherCreate.panelInsCour);
        TeacherCreate.frame.remove(TeacherCreate.panelIns);
        TeacherCreate.frame.remove(TeacherCreate.panelSel);
        TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);

        TeacherCreate.panelUpdatePwd = TeacherCreatePwd.createUpdatePwd(TeacherCreate.teacher);
        TeacherCreate.frame.add(TeacherCreate.panelUpdatePwd, "East");
        //界面重新显示起到刷新效果
        TeacherCreate.frame.repaint();
        TeacherCreate.frame.setVisible(true);

    }


    /**
     * 当导航栏在录入成绩上
     *
     * @return void
     * @Author Swy
     * @Date 13:04 2020-06-11
     * @Param null
     */
    public static void onInsGrade() {
        System.out.println("录入成绩");

        btnInfo.setIcon(infoIcon1);
        btnSel.setIcon(selIcon1);
        btnPwd.setIcon(pwdIcon1);
        btnInsCour.setIcon(insCourIcon1);
        btnIns.setIcon(new ImageIcon("src/main/resources/images/onIns.png"));

        //设置鼠标移过去变图片
        btnInfo.setRolloverIcon(infoIcon2);
        btnSel.setRolloverIcon(selIcon2);
        btnPwd.setRolloverIcon(pwdIcon2);
        btnInsCour.setRolloverIcon(insCourIcon2);
        btnIns.setRolloverIcon(null);


        TeacherCreate.frame.remove(TeacherCreate.panelHome);
        TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
        TeacherCreate.frame.remove(TeacherCreate.panelInsCour);
        TeacherCreate.frame.remove(TeacherCreate.panelInfo);
        TeacherCreate.frame.remove(TeacherCreate.panelSel);
        TeacherCreate.frame.remove(TeacherCreate.panelIns);

        TeacherCreate.panelIns = TeacherCreateIns.createIns(TeacherCreate.teacher);
        TeacherCreate.frame.add(TeacherCreate.panelIns, "East");
        TeacherCreate.frame.repaint();
        TeacherCreate.frame.setVisible(true);
    }


    /**
     * 导航栏在新增课程上
     *
     * @return void
     * @Author Swy
     * @Date 13:04 2020-06-11
     * @Param null
     */
    public static void onInsCourse() {
        System.out.println("新增课程");
        //设置其他导航的图片
        btnInfo.setIcon(infoIcon1);
        btnIns.setIcon(insIcon1);
        btnSel.setIcon(selIcon1);
        btnPwd.setIcon(pwdIcon1);
        btnInsCour.setIcon(new ImageIcon("src/main/resources/images/onInsCour.png"));

        //设置其他导航鼠标移过的图片
        btnInfo.setRolloverIcon(infoIcon2);
        btnIns.setRolloverIcon(insIcon2);
        btnSel.setRolloverIcon(selIcon2);
        btnPwd.setRolloverIcon(pwdIcon2);
        btnInsCour.setRolloverIcon(null);


        TeacherCreate.frame.remove(TeacherCreate.panelHome);
        TeacherCreate.frame.remove(TeacherCreate.panelUpdatePwd);
        TeacherCreate.frame.remove(TeacherCreate.panelSel);
        TeacherCreate.frame.remove(TeacherCreate.panelInfo);
        TeacherCreate.frame.remove(TeacherCreate.panelIns);
        TeacherCreate.frame.remove(TeacherCreate.panelInsCour);

        //将其他主体框移除，只留当前的
        TeacherCreate.panelInsCour = TeacherCreateInsCour.createInsCour(TeacherCreate.teacher);
        TeacherCreate.frame.add(TeacherCreate.panelInsCour, "East");
        TeacherCreate.frame.repaint();
        TeacherCreate.frame.setVisible(true);


    }

    /**
     * 导航按钮初始化
     *
     * @return void
     * @Author Swy
     * @Date 12:42 2020-06-11
     * @Param null
     */
    public static void btnInit() {

        btnInfo = new JButton();
        btnIns = new JButton();
        btnSel = new JButton();
        btnPwd = new JButton();
        btnInsCour = new JButton();

        //设置按钮图标
        btnInfo.setIcon(infoIcon1);
        btnIns.setIcon(insIcon1);
        btnSel.setIcon(selIcon1);
        btnPwd.setIcon(pwdIcon1);
        btnInsCour.setIcon(insCourIcon1);

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
    }
}
