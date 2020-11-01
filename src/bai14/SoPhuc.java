package bai14;

import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class SoPhuc {

    private float a;
    private float b;

    public SoPhuc() {
    }

    public SoPhuc(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public SoPhuc cong(SoPhuc sp) {
        float x = a + sp.a;
        float y = b + sp.b;
        return new SoPhuc(x, y);
    }

    public SoPhuc tru(SoPhuc sp) {
        float x = a - sp.a;
        float y = b - sp.b;
        return new SoPhuc(x, y);
    }

    public SoPhuc nhan(SoPhuc sp) {
        float x = a * sp.a - b * sp.b;
        float y = a * sp.b + sp.a * b;
        return new SoPhuc(x, y);
    }

    public SoPhuc chia(SoPhuc sp) {
        SoPhuc nd = sp.nghichDao();
        return this.nhan(nd);
    }

    public SoPhuc nghichDao() {
        float t = 1 / (a * a + b * b);
        float x = a * t;
        float y = -1 * b * t;
        return new SoPhuc(x, y);
    }

    public boolean bangNhau(SoPhuc sp) {
        return (a == sp.a) && (b == sp.b);
    }

    public boolean lonHon(SoPhuc sp) {
        return (a * a + b * b) > (sp.a * sp.a + sp.b * sp.b);
    }

    public boolean nhoHon(SoPhuc sp) {
        return (a * a + b * b) < (sp.a * sp.a + sp.b * sp.b);
    }

    public void hien() {
        if (b > 0) {
            System.out.println(a + "+j" + b);
        } else {
            System.out.println(a + "+j(" + b + ")");
        }
    }

    public void nhap() {
        Scanner in = new Scanner(System.in);
        String sp = in.next();
        String[] sps = sp.split("\\+");
        a = Float.parseFloat(sps[0]);
        b = Float.parseFloat(sps[1].substring(1));
    }
}
