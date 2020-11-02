/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;
import static java.lang.System.in;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Bai12 {  
    public static void sumAndSubMatrix(Scanner in) {
        System.out.println("Nhập số hàng: ");
        int row1 = in.nextInt();
        System.out.println("Nhập số cột: ");
        int col1 = in.nextInt();
        Matrix m1 = new Matrix(row1, col1);
        m1.init();
        System.out.println("Nhập số hàng: ");
        int row2 = in.nextInt();
        System.out.println("Nhập số cột: ");
        int col2 = in.nextInt();
        Matrix m2 = new Matrix(row2, col2);
        m2.init();
        
        if(m1.checkInAddAndSub(m2)){
            Matrix resSum = m1.add(m2);
            System.out.println("Tổng 2 ma trận là: ");
            resSum.print();
            Matrix resSub = m1.sub(m2);
            System.out.println("Hiệu 2 ma trận là: ");
            resSub.print();
        }
        else
            System.out.println("Không hợp lệ, mời nhập lại.");
    }
    
    public static void mulMatrix(Scanner in) {
        System.out.println("Nhập số hàng: ");
        int row1 = in.nextInt();
        System.out.println("Nhập số cột: ");
        int col1 = in.nextInt();
        Matrix m1 = new Matrix(row1, col1);
        m1.init();
        System.out.println("Nhập số hàng: ");
        int row2 = in.nextInt();
        System.out.println("Nhập số cột: ");
        int col2 = in.nextInt();
        Matrix m2 = new Matrix(row2, col2);
        m2.init();
        
        if(m1.checkInMul(m2)){
            Matrix resMul = m1.mul(m2);
            System.out.println("Tích 2 ma trận là: ");
            resMul.print();
        }
        else
            System.out.println("Không hợp lệ, mời nhập lại.");
    }
    
    public static void maTranChuyenVi(Scanner in) {
        System.out.println("Nhập số hàng: ");
        int row = in.nextInt();
        System.out.println("Nhập số cột: ");
        int col = in.nextInt();
        Matrix m = new Matrix(row, col);
        m.init();
        
        Matrix resTranspose = m.transpose();
        System.out.println("Ma trận chuyển vị là: ");
        resTranspose.print();
    }
               
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
        System.out.println("Chương trình có các mục menu: ");
        System.out.println("1. Tính tổng và hiệu hai ma trận.");
        System.out.println("2. Tính tích hai ma trận.");
        System.out.println("3. Tìm chuyển vị của một ma trận.");
        System.out.println("4. Kết thúc chương trình.");
            int n = in.nextInt();
            if(n==4) return;
            switch(n){
                case 1: 
                    sumAndSubMatrix(in);
                    break;
                case 2: 
                    mulMatrix(in);
                    break;
                case 3:
                    maTranChuyenVi(in);
                    break;
            }
        }
    }
}
