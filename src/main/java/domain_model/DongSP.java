package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char") // Sử dụng kiểu dữ liệu UUID
    private UUID id;

    @Column(name="ten")
    private String ten;

    @Column(name="ma")
    private String ma;
    @OneToMany(mappedBy = "dongSP")
    List<ChiTietSP> chiTietSPs;

    public DongSP() {
    }

    public DongSP(List<ChiTietSP> chiTietSPs) {
        this.chiTietSPs = chiTietSPs;
    }

    public DongSP(UUID id, String ten, String ma) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
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

//    public List<ChiTietSP> getChiTietSPs() {
//        return chiTietSPs;
//    }
//
//    public void setChiTietSPs(List<ChiTietSP> chiTietSPs) {
//        this.chiTietSPs = chiTietSPs;
//    }
}
