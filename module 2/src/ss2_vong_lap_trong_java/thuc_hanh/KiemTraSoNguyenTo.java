package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number that you want to check the prime number: ");
        int number = scanner.nextInt();
        boolean check = true;
        for (int i=2; i<=Math.sqrt(number); i++){
            if(number%i == 0){
                check = false;
                break;
            }
        }
        if(check){
            System.out.println(number + " is a prime number");
        }else {
            System.out.println(number + " is not a prime umber");
        }
    }
}
