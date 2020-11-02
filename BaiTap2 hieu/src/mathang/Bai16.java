/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;
import java.util.*;
import java.io.*;
import mathang.FileComparator_16.*;
/**
 *
 * @author Admin
 */
public class Bai16 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("MH.INP");
        Scanner in = new Scanner(file);
        ArrayList<MatHang> ds = new ArrayList<>();
        String m, t, n, g;
        
        while(in.hasNextLine()){
            MatHang mh = new MatHang();
            m = in.nextLine();
            t = in.nextLine();
            n = in.nextLine();
            g = in.nextLine();
            if(mh.check(m, t, n, g)){
                ds.add(new MatHang(Integer.parseInt(m), t, n, Double.parseDouble(g)));
            }
        }
        
        //In ds mat hang ra man hinh
        for (MatHang d : ds) {
                System.out.println(d);
        }
        
        //Sap xep theo gia giam dan va ghi ds ra man hinh
        System.out.println("3.--------------------------");
        Collections.sort(ds, new sortByPrice().reversed());
        for (MatHang d : ds) {
            System.out.println(d);
        }
        //In vao file SX.OUT
        PrintWriter printWriter = new PrintWriter(new File("SX.OUT"));
        for (MatHang d : ds) {
            printWriter.println(d);
        }
        printWriter.close();
        
        //Sap xep theo gia giam dan va ghi ds ra man hinh
        System.out.println("4.--------------------------");
        Collections.sort(ds, new sortByGroup());
        for (MatHang d : ds) {
            System.out.println(d);
        }
        //In vao file SX.OUT
        PrintWriter printWriter1 = new PrintWriter(new File("NHOM.OUT"));
        for (MatHang d : ds) {
            printWriter1.println(d);
        }
        printWriter1.close();
    }
}
