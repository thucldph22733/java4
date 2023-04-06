package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "GioHangChiTiet",uniqueConstraints = {@UniqueConstraint(columnNames = {"IdGioHang","IdChiTietSP"})}
)
public class GioHangChiTiet{
    @Id
//    @ManyToOne @JoinColumn(name = "IdGioHang")
//    GioHang gioHang;
//
//    @ManyToOne @JoinColumn(name = "IdChiTietSP")
//    ChiTietSP chiTietSP;

    @Column(name="SoLuong")
    private Integer soLuong;

    @Column(name="donGia")
    private Integer donGia;

    @Column(name="donGiaKhiGiam")
    private Integer donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(Integer soLuong, Integer donGia, Integer donGiaKhiGiam) {
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    public Integer getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(Integer donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
}
