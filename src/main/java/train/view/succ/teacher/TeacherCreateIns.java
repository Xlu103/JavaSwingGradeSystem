package train.view.succ.teacher;

import java.io.IOException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import train.dao.grade.GradeDao;
import train.entity.Grade;
import train.entity.Teacher;
import train.excel.ExcelData;
import train.view.util.JTextFieldHintListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.File;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 录入信息组件
 *
 * @ClassName: TeacherCreateIns
 * @Author: Swy
 * @Date: 2020-06-09 17:10
 **/
public class TeacherCreateIns {

    /**
     * 用于创建录入信息类，将信息放到excel文选择文件后录入信息
     *
     * @return JPanel 返回一个面板
     * @Author Swy
     * @Date 22:03 2020-06-09
     * @Param Teacher 教师实例
     */
    public static JPanel createIns(Teacher teacher) {
        //面板初始化
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        //标题标签
        JLabel lTitle = new JLabel("录入成绩");
        JLabel lCourNum = new JLabel("课程代码:");
        JLabel lCourName = new JLabel("课程名称:");
        JLabel lTeacherNum = new JLabel("教师工号:");
        JLabel lFilePath = new JLabel("文件目录:");
        JLabel lTeacherName = new JLabel("教师名称:");
        JLabel lLine = new JLabel(new ImageIcon("src/main/resources/images/line.png"));

        //输入框
        JTextField tfTeacherName = new JTextField(20);
        JTextField tfTeacherNum = new JTextField(20);
        JTextField tfCourNum = new JTextField(20);
        JTextField tfCourName = new JTextField(20);
        JTextField tfFilePath = new JTextField(20);

        //按钮保存跟取消
        JButton btnConfig = new JButton("确认");
        JButton btnCancel = new JButton("取消");
        JButton btnSelFile = new JButton(new ImageIcon("src/main/resources/images/file.png"));

        //设置字体
        Font fTitle = new Font("等线", Font.PLAIN, 20);
        Font fAllLeft = new Font("等线", Font.PLAIN, 14);
        Font fBtn = new Font("等线", Font.PLAIN, 16);
        lTitle.setFont(fTitle);
        lCourNum.setFont(fAllLeft);
        lCourName.setFont(fAllLeft);
        lTeacherNum.setFont(fAllLeft);
        lFilePath.setFont(fAllLeft);
        lTeacherName.setFont(fAllLeft);
        btnCancel.setFont(fBtn);
        btnConfig.setFont(fBtn);
        btnSelFile.setFont(fBtn);

        //文件选择按钮去除边框，背景
        btnSelFile.setOpaque(false);
        btnSelFile.setBorder(null);
        btnSelFile.setContentAreaFilled(false);

        //设置鼠标变手
        btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSelFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //字体颜色设置
        lCourNum.setForeground(new Color(136, 136, 136));
        lTeacherNum.setForeground(new Color(136, 136, 136));
        lCourName.setForeground(new Color(136, 136, 136));
        lFilePath.setForeground(new Color(136, 136, 136));
        lTeacherName.setForeground(new Color(136, 136, 136));

        //输入框边框样式
        MatteBorder border = new MatteBorder(1, 1, 1, 1, new Color(136, 136, 136, 97));
        tfTeacherName.setBorder(border);
        tfTeacherNum.setBorder(border);
        tfCourNum.setBorder(border);
        tfCourName.setBorder(border);
        tfFilePath.setBorder(border);
        btnConfig.setBorder(border);
        btnCancel.setBorder(border);

        //标题位置
        lTitle.setBounds(40, 20, 200, 20);
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

        //选择文件
        lFilePath.setBounds(40, 240, 100, 20);
        tfFilePath.setBounds(120, 235, 400, 30);
        btnSelFile.setBounds(540, 236, 25, 25);

        //按钮
        btnConfig.setBounds(120, 350, 80, 30);
        btnCancel.setBounds(280, 350, 80, 30);

        //文本框初始值
        tfTeacherNum.setText(teacher.getNum());
        tfTeacherName.setText(teacher.getName());

        //设置文本框不能被输入
        tfTeacherNum.setEnabled(false);

        //设置默认提示字体
        tfFilePath.addFocusListener(new JTextFieldHintListener(tfFilePath, "选择成绩表文件"));

        //添加标题到面板里
        panel.add(lTitle);
        panel.add(lLine);
        panel.add(lTitle);
        panel.add(lTeacherName);
        panel.add(tfTeacherName);
        panel.add(lTeacherNum);
        panel.add(tfTeacherNum);
        panel.add(lFilePath);
        panel.add(tfFilePath);
        panel.add(lCourName);
        panel.add(tfCourName);
        panel.add(lCourNum);
        panel.add(tfCourNum);
        panel.add(btnSelFile);
        panel.add(btnCancel);
        panel.add(btnConfig);

        //文件选择按钮事件
        btnSelFile.addActionListener(e -> {
            //得到文件目录
            String excelFilePath = TeacherCreateIns.selExcelFile();
            if (excelFilePath != null) {
                tfFilePath.setText(excelFilePath);
            }
        });

        btnConfig.addActionListener(e -> {
            //判断课程号是否为空
            if (!"".equals(tfCourNum.getText())) {
                //判断课程名称是否为空
                if (!"".equals(tfCourName.getText())) {
                    try {
                        //得到Excel文件中所有数据
                        ExcelData sheet1 = new ExcelData(tfFilePath.getText());
                        Grade[] grades = sheet1.readExcelData();
                        GradeDao gradeDao = new GradeDao();
                        int result = 0;
                        //将教师代码跟教师名称录入到成绩里面
                        for (int i = 0; i < grades.length; i++) {
                            grades[i].setCourName(tfCourName.getText());
                            grades[i].setCourNum(tfCourNum.getText());
                            grades[i].setTeacherName(teacher.getName());
                            grades[i].setTeacherNum(teacher.getNum());
                        }
                        //输出以下
                        System.out.println(Arrays.toString(grades));

                        //将每一个课程信息存到数据库
                        for (int i = 0; i < grades.length; i++) {
                            result += gradeDao.insGrade(grades[i]);
                        }
                        if (result == grades.length) {
                            JOptionPane.showMessageDialog(null, "成绩导入成功！!", "成功提示！", JOptionPane.PLAIN_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "成绩导入失败，请检查Excel格式是否正确！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (IOException ie) {
                        JOptionPane.showMessageDialog(null, "请选择正确的Excel文件！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                    } catch (MySQLIntegrityConstraintViolationException mqvde) {
                        JOptionPane.showMessageDialog(null, "课程代码或课程名称不存在！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex){
//                            ex.printStackTrace();
//                        System.out.println("课程代码或课程名称不存在");
                    JOptionPane.showMessageDialog(null, "课程代码或课程名称不存在！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                } catch(ClassNotFoundException ex){
//                    JOptionPane.showMessageDialog(null, "课程代码或课程名称不存在！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                       ex.printStackTrace();
                } catch(NullPointerException ne){
                    JOptionPane.showMessageDialog(null, "成绩导入失败，请检查Excel格式是否正确！", "错误提示！", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "课程名称不允许为空！", "错误提示！", JOptionPane.ERROR_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null, "课程代码不允许为空！", "错误提示！", JOptionPane.ERROR_MESSAGE);
        }
    });

        btnCancel.addActionListener(e -> {
            tfCourName.setText("");
            tfCourNum.setText("");
            tfFilePath.addFocusListener(new JTextFieldHintListener(tfFilePath, "选择成绩表文件"));
        });

        return panel;

}

    /**
     * 弹出文件选择框，选择Excel文件
     *
     * @return String 文件绝对路径
     * @Author Swy
     * @Date 1:14 2020-06-10
     * @Param null
     */
    private static String selExcelFile() {
        //JFileChooser 是文件选取器组件

        //新建一个文件选择器，默认的目录是构造器的参数,当前目录下创建过滤器
        JFileChooser fc = new JFileChooser(".");
        //excel过滤器
        ExcelFileFilter excelFilter = new ExcelFileFilter();
        //添加筛选规则，也就是只显示你要的文件的后缀
        fc.addChoosableFileFilter(excelFilter);
        fc.setFileFilter(excelFilter);
        //弹出一个文件选择框，参数本应该是  Component parent ，但为null代表空
        //JFileChooser.APPROVE_OPTION的意思是文件被选中的意思
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            //得到被选中的文件
            File f = fc.getSelectedFile();
            //获得改文件的绝对路径
            String filePath = f.getAbsolutePath();
            System.out.println(filePath);
            return filePath;
        }
        return null;
    }


}
