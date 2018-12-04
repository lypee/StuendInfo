package cn.com.lypee.View;

import cn.com.lypee.DataConnection.DataConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame{
    private static final long serialVersionUID = -5278598737087831336L;
    private JPanel jpanelCenter ,jpanelSouth ;
    private JTextField username ;
    private JPasswordField passwordField ;
    private JButton loginButton ,resetButton ;
    Login()
    {
        init();
    }
    private void init()
    {
        this.setTitle("Lypee");
        jpanelCenter = new JPanel();
        jpanelCenter.setLayout(new GridLayout(3,2));
        jpanelCenter.add(new JLabel("登陆"));
         username = new JTextField();
         jpanelCenter.add(username);
         jpanelCenter.add(new JLabel("密码"));
         passwordField = new JPasswordField();
         passwordField.addKeyListener(new LoginListener());
         jpanelCenter.add(passwordField);
         jpanelCenter.add(new JLabel("-----------"));
        jpanelCenter.add(new JLabel("------------"));



        jpanelSouth = new JPanel();
        jpanelSouth.setLayout(new GridLayout(1,2));
        loginButton= new JButton("登陆");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check();
            }
        });
        jpanelSouth.add(loginButton);

        resetButton = new JButton("重置");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                passwordField.setText("");
            }
        });
        jpanelSouth.add(resetButton);
        this.add(jpanelCenter, BorderLayout.CENTER);
        this.add(jpanelSouth, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(450, 250, 375, 140);
        this.setResizable(false);
        this.setVisible(true);
    }
    private class LoginListener extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                check();
            }
        }
    }
    private void check()
    {

        if(username.getText().equals("lypee") && String.valueOf(passwordField.getPassword()).equals("123456"))
        {
            dispose();
            new MainV();
        }
        else
        {
            username.setText("");
            passwordField.setText("");
        }
    }
}
