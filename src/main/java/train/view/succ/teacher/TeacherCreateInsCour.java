package train.view.succ.teacher;

import train.entity.Teacher;

import javax.swing.*;
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

        return panel;
    }
}
