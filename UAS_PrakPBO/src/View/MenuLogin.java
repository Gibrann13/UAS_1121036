/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Gibran<>
 */
public class MenuLogin implements ActionListener{
    JFrame frameLogin;
    JPanel panelAwal, panelLogin, panelRegister;
    JTextField email, firstname, lastname, phonenumber;
    JPasswordField password;
    JLabel title, title2, labelNanya;
    JButton buttonLogin, buttonRegister, buttonSubmitLogin, buttonSubmitRegister,buttonBackHome;
    JLabel labelLogo;

    
    public MenuLogin() {

        frameLogin = new JFrame("APK BEBAS");
        frameLogin.pack();
        frameLogin.setSize(1000, 700);
        frameLogin.setLocationRelativeTo(null);
        frameLogin.getContentPane().setBackground(new Color(31,253, 255));
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAwal = new JPanel();
        panelAwal.setLayout(null);
        panelAwal.setBackground(new Color(210,233, 255));
        panelAwal.setBounds(500, 20, 500, 600);

        title = new JLabel("SELAMAT DATANG DI");
        title.setBounds(50, 180, 400, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        title2 = new JLabel("APK BEBAS");
        title2.setBounds(50, 210, 400, 50);
        title2.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title2.setHorizontalAlignment(SwingConstants.CENTER);

        labelLogo = new JLabel();
        ImageIcon qr = new ImageIcon(getClass().getResource("bca.png"));
        labelLogo.setIcon(qr);
        labelLogo.setBounds(100, 200, 300, 200);
        labelLogo.setHorizontalAlignment(SwingConstants.CENTER);


        panelAwal.add(title);
        panelAwal.add(title2);
        panelAwal.add(labelLogo);

        login();
        frameLogin.add(panelAwal);
        frameLogin.setLayout(null);
        frameLogin.setVisible(true);
        
    }
    
    public void login() {
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBackground(Color.white);
        panelLogin.setBounds(0, 20, 500, 600);
        
        JLabel titleLogin = new JLabel("LOGIN");
        titleLogin.setBounds(50, 50, 400, 50);
        titleLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        titleLogin.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(130, 145, 100, 30);
        labelEmail.setFont(new Font("Helvetica Neue", Font.ITALIC, 18));
        email = new JTextField();
        email.setBounds(130, 170, 250, 40);

        JLabel labelpass = new JLabel("Password");
        labelpass.setBounds(130, 215, 100, 30);
        labelpass.setFont(new Font("Helvetica Neue", Font.ITALIC, 18));
        password = new JPasswordField();
        password.setBounds(130, 240, 250, 40);

        buttonSubmitLogin = new JButton("LOG IN");
        buttonSubmitLogin.setBounds(130, 300, 250, 50);
        buttonSubmitLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        buttonSubmitLogin.addActionListener(this);
        
        buttonBackHome = new JButton("BACK");
        buttonBackHome.setBounds(130, 350, 250, 50);
        buttonBackHome.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        buttonBackHome.addActionListener(this);
        
        
        
        panelLogin.add(labelEmail);
        panelLogin.add(labelpass);
        panelLogin.add(email);
        panelLogin.add(password);
        panelLogin.add(titleLogin);
        panelLogin.add(buttonSubmitLogin);
        panelLogin.add(buttonBackHome);
        
        frameLogin.add(panelLogin);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonSubmitLogin) {
            Controller ctrl = new Controller();
            if (ctrl.checkLogin(email.getText(), password.getText()).equals("ada")) {
                frameLogin.dispose();
                new MenuLihatData();
            }else{
                JOptionPane.showMessageDialog (null, "Email dan Password yang dimasukkan salah/belum berdaftar!", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    
    
        if (ae.getSource() == buttonBackHome) {
            frameLogin.dispose();
            new MenuAwal();
        }
        
        
        
    }
    

    public static void main(String[] args) {
        new MenuLogin();
    }
}
