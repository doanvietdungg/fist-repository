/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sophuc;

/**
 *
 * @author Admin
 */
public class Bai14 {
    public static void main(String[] args) {
        System.out.println("Nhập số phức 1: ");
        SoPhuc sp1 = new SoPhuc();
        sp1.nhap();
        System.out.println("Nhập số phức 2: ");
        SoPhuc sp2 = new SoPhuc();
        sp2.nhap();
        
        System.out.println("Tổng 2 số phức là: "); sp1.cong(sp2).hienThi();
        System.out.println("Hiệu 2 số phức là: "); sp1.tru(sp2).hienThi();
        System.out.println("Tích 2 số phức là: "); sp1.nhan(sp2).hienThi();
        System.out.println("Thương 2 số phức là: "); sp1.chia(sp2).hienThi();
        
        SoPhuc a = sp1.nghichDao();
        SoPhuc b = sp2.nghichDao();
        System.out.println("Nghịch đảo của số phức 1 là: " + a.toString());
        System.out.println("Nghịch đảo của số phức 2 là: " + b.toString());
        System.out.println("Kết quả so sánh là: ");
        if(a.lonHon(b)) 
            System.out.println(a.toString() + " lớn hơn " + b.toString());
        else if(a.nhoHon(b))
            System.out.println(a.toString() + " nhỏ hơn " + b.toString());
        else if(a.bangNhau(b))
            System.out.println(a.toString() + " bằng " + b.toString());
    }
}
