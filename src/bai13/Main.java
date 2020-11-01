package bai13;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Nhập 2 phân số (ts/ms): ");
        PhanSo ps1 = new PhanSo();
        ps1.nhap();
        PhanSo ps2 = new PhanSo();
        ps2.nhap();
        System.out.println("Tong: ");
        ps1.cong(ps2).hien();
        System.out.println("Hieu: ");
        ps1.tru(ps2).hien();
        System.out.println("Tich: ");
        ps1.nhan(ps2).hien();
        System.out.println("Thuong: ");
        ps1.chia(ps2).hien();
        System.out.println("Tối giản phân số 1: ");
        ps1.toiGian().hien();
        System.out.println("Tối giản phân số 2: ");
        ps2.toiGian().hien();
        if (ps1.bangNhau(ps2)) {
            System.out.println("Hai phân số bằng nhau");
        } else if (ps1.lonHon(ps2)) {
            System.out.println("Phân số 1 lớn hơn phân số 2");
        } else if (ps1.nhoHon(ps2)) {
            System.out.println("Phân số 1 nhỏ hơn phân số 2");
        }
    }
}
