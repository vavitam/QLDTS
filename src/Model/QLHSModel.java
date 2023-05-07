package Model;

import java.util.ArrayList;

public class QLHSModel {
    private ArrayList<HocSinh> dshs;
    private String luaChon;
    private String tenFile;
    public QLHSModel(){
        this.dshs = new ArrayList<HocSinh>();
        this.luaChon ="";
        this.tenFile="";
    }

    public ArrayList<HocSinh> getDshs() {
        return dshs;
    }

    public void setDshs(ArrayList<HocSinh> dshs) {
        this.dshs = dshs;
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public void insert(HocSinh hocSinh){
        this.dshs.add(hocSinh);
    }

    public void delete(HocSinh hocSinh){
        this.dshs.remove(hocSinh);
    }
    public void update(HocSinh hocSinh){
        int i=0;
        for (HocSinh hs : dshs){
            if (hs.getId() == hocSinh.getId()){
                dshs.remove(hs);
                dshs.add(i,hocSinh);
                break;
            } else i++;
        }
    }

    public boolean kiemTraTonTai(HocSinh hocSinh){
        for (HocSinh hs : dshs){
            if (hs.getId() == hocSinh.getId()){
                return true;
            }
        }
        return false;
    }
}
