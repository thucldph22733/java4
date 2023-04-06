package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet",uniqueConstraints = {@UniqueConstraint(columnNames = {"IdHoaDon","IdChiTietSP"})})
public class HoaDonChiTiet {
    @Id
//    @ManyToOne @JoinColumn(name = "IdHoaDon")
//    HoaDon hoaDon;
//
//    @ManyToOne @JoinColumn(name = "ChiTietSP")
//    ChiTietSP chiTietSP;

    @Column(name="soLuong")
    private Integer soLuong;

    @Column(name="donGia")
    private Double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer soLuong, Double donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }
}

