package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "KhachHang" )
public class KhachHang {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id" , columnDefinition="uniqueidentifier")
    private String id;

    @Column(name="ma")
    private String ma;

    @Column(name="ten")
    private String ten;

    @Column(name="tenDem")
    private String tenDem;

    @Column(name="ho")
    private String ho;

    @Column(name="NgaySinh")
//    @Temporal(TemporalType.DATE)
    private String ngaySinh;

    @Column(name="sdt")
    private String sdt;

    @Column(name="diaChi")
    private String diaChi;

    @Column(name="thanhPho")
    private String thanhPho;

    @Column(name="quocGia")
    private String quocGia;

    @Column(name="matKhau")
    private String matKhau;

//    @OneToMany (mappedBy = "khachHang")
//    List<GioHang> gioHangs;
//
//    @OneToMany (mappedBy = "khachHang")
//    List<HoaDon> hoaDons;

    public KhachHang() {
    }

//    public KhachHang(List<GioHang> gioHangs, List<HoaDon> hoaDons) {
//        this.gioHangs = gioHangs;
//        this.hoaDons = hoaDons;
//    }

    public KhachHang(String id, String ma, String ten, String tenDem, String ho, String ngaySinh, String sdt, String diaChi, String quocGia, String matKhau,String thanhPho) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
//        this.gioHangs = gioHangs;
//        this.hoaDons = hoaDons;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

//    public List<GioHang> getGioHangs() {
//        return gioHangs;
//    }
//
//    public void setGioHangs(List<GioHang> gioHangs) {
//        this.gioHangs = gioHangs;
//    }
//
//    public List<HoaDon> getHoaDons() {
//        return hoaDons;
//    }
//
//    public void setHoaDons(List<HoaDon> hoaDons) {
//        this.hoaDons = hoaDons;
//    }
}
