/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phanso;
import java.util.*;
/**
 *
 * @author Admin
 */
public class PhanSo {
    private int tu;
    private int mau;

    public PhanSo() {
        this.tu=0;
        this.mau=1;
    }

    public PhanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }
    
    private int usc(int a, int b){
        while(b>0){
            int temp = a%b; a=b; b=temp;
        }
        return a;
    }
    
    public boolean isToiGian() {
        return usc(this.tu, this.mau)==1;
    }
    
    public void rutGon() {
        int a = usc(this.tu, this.mau);
        this.tu = this.tu/a;
        this.mau = this.mau/a;
    }
    
    public void quyDong(PhanSo p) {
        int mc = this.mau*p.mau/usc(this.mau, p.mau);
        this.tu = mc/this.mau*this.tu; this.mau = mc;
        p.tu = mc/p.mau*p.tu; p.mau = mc;
    }
    
    public PhanSo cong(PhanSo ps2) {
        this.quyDong(ps2);
        PhanSo sum = new PhanSo();
        sum.tu = this.tu+ps2.tu;
        sum.mau = this.mau;
        if(!sum.isToiGian()) sum.rutGon();
        return sum;
    }
    
    public PhanSo tru(PhanSo ps2) {
        boolean checkAm = false;
        this.quyDong(ps2);
        PhanSo sub = new PhanSo();
        sub.tu = this.tu-ps2.tu;
        sub.mau = this.mau;
        if(sub.tu < 0){
            checkAm = true;
            sub.tu = -sub.tu;
        }
        if(!sub.isToiGian()) sub.rutGon();
        if(checkAm==true) sub.tu = -sub.tu;
        return sub;
    }
    
    public PhanSo nhan(PhanSo ps2) {
        PhanSo mul = new PhanSo();
        mul.tu = this.tu*ps2.tu;
        mul.mau = this.mau*ps2.mau;
        if(!mul.isToiGian()) mul.rutGon();
        return mul;
    }
    
    public PhanSo chia(PhanSo ps2) {
        PhanSo div = new PhanSo();
        div.tu = this.tu*ps2.mau;
        div.mau = this.mau*ps2.tu;
        if(!div.isToiGian()) div.rutGon();
        return div;
    }
    
    public PhanSo nghichDao() {
        PhanSo nd = new PhanSo();
        nd.tu = this.mau;
        nd.mau = this.tu;
        if(!nd.isToiGian()) nd.rutGon();
        return nd;
    }
    
    public PhanSo doiDau() {
        PhanSo dd = new PhanSo();
        dd.tu = -this.tu;
        dd.mau = this.mau;
        if(!dd.isToiGian()) dd.rutGon();
        return dd;
    }
    
    public boolean bangNhau(PhanSo ps2) {        
        if(!this.isToiGian()) this.rutGon();
        if(!ps2.isToiGian()) ps2.rutGon();
        return this.tu==ps2.tu && this.mau==ps2.mau;
    }
    
    public boolean lonHon(PhanSo ps2) {        
        this.quyDong(ps2);
        return this.tu>ps2.tu && this.mau==ps2.mau;
    }
    
    public boolean nhoHon(PhanSo ps2) {        
        this.quyDong(ps2);
        return this.tu<ps2.tu && this.mau==ps2.mau;
    }
        
    @Override
    public String toString() {
        return tu + "/" + mau;
    }
    
    public void hienThi() {
        System.out.println(tu + "/" + mau);
    }
    
    public void nhap() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập tử số: ");
        this.tu = in.nextInt();
        System.out.println("Nhập mẫu số: ");
        this.mau = in.nextInt();
    }
}
