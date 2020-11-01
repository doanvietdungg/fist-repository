package bai10;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<MyPoint> list = new ArrayList<>();
        while (n-- > 0) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            list.add(new MyPoint(x, y));
        }
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint();
        double m = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (m < MyPoint.distance(list.get(i), list.get(j))) {
                    m = MyPoint.distance(list.get(i), list.get(j));
                    p1 = list.get(i);
                    p2 = list.get(j);
                }
            }
        }
        System.out.println("Điểm thứ nhất: (" + p1.getX() + ";" + p1.getY() +")" );
        System.out.println("Điểm thứ hai: (" + p2.getX() + ";" + p2.getY() +")" );
        System.out.println("Khoảng cách: " + m);
    }
}
