package bai14;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Nhập 2 số phức (a+jb): ");
        SoPhuc sp1 = new SoPhuc();
        SoPhuc sp2 = new SoPhuc();
        sp1.nhap();
        sp2.nhap();
        System.out.println("Tổng 2 số phức là: ");
        sp1.cong(sp2).hien();
        System.out.println("Hiệu 2 số phức là: ");
        sp1.tru(sp2).hien();
        System.out.println("Tích 2 số phức là: ");
        sp1.nhan(sp2).hien();
        System.out.println("Thương 2 số phức là: ");
        sp1.chia(sp2).hien();
        System.out.println("Nghịch đảo của số phức thứ nhất: ");
        sp1.nghichDao().hien();
        System.out.println("Nghịch đảo của số phức thứ hai: ");
        sp2.nghichDao().hien();
        if (sp1.bangNhau(sp2)) {
            System.out.println("Hai số phức bằng nhau");
        } else if (sp1.lonHon(sp2)) {
            System.out.println("Số phức thứ nhất lớn hơn số phức thứ hai");
        } else if (sp1.nhoHon(sp2)) {
            System.out.println("Số phức thứ nhất nhỏ hơn số phức thứ hai");
        }
    }
}
