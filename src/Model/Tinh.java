package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Tinh {
    private int maTinh;
    private String tenTinh;
    public Tinh(){
    }

    public Tinh(int maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }

    public int getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    @Override
    public String toString() {
        return "Tinh{" +
                "maTinh=" + maTinh +
                ", tenTinh='" + tenTinh + '\'' +
                '}';
    }

    public static ArrayList<Tinh> getDSTinh(){
        String[] arr_tinh = {   "An Giang",
                "Ba Ria - Vung Tau",
                "Bac Lieu",
                "Bac Giang",
                "Bac Kan",
                "Bac Ninh",
                "Ben Tre",
                "Binh Duong",
                "Binh Dinh",
                "Binh Phuoc",
                "Binh Thuan",
                "Ca Mau",
                "Cao Bang",
                "Can Tho",
                "Da Nang",
                "Dak Lak",
                "Dak Nong",
                "Dien Bien",
                "Dong Nai",
                "Dong Thap",
                "Gia Lai",
                "Ha Giang",
                "Ha Nam",
                "Ha Noi",
                "Ha Tinh",
                "Hai Duong",
                "Hai Phong",
                "Hau Giang",
                "Hoa Binh",
                "Ho Chi Minh",
                "Hung Yen",
                "Khanh Hoa",
                "Kien Giang",
                "Kon Tum",
                "Lai Chau",
                "Lang Son",
                "Lao Cai",
                "Lam Đong",
                "Long An",
                "Nam Đinh",
                "Nghe An",
                "Ninh Binh",
                "Ninh Thuan",
                "Phu Tho",
                "Phu Yen",
                "Quang Binh",
                "Quang Nam",
                "Quang Ngai",
                "Quang Ninh",
                "Quang Tri",
                "Soc Trang",
                "Son La",
                "Tay Ninh",
                "Thai Binh",
                "Thai Nguyen",
                "Thanh Hoa",
                "Thua Thien Hue",
                "Tien Giang",
                "Tra Vinh",
                "Tuyen Quang",
                "Vinh Long",
                "Vinh Phuc",
                "Yen Bai"};
        ArrayList<Tinh> lisTinh = new ArrayList<Tinh>();
        int i=0;
        for (String tenTinh : arr_tinh){
            Tinh t = new Tinh(i,tenTinh);
            lisTinh.add(t);
        }
        return lisTinh;
    }

    public static Tinh getTinhById(int queQuan){
        return Tinh.getDSTinh().get(queQuan);
    }

    public static Tinh getTinhByTen(String tenTinh){
        ArrayList<Tinh> listTinh = Tinh.getDSTinh();
        for (Tinh tinh: listTinh){
            if (tinh.tenTinh.equals(tenTinh)){
                return tinh;
            }
        }
        return null;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Tinh tinh = (Tinh) o;
//        return maTinh == tinh.maTinh && Objects.equals(tenTinh, tinh.tenTinh);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(maTinh, tenTinh);
//    }

}
