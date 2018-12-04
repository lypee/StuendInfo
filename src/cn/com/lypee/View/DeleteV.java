package cn.com.lypee.View;

import cn.com.lypee.Dao.StudentDao;
import cn.com.lypee.DataConnection.DataConnection;
import cn.com.lypee.Student.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteV  extends JFrame {
    DataConnection dataConnection  = new DataConnection();
    StudentDao studentDao  = new StudentDao();
    private JPanel jPanelCenter, jPanelSouth;
    private JButton deleteButton;
    private JTextField number; //学号删除学生
    public DeleteV()
    {
        init();
    }

    private void init() {
        setTitle("删除");
        jPanelCenter = new JPanel();
        jPanelCenter.setLayout(new GridLayout(3, 2));
        jPanelCenter.add(new JLabel("学号"));
        number = new JTextField();
        jPanelCenter.add(number);
        jPanelCenter.add(new JLabel("-------------------------------------------------"));
        jPanelCenter.add(new JLabel("-------------------------------------------------"));

        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 2));
        deleteButton = new JButton("删除");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    //dao层
                    System.out.println("\n"+Integer.valueOf(number.getText())+ "\n");
                    studentDao.deleteDao(Integer.valueOf(number.getText()));
                }catch (IOException ee)
                {
                    ee.printStackTrace();
                }
                number.setText("");//置空
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
