package ss3_Mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 17, 23, 6, 9, 0, -1};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number that you want to check: ");
        int k = scanner.nextInt();
        boolean isExist = false;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == k){
                System.out.println("there is an element " + k + " in the array and the first position it appears is " + i);
                isExist = true;
            }
        }
        if (!isExist){
            System.out.println("There is not an element " + k + " in the array");
        }
    }
}
