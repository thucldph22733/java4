package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "NhanVien")
public class NhanVien {

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

    @Column(name="gioiTinh")
    private String gioiTinh;

//    @Temporal(TemporalType.DATE)
//    @Type(type="date")
    @Column(name="ngaySinh")
    private String ngaySinh;

    @Column(name="sdt")
    private String sdt;

    @Column(name="diaChi")
    private String diaChi;

    @Column(name="matKhau")
    private String matKhau;


    @ManyToOne()
    @JoinColumn(
            name = "IdCV",
            referencedColumnName = "Id"
    )
    private ChucVu chucVu;

    @ManyToOne()
    @JoinColumn(
            name = "IdCH",
            referencedColumnName = "Id"
    )

    private CuaHang cuaHang;

    @Column(name="trangThai")
    private Integer trangThai;

//    @OneToMany (mappedBy = "nhanVien")
//    List<HoaDon> hoaDons;

    public NhanVien() {
    }

    public NhanVien(String id, CuaHang cuaHang, ChucVu chucVu) {
        this.id = id;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
    }
//    public NhanVien(List<HoaDon> hoaDons) {
//        this.hoaDons = hoaDons;
//    }

    public NhanVien(String id, String ma, String ten, String tenDem, String ho, String gioiTinh, String ngaySinh, String sdt, String diaChi, String matKhau, CuaHang cuaHang, ChucVu chucVu, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public CuaHang getCuaHang() {
        return cuaHang;
    }

    public void setCuaHang(CuaHang cuaHang) {
        this.cuaHang = cuaHang;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
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

    public String isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

//    public CuaHang getCuaHang() {
//        return cuaHang;
//    }
//
//    public void setCuaHang(CuaHang cuaHang) {
//        this.cuaHang = cuaHang;
//    }
//
//    public ChucVu getChucVu() {
//        return chucVu;
//    }
//
//    public void setChucVu(ChucVu chucVu) {
//        this.chucVu = chucVu;
//    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

//    public List<HoaDon> getHoaDons() {
//        return hoaDons;
//    }
//
//    public void setHoaDons(List<HoaDon> hoaDons) {
//        this.hoaDons = hoaDons;
//    }
}
