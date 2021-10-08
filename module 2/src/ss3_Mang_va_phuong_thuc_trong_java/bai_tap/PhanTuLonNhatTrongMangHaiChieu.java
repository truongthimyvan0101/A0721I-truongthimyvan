package ss3_Mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class PhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row,col;
        do{
            System.out.print("Enter the number of row of matrix: ");
            row = scanner.nextInt();
        }while (row <= 0);

        do {
            System.out.print("Enter the number of column of matrix: ");
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

        int max = arr[0][0];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }

        System.out.println("The max value of two dimensional array is " + max);
    }
}
