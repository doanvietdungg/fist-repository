package bai17;

/**
 *
 * @author Dao Cong Binh
 */
public class Sach {
    private int maSach;
    private String ten;
    private String chuyenNghanh;
    private double gia;

    public Sach() {
    }

    public Sach(int maSach, String ten, String chuyenNghanh, double gia) {
        this.maSach = maSach;
        this.ten = ten;
        this.chuyenNghanh = chuyenNghanh;
        this.gia = gia;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTen() {
        return ten;
    }

    public String getChuyenNghanh() {
        return chuyenNghanh;
    }

    public double getGia() {
        return gia;
    }

    @Override
    public String toString() {
        return "maSach=" + maSach + "  ten=" + ten + "  chuyenNghanh=" + chuyenNghanh + "  gia=" + gia;
    }
    
    
}
