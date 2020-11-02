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
public class Bai10 {
    public static void main(String[] args) {
        MyPoint[] a = new MyPoint[100];
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Nhập số lượng tọa độ (n>1): ");
        do{
            n = in.nextInt();
        }while(n<2);
        double max=0;
        for(int z=1;z<=n;z++){
            System.out.println("Nhập tọa độ x, y: ");
            System.out.print("x = ");
            double x = in.nextDouble();
            System.out.print("y = ");
            double y = in.nextDouble();
            a[z] = new MyPoint(x, y);
        }
        int p=0, q=0;
        for(int i=1;i<n;i++){
            if(max < a[i].distance(a[i+1])){
                max = a[i].distance(a[i+1]);
                p=i; q=i+1;
            }
        }  
        System.out.println("Hai tọa độ là: " 
                            + a[p].toString() + ", " + a[q].toString());
        System.out.println("Khoảng cách lớn nhất giữa 2 tọa độ là: " + max);
    }
}
