/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Gibran<>
 */
public class MenuRegister implements ActionListener{
    JFrame frameRegister;
    JPanel panelAwal, panelLogin, panelRegister;
    JTextField InputEmail,InputPassword;
    JPasswordField password;
    JLabel title, title2,labelJK;
    JButton backToHome, ButtonSubmitRegister;
   JRadioButton jk1, jk2;
   ButtonGroup jk;
   JComboBox pilihKategory;
    public MenuRegister() {

        frameRegister = new JFrame("APK BEBAS");
        frameRegister.pack();
        frameRegister.setSize(1000, 700);
        frameRegister.setLocationRelativeTo(null);
        frameRegister.getContentPane().setBackground(new Color(31,253, 255));
        frameRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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




        panelAwal.add(title);
        panelAwal.add(title2);

        Register();
        frameRegister.add(panelAwal);
        frameRegister.setLayout(null);
        frameRegister.setVisible(true);
        
    }
    
    public void Register() {
        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBackground(Color.white);
        panelLogin.setBounds(0, 20, 500, 600);
        
        JLabel labelEmail = new JLabel("Email :");
        labelEmail.setBounds(50, 120, 200, 30);
        labelEmail.setFont(new Font("Helvetica Neue", Font.ITALIC, 18));
        InputEmail = new JTextField("");
        InputEmail.setBounds(50, 150, 200, 30);
        
        JLabel labelPassword = new JLabel("Password :");
        labelPassword.setBounds(50, 190, 200, 30);
        labelPassword.setFont(new Font("Helvetica Neue", Font.ITALIC, 18));
        InputPassword = new JTextField("");
        InputPassword.setBounds(50, 210, 200, 30);
        
        
        labelJK = new JLabel("Jenis Kelamin:");
        labelJK.setBounds(50, 240, 200, 30);
        jk1 = new JRadioButton("Male");
        jk2 = new JRadioButton("Female");
        jk1.setBounds(50, 270, 80, 30);
        jk2.setBounds(100, 270, 80, 30);
        jk = new ButtonGroup();
        jk.add(jk1);jk.add(jk2);
        
        JLabel labelKategori = new JLabel("Kategori");
        labelKategori.setBounds(50, 300, 200, 30);
        labelKategori.setFont(new Font("Helvetica Neue", Font.ITALIC, 18));
//        String IsiVoucher[]={"Voucher1","Voucher2","Voucher3","Voucher2","Voucher1"};
        pilihKategory = new JComboBox();
        pilihKategory.removeAllItems();
        ambilDataCatagory();
        pilihKategory.setBounds(50, 330, 200, 30);
        pilihKategory.addActionListener(this);
        
        backToHome = new JButton("BACK");
        backToHome.setBounds(80, 450, 150, 50);
        backToHome.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        backToHome.addActionListener(this);

        ButtonSubmitRegister = new JButton("Submit");
        ButtonSubmitRegister.setBounds(260, 450, 150, 50);
        ButtonSubmitRegister.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        ButtonSubmitRegister.addActionListener(this);
        
        panelLogin.add(labelKategori);
        panelLogin.add(pilihKategory);

        
        panelLogin.add(labelEmail);
        panelLogin.add(InputEmail);
        panelLogin.add(labelPassword);
        panelLogin.add(InputPassword);
        
        panelLogin.add(labelJK);
        panelLogin.add(jk1);
        panelLogin.add(jk2);
        
        panelLogin.add(ButtonSubmitRegister);
        panelLogin.add(backToHome);
        
        frameRegister.add(panelLogin);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backToHome) {
            frameRegister.dispose();
            new MenuAwal();
        }
    }
    
    
    public static void main(String[] args) {
        new MenuRegister();
    }
    
        static DatabaseHandler conn = new DatabaseHandler();

    public void ambilDataCatagory() {
        
        conn.connect();
        String query = "select categoryName from categoryUser";
        java.sql.ResultSet rs;
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                pilihKategory.addItem(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
