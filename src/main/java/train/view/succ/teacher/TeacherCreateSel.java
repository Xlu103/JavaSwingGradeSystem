package train.view.succ.teacher;

import train.entity.Teacher;
import train.view.util.JTextFieldHintListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * @ClassName: TeacherCreateSel
 * @Author: Swy
 * @Date: 2020-06-09 17:14
 **/
public class TeacherCreateSel {
    public static JPanel createSel(Teacher teacher) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //标题标签
        JLabel lTitle = new JLabel("查询成绩");
        JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));
        JLabel lCourName = new JLabel("课程名称:");
        JLabel lRule = new JLabel("筛选规则:");

        //下拉框出现的条目
        String[] gradeStrArr = new String[] { "优秀", "良好","中等","及格","不及格" };
        String[] courStrArr = new String[]{"Java程序设计", "C语言程序设计"};
        JComboBox cbGrade = new JComboBox(gradeStrArr);
        JComboBox cbCour = new JComboBox(courStrArr);

        // 列名
        String[] columnName = new String[]{"航班号", "出发时间", "飞行时间", "出发地", "目的地", "余票", "票价"};
        // 表格具体数据
        String[][] columnDate = new String[][]{
                {"1", "2019-01-18 10:05", "90分钟", "北京", "纽约", "50", "500.0"},
                {"2", "2019-01-18 10:05", "90分钟", "北京", "纽约", "10", "500.0"},
                {"3", "2019-01-18 10:05", "90分钟", "北京", "纽约", "10", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
                {"4", "2019-01-18 10:05", "90分钟", "北京", "纽约", "40", "500.0"},
        };
        JTable table = new JTable(columnDate, columnName);
        table.setBackground(new Color(250, 250, 250));
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.setEnabled(false);
        cbGrade.setOpaque(false);

        //添加到滚动条里面
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(new Color(250, 250, 250));

        //标题字体
        Font fTitle = new Font("等线", Font.PLAIN, 20);
        Font fAllLeft = new Font("等线", Font.PLAIN, 14);
        lTitle.setFont(fTitle);
        lCourName.setFont(fAllLeft);
        lRule.setFont(fAllLeft);

        //按钮保存跟取消
        JButton btnConfig = new JButton("查询");
        JButton btnCancel = new JButton("取消");

        //设置鼠标变手
        btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //边框样式
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
        table.setBorder(border);
        scrollPane.setBorder(border);
        cbGrade.setBorder(border);
        cbCour.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

        lTitle.setBounds(40, 20, 200, 20);
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

        scrollPane.setBounds(40,180,800,400);

        //添加标题到面板里
        panel.add(lTitle);
        panel.add(lLine);

        panel.add(lCourName);
        panel.add(cbCour);
        panel.add(cbGrade);
        panel.add(lRule);

        panel.add(btnConfig);
        panel.add(btnCancel);
        panel.add(scrollPane);

        return panel;
    }
}
