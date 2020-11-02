/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

/**
 *
 * @author Admin
 */
public class MatHang {
    private int maHang;
    private String ten;
    private String nhom;
    private double giaBan;

    public MatHang() {
    }

    public MatHang(int maHang, String ten, String nhom, double giaBan) {
        this.maHang = maHang;
        this.ten = ten;
        this.nhom = nhom;
        this.giaBan = giaBan;
    }

    public int getMaHang() {
        return maHang;
    }
    public String getTen() {
        return ten;
    }
    public String getNhom() {
        return nhom;
    }
    public double getGiaBan() {
        return giaBan;
    }
    
    private boolean isNumberic(String num){
        if(num == null) return false;
        try{
            double d = Double.parseDouble(num);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public boolean check(String ma_str, String ten, String nhom, String gia_str) {
        if(ma_str.trim().isEmpty() || !isNumberic(ma_str)
                || ten.trim().isEmpty() || nhom.trim().isEmpty()
                || gia_str.trim().isEmpty() || !isNumberic(gia_str))
            return false;
        if(Integer.parseInt(ma_str)<1000 || Integer.parseInt(ma_str)>9999)
            return false;
        if(Double.parseDouble(gia_str)<0)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return maHang + "\t" + ten + "\t" + nhom + "\t" + giaBan;
    }
    
    
}
