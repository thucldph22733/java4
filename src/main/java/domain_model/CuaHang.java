package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="cuaHang")
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUID
    private UUID id;

    @Column(name="ten")
    private String ten;

    @Column(name="ma")
    private String ma;

    @Column(name="diaChi")
    private String diaChi;

    @Column(name="thanhPho")
    private String thanhPho;

    @Column(name="quocGia")
    private String quocGia;

    @OneToMany(mappedBy = "cuaHang",
            fetch = FetchType.EAGER)
    List<NhanVien> nhanViens;

    public CuaHang() {
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public CuaHang(UUID id, String ten, String ma, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
//        this.nhanViens = nhanViens;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
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

//    public List<NhanVien> getNhanViens() {
//        return nhanViens;
//    }
//
//    public void setNhanViens(List<NhanVien> nhanViens) {
//        this.nhanViens = nhanViens;
//    }
}
