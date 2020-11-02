/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_bai15;

/**
 *
 * @author Admin
 */
public class StudentPtit {   
    private int maSV;
    private String ten;
    private String lop;
    private double dtb;

    public StudentPtit() {
    }

    public StudentPtit(int maSV, String ten, String lop, double dtb) {
        this.maSV = maSV;
        this.ten = ten;
        this.lop = lop;
        this.dtb = dtb;
    }

    public int getMaSV() {
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
    
    private boolean isNumberic(String num) {
        if(num == null) return false;
        try{
            double d = Double.parseDouble(num);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    
    public boolean check(String maSV_str, String ten, String lop, String dtb_str) {
        if(maSV_str.trim().isEmpty() || !isNumberic(maSV_str) 
                || ten.trim().isEmpty() || lop.trim().isEmpty()
                || dtb_str.trim().isEmpty() || !isNumberic(dtb_str))
            return false;
        if(Integer.parseInt(maSV_str)<1000 || Integer.parseInt(maSV_str)>9999)
            return false;
        if(Double.parseDouble(dtb_str)<0 || Double.parseDouble(dtb_str)>10)
            return false;
        return true;
    }
    
    public String xepLoai(){
        if(dtb>8) return "Giỏi";
        else if(dtb>7 && dtb<8) return "Khá";
        else if(dtb>5 && dtb<7) return "Trung Bình";
        else return "Yếu";
    }
    
    public int xl(){
        if(this.xepLoai().equals("Giỏi")) return 1;
        else if(this.xepLoai().equals("Khá")) return 2;
        else if(this.xepLoai().equals("Trung Bình")) return 3;
        else return 4;
    }
    
    //Lay ten rieng
    public String getTen1(){
        StringBuilder str = new StringBuilder();
        int i = ten.length()-1;
        while(ten.charAt(i) != ' '){
            str.insert(0, ten.charAt(i));
            i--;
        }
        return str.toString();
    }
    
    //Lay ten dem
    public String getTen2(){
        StringBuilder str = new StringBuilder();
        int i = ten.length()-1;
        while(ten.charAt(i) != ' '){
            i--;
        }
        i--;
        while(ten.charAt(i) != ' '){
            str.insert(0, ten.charAt(i));
            i--;
        }
        return str.toString();
    }
    
    //Lay ho
    public String getTen3(){
        StringBuilder str = new StringBuilder();
        int i = ten.length()-1;
        while(ten.charAt(i) != ' '){
            i--;
        }
        i--;
        while(ten.charAt(i) != ' '){
            i--;
        }
        i--;
        while(ten.charAt(i) != ' '){
            str.insert(0, ten.charAt(i));
            i--;
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return maSV + "\t" + ten + "\t" + lop + "\t" + dtb;
    }
    
    
}
