package View;

import Controller.QLHSController;
import Model.HocSinh;
import Model.QLHSModel;
import Model.Tinh;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.String.format;

public class QLHSView extends JFrame {
    public JPanel contentPane;
    public QLHSModel model;
    public JTextField textField_Truong_TimKiem;
    public JTable table;
    public JTextField textField_ID;
    public JTextField textField_HoVaTen;
    public JComboBox comboBox_queQuan;
    public JTextField textField_NgaySinh;
    public JTextField textField_HoTen_TimKiem;
    public JTextField textField_Anh;
    public JRadioButton radioButton_nu;
    private JTextField textField_Toan;
    public JRadioButton radioButton_nam;
    public ButtonGroup btn_gioiTinh;
    public JTextField textField_Van;
    public JTextField textField_Truong;
    public JScrollPane scrollPane;
    public JTable table_1;
    public JScrollPane scrollPane_1;
    public JTable table_SoLieu;
    public JScrollPane scrollPane_SoLieu;
    public JPanel panel_ThongTinHS;
    public JPanel panel_BieuDo;
    public JLabel lable_DanhSach;
    public JButton btnDangXuat;
    public ChartPanel chartPanel_Van;
    public ChartPanel chartPanel_Toan;
    public ChartPanel chartPanel_Anh;
    public ChartPanel chartPanel_Tong;
    public JPanel panel_TimKiem;
    public JPanel panel_SapXep;
    public JPanel panel_ThongKe;
    public JLabel logo_DN;
    public JLabel label_TenTK;
    public final String userName = "sa";
    public final String passWord = "123";
    String connUrl = "jdbc:sqlserver://DESKTOP-PKMCANL\\SQLEXPRESS:1433;" + "user="+userName+";password="+passWord+";databaseName=TuyenSinhLop10;encrypt=false";

    public QLHSView() {
        this.model = new QLHSModel();
        this.init();
    }

    public void init() {
        this.setTitle("Danh Sách Tuyển Sinh Lớp 10");
        this.setSize(1057, 714);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ActionListener action = new QLHSController(this);

        // MENU---------------------------------------------------------------------------------------------------------

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuFile = new JMenu("File");
        menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        menuBar.add(menuFile);

        JMenuItem menuOpen = new JMenuItem("Open");
        menuOpen.addActionListener(action);
        menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuFile.add(menuOpen);

        JMenuItem menuSave = new JMenuItem("Save");
        menuSave.addActionListener(action);
        menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuFile.add(menuSave);

        JSeparator separator = new JSeparator();
        menuFile.add(separator);

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(action);
        menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        menuFile.add(menuExit);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // BẢNG---------------------------------------------------------------------------------------------------------

        lable_DanhSach = new JLabel("DANH SÁCH TUYỂN SINH LỚP 10");
        lable_DanhSach.setFont(new Font("Tahoma", Font.BOLD, 19));
        lable_DanhSach.setForeground(new Color(19, 86, 187));
        lable_DanhSach.setBounds(435, 0, 320, 42);
        contentPane.add(lable_DanhSach);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"SBD", "Họ Và Tên", "Giới Tính", "Quê quán", "Ngày Sinh",
                        "Trường", "Văn", "Toán", "Anh", "Tổng"}));

        table.setRowHeight(25);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(169, 38, 862, 244);
        contentPane.add(scrollPane);

        JPanel panel_Button = new JPanel();
        panel_Button.setBackground(new Color(19, 86, 187));
        panel_Button.setBounds(0, 0, 159, 642);
        panel_Button.setLayout(null);
        contentPane.add(panel_Button);

        // TÀI KHOẢN----------------------------------------------------------------------------------------------------

        btnDangXuat = new JButton("Đăng xuất");
        btnDangXuat.addActionListener(action);
        btnDangXuat.setBounds(0, 600, 159, 42);
        btnDangXuat.setForeground(Color.WHITE);
        btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setFocusPainted(false);
        btnDangXuat.setBackground(new Color(11, 102, 193));
        panel_Button.add(btnDangXuat);

        logo_DN = new JLabel(new ImageIcon(getClass().getResource("User-Admin.png")));
        logo_DN.setBounds(55, 11, 48, 48);
        panel_Button.add(logo_DN);

        label_TenTK = new JLabel("Văn Viết Tâm");
        label_TenTK.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_TenTK.setForeground(new Color(255, 255, 255));
        label_TenTK.setBounds(34, 65, 96, 25);
        panel_Button.add(label_TenTK);

        JSeparator separator_Ten = new JSeparator();
        separator_Ten.setBounds(10, 101, 139, 2);
        panel_Button.add(separator_Ten);

        // TÌM KIẾM-----------------------------------------------------------------------------------------------------

        JButton btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.addActionListener(action);
        btnTimKiem.setBorderPainted(false);
        btnTimKiem.setFocusPainted(false);
        btnTimKiem.setBounds(0, 244, 159, 42);
        btnTimKiem.setForeground(new Color(255, 255, 255));
        btnTimKiem.setBackground(new Color(19, 86, 187));
        btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Button.add(btnTimKiem);

        panel_TimKiem = new JPanel();
        panel_TimKiem.setLayout(null);
        panel_TimKiem.setBackground(new Color(255, 255, 255));
        panel_TimKiem.setBounds(254, 293, 620, 338);
        contentPane.add(panel_TimKiem);

        JLabel logo_TimKiem = new JLabel(new ImageIcon(getClass().getResource("Search-icon.png")));
        logo_TimKiem.setBounds(182, 11, 89, 78);
        panel_TimKiem.add(logo_TimKiem);

        JLabel label_TimKiem = new JLabel("Tìm kiếm");
        label_TimKiem.setForeground(Color.RED);
        label_TimKiem.setHorizontalAlignment(SwingConstants.LEFT);
        label_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 22));
        label_TimKiem.setBounds(271, 34, 114, 23);
        panel_TimKiem.add(label_TimKiem);

        JLabel label_Truong_TimKiem = new JLabel("Trường");
        label_Truong_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_Truong_TimKiem.setBounds(173, 100, 73, 35);
        panel_TimKiem.add(label_Truong_TimKiem);

        textField_Truong_TimKiem = new JTextField();
        textField_Truong_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_Truong_TimKiem.setColumns(10);
        textField_Truong_TimKiem.setBounds(271, 103, 193, 29);
        panel_TimKiem.add(textField_Truong_TimKiem);

        JLabel label_HoTen_TimKiem = new JLabel("Họ và tên");
        label_HoTen_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_HoTen_TimKiem.setBounds(173, 163, 89, 35);
        panel_TimKiem.add(label_HoTen_TimKiem);

        textField_HoTen_TimKiem = new JTextField();
        textField_HoTen_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_HoTen_TimKiem.setColumns(10);
        textField_HoTen_TimKiem.setBounds(271, 166, 192, 29);
        panel_TimKiem.add(textField_HoTen_TimKiem);

        JButton btnTim = new JButton("Tìm");
        btnTim.addActionListener(action);
        btnTim.setForeground(new Color(255, 255, 255));
        btnTim.setBackground(new Color(19, 86, 187));
        btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTim.setFocusPainted(false);
        btnTim.setBounds(173, 257, 117, 35);
        panel_TimKiem.add(btnTim);

        JButton btnHuyTim = new JButton("Hủy tìm");
        btnHuyTim.addActionListener(action);
        btnHuyTim.setForeground(new Color(255, 255, 255));
        btnHuyTim.setBackground(new Color(19, 86, 187));
        btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnHuyTim.setFocusPainted(false);
        btnHuyTim.setBounds(347, 256, 117, 36);
        panel_TimKiem.add(btnHuyTim);

        panel_TimKiem.setVisible(false);

        // THÔNG TIN HỌC SINH-------------------------------------------------------------------------------------------

        JButton btnChinhSua = new JButton("Chỉnh sửa");
        btnChinhSua.addActionListener(action);
        btnChinhSua.setBounds(0, 190, 159, 43);
        btnChinhSua.setBorderPainted(false);
        btnChinhSua.setFocusPainted(false);
        btnChinhSua.setForeground(new Color(255, 255, 255));
        btnChinhSua.setBackground(new Color(19, 86, 187));
        btnChinhSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Button.add(btnChinhSua);

        panel_ThongTinHS = new JPanel();
        panel_ThongTinHS.setBackground(new Color(255, 255, 255));
        panel_ThongTinHS.setBounds(169, 293, 879, 349);
        panel_ThongTinHS.setLayout(null);
        contentPane.add(panel_ThongTinHS);

        JLabel label_ThongTinHocSinh = new JLabel("Thông tin học sinh");
        label_ThongTinHocSinh.setFont(new Font("Tahoma", Font.BOLD, 22));
        label_ThongTinHocSinh.setBounds(219, 32, 238, 35);
        label_ThongTinHocSinh.setForeground(Color.RED);
        panel_ThongTinHS.add(label_ThongTinHocSinh);

        JLabel lable_SBD = new JLabel("SBD");
        lable_SBD.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lable_SBD.setBounds(125, 75, 42, 35);
        panel_ThongTinHS.add(lable_SBD);

        textField_ID = new JTextField();
        textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_ID.setColumns(10);
        textField_ID.setBounds(219, 78, 95, 29);
        panel_ThongTinHS.add(textField_ID);

        JLabel label_HoVaTen = new JLabel("Họ và tên");
        label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_HoVaTen.setBounds(125, 118, 102, 35);
        panel_ThongTinHS.add(label_HoVaTen);

        textField_HoVaTen = new JTextField();
        textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_HoVaTen.setColumns(10);
        textField_HoVaTen.setBounds(219, 121, 197, 29);
        panel_ThongTinHS.add(textField_HoVaTen);

        JLabel label_GioiTinh = new JLabel("Giới tính");
        label_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_GioiTinh.setBounds(125, 158, 102, 29);
        panel_ThongTinHS.add(label_GioiTinh);

        radioButton_nam = new JRadioButton("Nam");
        radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
        radioButton_nam.setBackground(new Color(255, 255, 255));
        radioButton_nam.setBounds(219, 160, 61, 23);
        panel_ThongTinHS.add(radioButton_nam);

        radioButton_nu = new JRadioButton("Nữ");
        radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        radioButton_nu.setBackground(new Color(255, 255, 255));
        radioButton_nu.setBounds(355, 160, 61, 23);
        panel_ThongTinHS.add(radioButton_nu);

        JLabel label_NgaySinh = new JLabel("Ngày sinh");
        label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_NgaySinh.setBounds(125, 190, 109, 35);
        panel_ThongTinHS.add(label_NgaySinh);

        textField_NgaySinh = new JTextField();
        textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_NgaySinh.setColumns(10);
        textField_NgaySinh.setBounds(219, 193, 197, 29);
        panel_ThongTinHS.add(textField_NgaySinh);

        JLabel label_QueQuan = new JLabel("Quê quán");
        label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_QueQuan.setBounds(125, 279, 102, 35);
        panel_ThongTinHS.add(label_QueQuan);

        comboBox_queQuan = new JComboBox();
        ArrayList<Tinh> listTinh = Tinh.getDSTinh();
        comboBox_queQuan.addItem("");
        for (Tinh tinh : listTinh) {
            comboBox_queQuan.addItem(tinh.getTenTinh());
        }
        comboBox_queQuan.setBounds(219, 282, 197, 29);
        panel_ThongTinHS.add(comboBox_queQuan);

        JLabel label_Truong = new JLabel("Trường");
        label_Truong.setFont(new Font("Tahoma", Font.PLAIN, 19));
        label_Truong.setBounds(125, 236, 109, 35);
        panel_ThongTinHS.add(label_Truong);

        textField_Truong = new JTextField();
        textField_Truong.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_Truong.setColumns(10);
        textField_Truong.setBounds(219, 239, 197, 29);
        panel_ThongTinHS.add(textField_Truong);

        btn_gioiTinh = new ButtonGroup();
        btn_gioiTinh.add(radioButton_nam);
        btn_gioiTinh.add(radioButton_nu);

        JLabel lable_Van = new JLabel("Văn");
        lable_Van.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lable_Van.setBounds(467, 196, 52, 23);
        panel_ThongTinHS.add(lable_Van);

        textField_Van = new JTextField();
        textField_Van.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_Van.setColumns(10);
        textField_Van.setBounds(529, 193, 116, 29);
        panel_ThongTinHS.add(textField_Van);

        JLabel lable_Toan = new JLabel("Toán");
        lable_Toan.setHorizontalAlignment(SwingConstants.CENTER);
        lable_Toan.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lable_Toan.setBounds(458, 242, 52, 23);
        panel_ThongTinHS.add(lable_Toan);

        textField_Toan = new JTextField();
        textField_Toan.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_Toan.setColumns(10);
        textField_Toan.setBounds(529, 239, 116, 29);
        panel_ThongTinHS.add(textField_Toan);

        JLabel lable_Anh = new JLabel("Anh");
        lable_Anh.setHorizontalAlignment(SwingConstants.LEFT);
        lable_Anh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lable_Anh.setBounds(467, 285, 52, 23);
        panel_ThongTinHS.add(lable_Anh);

        textField_Anh = new JTextField();
        textField_Anh.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField_Anh.setColumns(10);
        textField_Anh.setBounds(529, 282, 116, 29);
        panel_ThongTinHS.add(textField_Anh);

        JLabel logo_ThongTinHS = new JLabel(new ImageIcon(getClass().getResource("Text-Edit-icon.png")));
        logo_ThongTinHS.setBounds(529, 32, 116, 146);
        panel_ThongTinHS.add(logo_ThongTinHS);

        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(action);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setForeground(new Color(255, 255, 255));
        btnThem.setBackground(new Color(19, 86, 187));
        btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnThem.setBounds(762, 82, 117, 48);
        panel_ThongTinHS.add(btnThem);

        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(action);
        btnXoa.setBorderPainted(false);
        btnXoa.setFocusPainted(false);
        btnXoa.setForeground(new Color(255, 255, 255));
        btnXoa.setBackground(new Color(19, 86, 187));
        btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnXoa.setBounds(762, 201, 117, 48);
        panel_ThongTinHS.add(btnXoa);

        JButton btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.addActionListener(action);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setForeground(new Color(255, 255, 255));
        btnCapNhat.setBackground(new Color(19, 86, 187));
        btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCapNhat.setBounds(762, 158, 117, 48);
        panel_ThongTinHS.add(btnCapNhat);

        JButton btnLuu = new JButton("Lưu");
        btnLuu.addActionListener(action);
        btnLuu.setBorderPainted(false);
        btnLuu.setFocusPainted(false);
        btnLuu.setForeground(new Color(255, 255, 255));
        btnLuu.setBackground(new Color(19, 86, 187));
        btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnLuu.setBounds(762, 122, 117, 48);
        panel_ThongTinHS.add(btnLuu);

        // SẮP XẾP------------------------------------------------------------------------------------------------------

        JButton btnSapXep = new JButton("Sắp xếp");
        btnSapXep.addActionListener(action);
        btnSapXep.setBounds(0, 297, 159, 42);
        btnSapXep.setBorderPainted(false);
        btnSapXep.setFocusPainted(false);
        btnSapXep.setForeground(new Color(255, 255, 255));
        btnSapXep.setBackground(new Color(19, 86, 187));
        btnSapXep.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Button.add(btnSapXep);

        panel_SapXep = new JPanel();
        panel_SapXep.setLayout(null);
        panel_SapXep.setBackground(new Color(255, 255, 255));
        panel_SapXep.setBounds(169, 293, 862, 349);
        contentPane.add(panel_SapXep);

        JLabel label_SapXep = new JLabel("Sắp xếp theo");
        label_SapXep.setForeground(Color.RED);
        label_SapXep.setFont(new Font("Tahoma", Font.BOLD, 22));
        label_SapXep.setBounds(197, 45, 152, 35);
        panel_SapXep.add(label_SapXep);

        JButton btnVan_SX = new JButton("Văn");
        btnVan_SX.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnVan_SX.addActionListener(action);
        btnVan_SX.setFocusPainted(false);
        btnVan_SX.setForeground(new Color(255, 255, 255));
        btnVan_SX.setBackground(new Color(19, 86, 187));
        btnVan_SX.setBounds(143, 117, 89, 35);
        panel_SapXep.add(btnVan_SX);

        JButton btnToan_XS = new JButton("Toán");
        btnToan_XS.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnToan_XS.addActionListener(action);
        btnToan_XS.setFocusPainted(false);
        btnToan_XS.setForeground(new Color(255, 255, 255));
        btnToan_XS.setBackground(new Color(19, 86, 187));
        btnToan_XS.setBounds(276, 117, 89, 35);
        panel_SapXep.add(btnToan_XS);

        JButton btnAnh_SX = new JButton("Anh");
        btnAnh_SX.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAnh_SX.addActionListener(action);
        btnAnh_SX.setFocusPainted(false);
        btnAnh_SX.setForeground(new Color(255, 255, 255));
        btnAnh_SX.setBackground(new Color(19, 86, 187));
        btnAnh_SX.setBounds(143, 185, 89, 35);
        panel_SapXep.add(btnAnh_SX);

        JButton btnTong_SX = new JButton("Tổng");
        btnTong_SX.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnTong_SX.addActionListener(action);
        btnTong_SX.setFocusPainted(false);
        btnTong_SX.setForeground(new Color(255, 255, 255));
        btnTong_SX.setBackground(new Color(19, 86, 187));
        btnTong_SX.setBounds(276, 185, 89, 35);
        panel_SapXep.add(btnTong_SX);

        JButton btnThoat_SX = new JButton("Thoát");
        btnThoat_SX.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnThoat_SX.addActionListener(action);
        btnThoat_SX.setFocusPainted(false);
        btnThoat_SX.setForeground(new Color(255, 255, 255));
        btnThoat_SX.setBackground(new Color(19, 86, 187));
        btnThoat_SX.setBounds(208, 245, 89, 35);
        panel_SapXep.add(btnThoat_SX);

        JLabel logo_SapXep = new JLabel(new ImageIcon(getClass().getResource("Sort-ascending-icon.png")));
        logo_SapXep.setBounds(513, 46, 256, 264);
        panel_SapXep.add(logo_SapXep);

        panel_SapXep.setVisible(false);

        // BIỂU ĐỒ------------------------------------------------------------------------------------------------------

        JButton btnBieuDo = new JButton("Biểu đồ");
        btnBieuDo.addActionListener(action);
        btnBieuDo.setBounds(0, 403, 159, 42);
        btnBieuDo.setBorderPainted(false);
        btnBieuDo.setFocusPainted(false);
        btnBieuDo.setForeground(new Color(255, 255, 255));
        btnBieuDo.setBackground(new Color(19, 86, 187));
        btnBieuDo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Button.add(btnBieuDo);

        panel_BieuDo = new JPanel();
        panel_BieuDo.setLayout(null);
        panel_BieuDo.setBackground(new Color(255, 255, 255));
        panel_BieuDo.setBounds(169, 0, 851, 642);
        contentPane.add(panel_BieuDo);

        JLabel lable_BieuDienBieuDo = new JLabel("BIỂU ĐỒ ĐIỂM TUYỂN SINH LỚP 10");
        lable_BieuDienBieuDo.setForeground(new Color(255, 0, 0));
        lable_BieuDienBieuDo.setFont(new Font("Tahoma", Font.BOLD, 22));
        lable_BieuDienBieuDo.setBounds(230, 11, 429, 32);
        panel_BieuDo.add(lable_BieuDienBieuDo);

        JLabel lable_SoLieu = new JLabel("Số liệu");
        lable_SoLieu.setFont(new Font("Tahoma", Font.BOLD, 22));
        lable_SoLieu.setBounds(395, 458, 82, 42);
        panel_BieuDo.add(lable_SoLieu);

        table_SoLieu = new JTable();
        table_SoLieu.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table_SoLieu.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Loại", "Văn", "Toán", "Anh", "Tổng"}));

        table_SoLieu.setRowHeight(25);
        scrollPane_SoLieu = new JScrollPane(table_SoLieu);
        scrollPane_SoLieu.setBounds(183, 502, 503, 129);
        panel_BieuDo.add(scrollPane_SoLieu);
        //hienBieuDo();

        panel_BieuDo.setVisible(false);


        // BẢNG ĐIỂM THỐNG KÊ-------------------------------------------------------------------------------------------

        JButton btnThongKe = new JButton("Thống kê");
        btnThongKe.addActionListener(action);
        btnThongKe.setBounds(0, 350, 159, 42);
        btnThongKe.setBorderPainted(false);
        btnThongKe.setFocusPainted(false);
        btnThongKe.setForeground(new Color(255, 255, 255));
        btnThongKe.setBackground(new Color(19, 86, 187));
        btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_Button.add(btnThongKe);

        panel_ThongKe = new JPanel();
        panel_ThongKe.setLayout(null);
        panel_ThongKe.setBackground(new Color(255, 255, 255));
        panel_ThongKe.setBounds(281, 293, 583, 338);
        contentPane.add(panel_ThongKe);

        JLabel lable_BangDiem = new JLabel("Số lượng điểm tuyển sinh lớp 10");
        lable_BangDiem.setForeground(new Color(255, 0, 0));
        lable_BangDiem.setFont(new Font("Tahoma", Font.BOLD, 22));
        lable_BangDiem.setBounds(145, 11, 378, 35);
        panel_ThongKe.add(lable_BangDiem);

        table_1 = new JTable();
        table_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        table_1.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"Điểm", "Văn", "Toán", "Anh"}));

        table_1.setRowHeight(25);

        scrollPane_1 = new JScrollPane(table_1);
        scrollPane_1.setBounds(52, 52, 521, 275);
        panel_ThongKe.add(scrollPane_1);

        panel_ThongKe.setVisible(false);


        //--------------------------------------------------------------------------------------------------------------

        this.setVisible(true);
    }

    public void xoaForm() {
        textField_ID.setText("");
        textField_HoVaTen.setText("");
        btn_gioiTinh.clearSelection();
        textField_NgaySinh.setText("");
        textField_Truong.setText("");
        textField_Van.setText("");
        textField_Toan.setText("");
        textField_Anh.setText("");
        textField_Truong_TimKiem.setText("");
        textField_HoTen_TimKiem.setText("");
        comboBox_queQuan.setSelectedIndex(-1);
    }

    public void themThiSinh() {
        // Lấy dữu liệu từ thông tin học sinh
        int sbd = Integer.valueOf(this.textField_ID.getText());
        String hoVaTen = this.textField_HoVaTen.getText();
        int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
        Tinh tinh = Tinh.getTinhById(queQuan);
        String ngaySinh = this.textField_NgaySinh.getText();
        boolean gioiTinh = true;
        if (this.radioButton_nam.isSelected()) gioiTinh = true;
        else if (this.radioButton_nu.isSelected()) gioiTinh = false;
        String truong = this.textField_Truong.getText();
        float van = Float.valueOf(this.textField_Van.getText());
        float toan = Float.valueOf(this.textField_Toan.getText());
        float anh = Float.valueOf(this.textField_Anh.getText());

        HocSinh hocSinh = new HocSinh(sbd, hoVaTen, gioiTinh, tinh, ngaySinh, truong, van, toan, anh);
        this.capNhapThiSinh(hocSinh);
    }

    public boolean kiemTraDieuKien(){
        int sbd = Integer.valueOf(this.textField_ID.getText());
        float van = Float.valueOf(this.textField_Van.getText());
        float toan = Float.valueOf(this.textField_Toan.getText());
        float anh = Float.valueOf(this.textField_Anh.getText());
        if (sbd<=0){
            JOptionPane.showMessageDialog(textField_ID,"SBD bị sai!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (0.0 > van || van > 10.0) {
            JOptionPane.showMessageDialog(textField_ID,"Điểm văn bị sai!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (0.0 > toan || toan > 10.0) {
            JOptionPane.showMessageDialog(textField_ID,"Điểm toán bị sai!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (0.0 > anh || anh > 10.0) {
            JOptionPane.showMessageDialog(textField_ID,"Điểm anh bị sai!","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void themThiSinhKtraID() {
        int sbd = Integer.valueOf(this.textField_ID.getText());
        String hoVaTen = this.textField_HoVaTen.getText();
        int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
        Tinh tinh = Tinh.getTinhById(queQuan);
        String ngaySinh = this.textField_NgaySinh.getText();
        boolean gioiTinh = true;
        if (this.radioButton_nam.isSelected()) gioiTinh = true;
        else if (this.radioButton_nu.isSelected()) gioiTinh = false;
        String truong = this.textField_Truong.getText();
        float van = Float.valueOf(this.textField_Van.getText());
        float toan = Float.valueOf(this.textField_Toan.getText());
        float anh = Float.valueOf(this.textField_Anh.getText());

        HocSinh hocSinh = new HocSinh(sbd, hoVaTen, gioiTinh, tinh, ngaySinh, truong, van, toan, anh);
        this.luuThiSinh(hocSinh);
    }

    public void luuThiSinh(HocSinh hocSinh){
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if (!this.model.kiemTraTonTai(hocSinh)) {
            this.model.insert(hocSinh);
            this.themThiSinhVaoTable(hocSinh);
        } else {
            JOptionPane.showMessageDialog(textField_ID,"Đã trùng SBD của học sinh khác!","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void capNhapThiSinh(HocSinh hocSinh) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        if (!this.model.kiemTraTonTai(hocSinh)) {
            this.model.insert(hocSinh);
            this.themThiSinhVaoTable(hocSinh);
        } else {
            this.model.update(hocSinh);
            int soLuongDong = model_table.getRowCount();
            for (int i = 0; i < soLuongDong; i++) {
                String sbd = model_table.getValueAt(i, 0) + "";
                if (sbd.equals(hocSinh.getId() + "")) {
                    model_table.setValueAt(hocSinh.getId(), i, 0);
                    model_table.setValueAt(hocSinh.getTenThiSinh(), i, 1);
                    model_table.setValueAt((hocSinh.isGioiTinh() ? "Nam" : "Nu"), i, 2);
                    model_table.setValueAt(hocSinh.getQueQuan().getTenTinh() + "", i, 3);
                    model_table.setValueAt(hocSinh.getNgaySinh(), i, 4);
                    model_table.setValueAt(hocSinh.getTruong(), i, 5);
                    model_table.setValueAt(hocSinh.getVan() + "", i, 6);
                    model_table.setValueAt(hocSinh.getToan() + "", i, 7);
                    model_table.setValueAt(hocSinh.getAnh() + "", i, 8);
                    model_table.setValueAt((hocSinh.getVan() + hocSinh.getToan() + hocSinh.getAnh()) + "", i, 9);
                }
            }
        }
    }

    public void themThiSinhVaoTable(HocSinh hocSinh) {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        model_table.addRow(new Object[]{hocSinh.getId() + "", hocSinh.getTenThiSinh(), (hocSinh.isGioiTinh() ? "Nam" : "Nu"),
                hocSinh.getQueQuan().getTenTinh(), hocSinh.getNgaySinh(), hocSinh.getTruong(),
                hocSinh.getVan() + "", hocSinh.getToan() + "", hocSinh.getAnh() + "", hocSinh.getVan() + hocSinh.getToan() + hocSinh.getAnh() + ""});
    }

    public HocSinh thiSinhDangChon() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();

        int sbd = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
        String hoVaTen = model_table.getValueAt(i_row, 1) + "";
        String ktraGT = model_table.getValueAt(i_row, 2) + "";
        boolean gioiTinh = ktraGT.equals("Nam");
        Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 3) + "");
        String ngaySinh = model_table.getValueAt(i_row, 4) + "";
        String truong = model_table.getValueAt(i_row, 5) + "";
        float van = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
        float toan = Float.valueOf(model_table.getValueAt(i_row, 7) + "");
        float anh = Float.valueOf(model_table.getValueAt(i_row, 8) + "");

        HocSinh hs = new HocSinh(sbd, hoVaTen, gioiTinh, tinh, ngaySinh, truong, van, toan, anh);
        return hs;
    }

    public void hienthiThiSinhDaChon() {
        HocSinh hs = thiSinhDangChon();

        this.textField_ID.setText(hs.getId() + "");
        this.textField_HoVaTen.setText(hs.getTenThiSinh() + "");
        if (hs.isGioiTinh()) {
            radioButton_nam.setSelected(true);
        } else {
            radioButton_nu.setSelected(true);
        }
        this.comboBox_queQuan.setSelectedItem(hs.getQueQuan().getTenTinh());
        this.textField_NgaySinh.setText(hs.getNgaySinh() + "");
        this.textField_Truong.setText(hs.getTruong() + "");
        this.textField_Van.setText(hs.getVan() + "");
        this.textField_Toan.setText(hs.getToan() + "");
        this.textField_Anh.setText(hs.getAnh() + "");
    }

    public void xoaThiSinh() {
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int i_row = table.getSelectedRow();
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa học sinh này?");
        if (luaChon == JOptionPane.YES_OPTION) {
            HocSinh hs = thiSinhDangChon();
            this.model.delete(hs);
            model_table.removeRow(i_row);
        }
    }

    public void thucHienTim() {
        this.taiLaiDuLieu();

        String truong_TimKiem = this.textField_Truong_TimKiem.getText();
        String hoVaTen_TimKiem = this.textField_HoTen_TimKiem.getText();
        DefaultTableModel model_table = (DefaultTableModel) table.getModel();
        int soLuongDong = model_table.getRowCount();

        if (!truong_TimKiem.equals("")) {
            int i = 0;
            while (i < model_table.getRowCount()) {
                String truongTrongBang = model_table.getValueAt(i, 5) + "";
                if (!truongTrongBang.equals(truong_TimKiem)) {
                    model_table.removeRow(i);
                } else i++;
            }
        }

        if (!hoVaTen_TimKiem.equals("")) {
            int i = 0;
            while (i < model_table.getRowCount()) {
                String hoVaTen = model_table.getValueAt(i, 1) + "";
                if (!hoVaTen.equals(hoVaTen_TimKiem)) {
                    model_table.removeRow(i);
                } else i++;
            }
        }
    }

    public void taiLaiDuLieu() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (HocSinh hs : this.model.getDshs()) {
            this.themThiSinhVaoTable(hs);
        }
    }

    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn thoát khỏi chương trình",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void kiemTraLuuChuongTrinh(){
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Đã chỉnh sửa." +
                        " Bạn có muốn lưu lại!",
                "Chú ý",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION){
            xoaBangSQL();
            luuChuongTrinh();
        }
    }

    public void luuChuongTrinh() {
        try {
            Connection conn = DriverManager.getConnection(connUrl);

            String sql = "INSERT INTO BangDiem(SBD, HoVaTen, GioiTinh, QueQuan, NgaySinh, Truong, Van, Toan, Anh, Tong)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            for (HocSinh hs : this.model.getDshs()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, hs.getId());
                ps.setString(2, hs.getTenThiSinh());
                String gt = hs.isGioiTinh() ? "Nam" : "Nu";
                ps.setString(3, gt);
                ps.setString(4, hs.getQueQuan().getTenTinh());
                ps.setString(5, hs.getNgaySinh()+"");
                ps.setString(6, hs.getTruong());
                ps.setFloat(7, hs.getVan());
                ps.setFloat(8, hs.getToan());
                ps.setFloat(9, hs.getAnh());
                ps.setFloat(10, hs.getVan() + hs.getAnh() + hs.getToan());

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void xoaBangSQL() {
        try {
            Connection conn = DriverManager.getConnection(connUrl);
            Statement statement = conn.createStatement();

            String delete = "DELETE FROM BangDiem";

            statement.executeUpdate(delete);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void moChuongTrinh() {
        try {
            Connection conn = DriverManager.getConnection(connUrl);
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM BangDiem";

            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                int sbd = result.getInt(1);
                String name = result.getString(2);
                String gender = result.getString(3);
                boolean gioiTinh = gender.equals("Nam");
                String address = result.getString(4);
                Tinh tinh = Tinh.getTinhByTen(address);
                String DOB = result.getString(5);
                String school = result.getString(6);
                float van = result.getFloat(7);
                float toan = result.getFloat(8);
                float anh = result.getFloat(9);

                HocSinh hocSinh = new HocSinh(sbd, name, gioiTinh, tinh, DOB, school, van, toan, anh);
                this.themThiSinhVaoTable(hocSinh);
                this.model.insert(hocSinh);
                //System.out.println(hocSinh.getTenThiSinh());
            }

            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void xoaBang() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sapXepToan() {
        QLHSModel dsToan = new QLHSModel();
        for (HocSinh hs : this.model.getDshs())
            dsToan.getDshs().add(hs);
        Collections.sort(dsToan.getDshs(), new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return (o1.getToan() > o2.getToan()) ? -1 : 1;
            }
        });
        xoaBang();
        for (HocSinh hs : dsToan.getDshs()) {
            this.themThiSinhVaoTable(hs);
        }
    }

    public void sapXepVan() {
        QLHSModel dsVan = new QLHSModel();
        for (HocSinh hs : this.model.getDshs())
            dsVan.getDshs().add(hs);
        Collections.sort(dsVan.getDshs(), new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return (o1.getVan() > o2.getVan()) ? -1 : 1;
            }
        });
        xoaBang();
        for (HocSinh hs : dsVan.getDshs()) {
            this.themThiSinhVaoTable(hs);
        }
    }

    public void sapXepAnh() {
        QLHSModel dsAnh = new QLHSModel();
        for (HocSinh hs : this.model.getDshs())
            dsAnh.getDshs().add(hs);
        Collections.sort(dsAnh.getDshs(), new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return (o1.getAnh() > o2.getAnh()) ? -1 : 1;
            }
        });
        xoaBang();
        for (HocSinh hs : dsAnh.getDshs()) {
            this.themThiSinhVaoTable(hs);
        }
    }

    public void sapXepTong() {
        QLHSModel dsTong = new QLHSModel();
        for (HocSinh hs : this.model.getDshs())
            dsTong.getDshs().add(hs);
        Collections.sort(dsTong.getDshs(), new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return ((o1.getAnh() + o1.getToan() + o1.getVan()) > (o2.getAnh() + o2.getToan() + o2.getVan())) ? -1 : 1;
            }
        });
        xoaBang();
        for (HocSinh hs : dsTong.getDshs()) {
            this.themThiSinhVaoTable(hs);
        }
    }

    public void demDiem() {
        int[] dsVan = new int[10];
        int[] dsToan = new int[10];
        int[] dsAnh = new int[10];
        for (HocSinh hs : this.model.getDshs()) {
            float a = hs.getVan();
            if (a > 9) dsVan[0]++;
            else if (a > 8) dsVan[1]++;
            else if (a > 7) dsVan[2]++;
            else if (a > 6) dsVan[3]++;
            else if (a > 5) dsVan[4]++;
            else if (a > 4) dsVan[5]++;
            else if (a > 3) dsVan[6]++;
            else if (a > 2) dsVan[7]++;
            else if (a > 1) dsVan[8]++;
            else dsVan[9]++;

            a = hs.getToan();
            if (a > 9) dsToan[0]++;
            else if (a > 8) dsToan[1]++;
            else if (a > 7) dsToan[2]++;
            else if (a > 6) dsToan[3]++;
            else if (a > 5) dsToan[4]++;
            else if (a > 4) dsToan[5]++;
            else if (a > 3) dsToan[6]++;
            else if (a > 2) dsToan[7]++;
            else if (a > 1) dsToan[8]++;
            else dsToan[9]++;

            a = hs.getAnh();
            if (a > 9) dsAnh[0]++;
            else if (a > 8) dsAnh[1]++;
            else if (a > 7) dsAnh[2]++;
            else if (a > 6) dsAnh[3]++;
            else if (a > 5) dsAnh[4]++;
            else if (a > 4) dsAnh[5]++;
            else if (a > 3) dsAnh[6]++;
            else if (a > 2) dsAnh[7]++;
            else if (a > 1) dsAnh[8]++;
            else dsAnh[9]++;
        }
        xoaBangTable_1();
        DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
        for (int i = 0; i < 10; i++) {
            model_table.addRow(new Object[]{
                    (10 - (i + 1) + " - " + (10 - i)), dsVan[i], dsToan[i], dsAnh[i]
            });
        }
    }

    public void xoaBangTable_1() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // BIỂU ĐỒ-------------------------------------------------------------

    public void xoaBangBieuDo() {
        while (true) {
            DefaultTableModel model_table = (DefaultTableModel) table_SoLieu.getModel();
            int soLuongDong = model_table.getRowCount();
            if (soLuongDong == 0) {
                break;
            } else {
                try {
                    model_table.removeRow(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void hienBieuDo() {
        int[] dsVan = new int[4];
        for (HocSinh hs : this.model.getDshs()) {
            if (hs.getVan() >= 8) dsVan[0]++;
            else if (hs.getVan() >= 6.5) dsVan[1]++;
            else if (hs.getVan() >= 5.0) dsVan[2]++;
            else dsVan[3]++;
        }
        DefaultPieDataset dataset_Van = new DefaultPieDataset();
        dataset_Van.setValue("Giỏi (8.0 - 10)", dsVan[0]);
        dataset_Van.setValue("Khá (6.5 - 7.9)", dsVan[1]);
        dataset_Van.setValue("Trung bình (5.0 - 6.4)", dsVan[2]);
        dataset_Van.setValue("Yếu (0.0 - 4.9)", dsVan[3]);
        JFreeChart pieChart_Van = createPieChart_Van(dataset_Van);
        chartPanel_Van = new ChartPanel(pieChart_Van);
        chartPanel_Van.setBounds(85, 49, 345, 197);
        panel_BieuDo.add(chartPanel_Van);

        int[] dsToan = new int[4];
        for (HocSinh hs : this.model.getDshs()) {
            if (hs.getToan() >= 8) dsToan[0]++;
            else if (hs.getToan() >= 6.5) dsToan[1]++;
            else if (hs.getToan() >= 5.0) dsToan[2]++;
            else dsToan[3]++;
        }
        DefaultPieDataset dataset_Toan = new DefaultPieDataset();
        dataset_Toan.setValue("Giỏi (8.0 - 10)", dsToan[0]);
        dataset_Toan.setValue("Khá (6.5 - 7.9)", dsToan[1]);
        dataset_Toan.setValue("Trung bình (5.0 - 6.4)", dsToan[2]);
        dataset_Toan.setValue("Yếu (0.0 - 4.9)", dsToan[3]);
        JFreeChart pieChart_Toan = createPieChart_Toan(dataset_Toan);
        chartPanel_Toan = new ChartPanel(pieChart_Toan);
        chartPanel_Toan.setBounds(443, 49, 345, 197);
        panel_BieuDo.add(chartPanel_Toan);

        int[] dsAnh = new int[4];
        for (HocSinh hs : this.model.getDshs()) {
            if (hs.getAnh() >= 8) dsAnh[0]++;
            else if (hs.getAnh() >= 6.5) dsAnh[1]++;
            else if (hs.getAnh() >= 5.0) dsAnh[2]++;
            else dsAnh[3]++;
        }
        DefaultPieDataset dataset_Anh = new DefaultPieDataset();
        dataset_Anh.setValue("Giỏi (8.0 - 10)", dsAnh[0]);
        dataset_Anh.setValue("Khá (6.5 - 7.9)", dsAnh[1]);
        dataset_Anh.setValue("Trung bình (5.0 - 6.4)", dsAnh[2]);
        dataset_Anh.setValue("Yếu (0.0 - 4.9)", dsAnh[3]);
        JFreeChart pieChart_Anh = createPieChart_Anh(dataset_Anh);
        chartPanel_Anh = new ChartPanel(pieChart_Anh);
        chartPanel_Anh.setBounds(443, 257, 345, 197);
        panel_BieuDo.add(chartPanel_Anh);

        int[] dsTong = new int[4];
        for (HocSinh hs : this.model.getDshs()) {
            if (hs.getAnh() + hs.getToan() + hs.getVan() >= 25) dsTong[0]++;
            else if (hs.getAnh() + hs.getToan() + hs.getVan() >= 20) dsTong[1]++;
            else if (hs.getAnh() + hs.getToan() + hs.getVan() >= 12) dsTong[2]++;
            else dsTong[3]++;
        }
        DefaultPieDataset dataset_Tong = new DefaultPieDataset();
        dataset_Tong.setValue("Giỏi (25 - 30)", dsTong[0]);
        dataset_Tong.setValue("Khá (20 - 24.9)", dsTong[1]);
        dataset_Tong.setValue("Trung bình (12 - 19.9)", dsTong[2]);
        dataset_Tong.setValue("Yếu (0.0 - 11.9)", dsTong[3]);
        JFreeChart pieChart_Tong = createPieChart_Tong(dataset_Tong);
        chartPanel_Tong = new ChartPanel(pieChart_Tong);
        chartPanel_Tong.setBounds(85, 257, 345, 197);
        panel_BieuDo.add(chartPanel_Tong);

        xoaBangBieuDo();
        DefaultTableModel model_table = (DefaultTableModel) table_SoLieu.getModel();
        model_table.addRow(new Object[]{
                "Giỏi", (dsVan[0] + " (" + (format("%.1f", dsVan[0] * 100.0 / (dsVan[0] + dsVan[1] + dsVan[2] + dsVan[3]))) + "%)"), (dsToan[0] + " (" + (format("%.1f", dsToan[0] * 100.0 / (dsToan[0] + dsToan[1] + dsToan[2] + dsToan[3]))) + "%)"), (dsAnh[0] + " (" + (format("%.1f", dsAnh[0] * 100.0 / (dsAnh[0] + dsAnh[1] + dsAnh[2] + dsAnh[3]))) + "%)"), (dsTong[0] + " (" + (format("%.1f", dsTong[0] * 100.0 / (dsTong[0] + dsTong[1] + dsTong[2] + dsTong[3]))) + "%)")
        });
        model_table.addRow(new Object[]{
                "Khá", (dsVan[1] + " (" + (format("%.1f", dsVan[1] * 100.0 / (dsVan[0] + dsVan[1] + dsVan[2] + dsVan[3]))) + "%)"), (dsToan[1] + " (" + (format("%.1f", dsToan[1] * 100.0 / (dsToan[0] + dsToan[1] + dsToan[2] + dsToan[3]))) + "%)"), (dsAnh[1] + " (" + (format("%.1f", dsAnh[1] * 100.0 / (dsAnh[0] + dsAnh[1] + dsAnh[2] + dsAnh[3]))) + "%)"), (dsTong[1] + " (" + (format("%.1f", dsTong[1] * 100.0 / (dsTong[0] + dsTong[1] + dsTong[2] + dsTong[3]))) + "%)")
        });
        model_table.addRow(new Object[]{
                "Trung bình", (dsVan[2] + " (" + (format("%.1f", dsVan[2] * 100.0 / (dsVan[0] + dsVan[1] + dsVan[2] + dsVan[3]))) + "%)"), (dsToan[2] + " (" + (format("%.1f", dsToan[2] * 100.0 / (dsToan[0] + dsToan[1] + dsToan[2] + dsToan[3]))) + "%)"), (dsAnh[2] + " (" + (format("%.1f", dsAnh[2] * 100.0 / (dsAnh[0] + dsAnh[1] + dsAnh[2] + dsAnh[3]))) + "%)"), (dsTong[2] + " (" + (format("%.1f", dsTong[2] * 100.0 / (dsTong[0] + dsTong[1] + dsTong[2] + dsTong[3]))) + "%)")
        });
        model_table.addRow(new Object[]{
                "Yếu", (dsVan[3] + " (" + (format("%.1f", dsVan[3] * 100.0 / (dsVan[0] + dsVan[1] + dsVan[2] + dsVan[3]))) + "%)"), (dsToan[3] + " (" + (format("%.1f", dsToan[3] * 100.0 / (dsToan[0] + dsToan[1] + dsToan[2] + dsToan[3]))) + "%)"), (dsAnh[3] + " (" + (format("%.1f", dsAnh[3] * 100.0 / (dsAnh[0] + dsAnh[1] + dsAnh[2] + dsAnh[3]))) + "%)"), (dsTong[3] + " (" + (format("%.1f", dsTong[3] * 100.0 / (dsTong[0] + dsTong[1] + dsTong[2] + dsTong[3]))) + "%)")
        });
    }

    private static JFreeChart createPieChart_Van(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Môn Văn".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }

    private static JFreeChart createPieChart_Toan(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Môn Toán".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }

    private static JFreeChart createPieChart_Anh(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Môn Anh".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }

    private static JFreeChart createPieChart_Tong(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Tổng".toUpperCase(),
                dataset, true, true, true);
        return chart;
    }
    public void sapXepThuTu(){
        Collections.sort(this.model.getDshs(), new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                return (o1.getId() < o2.getId()) ? -1 : 1;
            }
        });
        xoaBang();
        for (HocSinh hs : this.model.getDshs()) {
            this.themThiSinhVaoTable(hs);
        }
    }


}


