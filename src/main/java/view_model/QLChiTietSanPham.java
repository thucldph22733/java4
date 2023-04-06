package view_model;

public class QLChiTietSanPham {
    private String san_pham;
    private String nsx;
    private String anh;
    private String ten_sp;
    private String mau_sac;
    private String dong_sp;
    private int nbh;
    private int so_luong;
    private String mo_ta;
    private String gia_nhap;
    private String gia_ban;

    public QLChiTietSanPham() {
    }

    public QLChiTietSanPham(String san_pham, String nsx, String anh, String ten_sp, String mau_sac, String dong_sp, int nbh, int so_luong, String mo_ta, String gia_nhap, String gia_ban) {
        this.san_pham = san_pham;
        this.nsx = nsx;
        this.anh = anh;
        this.ten_sp = ten_sp;
        this.mau_sac = mau_sac;
        this.dong_sp = dong_sp;
        this.nbh = nbh;
        this.so_luong = so_luong;
        this.mo_ta = mo_ta;
        this.gia_nhap = gia_nhap;
        this.gia_ban = gia_ban;
    }

    public String getSan_pham() {
        return san_pham;
    }

    public void setSan_pham(String san_pham) {
        this.san_pham = san_pham;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public String getMau_sac() {
        return mau_sac;
    }

    public void setMau_sac(String mau_sac) {
        this.mau_sac = mau_sac;
    }

    public String getDong_sp() {
        return dong_sp;
    }

    public void setDong_sp(String dong_sp) {
        this.dong_sp = dong_sp;
    }

    public int getNbh() {
        return nbh;
    }

    public void setNbh(int nbh) {
        this.nbh = nbh;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getGia_nhap() {
        return gia_nhap;
    }

    public void setGia_nhap(String gia_nhap) {
        this.gia_nhap = gia_nhap;
    }

    public String getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(String gia_ban) {
        this.gia_ban = gia_ban;
    }
}
