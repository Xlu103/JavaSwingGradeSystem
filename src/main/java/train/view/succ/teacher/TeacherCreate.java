package train.view.succ.teacher;


import train.entity.Teacher;

import javax.swing.*;
import java.sql.SQLException;

/**
 * 用于创建多个布局
 *
 * @ClassName: TeacherCreatePanel
 * @Author: Swy
 * @Date: 2020-06-08 15:49
 **/
public class TeacherCreate {

    /**
     * panelTop 顶部
     * panelLeft 导航条
     * panelInfo 个人信息
     * panelUpdatePwd 修改密码
     * panelHome 主页
     * panelIns 录入信息
     * panelSel 查询成绩
     * panelInsCour 新增课程
     */
    protected static JPanel panelTop;
    protected static JPanel panelLeft;
    protected static JPanel panelInfo;
    protected static JPanel panelUpdatePwd;
    protected static JPanel panelHome;
    protected static JPanel panelIns;
    protected static JPanel panelSel;
    protected static JPanel panelInsCour;

    protected static JFrame frame;
    protected static Teacher teacher;

    protected static void initFrame(JFrame frame, Teacher teacher) throws SQLException, ClassNotFoundException {
        TeacherCreate.frame = frame;
        TeacherCreate.teacher = teacher;
        //创建左边导航条
        TeacherCreate.panelLeft = TeacherCreateLeft.createLeft(teacher);
        //创建顶部红色框
        TeacherCreate.panelTop = TeacherCreateTop.createTop();
        //创建个人信息组件
        TeacherCreate.panelInfo = TeacherCreateInfo.createInfo(teacher);
        //创建修改密码组件
        TeacherCreate.panelUpdatePwd = TeacherCreatePwd.createUpdatePwd(teacher);
        //创建录入成绩组件
        TeacherCreate.panelIns = TeacherCreateIns.createIns(teacher);
        //创建查询信息组件
        TeacherCreate.panelSel = TeacherCreateSel.createSel(teacher);
        //创建新增课程组件
        TeacherCreate.panelInsCour = TeacherCreateInsCour.createInsCour(teacher);

        TeacherCreate.frame.add(TeacherCreate.panelHome, "East");
        TeacherCreate.frame.add(TeacherCreate.panelTop, "North");
        TeacherCreate.frame.add(TeacherCreate.panelLeft, "West");
    }
}