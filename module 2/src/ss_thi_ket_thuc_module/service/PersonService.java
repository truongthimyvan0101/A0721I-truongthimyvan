package ss_thi_ket_thuc_module.service;

import ss_thi_ket_thuc_module.model.DienThoaiChinhHang;
import ss_thi_ket_thuc_module.model.DienThoaiXachTay;
import ss_thi_ket_thuc_module.model.Person;

import java.util.Scanner;

public class PersonService implements IService {
    private Scanner scanner = new Scanner(System.in);
    public static Person[] personList = new Person[100];
    static {
        personList[0]=new DienThoaiChinhHang(1,"Samsung S9",1000000,10,"Samsung",365,"Toan Quoc");
        personList[1]=new DienThoaiChinhHang(2,"IphoneX",2000000, 10,"Apple",365,"Quoc Te");
        personList[2]=new DienThoaiXachTay(3,"Nokia N72",1000000, 10, "Nokia", "china","Da Sua chua");
        personList[3]=new DienThoaiXachTay(3,"Iphone 11", 6000000, 10, "Nokia","USA", "Chua sua chua");
    }

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void see() {

    }

    @Override
    public void search() {

    }

    @Override
    public void edit() {

    }

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        personService.add();
    }
}
