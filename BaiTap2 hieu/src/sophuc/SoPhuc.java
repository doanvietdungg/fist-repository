/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sophuc;
import java.util.*;
/**
 *
 * @author Admin
 */
public class SoPhuc {
    private float a;
    private float b;

    public SoPhuc() {
        this.a = 0;
        this.b = 0;
    }

    public SoPhuc(float thuc, float ao) {
        this.a = thuc;
        this.b = ao;
    }
    
    public SoPhuc cong(SoPhuc sp2) {
        SoPhuc sum = new SoPhuc();
        sum.a = this.a + sp2.a;
        sum.b = this.b + sp2.b;
        return sum;
    }
    
    public SoPhuc tru(SoPhuc sp2) {
        SoPhuc sub = new SoPhuc();
        sub.a = this.a - sp2.a;
        sub.b = this.b - sp2.b;
        return sub;
    }
    
    public SoPhuc nhan(SoPhuc sp2) {
        SoPhuc mul = new SoPhuc();
        mul.a = this.a*sp2.a - this.b*sp2.b;
        mul.b = this.a*sp2.b + this.b*sp2.a;
        return mul;
    }
    
    public SoPhuc chia(SoPhuc sp2) {
        SoPhuc div = new SoPhuc();
        SoPhuc a = sp2.nghichDao();
        div = this.nhan(a);
        return div;
    }
    
    public SoPhuc nghichDao() {
        SoPhuc nd = new SoPhuc();
        nd.a = this.a/(a*a+b*b);
        nd.b = -this.b/(a*a+b*b);
        return nd;
    }
    
    private float modul() {
        return (float) Math.sqrt(a*a+b*b);
    }
    
    public boolean bangNhau(SoPhuc sp2) {
        return this.modul()==sp2.modul();
    }
    
    public boolean lonHon(SoPhuc sp2) {
        return this.modul()>sp2.modul();
    }
    
    public boolean nhoHon(SoPhuc sp2) {
        return this.modul()<sp2.modul();
    }
    
    public void hienThi() {
        System.out.print(a);
        if(this.b>0) System.out.println(" + " + b + "i");
        else if(this.b<0) System.out.println(" - " + -b + "i");
        else if(this.b==0) System.out.println("");
    }
    
    public void nhap() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập phần thực: ");
        a = in.nextInt();
        System.out.println("Nhập phần ảo: ");
        b = in.nextInt();
    }

    @Override
    public String toString() {
        return a + " + " + b + 'i';
    }
    
}
