package ss10_danh_sach.bai_tap.trien_khai_phuong_thuc_arraylist;

public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayLists = new MyArrayList<Integer>();
        myArrayLists.add(1);
        myArrayLists.add(2);
        myArrayLists.add(4);
        myArrayLists.add(5);
        myArrayLists.add(2,3);
        for (int i = 0; i < myArrayLists.size(); i++){
            System.out.println(myArrayLists.get(i));
        }
    }
}
