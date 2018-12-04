package cn.com.lypee.View;

import cn.com.lypee.Dao.StudentDao;
import cn.com.lypee.DataConnection.DataConnection;
import cn.com.lypee.Student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//根据学号修改姓名
public class updateV extends JFrame {
    DataConnection dataConnection  = new DataConnection();
    StudentDao studentDao  = new StudentDao();
    private JPanel jPanelCenter, jPanelSouth;
    private JButton deleteButton, exitButton;
    private JTextField number,name; //学号删除学生
    public updateV()
    {
        init();
    }
    private void init() {
        setTitle("更新:根据学号修改姓名");
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(3, 2));
        jPanelCenter.add(new JLabel("学号"));
        number = new JTextField();
        jPanelCenter.add(number);
        jPanelCenter.add(new JLabel("姓名"));
        name = new JTextField();
        jPanelCenter.add(name);
        jPanelCenter.add(new JLabel("-------------------------------------------------"));
        jPanelCenter.add(new JLabel("-------------------------------------------------"));

        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        deleteButton = new JButton("修改");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Student student = new Student() ;
                    student.setName(name.getText());
                    student.setNumber(Integer.valueOf(number.getText()));
                    //dao层
                    System.out.println("\n"+student.getNumber() + " " + student.getName()+ "\n");
                    studentDao.updateDao(student);
                }catch (IOException ee)
                {
                    ee.printStackTrace();
                }
                number.setText("");//置空
                name.setText("");
            }
        });
        this.add(jPanelCenter, BorderLayout.CENTER);
        this.add(jPanelSouth, BorderLayout.SOUTH);
        jPanelSouth.add(deleteButton);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(470, 250, 400, 130);
        setResizable(false);
        setVisible(true);
    }
}
