package view_model;

public class QlHoaDonCT {
    private String hoa_don;
    private String ct_sp;
    private int so_luong ;
    private String don_gia;

    public QlHoaDonCT() {
    }

    public QlHoaDonCT(String hoa_don, String ct_sp, int so_luong, String don_gia) {
        this.hoa_don = hoa_don;
        this.ct_sp = ct_sp;
        this.so_luong = so_luong;
        this.don_gia = don_gia;
    }

    public String getHoa_don() {
        return hoa_don;
    }

    public void setHoa_don(String hoa_don) {
        this.hoa_don = hoa_don;
    }

    public String getCt_sp() {
        return ct_sp;
    }

    public void setCt_sp(String ct_sp) {
        this.ct_sp = ct_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public String getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(String don_gia) {
        this.don_gia = don_gia;
    }
}
