/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Controller.DatabaseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Gibran<>
 */
public class MenuAwal implements ActionListener{
    
    JFrame frameHome;
    JFrame frameAdmin;
    JButton ButtonLogin, ButtonRegister, ButtonLihatData;


    public MenuAwal(){
        frameHome = new JFrame("MENU UTAMA");
        frameHome.pack();
        frameHome.setSize(1000, 700);
        frameHome.setLocationRelativeTo(null);
        frameHome.getContentPane().setBackground(new Color(31,253, 255));
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel title = new JLabel("WELCOME");
        title.setBounds(90, 50, 800, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        ButtonLogin = new JButton("Login");
        ButtonLogin.setBounds(190, 120, 250, 100);
        ButtonLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        ButtonLogin.addActionListener(this);

        ButtonRegister = new JButton("Register");
        ButtonRegister.setBounds(550, 120, 250, 100);
        ButtonRegister.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        ButtonRegister.addActionListener(this);
        
        ButtonLihatData = new JButton("Lihat Data User");
        ButtonLihatData.setBounds(190, 270, 250, 100);
        ButtonLihatData.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        ButtonLihatData.addActionListener(this);
        
        
        
        frameHome.add(title);
        frameHome.add(ButtonLogin);
        frameHome.add(ButtonRegister);
        frameHome.add(ButtonLihatData);
       
        frameHome.setLayout(null);
        frameHome.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ButtonLogin) {
            frameHome.dispose();
            new MenuLogin();
        } else if (ae.getSource() == ButtonRegister){
            new MenuRegister();
        } else if (ae.getSource() == ButtonLihatData){
            new MenuLihatData();
        }


    }
    
    
    public static void main(String[] args) {
        new MenuAwal();
    }

}
