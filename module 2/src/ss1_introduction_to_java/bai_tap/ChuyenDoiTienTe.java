package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.println("Enter the USD currency: ");
        int usd = scanner.nextInt();
        int vnd = usd * rate;
        System.out.println("The number of money after converting to vnd is "+ vnd+ " VND");
    }
}
