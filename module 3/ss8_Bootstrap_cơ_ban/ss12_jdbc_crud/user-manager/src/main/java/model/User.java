package model;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;

    public User(int ma_mat_bang, String dien_tich, String trang_thai, String tang, String loai_van_phong, String gia_tien, String ngay_bat_dau, String ngay_ket_thuc) {}

    public User(String dien_tich, String trang_thai, String tang, String loai_van_phong, String gia_tien, String ngay_bat_dau, String ngay_ket_thuc) {
        super();
        this.dien_tich = dien_tich;
        this.trang_thai = trang_thai;
        this.tang = tang;
        this.loai_van_phong = loai_van_phong;
        this.gia_tien = gia_tien;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    public User(int ma_mat_bang, String dien_tich, String trang_thai, String tang, String loai_van_phong, String gia_tien, String ngay_bat_dau, String ngay_ket_thuc) {
        super();
        this.ma_mat_bang = ma_mat_bang;
        this.dien_tich = dien_tich;
        this.trang_thai = trang_thai;
        this.tang = tang;
        this.loai_van_phong = loai_van_phong;
        this.gia_tien = gia_tien;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public int getma_mat_bang() {
        return ma_mat_bang;
    }
    public void setma_mat_bang(int ma_mat_bang) {
        this.ma_mat_bang = ma_mat_bang;
    }
    public String getdien_tich() {
        return dien_tich;
    }
    public void setdien_tich(String dien_tich) {
        this.dien_tich = dien_tich;
    }
    public String gettrang_thai() {
        return trang_thai;
    }
    public void settrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
    public String gettang() {
        return tang;
    }
    public void settang(String tang) {
        this.tang = tang;
    }
}
