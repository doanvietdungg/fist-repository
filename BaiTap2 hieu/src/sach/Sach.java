/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;

/**
 *
 * @author Admin
 */
public class Sach {
    private int maSach;
    private String tenSach;
    private String chuyenNganh;
    private double giaBan;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String chuyenNganh, double giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.chuyenNganh = chuyenNganh;
        this.giaBan = giaBan;
    }

    public String getTenSach() {
        return tenSach;
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
    
    public boolean check(String ma_str, String ten, String nganh, String gia_str) {
        if(ma_str.trim().isEmpty() || ten.trim().isEmpty()
                || nganh.trim().isEmpty() || gia_str.trim().isEmpty()
                || !isNumberic(ma_str) || !isNumberic(gia_str))
            return false;
        if(Integer.parseInt(ma_str)<1000 || Integer.parseInt(ma_str)>9999)
            return false;
        if(Double.parseDouble(gia_str)<0)
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return maSach + "\t" + tenSach + "\t" + chuyenNganh + "\t" + giaBan;
    }
    
    
}
