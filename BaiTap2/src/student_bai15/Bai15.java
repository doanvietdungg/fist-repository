/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_bai15;
import java.util.*;
import java.io.*;
import student_bai15.FieldCompartors.*;
/**
 *
 * @author Admin
 */
public class Bai15 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("SV.INP");
        Scanner in = new Scanner(file);
        ArrayList<StudentPtit> ds = new ArrayList<>();
        String m, t, k, d;
        
        //Nhap du lieu va luu vao mang
        while(in.hasNext()){
            StudentPtit s = new StudentPtit();
            m = in.nextLine();
            t = in.nextLine();
            k = in.nextLine();
            d = in.nextLine();
            if(s.check(m, t, k, d)) {
                ds.add(new StudentPtit(Integer.parseInt(m), t, k, Double.parseDouble(d)));
            }
        }
        
        //In danh sach SV da nhap ra man hinh
        for (StudentPtit sv : ds) {
                System.out.println(sv);
        }
        
        //Sap xep ds sinh vien theo lop va hien thi ds sinh vien theo tung lop
        System.out.println("3--------------------------");
        Collections.sort(ds, new lop().thenComparing(new inDtb().reversed()));
        for (StudentPtit sv : ds) {
            System.out.println(sv);
        }
        
        //In 3. vao file SX.OUT
        PrintWriter printWriter = new PrintWriter(new File("SX.OUT"));
        for (StudentPtit sv : ds) {
            printWriter.println(sv);
        }
        printWriter.close();
        
        //Phan loai SV theo 4 muc
        System.out.println("4--------------------------");
        Collections.sort(ds, new inXepLoai().thenComparing(new Ten1().
                thenComparing(new Ten2().thenComparing(new Ten3()))));
        for (StudentPtit sv : ds) {
            System.out.print(sv.xepLoai() + "\t");
            System.out.println(sv);
        }
        
        //In 4. vao file XEPLOAI.OUT    
        PrintWriter printWriter1 = new PrintWriter(new File("XEPLOAI.OUT"));
        for (StudentPtit sv : ds) {
            printWriter1.print(sv.xepLoai() + "\t");
            printWriter1.println(sv);
        }
        printWriter1.close();
    }
}
