package bai18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class View {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Hiển thị danh sách môn học");
        System.out.println("2.Sắp xếp danh sách môn học theo tín chỉ");
        System.out.println("3.Hiển thị danh sách môn học theo nhóm và lưu vào file");
        System.out.println("4.Thoát");
        int choice = scanner.nextInt();

        Controller controller = new Controller();

        String fileMonHoc = "MH.INP";
        String fileSX = "SXMH.OUT";
        ArrayList<MonHoc> monHocs = new ArrayList<>();
        switch (choice) {
            case 1:
                monHocs = controller.readMHFromFile(fileMonHoc);
                show(monHocs);
                break;
            case 2:
                monHocs = controller.readMHFromFile(fileMonHoc);
                controller.sortByTC(monHocs);
                for (MonHoc m : monHocs) {
                    controller.writeToFile(m, fileSX);
                }
                show(monHocs);
                break;
            case 3:
                monHocs = controller.readMHFromFile(fileMonHoc);
                HashSet<String> set = new HashSet<>();
                set.add("Cơ bản");
                set.add("Cơ sở ngành");
                set.add("Chuyên ngành");
                set.add("Kỹ năng mềm");
                ArrayList<MonHoc> res = new ArrayList<>();
                for (String nhom : set) {
                    res = controller.locNhomMH(monHocs, nhom);
                    show(res);
                    for (MonHoc s : res) {
                        controller.writeToFile(s, "NHOMMH.OUT");
                    }
                }
                break;
            case 4:
                System.out.println("See you later!");
                break;
            default:
                break;
        }
    }

    private static void show(ArrayList<MonHoc> monHocs) {
        for (MonHoc monHoc : monHocs) {
            System.out.println(monHoc);
        }
    }
}
