package train.view.succ.teacher;

import train.dao.course.CourseDao;
import train.dao.grade.GradeDao;
import train.entity.Course;
import train.entity.Grade;
import train.entity.Teacher;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.SQLException;


/**
 * 查询成绩类
 * @ClassName: TeacherCreateSel
 * @Author: Swy
 * @Date: 2020-06-09 17:14
 **/
public class TeacherCreateSel {
    protected static JPanel panel = null;
    protected static JLabel lTitle = null;
    protected static JLabel lLine = null;
    protected static JLabel lCourName = null;
    protected static JLabel lRule = null;
    protected static JComboBox cbGrade = null;
    protected static JComboBox cbCour = null;
    protected static Teacher teacher;
    protected static String[] gradeStrArr = new String[]{"全部", "优秀", "良好", "中等", "及格", "不及格"};
    protected static String[] courStrArr = null;
    protected static String[] columnName = new String[]{"编号", "课程代码", "课程名称", "教程工号", "教师姓名", "学生姓名", "学生学号", "学生成绩"};
    protected static Font fTitle = new Font("等线", Font.PLAIN, 24);
    protected static Font fAllLeft = new Font("等线", Font.PLAIN, 14);
    protected static JButton btnConfig = null;
    protected static JButton btnCancel = null;
    protected static MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
    protected static JScrollPane scrollPane;
    protected static JTable table;

    /**
     * 创建查询成绩窗体
     *
     * @return JPanel 一个查询学生成绩的窗体
     * @Author Swy
     * @Date 15:23 2020-06-11
     * @Param Teacher 教师实例
     */
    public static JPanel createSel(Teacher teacher) {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //教师实例初始化
        teacherInit(teacher);

        //组件初始化
        itemInit();

        lTitle.setBounds(40, 35, 200, 24);
        //分割线
        lLine.setBounds(20, 50, 850, 30);

        //课程编号输入框
        lCourName.setBounds(40, 120, 100, 30);
        cbCour.setBounds(110, 120, 130, 30);

        //筛选成绩下拉列表
        lRule.setBounds(280, 120, 100, 30);
        cbGrade.setBounds(350, 120, 60, 30);
        //按钮
        btnConfig.setBounds(480, 120, 80, 30);
        btnCancel.setBounds(600, 120, 80, 30);

        //添加标题到面板里
        panel.add(lTitle);
        panel.add(lLine);

        panel.add(lCourName);
        panel.add(cbCour);
        panel.add(cbGrade);
        panel.add(lRule);
        panel.add(btnConfig);
        panel.add(btnCancel);

        btnConfig.addActionListener(e -> selGrade());
        return panel;
    }

    /**
     * 查询按钮事件
     *
     * @return void
     * @Author Swy
     * @Date 17:20 2020-06-11
     * @Param null
     */
    public static void selGrade() {
        // 得到所选的每课程名称
        String courName = (String) cbCour.getSelectedItem();
        // 得到所选的规则
        String rule = (String) cbGrade.getSelectedItem();
        try {
            //得到教师所有的课程
            Course[] courses = new CourseDao().selCourse(teacher);
            //根据所选课程名称得到课程代码，获取所有学生成绩
            String courNum = getCourseNum(courses, courName);

            Grade[] grades = getGrade(courNum, rule);
            if (scrollPane != null) {
                panel.remove(scrollPane);
            }

            table = getTable(grades);
            scrollPane = scrollPaneInit(table);
            panel.add(scrollPane);
            panel.repaint();
            panel.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("该老师没有课程！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回学生成绩数组，具有筛选共呢个你
     *
     * @return 学生成绩实例数组
     * @Author Swy
     * @Date 18:10 2020-06-11
     * @Param courNum 课程代码，rule  筛选规则
     */
    public static Grade[] getGrade(String courNum, String rule) throws SQLException, ClassNotFoundException {
        System.out.println(rule);
        switch (rule) {
            case "优秀":
                return new GradeDao().selGrade(courNum, 95, 100);
            case "良好":
                return new GradeDao().selGrade(courNum, 85, 100);
            case "中等":
                return new GradeDao().selGrade(courNum, 75, 100);
            case "及格":
                return new GradeDao().selGrade(courNum, 65, 100);
            case "不及格":
                return new GradeDao().selGrade(courNum, 0, 60);
            case "全部":
                return new GradeDao().selGrade(courNum, 0, 100);
            default:
                return new GradeDao().selGrade(courNum, 0, 0);
        }

    }

    /**
     * 教师实例初始
     *
     * @return void
     * @Author Swy
     * @Date 17:51 2020-06-11
     * @Param teacher 教师实例；
     */
    public static void teacherInit(Teacher teacher) {
        TeacherCreateSel.teacher = teacher;
        try {
            Course[] courses = new CourseDao().selCourse(teacher);
            courStrArr = new String[courses.length];
            for (int i = 0; i < courses.length; i++) {
                courStrArr[i] = courses[i].getName();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 组件初始化
     *
     * @return void
     * @Author Swy
     * @Date 15:32 2020-06-11
     * @Param null
     */
    public static void itemInit() {
        btnCancel = new JButton("取消");
        btnConfig = new JButton("查询");
        cbGrade = new JComboBox(gradeStrArr);
        cbCour = new JComboBox(courStrArr);
        lTitle = new JLabel("查询成绩");
        lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));
        lCourName = new JLabel("课程名称:");
        lRule = new JLabel("筛选规则:");

//        table = new JTable(columnDate, columnName);
//        scrollPane = scrollPaneInit(table);
        cbGrade.setOpaque(false);

        //设置字体
        lTitle.setFont(fTitle);
        lCourName.setFont(fAllLeft);
        lRule.setFont(fAllLeft);

        //设置鼠标变手
        btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        cbGrade.setBorder(border);
        cbCour.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

    }

    /**
     * 滚动面板初始化
     *
     * @return JScrollPane 滚动面板
     * @Author Swy
     * @Date 16:51 2020-06-11
     * @Param JTable 在面板里面的表格
     */
    public static JScrollPane scrollPaneInit(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40, 180, 800, 400);
        scrollPane.setBorder(border);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        return scrollPane;
    }

    /**
     * 根据课程名在课程数组里面获取课程代码
     *
     * @return String 课程代码
     * @Author Swy
     * @Date 16:52 2020-06-11
     * @Param CouresName 课程名,course 课程列表
     */
    public static String getCourseNum(Course[] course, String courseName) {
        String courNum = "";
        for (Course value : course) {
            if (value.getName().equals(courseName)) {
                courNum = value.getNum();
                return courNum;
            }
        }
        return courNum;
    }

    /**
     * 得到成绩数组返回一个表格
     *
     * @return JTable 表格
     * @Author Swy
     * @Date 17:17 2020-06-11
     * @Param grades 成绩实例数组,rule 规则
     */
    public static JTable getTable(Grade[] grades) {

        String[][] columnDate = new String[grades.length][8];
        for (int i = 0; i < grades.length; i++) {
            columnDate[i][0] = (i + 1) + "";
            columnDate[i][1] = grades[i].getCourNum();
            columnDate[i][2] = grades[i].getCourName();
            columnDate[i][3] = grades[i].getTeacherNum();
            columnDate[i][4] = grades[i].getTeacherName();
            columnDate[i][5] = grades[i].getStuName();
            columnDate[i][6] = grades[i].getStuNum();
            columnDate[i][7] = grades[i].getStuGrade();
        }
        JTable table = new JTable(columnDate, columnName);


        //设置表头颜色
        DefaultTableCellRenderer cellRenderer1 = new DefaultTableCellRenderer();
        DefaultTableCellRenderer cellRenderer2 = new DefaultTableCellRenderer();
        cellRenderer1.setBackground(new Color(122, 243, 250));
        cellRenderer2.setBackground(new Color(181, 248, 250));
        for (int i = 0; i < 8; i++) {
            TableColumn column = table.getTableHeader().getColumnModel().getColumn(i);
            if (i % 2 == 0) {
                column.setHeaderRenderer(cellRenderer1);
            } else {
                column.setHeaderRenderer(cellRenderer2);
            }

        }

        //背景颜色
        table.setBackground(new Color(250, 250, 250));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        //不能点击更改
        table.setEnabled(false);
        //设置边框
        table.setBorder(border);

        return table;

    }

}
