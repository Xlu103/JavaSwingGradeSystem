package train.view.index;
import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: IndexView
 * @Author: Swy
 * @Date: 2020-06-08 15:40
 **/
public class IndexView {
    private static final int DIALOG_WHITE=1100;
    private static final int DIALOG_HEIGHT=800;
    public static void main(String[] args) {
        SwingUtilities. invokeLater(()-> initIndex());
    }

    public static void initIndex(){
        JFrame frame = new JFrame();
        Point point = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

        frame.setBounds(point.x - DIALOG_WHITE / 2, point.y - DIALOG_HEIGHT / 2, DIALOG_WHITE, DIALOG_HEIGHT);

        //禁止修改窗口大小
        frame.setResizable(false);

        //将右上角的关闭开启隐藏
        frame.setUndecorated(false);

        frame.setVisible(true);

        frame.setLayout(new BorderLayout());

    }
}
