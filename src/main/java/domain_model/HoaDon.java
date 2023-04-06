package domain_model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "HoaDon",uniqueConstraints = {@UniqueConstraint(columnNames = {"IdKH","IdNV"})})
public class HoaDon {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

//    @ManyToOne @JoinColumn(name = "IdKH")
//    KhachHang khachHang;
//
//    @ManyToOne @JoinColumn(name = "IdNV")
//    NhanVien nhanVien;

    @Column(name="ma")
    private String ma;

    @Column(name="NgayTao")
    private String ngayTao;

    @Column(name="NgayThanhToan")
    private String ngayThanhToan;

    @Column(name="NgayShip")
    private String ngayShip;

    @Column(name="ngayNhan")
    private String ngayNhan;

    @Column(name="tinhTrang")
    private Integer tinhTrang;

    @Column(name="tenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name="diaChi")
    private String diaChi;

    @Column(name="sdt")
    private String sdt;

//    @OneToMany (mappedBy = "hoaDon")
//    List<HoaDonChiTiet> hoaDonChiTiets;

    public HoaDon() {
    }

//    public HoaDon(List<HoaDonChiTiet> hoaDonChiTiets) {
//        this.hoaDonChiTiets = hoaDonChiTiets;
//    }

    public HoaDon(String id, String ma, String ngayTao, String ngayThanhToan, String ngayShip, String ngayNhan, Integer tinhTrang, String tenNguoiNhan, String diaChi, String sdt) {
        this.id = id;
//        this.khachHang = khachHang;
//        this.nhanVien = nhanVien;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
//        this.hoaDonChiTiets = hoaDonChiTiets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public KhachHang getKhachHang() {
//        return khachHang;
//    }
//
//    public void setKhachHang(KhachHang khachHang) {
//        this.khachHang = khachHang;
//    }
//
//    public NhanVien getNhanVien() {
//        return nhanVien;
//    }
//
//    public void setNhanVien(NhanVien nhanVien) {
//        this.nhanVien = nhanVien;
//    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(String ngayShip) {
        this.ngayShip = ngayShip;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

//    public List<HoaDonChiTiet> getHoaDonChiTiets() {
//        return hoaDonChiTiets;
//    }
//
//    public void setHoaDonChiTiets(List<HoaDonChiTiet> hoaDonChiTiets) {
//        this.hoaDonChiTiets = hoaDonChiTiets;
//    }
}
