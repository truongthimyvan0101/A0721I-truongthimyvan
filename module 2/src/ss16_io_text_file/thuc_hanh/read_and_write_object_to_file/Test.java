package ss16_io_text_file.thuc_hanh.read_and_write_object_to_file;
import java.io.IOException;
import java.util.List;
public class Test {
    public static void main(String[] args) {
        List<Student> students = null;
        try {
            students = FileUtils.readDataFromFile("C:\\A0721I1-truongthimyvan\\module 2\\src\\ss16_io_text_file\\thuc_hanh\\read_and_write_object_to_file\\file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student: students) {
            System.out.println(student);
        }

        try {
            FileUtils.writeDataToFile("C:\\A0721I1-truongthimyvan\\module 2\\src\\ss16_io_text_file\\thuc_hanh\\read_and_write_object_to_file\\file", students);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
