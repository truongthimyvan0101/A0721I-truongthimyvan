package ss3_Mang_va_phuong_thuc_trong_java.thuc_hanh;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static void main(String[] args) {
        int arr[] = {1, 4, 7, 99, 0, 19, -1};
        System.out.println("The min value in array is " + arr[minValue(arr)]);

    }
    public static int minValue(int[] arr){
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] < arr[index]){
                index = i;
            }
        }
        return index;
    }
}
