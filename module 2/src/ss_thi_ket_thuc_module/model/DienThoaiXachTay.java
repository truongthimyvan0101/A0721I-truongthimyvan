package ss_thi_ket_thuc_module.model;

import com.sun.org.apache.xpath.internal.operations.String;

public class DienThoaiXachTay extends Person {
    private String Quocgiaxachtay;
    private String Trangthai;

    public DienThoaiXachTay(int id, java.lang.String nokia_n72, int giaban, int soluong, java.lang.String nokia, java.lang.String china, java.lang.String sua_chua) {

    }

    public DienThoaiXachTay(int id, java.lang.String Tendienthoai, int Giaban, int Soluong, java.lang.String Nhasanxuat, String Quocgiaxachtay, String Trangthai) {
        super(id, Tendienthoai, Giaban, Soluong, Nhasanxuat);
        this.Quocgiaxachtay = Quocgiaxachtay;
        this.Trangthai = Trangthai;
    }

    public String getQuocgiaxachtay() {
        return Quocgiaxachtay;
    }

    public void setQuocgiaxachtay(String Quocgiaxachtay) {
        this.Quocgiaxachtay = Quocgiaxachtay;
    }

    public String getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }

    @Override
    public java.lang.String toString() {
        return "id=" + id +
                ", Tendienthoai='" + Tendienthoai + '\'' +
                ", Giaban=" + Giaban +
                ", Soluong=" + Soluong +
                ", Nhasanxuat='" + Nhasanxuat + '\'' +
                ", Quocgiaxachtay=" + Quocgiaxachtay +
                ", Trangthai='" + Trangthai + '\'';
    }

    @Override
    public void goToBy() {

    }

    public void Dienthoaixachtay() {
        System.out.println("Xach tay từ nước ngoài về");
    }
}