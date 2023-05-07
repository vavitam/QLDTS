package Model;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Objects;

public class HocSinh {
    private int id;
    private String tenThiSinh;
    private boolean gioiTinh;
    private Tinh queQuan;
    private String ngaySinh;
    private String truong;
    private float van;
    private float toan;
    private float anh;
    public HocSinh (){
    }

    public HocSinh(int id, String tenThiSinh, boolean gioiTinh, Tinh queQuan, String ngaySinh, String truong, float van, float toan, float anh) {
        this.id = id;
        this.tenThiSinh = tenThiSinh;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.truong = truong;
        this.van = van;
        this.toan = toan;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Tinh getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(Tinh queQuan) {
        this.queQuan = queQuan;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTruong() {
        return truong;
    }

    public void setTruong(String truong) {
        this.truong = truong;
    }

    public float getVan() {
        return van;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getAnh() {
        return anh;
    }

    public void setAnh(float anh) {
        this.anh = anh;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HocSinh hocSinh = (HocSinh) o;
//        return id == hocSinh.id && gioiTinh == hocSinh.gioiTinh && Float.compare(hocSinh.van, van) == 0 && Float.compare(hocSinh.toan, toan) == 0 && Float.compare(hocSinh.anh, anh) == 0 && Objects.equals(tenThiSinh, hocSinh.tenThiSinh) && Objects.equals(queQuan, hocSinh.queQuan) && Objects.equals(ngaySinh, hocSinh.ngaySinh) && Objects.equals(truong, hocSinh.truong);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, tenThiSinh, gioiTinh, queQuan, ngaySinh, truong, van, toan, anh);
//    }
}
