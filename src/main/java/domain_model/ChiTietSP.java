package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name ="ChiTietSP",uniqueConstraints = {@UniqueConstraint(columnNames = {"IdSP","IdNSX","IdMauSac","IdDongSP"})})
public class ChiTietSP {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @ManyToOne @JoinColumn(name="IdSP")
    private SanPham sanPham;

    @ManyToOne @JoinColumn(name="IdNSX")
    private NSX nsx;

    @ManyToOne @JoinColumn(name="IdMauSac")
    private MauSac mauSac;

    @ManyToOne @JoinColumn(name="IdDongSP")
    private DongSP dongSP;


    @Column(name="namBH")
    private String namBH;

    @Column(name="moTa")
    private String moTa;

    @Column(name="soLuongTon")
    private Integer soLuongTon;

    @Column(name="giaNhap")
    private Double giaNhap;

    @Column(name="giaBan")
    private Double giaBan;

    @Column(name="Img")
    private String img;

//    @OneToMany(mappedBy = "chiTietSP")
//    List<GioHangChiTiet> listGioHangChiTiet;
//
//    @OneToMany(mappedBy = "chiTietSP")
//    List<HoaDonChiTiet> listHoaDonChiTiet;


    public ChiTietSP() {
    }

    public ChiTietSP(String img) {
        this.img = img;
    }

    public ChiTietSP(String id, SanPham sanPham, NSX nsx, MauSac mauSac, DongSP dongSP, String namBH, String moTa, Integer soLuongTon, Double giaNhap, Double giaBan) {
        this.id = id;
        this.sanPham = sanPham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
//        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public String getNamBH() {
        return namBH;
    }

    public void setNamBH(String namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
