package View;

import Model.QLHSModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrangChu extends JFrame{
    private QLHSModel model;
    public JPanel contentPane;

    public TrangChu(){
        this.model = new QLHSModel();
        this.init();
    }
    public void init(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(830, 477);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_Button = new JPanel();
        panel_Button.setBackground(new Color(19, 86, 187));
        panel_Button.setBounds(0, 0, 159, 438);
        panel_Button.setLayout(null);
        contentPane.add(panel_Button);

        JLabel logo_Home = new JLabel(new ImageIcon(getClass().getResource("Home-blue.png")));
        logo_Home.setBounds(10, 106, 139, 138);
        panel_Button.add(logo_Home);

        JLabel label_TranhChu = new JLabel("Trang chủ");
        label_TranhChu.setForeground(new Color(255, 255, 255));
        label_TranhChu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        label_TranhChu.setBounds(33, 244, 96, 35);
        panel_Button.add(label_TranhChu);

        JButton btnDangNhap = new JButton("Đăng nhập");
        btnDangNhap.setBounds(0, 396, 159, 42);
        btnDangNhap.setForeground(Color.WHITE);
        btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDangNhap.setBorderPainted(false);
        btnDangNhap.setFocusPainted(false);
        btnDangNhap.setBackground(new Color(11, 102, 193));
        btnDangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                setVisible(false);
            }
        });
        panel_Button.add(btnDangNhap);

        JPanel panel_TrangChu = new JPanel();
        panel_TrangChu.setLayout(null);
        panel_TrangChu.setBackground(new Color(255, 255, 255));
        panel_TrangChu.setBounds(168, 0, 636, 438);
        contentPane.add(panel_TrangChu);

        JLabel label_TieuDe = new JLabel("HỆ THỐNG QUẢN LÝ");
        label_TieuDe.setFont(new Font("Tahoma", Font.PLAIN, 55));
        label_TieuDe.setBounds(81, 142, 505, 67);
        panel_TrangChu.add(label_TieuDe);
        label_TieuDe.setForeground(new Color(19, 86, 187));

        JLabel label_TuyenSinh = new JLabel("ĐIỂM TUYỂN SINH LỚP 10 THPT");
        label_TuyenSinh.setForeground(new Color(71, 137, 238));
        label_TuyenSinh.setFont(new Font("Tahoma", Font.PLAIN, 40));
        label_TuyenSinh.setBounds(34, 234, 592, 67);
        panel_TrangChu.add(label_TuyenSinh);

        JLabel label_NamHoc = new JLabel("Năm học: 2022 - 2023");
        label_NamHoc.setForeground(new Color(19, 86, 187));
        label_NamHoc.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label_NamHoc.setBounds(323, 337, 268, 49);
        panel_TrangChu.add(label_NamHoc);

        JLabel label_SoGD = new JLabel("SỞ GIÁO DỤC VÀ ĐÀO TẠO TT HUẾ");
        label_SoGD.setFont(new Font("Tahoma", Font.PLAIN, 30));
        label_SoGD.setForeground(new Color(0, 0, 128));
        label_SoGD.setBounds(127, 42, 546, 49);
        panel_TrangChu.add(label_SoGD);

        JLabel logo_SoGDDT = new JLabel(new ImageIcon(getClass().getResource("SoGDDT.png")));
        logo_SoGDDT.setFont(new Font("Tahoma", Font.PLAIN, 8));
        logo_SoGDDT.setBounds(0, 11, 117, 117);
        panel_TrangChu.add(logo_SoGDDT);

        JSeparator separator_So = new JSeparator();
        separator_So.setBounds(174, 89, 395, 2);
        panel_TrangChu.add(separator_So);

        this.setVisible(true);
    }
}
