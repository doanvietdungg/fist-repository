package bai03;

import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tạo hình chữ nhật (width, height, color):");
        double width, height;
        do {
            width = scanner.nextDouble();
            if (width <= 0) {
                System.out.println("Chiều dài phải lớn hơn 0! Nhập lại!");
            }
        } while (width <= 0);
        do {
            height = scanner.nextDouble();
            if (height <= 0) {
                System.out.println("Chiều rộng phải lớn hơn 0! Nhập lại!");
            }
        } while (height <= 0);
        scanner.nextLine();
        String color = scanner.nextLine();
        Rectangle rec = new Rectangle(width, height, color);
        System.out.println(rec);
        System.out.println("Diện tích: " + rec.findArea());
        System.out.println("Chu vi: " + rec.findPerimeter());
    }
}
