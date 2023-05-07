package View;

import Controller.QLHSController;
import Model.QLHSModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Login extends JFrame{
    public QLHSModel model;
    public JPanel contentPane;
    public JTextField textField_Name;
    public JPasswordField textField_Pass;
    public JButton button_Signin;
    public JButton button_Cancel;
    public Login() {
        this.model = new QLHSModel();
        this.init();
    }

    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(461, 295);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_LoginAcc = new JLabel("Login to your account");
        label_LoginAcc.setForeground(new Color(19, 86, 187));
        label_LoginAcc.setFont(new Font("Tahoma", Font.PLAIN, 23));
        label_LoginAcc.setBounds(202, 11, 225, 48);
        contentPane.add(label_LoginAcc);

        JLabel label_Name = new JLabel("Username");
        label_Name.setForeground(new Color(71, 137, 237));
        label_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_Name.setBounds(202, 67, 114, 26);
        contentPane.add(label_Name);

        textField_Name = new JTextField();
        textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Name.setBounds(202, 92, 225, 29);
        contentPane.add(textField_Name);
        textField_Name.setColumns(10);

        JLabel label_Pass = new JLabel("Password");
        label_Pass.setForeground(new Color(71, 137, 237));
        label_Pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_Pass.setBounds(202, 132, 114, 26);
        contentPane.add(label_Pass);

        textField_Pass = new JPasswordField();
        textField_Pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_Pass.setColumns(10);
        textField_Pass.setBounds(202, 157, 225, 29);
        contentPane.add(textField_Pass);

        button_Signin = new JButton("Sign in");
        button_Signin.setForeground(new Color(255, 255, 255));
        button_Signin.setBackground(new Color(19, 86, 187));
        button_Signin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        button_Signin.setBounds(202, 206, 102, 29);
        button_Signin.setFocusPainted(false);
        button_Signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textField_Name.getText();
                String pass = new String(textField_Pass.getPassword());
                if (user.equals("")){
                    JOptionPane.showMessageDialog(button_Signin,"Username cannot be empty!","Error",JOptionPane.ERROR_MESSAGE);
                } else  if (pass.equals("")){
                    JOptionPane.showMessageDialog(button_Signin,"Password cannot be empty!","Error",JOptionPane.ERROR_MESSAGE);
                } else if (user.equals("sa")&& pass.equals("123")){
                    QLHSView qlhsView = new QLHSView();
                    qlhsView.moChuongTrinh();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(button_Signin,"Wrong username or password!","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        contentPane.add(button_Signin);

        button_Cancel = new JButton("Cancel");
        button_Cancel.setForeground(Color.WHITE);
        button_Cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        button_Cancel.setBackground(new Color(19, 86, 187));
        button_Cancel.setBounds(325, 206, 102, 29);
        button_Cancel.setFocusPainted(false);
        button_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TrangChu trangChu = new TrangChu();
            }
        });
        contentPane.add(button_Cancel);

        JLabel logo = new JLabel(new ImageIcon(getClass().getResource("blue-user-icon.png")));
        logo.setBounds(31, 54, 133, 145);
        contentPane.add(logo);

        setVisible(true);
    }
}

