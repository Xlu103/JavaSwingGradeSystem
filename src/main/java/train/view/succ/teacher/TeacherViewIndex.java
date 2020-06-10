package train.view.succ.teacher;

import train.dao.teacher.TeacherDao;
import train.entity.Teacher;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * 教师后台主界面
 *
 * @ClassName: TeacherViewIndex
 * @Author: Swy
 * @Date: 2020-06-08 15:20
 **/
public class TeacherViewIndex extends Frame {
    private static final int DIALOG_WHITE = 1125;
    private static final int DIALOG_HEIGHT = 648;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    initIndex();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void initIndex() throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame();
        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(point.x - DIALOG_WHITE / 2, point.y - DIALOG_HEIGHT / 2, DIALOG_WHITE, DIALOG_HEIGHT);

        //禁止修改窗口大小
        frame.setResizable(false);

        //将右上角的关闭开启隐藏
        frame.setUndecorated(true);

        //显示
        frame.setVisible(true);
        //设置为边界布局
        frame.setLayout(new BorderLayout());

        //教师实例
        Teacher teacher = new TeacherDao().selectTeacher("771", "000000");

        //初始化窗体
        TeacherCreate.initFrame(frame,teacher);

    }
}
