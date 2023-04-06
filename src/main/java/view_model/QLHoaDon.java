package view_model;

public class QLHoaDon {
    private String khach_hang;
    private String nhan_vien;
    private String ma;
    private String ngay_tao;
    private String ngay_thanh_toan;
    private String ngay_ship;
    private String ngay_nhan;
    private int tinh_trang;
    private String ten_nguoi_nhan;
    private String dia_chi;
    private String sdt;

    public QLHoaDon() {
    }

    public QLHoaDon(String khach_hang, String nhan_vien, String ma, String ngay_tao, String ngay_thanh_toan, String ngay_ship, String ngay_nhan, int tinh_trang, String ten_nguoi_nhan, String dia_chi, String sdt) {
        this.khach_hang = khach_hang;
        this.nhan_vien = nhan_vien;
        this.ma = ma;
        this.ngay_tao = ngay_tao;
        this.ngay_thanh_toan = ngay_thanh_toan;
        this.ngay_ship = ngay_ship;
        this.ngay_nhan = ngay_nhan;
        this.tinh_trang = tinh_trang;
        this.ten_nguoi_nhan = ten_nguoi_nhan;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
    }

    public String getKhach_hang() {
        return khach_hang;
    }

    public void setKhach_hang(String khach_hang) {
        this.khach_hang = khach_hang;
    }

    public String getNhan_vien() {
        return nhan_vien;
    }

    public void setNhan_vien(String nhan_vien) {
        this.nhan_vien = nhan_vien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgay_tao() {
        return ngay_tao;
    }

    public void setNgay_tao(String ngay_tao) {
        this.ngay_tao = ngay_tao;
    }

    public String getNgay_thanh_toan() {
        return ngay_thanh_toan;
    }

    public void setNgay_thanh_toan(String ngay_thanh_toan) {
        this.ngay_thanh_toan = ngay_thanh_toan;
    }

    public String getNgay_ship() {
        return ngay_ship;
    }

    public void setNgay_ship(String ngay_ship) {
        this.ngay_ship = ngay_ship;
    }

    public String getNgay_nhan() {
        return ngay_nhan;
    }

    public void setNgay_nhan(String ngay_nhan) {
        this.ngay_nhan = ngay_nhan;
    }

    public int getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(int tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public String getTen_nguoi_nhan() {
        return ten_nguoi_nhan;
    }

    public void setTen_nguoi_nhan(String ten_nguoi_nhan) {
        this.ten_nguoi_nhan = ten_nguoi_nhan;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
