package bai12;

import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------MENU----------");
        System.out.println("1.Tính tổng và hiệu của 2 ma trận");
        System.out.println("2.Tính tích của 2 ma trận");
        System.out.println("3.Tìm chuyển vị của một ma trận");
        System.out.println("4.Thoát");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Nhập kích thước ma trận: ");
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                System.out.println("Nhập 2 ma trận: ");
                Matrix x = new Matrix(m, n);
                x.input();
                Matrix y = new Matrix(m, n);
                y.input();
                System.out.println("Tổng 2 ma trận là: ");
                Matrix sum = x.add(y);
                sum.print();
                System.out.println("Hiệu 2 ma trận là: ");
                Matrix sub = x.sub(y);
                sub.print();
                break;
            case 2:
                System.out.println("Nhập kích thước ma trận thứ nhất: ");
                m = scanner.nextInt();
                n = scanner.nextInt();
                x = new Matrix(m, n);
                System.out.println("Ma trận 1: ");
                x.input();
                System.out.println("Nhập kích thước ma trận thứ hai: ");
                m = scanner.nextInt();
                n = scanner.nextInt();
                y = new Matrix(m, n);
                System.out.println("Ma trận 2: ");
                y.input();
                Matrix mulMatrix = x.mul(y);
                System.out.println("Tích 2 ma trận là: ");
                mulMatrix.print();
                break;
            case 3:
                System.out.println("Nhập kích thước ma trận: ");
                m = scanner.nextInt();
                n = scanner.nextInt();
                x = new Matrix(m, n);
                System.out.println("Nhập ma trận X: ");
                x.input();
                System.out.println("Ma trận chuyển vị của X la: ");
                x.transpose().print();
                break;
            case 4:
                System.out.println("Cảm ơn đã dùng dịch vụ!");
                break;
            default:
                System.out.println("Chọn không đúng! Vui lòng chọn lại!");
                break;
        }
    }
}
