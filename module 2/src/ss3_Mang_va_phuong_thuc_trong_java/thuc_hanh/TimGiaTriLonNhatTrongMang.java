package ss3_Mang_va_phuong_thuc_trong_java.thuc_hanh;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int[] arr = {1, 5, -3, 6, 8, 12, 100};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("The max number in the array is " + max);
    }
}
