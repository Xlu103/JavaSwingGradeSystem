package train.view.succ.teacher;

import train.dao.teacher.TeacherDao;
import train.entity.Teacher;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * 个人信息类，用于创建信息面板
 *
 * @ClassName: TeacherCreateInfo
 * @Author: Swy
 * @Date: 2020-06-09 17:01
 **/
public class TeacherCreateInfo {

    /**
     * 标题标签
     */
    protected static JLabel lTitle = null;
    protected static JLabel lName = null;
    protected static JLabel lIntroduce = null;
    protected static JLabel lSex = null;

    /**
     * 输入框
     */
    protected static JTextField tfName = null;
    protected static JTextArea taIntroduce = null;

    /**
     * 单选框性别
     */
    protected static JRadioButton jrbMale = null;
    protected static JRadioButton jrbFemale = null;
    protected static ButtonGroup bgSex = null;

    /**
     * 字体样式
     */
    protected static Font fTitle = new Font("等线", Font.PLAIN, 24);
    protected static Font fAllLeft = new Font("等线", Font.PLAIN, 14);

    /**
     * 按钮保存跟取消
     */
    protected static JButton btnConfig = null;
    protected static JButton btnCancel = null;

    /**
     * 教师实例
     */
    protected static Teacher teacher = null;

    protected static JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));

    /**
     * 获得个人信息面板
     *
     * @return JPanel
     * @Author Swy
     * @Date 22:57 2020-06-08
     * @Param null
     */
    public static JPanel createInfo(Teacher teacher) {
        //面板初始化
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        TeacherCreateInfo.teacher = teacher;


        //初始化初始化
        itemInit();

        //教师初始化
        teacherInit();

        //标题跟分割线位置
        lLine.setBounds(20, 50, 850, 30);
        lTitle.setBounds(40, 35, 200, 24);

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

        //按钮事件绑定
        btnConfig.addActionListener(e -> updateInfo());
        return panel;
    }

    /**
     * 保存按钮事件，将教师的信息更新
     *
     * @return void
     * @Author Swy
     * @Date 13:15 2020-06-11
     * @Param null
     */
    public static void updateInfo() {
        String name = tfName.getText();
        String introduce = taIntroduce.getText();
        //判断单选框是否被选择
        String sex=jrbFemale.isSelected()?"女":"男";
        teacher.setSex(sex);
        teacher.setIntroduce(introduce);
        teacher.setName(name);
        try {
            TeacherCreate.teacher = teacher;
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
    }


    /**
     * 教师初始化，将教师的信息在组件上显示出来
     *
     * @return void
     * @Author Swy
     * @Date 13:25 2020-06-11
     * @Param null
     */
    public static void teacherInit() {
        //将老师的是信息显示出来
        tfName.setText(teacher.getName());
        taIntroduce.setText(teacher.getIntroduce());

        //如果一开始是男的，就将男选框选上
        if ("男".equals(teacher.getSex())) {
            jrbMale.setSelected(true);
        } else {
            jrbFemale.setSelected(true);
        }
    }

    /**
     * 按钮初始化
     *
     * @return void
     * @Author Swy
     * @Date 13:19 2020-06-11
     * @Param null
     */
    public static void itemInit() {
        //按钮
        btnConfig = new JButton("保存");
        btnCancel = new JButton("取消");

        //标题标签
        lTitle = new JLabel("编辑个人信息");
        lName = new JLabel("姓名:");
        lIntroduce = new JLabel("介绍:");
        lSex = new JLabel("性别:");

        //姓名输入框
        tfName = new JTextField(100);
        taIntroduce = new JTextArea(3, 30);

        //单选框性别
        jrbMale = new JRadioButton("男");
        jrbFemale = new JRadioButton("女");
        bgSex = new ButtonGroup();

        //字体配置
        lTitle.setFont(fTitle);
        lName.setFont(fAllLeft);
        lIntroduce.setFont(fAllLeft);
        lSex.setFont(fAllLeft);

        //边框样式
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
        tfName.setBorder(border);
        taIntroduce.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

        //按钮变手
        btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //字体颜色设置
        lName.setForeground(new Color(136, 136, 136));
        lIntroduce.setForeground(new Color(136, 136, 136));
        lSex.setForeground(new Color(136, 136, 136));

        //单选框分组
        bgSex.add(jrbMale);
        bgSex.add(jrbFemale);
    }

}
