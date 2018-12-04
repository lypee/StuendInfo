package cn.com.lypee.View;

import cn.com.lypee.Dao.StudentDao;
import cn.com.lypee.DataConnection.DataConnection;
import cn.com.lypee.Student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.io.IOException;

//根据学号查找学生信息
public class searchV extends JFrame {
    DataConnection dataConnection  = new DataConnection();
    StudentDao studentDao  = new StudentDao();
    Student student = new Student();
    private JPanel jPanel ;
    private JTextField number ,name ,tel, department ;
    public searchV(Integer num)  throws IOException
    {
        init(num);
    }
    private void init(Integer num)  throws IOException
    {
        student = studentDao.findDao(num);
        jPanel = new JPanel() ;
        jPanel.setLayout(new GridLayout(5,2));
        jPanel.add(new JLabel("学号"));
        number = new JTextField();
        number.setText(String.valueOf(student.getNumber()));
        jPanel.add(number);

        jPanel.add(new JLabel("姓名"));
        name = new JTextField();
        name.setText(student.getName());
        jPanel.add(name);

        jPanel.add(new JLabel("电话"));
        tel = new JTextField();
        tel.setText(student.getTel());
        jPanel.add(tel);

        jPanel.add(new JLabel("专业"));
        department = new JTextField();
        department.setText(student.getDepartment());
        jPanel.add(department);

        this.add(jPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 250, 400, 130);
        setResizable(false);
        setVisible(true);
    }

}
