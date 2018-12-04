package cn.com.lypee.View;

import cn.com.lypee.Dao.StudentDao;
import cn.com.lypee.DataConnection.DataConnection;
import cn.com.lypee.Student.Student;
import cn.com.lypee.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class addV extends JFrame {
    DataConnection dataConnection  = new DataConnection();
    StudentDao studentDao  = new StudentDao();
    private static final long serialVersionUID = -1984182788841566838L;

    private JPanel jPanelCenter, jPanelSouth;
    private JButton addButton, exitButton;
    private JTextField number ,name ,tel ,department ;
    public addV()
    {
        init();
    }
    public void init()
    {
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(6,2));
        jPanelCenter.add(new JLabel("学号"));
        number = new JTextField();
        jPanelCenter.add(number);
        jPanelCenter.add(new JLabel("姓名"));
        name = new JTextField();
        jPanelCenter.add(name);
        jPanelCenter.add(new JLabel("电话"));
        tel = new JTextField();
        jPanelCenter.add(tel);
        jPanelCenter.add(new JLabel("专业"));
        department = new JTextField();
        jPanelCenter.add(department);
        jPanelCenter.add(new JLabel("*****************\n*************"));

        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1,2));
        addButton=  new JButton("添加");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try
                {
                    Student student = new Student() ;
                    student.setNumber(Integer.valueOf(number.getText()));
                    student.setName(name.getText());
                    //dao层
                    student.setTel(tel.getText());
                    student.setDepartment(department.getText());
                    System.out.println("\n"+ student.getNumber() + student.getName() + student.getTel() + student.getDepartment());
                    studentDao.insertDao(student);
                }catch (IOException ee)
                {
                    ee.printStackTrace();
                }
                setEmpty();//置空
            }
        });
        jPanelSouth.add(addButton);
        exitButton = new JButton("退出");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jPanelSouth.add(exitButton);
        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth,  BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 200, 400, 270);
        setResizable(false);
        setVisible(true);
    }
        public void setEmpty()
        {
            number.setText("");
            name.setText("");
            tel.setText("");
            department.setText("");
        }
}
