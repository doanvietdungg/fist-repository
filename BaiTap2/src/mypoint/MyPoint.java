/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypoint;

/**
 *
 * @author Admin
 */
public class MyPoint {
    private double x; //tọa độ x
    private double y; //tọa độ y

    public MyPoint() {
        x=0;
        y=0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public MyPoint(MyPoint p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    
    public double distance(MyPoint secondPoint){
        double a = this.x - secondPoint.x;
        double b = this.y - secondPoint.y;
        return Math.sqrt(a*a+b*b);
    }
    
    public double distance(MyPoint p1, MyPoint p2){
        double a = p1.x - p2.x;
        double b = p1.y - p2.y;
        return Math.sqrt(a*a+b*b);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")"; 
    }
    
    
}
