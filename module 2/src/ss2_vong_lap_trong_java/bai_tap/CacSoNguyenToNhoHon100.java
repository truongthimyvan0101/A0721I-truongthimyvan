package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class CacSoNguyenToNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number that you want to print a prime number that is smaller than the number you entered: ");
        int n = scanner.nextInt();
        int i = 2;
        String primeNumberString = "";
        while (i < n){
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNumberString += i +" ";
            }
            i++;
        }
        System.out.println(primeNumberString);
    }
}
