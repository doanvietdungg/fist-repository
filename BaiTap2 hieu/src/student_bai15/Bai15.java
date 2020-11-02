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
        String m, t, l, d;
        
        while(in.hasNextLine()){
            StudentPtit s = new StudentPtit();
            m = in.nextLine();
            t = in.nextLine();
            l = in.nextLine();
            d = in.nextLine();
            if(s.check(m, t, l, d)){
                ds.add(new StudentPtit(Integer.parseInt(m), t, l, Double.parseDouble(d)));
            }
        }
        
        //2. In ds sv da nhap ra man hinh
        for (StudentPtit sv : ds) {
            System.out.println(sv);
        }
        
        //3.Sap xep theo lop, dtb in ra man hinh
        System.out.println("3.-----------------------");
        Collections.sort(ds, new sortByClass().thenComparing(new sortByPoint().reversed()));
        for (StudentPtit sv : ds) {
            System.out.println(sv);
        }
        
        //3.Sap xep theo lop, dtb in vao file SX.OUT
        PrintWriter printWriter = new PrintWriter(new File("SX.OUT"));
        for (StudentPtit sv : ds) {
            printWriter.println(sv);
        }
        printWriter.close();
        
        //4. Phan loai SV, sap xep theo ten SV va in ra man hinh
        System.out.println("4.-----------------------");
        Collections.sort(ds, new sortByRank().thenComparing(new sortByFirstName().
           thenComparing(new sortByLastName().thenComparing(new sortByMiddleName()))));
        for (StudentPtit sv : ds) {
            System.out.print(sv.xepLoai() + "\t");
            System.out.println(sv);
        }
        
        //4. Phan loai SV, sap xep theo ten SV va in ra file
        PrintWriter printWriter1 = new PrintWriter(new File("XEPLOAI.OUT"));
        for (StudentPtit sv : ds) {
            printWriter1.print(sv.xepLoai() + "\t");
            printWriter1.println(sv);
        }
        printWriter1.close();
    }
}
