/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanso;

/**
 *
 * @author Admin
 */
public class Bai13 {
    public static void main(String[] args) {
        System.out.println("Nhập phân số 1: ");
        PhanSo ps1 = new PhanSo();
        ps1.nhap();
        System.out.println("Nhập phân số 2: ");
        PhanSo ps2 = new PhanSo();      
        ps2.nhap();
        
        System.out.println("Tổng của 2 phân số = " + ps1.cong(ps2));
        System.out.println("Hiệu của 2 phân số = " + ps1.tru(ps2));
        System.out.println("Tích của 2 phân số = " + ps1.nhan(ps2));
        System.out.println("Thương của 2 phân số = " + ps1.chia(ps2));
               
        ps1.rutGon();
        ps2.rutGon();
        if(ps1.lonHon(ps2)) 
            System.out.println(ps1.toString() + " > "  + ps2.toString());
        else if(ps1.nhoHon(ps2))
            System.out.println(ps1.toString() + " < "  + ps2.toString());
        else if(ps1.bangNhau(ps2))
            System.out.println(ps1.toString() + " = "  + ps2.toString());
    }
}
