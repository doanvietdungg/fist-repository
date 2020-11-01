package bai13;

import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class PhanSo {

    private int ts;
    private int ms;

    public PhanSo() {
        ts = 0;
        ms = 1;
    }

    public PhanSo(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }

    public PhanSo toiGian() {
        int a = ts;
        int b = ms;
        if (a < 0) {
            a *= -1;
        }
        if (b < 0) {
            b *= -1;
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return new PhanSo(ts / a, ms / a);
    }

    public PhanSo cong(PhanSo ps) {
        int a = ts * ps.ms + ms * ps.ts;
        int b = ms * ps.ms;
        PhanSo p = new PhanSo(a, b);
        return p.toiGian();
    }

    public PhanSo tru(PhanSo ps) {
        int a = ts * ps.ms - ms * ps.ts;
        int b = ms * ps.ms;
        if (a != 0) {
            PhanSo p = new PhanSo(a, b);
            return p.toiGian();
        }
        return new PhanSo();
    }

    public PhanSo nhan(PhanSo ps) {
        int a = ts * ps.ts;
        int b = ms * ps.ms;
        PhanSo p = new PhanSo(a, b);
        return p.toiGian();
    }

    public PhanSo chia(PhanSo ps) {
        int a = ts * ps.ms;
        int b = ms * ps.ts;
        PhanSo p = new PhanSo(a, b);
        return p.toiGian();
    }

    public PhanSo nghichDao() {
        PhanSo p = new PhanSo(ms, ts);
        return p.toiGian();
    }

    public PhanSo doiDau() {
        if (ts * ms < 0) {
            if (ts < 0) {
                ts *= -1;
            } else if (ms < 0) {
                ms *= -1;
            }
        } else {
            if (ts > 0) {
                ts *= -1;
            } else {
                ms *= -1;
            }
        }
        PhanSo p = new PhanSo(ts, ms);
        return p;
    }

    public boolean bangNhau(PhanSo ps) {
        this.toiGian();
        ps.toiGian();
        return ts * ps.ms == ms * ps.ts;
    }

    public boolean lonHon(PhanSo ps) {
        this.toiGian();
        ps.toiGian();
        return ts * ps.ms > ms * ps.ts;
    }

    public boolean nhoHon(PhanSo ps) {
        this.toiGian();
        ps.toiGian();
        return ts * ps.ms < ms * ps.ts;
    }

    public void hien() {
        System.out.println(ts + "/" + ms);
    }

    public void nhap() {
        Scanner in = new Scanner(System.in);
        do {
            String p = in.next();
            String[] ps = p.split("/");
            ts = Integer.parseInt(ps[0]);
            ms = Integer.parseInt(ps[1]);
            if (ms == 0) {
                System.out.println("Mẫu số khác 0! Nhập lại!");
            }
        } while (ms == 0);

    }
}
