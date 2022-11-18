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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Gibran<>
 */
public class MenuLihatData implements ActionListener{
    
    JFrame frameLihatData;
    JPanel panelAwal,panelData;
    JLabel title, title2,labelJK;
    JButton buttonSubmitData, buttonBackHome;
   
    public MenuLihatData() {

        frameLihatData = new JFrame("APK BEBAS");
        frameLihatData.pack();
        frameLihatData.setSize(1000, 700);
        frameLihatData.setLocationRelativeTo(null);
        frameLihatData.getContentPane().setBackground(new Color(31,253, 255));
        frameLihatData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelAwal = new JPanel();
        panelAwal.setLayout(null);
        panelAwal.setBackground(new Color(210,233, 255));
        panelAwal.setBounds(500, 20, 500, 600);

        title = new JLabel("MENU LIHAT DATA");
        title.setBounds(50, 180, 400, 50);
        title.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        title2 = new JLabel("APK BEBAS");
        title2.setBounds(50, 210, 400, 50);
        title2.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        title2.setHorizontalAlignment(SwingConstants.CENTER);




        panelAwal.add(title);
        panelAwal.add(title2);

        login();
        frameLihatData.add(panelAwal);
        frameLihatData.setLayout(null);
        frameLihatData.setVisible(true);
        
    }
    
    public void login() {
        panelData = new JPanel();
        panelData.setLayout(null);
        panelData.setBackground(Color.white);
        panelData.setBounds(0, 20, 500, 600);
        
        JLabel titleLogin = new JLabel("LIHAT DATA");
        titleLogin.setBounds(50, 50, 400, 50);
        titleLogin.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        titleLogin.setHorizontalAlignment(SwingConstants.CENTER);
        
    

        buttonSubmitData = new JButton("SUBMIT");
        buttonSubmitData.setBounds(130, 300, 250, 50);
        buttonSubmitData.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        buttonSubmitData.addActionListener(this);
        
        buttonBackHome = new JButton("BACK");
        buttonBackHome.setBounds(130, 350, 250, 50);
        buttonBackHome.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        buttonBackHome.addActionListener(this);
                
        panelData.add(titleLogin);
        panelData.add(buttonSubmitData);
        panelData.add(buttonBackHome);
        
        frameLihatData.add(panelData);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == buttonSubmitData) {
            
        }
    
    
        if (ae.getSource() == buttonBackHome) {
            frameLihatData.dispose();
            new MenuAwal();
        }
    }

    public static void main(String[] args) {
        new MenuLihatData();
    }
}
