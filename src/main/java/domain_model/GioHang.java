package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "GioHang",uniqueConstraints = {@UniqueConstraint(columnNames = {"idKH"})
})
public class GioHang {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

//    @ManyToOne @JoinColumn(name = "IdKH")
//    private KhachHang khachHang;

    @Column(name="ma")
    private String ma;

    @Column(name="ngayTao")
    private String ngayTao;

    @Column(name="ngayThanhToan")
    private String ngayThanhToan;

    @Column(name="tenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name="diaChi")
    private String diaChi;

    @Column(name="sdt")
    private String sdt;

    @Column(name="tinhTrang")
    private Integer tinhTrang;

//    @OneToMany(mappedBy = "gioHang")
//    List<GioHangChiTiet> gioHangChiTiets;

    public GioHang() {
    }

//    public GioHang(List<GioHangChiTiet> gioHangChiTiets) {
//        this.gioHangChiTiets = gioHangChiTiets;
//    }

    public GioHang(String id, String ma, String ngayTao, String ngayThanhToan, String tenNguoiNhan, String diaChi, String sdt, Integer tinhTrang) {
        this.id = id;
//        this.khachHang = khachHang;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
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

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
//
//    public List<GioHangChiTiet> getGioHangChiTiets() {
//        return gioHangChiTiets;
//    }
//
//    public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
//        this.gioHangChiTiets = gioHangChiTiets;
//    }
}
