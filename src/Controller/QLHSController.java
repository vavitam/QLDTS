package Controller;

import View.Login;
import View.QLHSView;
import View.TrangChu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UncheckedIOException;

public class QLHSController implements ActionListener{
    public QLHSView view;
    boolean ktra = true;
    int KtraID = 1;

    public QLHSController(QLHSView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sc = e.getActionCommand();
        if (sc.equals("Thêm")) {
            this.view.xoaForm();
            this.view.model.setLuaChon("Thêm");
            KtraID = 1;
        } else if (sc.equals("Lưu")) {
            try {
                if (this.view.kiemTraDieuKien()){
                    if (KtraID == 0) this.view.themThiSinh();
                    else this.view.themThiSinhKtraID();
                    ktra = false;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (sc.equals("Cập nhật")) {
            this.view.hienthiThiSinhDaChon();
            KtraID = 0;
            ktra = false;
        } else if (sc.equals("Xóa")) {
            this.view.xoaThiSinh();
            ktra = false;
        } else if (sc.equals("Tìm")) {
            this.view.thucHienTim();
        } else if (sc.equals("Hủy tìm")) {
            this.view.taiLaiDuLieu();
        } else if (sc.equals("Exit")) {
            if (ktra)
                this.view.thoatKhoiChuongTrinh();
            else {
                this.view.kiemTraLuuChuongTrinh();
                this.view.thoatKhoiChuongTrinh();
            }
        } else if (sc.equals("Save")) {
            this.view.xoaBangSQL();
            this.view.luuChuongTrinh();
            ktra = true;
        } else if (sc.equals("Open")) {
            this.view.moChuongTrinh();
        } else if (sc.equals("Toán")) {
            this.view.sapXepToan();
        } else if (sc.equals("Văn")) {
            this.view.sapXepVan();
        } else if (sc.equals("Anh")) {
            this.view.sapXepAnh();
        } else if (sc.equals("Tổng")) {
            this.view.sapXepTong();
        } else if (sc.equals("Thoát")) {
            this.view.sapXepThuTu();
            //this.view.taiLaiDuLieu();
        } else if (sc.equals("Chỉnh sửa")) {
            this.view.lable_DanhSach.setVisible(true);
            this.view.scrollPane.setVisible(true);
            this.view.panel_ThongTinHS.setVisible(true);
            this.view.panel_TimKiem.setVisible(false);
            this.view.panel_SapXep.setVisible(false);
            this.view.panel_BieuDo.setVisible(false);
            this.view.panel_ThongKe.setVisible(false);
            this.view.taiLaiDuLieu();
        } else if (sc.equals("Tìm kiếm")) {
            this.view.lable_DanhSach.setVisible(true);
            this.view.scrollPane.setVisible(true);
            this.view.panel_ThongTinHS.setVisible(false);
            this.view.panel_TimKiem.setVisible(true);
            this.view.panel_SapXep.setVisible(false);
            this.view.panel_BieuDo.setVisible(false);
            this.view.panel_ThongKe.setVisible(false);
            this.view.taiLaiDuLieu();
        } else if (sc.equals("Sắp xếp")) {
            this.view.lable_DanhSach.setVisible(true);
            this.view.scrollPane.setVisible(true);
            this.view.panel_ThongTinHS.setVisible(false);
            this.view.panel_TimKiem.setVisible(false);
            this.view.panel_SapXep.setVisible(true);
            this.view.panel_BieuDo.setVisible(false);
            this.view.panel_ThongKe.setVisible(false);
            this.view.taiLaiDuLieu();
        } else if (sc.equals("Biểu đồ")) {
            this.view.lable_DanhSach.setVisible(false);
            this.view.scrollPane.setVisible(false);
            this.view.panel_ThongTinHS.setVisible(false);
            this.view.panel_TimKiem.setVisible(false);
            this.view.panel_SapXep.setVisible(false);
            this.view.panel_BieuDo.setVisible(true);
            this.view.hienBieuDo();
            this.view.panel_ThongKe.setVisible(false);
            this.view.taiLaiDuLieu();
            this.view.hienBieuDo();
        } else if (sc.equals("Thống kê")) {
            this.view.lable_DanhSach.setVisible(true);
            this.view.scrollPane.setVisible(true);
            this.view.panel_ThongTinHS.setVisible(false);
            this.view.panel_TimKiem.setVisible(false);
            this.view.panel_SapXep.setVisible(false);
            this.view.panel_BieuDo.setVisible(false);
            this.view.panel_ThongKe.setVisible(true);
            this.view.taiLaiDuLieu();
            this.view.demDiem();
        } else if (sc.equals("Đăng xuất")) {
            if (ktra == false) {
                this.view.kiemTraLuuChuongTrinh();
            }
            TrangChu trangChu = new TrangChu();
            this.view.setVisible(false);
        }
    }
}
