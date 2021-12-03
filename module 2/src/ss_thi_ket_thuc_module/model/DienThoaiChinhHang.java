package ss_thi_ket_thuc_module.model;

public class DienThoaiChinhHang extends Person{
    private int Thoigianbaohanh;
    private String Phamvibaohanh;

    public DienThoaiChinhHang() {

    }

    public DienThoaiChinhHang(int id, String Tendienthoai, int Giaban, int Soluong, String Nhasanxuat, int Thoigianbaohanh, String Phamvibaohanh) {
        super(id, Tendienthoai, Giaban, Soluong, Nhasanxuat);
        this.Thoigianbaohanh = Thoigianbaohanh;
        this.Phamvibaohanh = Phamvibaohanh;
    }

    public int getThoigianbaohanh() {
        return Thoigianbaohanh;
    }

    public void setThoigianbaohanh(int Thoigianbaohanh) {
        this.Thoigianbaohanh = Thoigianbaohanh;
    }

    public String getPhamvibaohanh() {
        return Phamvibaohanh;
    }

    public void setPhamvibaohanh(String Phamvibaohanh) {
        this.Phamvibaohanh = Phamvibaohanh;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", Tendienthoai='" + Tendienthoai + '\'' +
                ", Giaban=" + Giaban +
                ", Soluong=" + Soluong +
                ", Nhasanxuat='" + Nhasanxuat + '\'' +
                ", Thoigianbaohanh=" + Thoigianbaohanh +
                ", Phamvibaohanh='" + Phamvibaohanh + '\'';
    }

    @Override
    public void goToBy() {

    }
    //lấy thông tin để ghi file csv
    public String getInfoToCSV(){
        return this.id+ ","+ this.Tendienthoai+"," +this.Giaban+","+this.Soluong+","+this.Thoigianbaohanh+","+this.Phamvibaohanh;
    }
}
