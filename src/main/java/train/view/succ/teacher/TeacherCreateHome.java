package train.view.succ.teacher;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: TeacherCreateHome
 * @Author: Swy
 * @Date: 2020-06-09 17:01
 **/
public class TeacherCreateHome {
    /**
     * 创建主页面板
     *
     * @Author Swy
     * @Date 16:35 2020-06-09
     * @Param null
     * @return JPanel主页面板
     */
    public static JPanel createHome() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(925, 600));
        panel.setBackground(new Color(250, 250, 250));

        JLabel lTitle= new JLabel("主页");
        lTitle.setBounds(0, 0, 100, 300);
        panel.add(lTitle);
        return panel;
    }
}
