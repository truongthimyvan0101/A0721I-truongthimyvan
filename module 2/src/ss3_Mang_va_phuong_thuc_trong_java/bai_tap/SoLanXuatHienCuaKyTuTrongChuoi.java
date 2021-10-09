package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter a character: ");
        char character = scanner.nextLine().charAt(0);
        int count = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++){
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == character){
                count++;
            }
        }

        System.out.println("\nThe number of character " + character + " is " + count);
    }
}
