package ss4_lop_va_doi_tuong_trong_java.bai_tap.XayDungLopStopWatch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[10000000];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = (int) (Math.random()*10000000);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Arrays.sort(numbers);
        stopWatch.stop();
        System.out.println("milliseconds: " + stopWatch.getElapsedTime());
    }
}
