/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectange;

/**
 *
 * @author Admin
 */
import java.util.*;

public class Rectange {

    Scanner in = new Scanner(System.in);
    private double width; //chiều rộng HCN
    private double height;//chiều dài HCN
    private String color; //màu HCN

    public Rectange() {
        this.height = 1.0;
        this.width = 1.0;
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double findArea(double width, double height) {//diện tích HCN
        return width*height;
    }

    public double findPerimeter(double width, double height) {//chu vi HCN
        return 2*(width+height);
    }

    public void initRectange() {//hàm khởi tạo
        do {
            System.out.println("Enter width: ");
            width = in.nextDouble();
            System.out.println("Enter height: ");
            height = in.nextDouble();
        } while (this.width > this.height);
        in.nextLine();
        System.out.println("Enter color: ");
        color = in.nextLine();
    }

    @Override
    public String toString() {
        return "Rectange {" + "Width: " + width
                + ", Height: " + height + ", Color: " + color + "}";
    }

    public void printAreaAndPerimeter() {
        System.out.println("Area's rectange = " + findArea(width, height));
        System.out.println("Perimeter's rectange = " + findPerimeter(width, height));
    }
}
