package bai16;

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
        System.out.println("1.Hiển thị mặt hàng có trong file");
        System.out.println("2.Sắp xếp mặt hàng theo giá bán và lưu vào file");
        System.out.println("3.Hiển thị danh sách mặt hàng theo nhóm và lưu vào file");
        System.out.println("4.Thoát");
        int choice = scanner.nextInt();

        String matHangFileName = "MH.INT";
        String giaBanFileName = "SXH.OUT";
        String nhomFileName = "NHOM.OUT";

        ArrayList<MatHang> matHangs = new ArrayList<>();
        Controller controller = new Controller();
        switch (choice) {
            case 1:
                matHangs = controller.readFromFile(matHangFileName);
                show(matHangs);
                break;
            case 2:
                matHangs = controller.readFromFile(matHangFileName);
                controller.sortByPrice(matHangs);
                for (MatHang m : matHangs) {
                    controller.writeToFile(m, giaBanFileName);
                }
                show(matHangs);
                break;
            case 3:
                matHangs = controller.readFromFile(matHangFileName);
                HashSet<String> set = new HashSet<>();
                for (MatHang matHang : matHangs) {
                    set.add(matHang.getNhom());
                }
                ArrayList<MatHang> res = new ArrayList<>();
                for (String tenNhom : set) {
                    res = controller.filterByGroup(matHangs, tenNhom);
                    show(res);
                    for (MatHang m : res) {
                        controller.writeToFile(m, nhomFileName);
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

    private static void show(ArrayList<MatHang> matHangs) {
        for (MatHang matHang : matHangs) {
            System.out.println(matHang);
        }
    }
}
