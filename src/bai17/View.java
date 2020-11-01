package bai17;

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
        System.out.println("1.Hiển thị sách có trong file");
        System.out.println("2.Sắp xếp sách theo giá bán và lưu vào file");
        System.out.println("3.Hiển thị sách theo chuyên ngành và lưu vào file");
        System.out.println("4.Thoát");

        int choice = scanner.nextInt();
        Controller controller = new Controller();

        ArrayList<Sach> sachs = new ArrayList<>();

        switch (choice) {
            case 1:
                sachs = controller.readFile("SACH.INP");
                show(sachs);
                break;
            case 2:
                sachs = controller.readFile("SACH.INP");
                controller.sortByPrice(sachs);
                for (Sach sach : sachs) {
                    controller.writeToFile(sach, "SXS.OUT");
                }
                show(sachs);
                break;
            case 3:
                sachs = controller.readFile("SACH.INP");
                HashSet<String> set = new HashSet<>();
                for (Sach s : sachs) {
                    set.add(s.getChuyenNghanh());
                }
                ArrayList<Sach> res = new ArrayList<>();
                for (String cn : set) {
                    res = controller.locChuyenNganh(sachs, cn);
                    show(res);
                    for (Sach s : res) {
                        controller.writeToFile(s, "CN.OUT");
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

    private static void show(ArrayList<Sach> sachs) {
        for (Sach sach : sachs) {
            System.out.println(sach);
        }
    }
}
