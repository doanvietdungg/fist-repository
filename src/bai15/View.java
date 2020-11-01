package bai15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Dao Cong Binh
 */
public class View {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------MENU---------");
        System.out.println("0.(Chức năng thêm)Thêm sinh viên vào danh sách sinh viên");
        System.out.println("1.Lấy sinh viên từ file SV.INT, hiển thị danh sách sinh viên");
        System.out.println("2.Sắp xếp sinh viên theo lớp (điểm TB giảm dần)");
        System.out.println("3.Phân loại sinh viên");
        System.out.println("4.Thoát");

        Controller controller = new Controller();
        int choice = scanner.nextInt();
        String svFileName = "SV.INP";
        String sxSVFileName = "SX.OUT";
        String xlSVFileName = "XL.OUT";

        ArrayList<SinhVien> sinhViens = new ArrayList<>();

        switch (choice) {
            case 0:
                String ten,
                 lop,
                 maSV;
                double dtb;
                do {
                    System.out.println("Nhập mã sinh viên (có 4 chữ số)");
                    maSV = scanner.next();
                } while (!maSV.matches("\\d{4}"));
                String[] strings;
                scanner.nextLine();
                do {
                    System.out.println("Nhập tên sinh viên (gồm họ và tên)");
                    ten = scanner.nextLine();
                    if (ten.length() == 0) {
                        System.out.println("Tên sinh viên không được để trống!");
                    }
                    strings = ten.trim().split(" ");
                } while (strings.length < 2);
                do {
                    System.out.println("Nhập tên lớp (vd:d18cqcn08-b)");
                    lop = scanner.nextLine();
                    if (lop.length() == 0) {
                        System.out.println("Tên lớp không được để trống!");
                    }
                    lop = lop.toUpperCase();
                } while (!lop.matches("^D\\d{2}[A-Z]{4}\\d{2}-B$") || lop.length() == 0);
                do {
                    System.out.println("Nhập điểm trung bình");
                    dtb = scanner.nextDouble();
                } while (dtb < 0 || dtb > 10);

                SinhVien sinhVien = new SinhVien(maSV, ten, lop, dtb);
                controller.writeToFile(sinhVien, svFileName);
                break;
            case 1:
                sinhViens = controller.readFromFile(svFileName);
                show(sinhViens);
                break;
            case 2:
                System.out.println("Danh sách sinh viên theo lớp"
                        + " (Sắp xếp theo điểm trung bình giảm dần)");
                sinhViens = controller.readFromFile(svFileName);
                HashSet<String> hashSet = new HashSet<>();
                for (SinhVien s : sinhViens) {
                    hashSet.add(s.getLop());
                }
                ArrayList<SinhVien> res = new ArrayList<>();
                TreeSet<String> tree = new TreeSet<>(hashSet);
                for (String lopString : tree) {
                    res = controller.filterandSortByClass(sinhViens, lopString);
                    show(res);
                    for (SinhVien st : res) {
                        controller.writeFileSX(st, sxSVFileName);
                    }
                }

                break;
            case 3:
                sinhViens = controller.readFromFile(svFileName);
                for (SinhVien s : sinhViens) {
                    controller.writeFileXL(s, xlSVFileName);
                }
                res = controller.readFileXL(xlSVFileName);
                controller.sortByName(res);
                for (SinhVien s : res) {
                    System.out.println(s + " " + s.getXl());
                }
                break;
            case 4:
                System.out.println("See you again!");
                break;
            default:
                break;
        }
    }

    private static void show(ArrayList<SinhVien> sinhViens) {
        for (SinhVien sinhVien : sinhViens) {
            System.out.println(sinhVien);
        }
    }
}
