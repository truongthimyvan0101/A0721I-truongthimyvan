package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TongCacSoCuaCotMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do{
            System.out.print("Enter the number of row: ");
            row = scanner.nextInt();
        }while (row <= 0);

        do{
            System.out.print("Enter the number of col ");
            col = scanner.nextInt();
        }while (col <= 0);

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print("arr[" + i + "][" + j + "]: ");
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Enter a column that you want to make total: ");
        int k = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < row; i++){
            sum += arr[i][k];
        }
        System.out.println("The total of" + " k column in matrix is " + sum);
    }
    }
