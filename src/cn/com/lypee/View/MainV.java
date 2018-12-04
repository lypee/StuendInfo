package cn.com.lypee.View;



import org.apache.ibatis.annotations.Param;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainV  extends JFrame {
    private JPanel jPanelNorth;
    private JButton  jButtonAdd, jButtonDelete, jButtonUpdate, jButtonQuery;

    private JTextField condition;

    //private static String[] column = {"number" ,"name","tel","department"};

    public MainV()
    {
        init();
    }
    public void init()
    {
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        this.setSize(800,600);
        // north panel
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 5));
        condition = new JTextField("");//查找的id
        condition.addKeyListener(new FindListener());
        jPanelNorth.add(condition);
        // query by name
        jButtonQuery = new JButton("查找");
        jButtonQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try
                {
                    new searchV(Integer.valueOf(condition.getText()));
                }catch (IOException eee)
                {
                    eee.printStackTrace();
                }
            }
        });
        jButtonQuery.addKeyListener(new FindListener());
        // add
        jPanelNorth.add(jButtonQuery);
        jButtonAdd = new JButton("添加");
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addV();
            }
        });
        jPanelNorth.add(jButtonAdd);
        // delete
        jButtonDelete = new JButton("删除");
        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteV();
            }
        });
        jPanelNorth.add(jButtonDelete);
        // update
        jButtonUpdate = new JButton("更新");
        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new updateV();
            }
        });
        jPanelNorth.add(jButtonUpdate);
        this.add(jPanelNorth, BorderLayout.NORTH);


        setBounds(400, 200, 750, 150);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private class FindListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            }
        }
    }

}
