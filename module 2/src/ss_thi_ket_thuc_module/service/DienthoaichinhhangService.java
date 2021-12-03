package ss_thi_ket_thuc_module.service;

import ss_thi_ket_thuc_module.model.DienThoaiChinhHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienthoaichinhhangService {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void add(){
        /// code thêm mới
        System.out.println("nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("nhập tên");
        String Tendienthoai = scanner.nextLine();
        System.out.println("nhập gia ban");
        int Giaban = Integer.parseInt(scanner.nextLine());
        System.out.println("nhap so luong");
        int Soluong= Integer.parseInt(scanner.nextLine());
        System.out.println("nhap nha xuat ban");
        String Nhasanxuat = scanner.nextLine();
        System.out.println("nhap thoi gian bao hanh");
        int Thoigianbaohanh = Integer.parseInt(scanner.nextLine());
        System.out.println("nhap Pham vi bao hanh");
        String Phamvibaohanh = scanner.nextLine();
        DienThoaiChinhHang Dienthoaichinhhang = new DienThoaiChinhHang(id, Tendienthoai, Giaban, Soluong, Nhasanxuat, Thoigianbaohanh, Phamvibaohanh);
        List<DienThoaiChinhHang> DienthoaichinhhangList = new ArrayList<>();
        boolean add = DienthoaichinhhangList.add(Dienthoaichinhhang);
        ReadAndWriteFile.writeStudentListToCSV(DienthoaichinhhangList,true);
    }

    @Override
    public void delete(){
        System.out.println("chọn dien thoai cần xóa");
        int index = Integer.parseInt(scanner.nextLine());
        List<DienThoaiChinhHang> DienthoaichinhhangtList = ReadAndWriteFile.readDienthoaichinhhangListFromCSV();
        DienthoaichinhhangtList.remove(index-1);
        ReadAndWriteFile.writeStudentListToCSV(DienthoaichinhhangtList,false);
    }
    @Override
    public void see(){
        System.out.println("chọn điện thoại cần xem");
        int index = Integer.parseInt(scanner.nextLine());
        List<DienThoaiChinhHang> DienthoaichinhhangList = ReadAndWriteFile.readDienthoaichinhhangListFromCSV();
        System.out.println("nhập tên cần sửa");
        String nameNew= scanner.nextLine();
        DienThoaiChinhHang.get(index-1).setTendienthoai(searchByTendienthoai());
        ReadAndWriteFile.writeStudentListToCSV(studentList,false);
    }
    public void searchByTendienthoai(){
        System.out.println("nhập tên cần tìm kiếm");
        String searchTendienthoai = scanner.nextLine();
        List<DienThoaiChinhHang> DienthoaichinhhangList = ReadAndWriteFile.readDienthoaichinhhangListFromCSV();
        for (DienThoaiChinhHang student: DienthoaichinhhangList){
            if (student.getTendienthoai().contains(searchTendienthoai)){// tìm kiếm gần đúng
                System.out.println(DienThoaiChinhHang.toString());
            }
        }
    }
}
