package bai15;

/**
 *
 * @author Dao Cong Binh
 */
public class SinhVien {

    private String maSV;
    private String ten;
    private String lop;
    private double dtb;
    private String xl;

    public SinhVien() {
    }

    public SinhVien(String maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
        String status;
        if (dtb > 8) {
            status = "Gioi";
        } else if (dtb > 7) {
            status = "Kha";
        } else if (dtb > 5) {
            status = "Trung binh";
        } else {
            status = "Yeu";
        }
        this.xl = status;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public double getDtb() {
        return dtb;
    }

    public String getXl() {
        return xl;
    }

    @Override
    public String toString() {
        return "maSV=" + maSV + " ten=" + ten + " lop=" + lop + " dtb=" + dtb;
    }

}
