package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class ThietKeMenuChoUngDung {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the square");
            System.out.println("3. Draw the rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Draw the triangle");
                    for (int i = 6; i>=1; i--){
                        for (int j = 1; j<=i; j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for (int i=1; i<=6; i++){
                        System.out.println("* * * * * *");
                    }
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    for (int i=1; i<=3; i++){
                        System.out.println("* * * * * *");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
