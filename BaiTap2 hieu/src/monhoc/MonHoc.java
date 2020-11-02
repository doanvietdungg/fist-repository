/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc;

/**
 *
 * @author Admin
 */
public class MonHoc {
    private int maMon;
    private String tenMon;
    private String nhomMon;
    private int soTinchi;
    
    public MonHoc() {
    }

    public MonHoc(int maMon, String tenMon, String nhomMon, int soTinchi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.nhomMon = nhomMon;
        this.soTinchi = soTinchi;
    }
    
    public int getSoTinchi() {
        return soTinchi;
    }
    public String getTenMon() {
        return tenMon;
    }
    
    private boolean isNumberic(String num){
        if(num == null)
            return false;
        try{
            double d = Double.parseDouble(num);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public boolean check(String ma_str, String ten, String nhom, String soTin_str) {
        if(ma_str.trim().isEmpty() || ten.trim().isEmpty()
                || ten.trim().isEmpty() || soTin_str.trim().isEmpty()
                || !isNumberic(ma_str) || !isNumberic(soTin_str))
            return false;
        if(Integer.parseInt(ma_str)<1000 || Integer.parseInt(ma_str)>9999)
            return false;
        if(Integer.parseInt(soTin_str)<=0 || Integer.parseInt(soTin_str)>=7)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return maMon + "\t" + tenMon + "\t" + nhomMon + "\t" + soTinchi;
    }
    
    
}
