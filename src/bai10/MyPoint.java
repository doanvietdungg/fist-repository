package bai10;

/**
 *
 * @author Dao Cong Binh
 */
public class MyPoint {

    private double x;
    private double y;

    public MyPoint() {
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MyPoint(MyPoint mp) {
        this.x = mp.x;
        this.y = mp.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint mp) {
        double a = (mp.x - x) * (mp.x - x) + (mp.y - y) * (mp.y - y);
        return Math.sqrt(a);
    }

    static double distance(MyPoint p1, MyPoint p2) {
        double a = (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
        return Math.sqrt(a);
    }
}
