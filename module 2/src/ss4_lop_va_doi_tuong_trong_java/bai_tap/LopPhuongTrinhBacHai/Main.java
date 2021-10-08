package ss4_lop_va_doi_tuong_trong_java.bai_tap.LopPhuongTrinhBacHai;

public class Main {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation(0,0,0);
        quadraticEquation.display();
        quadraticEquation.setA(2);
        quadraticEquation.setB(4);
        quadraticEquation.setC(-2);
        quadraticEquation.display();
    }
}
