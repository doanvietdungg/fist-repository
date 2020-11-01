package bai18;

/**
 *
 * @author Dao Cong Binh
 */
public class MonHoc {
    private int maMon;
    private String ten;
    private String nhom;
    private int soTC;

    public MonHoc() {
    }

    public MonHoc(int maMon, String ten, String nhom, int soTC) {
        this.maMon = maMon;
        this.ten = ten;
        this.nhom = nhom;
        this.soTC = soTC;
    }

    public int getMaMon() {
        return maMon;
    }

    public String getTen() {
        return ten;
    }

    public String getNhom() {
        return nhom;
    }

    public int getSoTC() {
        return soTC;
    }

    @Override
    public String toString() {
        return "maMon=" + maMon + "  ten=" + ten + "  nhom=" + nhom + "  soTC=" + soTC;
    }
    
}
