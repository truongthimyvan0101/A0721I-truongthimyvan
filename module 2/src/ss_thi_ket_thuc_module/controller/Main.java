package ss_thi_ket_thuc_module.controller;
import ss_thi_ket_thuc_module.service.PersonService;

import java.util.Scanner;

public class Main {
    static final int ADD =1;
    private static PersonService dienthoaiService = new PersonService();
    public static void main(String[] args) {
        boolean flag =true;
        do {
            System.out.println("Chọn chức năng cần thực hiên" +
                    "\n1.add" +
                    "\n2.delete" +
                    "\n3.see" +
                    "\n4.search"+
                    "\n5.Exit");
            Scanner scanner = new Scanner(System.in);
            int chooseMenu = scanner.nextInt();
            switch (chooseMenu){
                case 1:
                    dienthoaiService.add();
                    //code
                    break;
                case 2:
                    //code
                    System.out.println("chức năng delete");
                    dienthoaiService.delete();
                    break;
                case 3:
                    System.out.println("chức năng xem danh sach dien thoai");
                    dienthoaiService.see();
                    break;
                case 4:
                    System.out.println("chức năng search");
                    dienthoaiService.search();
                    break;
                default:
                    flag=false;
            }
        }while (flag);

    }
}
