package ss_thi_ket_thuc_module.model;

public abstract class Person {
    protected int id;
    protected String Tendienthoai;
    protected int Giaban;
    protected int Soluong;
    protected String Nhasanxuat;

    public Person() {
    }

    public Person(int id, String Tendienthoai, int Giaban, int Soluong, String Nhasanxuat) {
        this.id = id;
        this.Tendienthoai = Tendienthoai;
        this.Giaban = Giaban;
        this.Soluong = Soluong;
        this.Nhasanxuat = Nhasanxuat;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendienthoai() {
        return Tendienthoai;
    }

    public void setTendienthoai(String Tendienthoai) {
        this.Tendienthoai = Tendienthoai;
    }

    public int getGiaban() {
        return Giaban;
    }

    public void setGiaban(int Giaban) {
        this.Giaban = Giaban;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public String getNhasanxuat() {
        return Nhasanxuat;
    }

    public void setNhasanxuat(String Nhasanxuat) {
        this.Nhasanxuat = Nhasanxuat;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", Tendienthoai='" + Tendienthoai + '\'' +
                ", Giaban=" + Giaban + '\'' +
                ", Soluong=" + Soluong + '\'' +
                ", Nhasanxuat='" + Nhasanxuat + '\'' +
                '}';
    }
    public abstract void goToBy();
}
