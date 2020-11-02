/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;
import java.util.*;
import java.io.*;
import sach.FileComparator_17.*;
/**
 *
 * @author Admin
 */
public class Bai17 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("SACH.INP");
        Scanner in = new Scanner(file);
        ArrayList<Sach> ds = new ArrayList<>();
        String m, t, n, g;
        
        while(in.hasNextLine()){
            Sach s = new Sach();
            m = in.nextLine();
            t = in.nextLine();
            n = in.nextLine();
            g = in.nextLine();
            if(s.check(m, t, n, g)){
                ds.add(new Sach(Integer.parseInt(m), t, n, Double.parseDouble(g)));
            }
        }
        
        //In ra man hinh ds cuon sach
        for (Sach d : ds) {
            System.out.println(d);
        }
        
        //Sap xep ds theo gia giam dan in ra man hinh
        System.out.println("3.------------------------");
        Collections.sort(ds, new sortByPrice().reversed());
        for (Sach d : ds) {
            System.out.println(d);
        }
        //In ra file SX_SACH.OUT
        PrintWriter printWriter = new PrintWriter(new File("SX_SACH.OUT"));
        for (Sach d : ds) {
            printWriter.println(d);
        }
        printWriter.close();
        
        //Sap xep ds theo gia giam dan in ra man hinh
        System.out.println("4.------------------------");
        Collections.sort(ds, new sortByNameOfBook());
        for (Sach d : ds) {
            System.out.println(d);
        }
        //In ra file CN.OUT
        PrintWriter printWriter1 = new PrintWriter(new File("CN.OUT"));
        for (Sach d : ds) {
            printWriter1.println(d);
        }
        printWriter1.close();
    }
}
