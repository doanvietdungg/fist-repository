/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypoint;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Bai11 {
    public static boolean laTamGiac(double a, double b, double c){
        if(a+b<=c || a+c<=b || b+c<=a) return false;
        return true;
    }
    public static boolean laTamGiacVuong(double a, double b, double c){
        if(a>b && a>c) return (a*a==b*b+c*c);
        if(b>a && b>c) return (b*b==a*a+c*c);
        if(c>a && c>b) return (c*c==a*a+b*b);
        return false;
    }
    public static boolean laTamGiacCan(double a, double b, double c){
        return (a==b || a==c || b==c);
    }
    public static boolean laTamGiacDeu(double a, double b, double c){
        return (a==b && a==c);
    }
    public static boolean laTamGiacVuongCan(double a, double b, double c){
        if(laTamGiacVuong(a,b,c)){
            if(a==b || a==c || b==c) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Nhập tọa độ điểm A: ");
        System.out.print("x = ");
        double x1 = in.nextDouble();
        System.out.print("y = ");
        double y1 = in.nextDouble();
        MyPoint A = new MyPoint(x1, y1);
        
        System.out.println("Nhập tọa độ điểm B: ");
        System.out.print("x = ");
        double x2 = in.nextDouble();
        System.out.print("y = ");
        double y2 = in.nextDouble();
        MyPoint B = new MyPoint(x2, y2);
        
        System.out.println("Nhập tọa độ điểm C: ");
        System.out.print("x = ");
        double x3 = in.nextDouble();
        System.out.print("y = ");
        double y3 = in.nextDouble();
        MyPoint C = new MyPoint(x3, y3);
        
        double AB = A.distance(B);
        double AC = A.distance(C);
        double BC = B.distance(C);
        
        System.out.println(AB + " " + AC + " " + BC);
        if(laTamGiac(AB, AC, BC)){
            if(laTamGiacVuong(AB, AC, BC))
                System.out.println("Tam giác vuông");
            else if(laTamGiacCan(AB, AC, BC))
                System.out.println("Tam giác cân");
            else if(laTamGiacVuongCan(AB, AC, BC))
                System.out.println("Tam giác vuông cân");
            else if(laTamGiacDeu(AB, AC, BC))
                System.out.println("Tam giác đều ");
            else
                System.out.println("Tam giác thường");
        }
        else
            System.out.println("Không phải là tam giác");
    }
}
