package bai11;

import bai10.MyPoint;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            MyPoint p1 = new MyPoint(x, y);
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            MyPoint p2 = new MyPoint(x, y);
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            MyPoint p3 = new MyPoint(x, y);
            double a = p1.distance(p2);
            double b = p1.distance(p3);
            double c = p2.distance(p3);
            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("Không tạo thành tam giác.");
            } else {
                if (a == b && b == c) {
                    System.out.println("Tam giác đều.");
                } else if (a == b || b == c || a == c) {
                    if (a * a == b * b + c * c
                            || b * b == a * a + c * c
                            || c * c == b * b + a * a) {
                        System.out.println("Tam giác vuông cân.");
                    } else {
                        System.out.println("Tam giác cân.");
                    }
                } else if (a * a == b * b + c * c
                        || b * b == a * a + c * c
                        || c * c == b * b + a * a) {
                        System.out.println("Tam giác vuông.");
                } else {
                    System.out.println("Tam giác thường.");
                }
            }
        }
    }
}
