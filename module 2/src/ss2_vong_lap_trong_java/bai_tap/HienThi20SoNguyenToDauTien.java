package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of prime number that you want to print to screen");
        int n = scanner.nextInt();
        int count = 0, i = 2;
        String primeNumberString = "";
        while (count < n){
            boolean check = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                count++;
                primeNumberString += i + " ";
            }
            i++;
        }
        System.out.println(primeNumberString);
    }
}
