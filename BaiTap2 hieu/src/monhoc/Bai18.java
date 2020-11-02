/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc;
import java.util.*;
import java.io.*;
import monhoc.FileComparator_18.*;
/**
 *
 * @author Admin
 */
public class Bai18 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("MONHOC.INP");
        Scanner in = new Scanner(file);
        ArrayList<MonHoc> ds = new ArrayList<>();
        String m, t, n, tc;
        
        while(in.hasNextLine()){
            MonHoc mh = new MonHoc();
            m = in.nextLine();
            t = in.nextLine();
            n = in.nextLine();
            tc = in.nextLine();
            if(mh.check(m, t, n, tc)){
                ds.add(new MonHoc(Integer.parseInt(m), t, n, Integer.parseInt(tc)));
            }
        }
        
        //In ds mon hoc ra man hinh
        for (MonHoc d : ds) {
            System.out.println(d);
        }
        
        //3. Sx ds mon hoc theo so tin chi giam dan va in ra mon hinh
        System.out.println("3.--------------------------------------");
        Collections.sort(ds, new sapXepTheoSoTinChi().reversed());
        for (MonHoc d : ds) {
            System.out.println(d);
        }
        //In ra file
        PrintWriter printWriter = new PrintWriter(new File("SX_MONHOC.OUT"));
        for (MonHoc d : ds) {
            printWriter.println(d);
        }
        printWriter.close();
        
        //4. Sx ds mon hoc theo ten mon hoc va in ra mon hinh
        System.out.println("3.--------------------------------------");
        Collections.sort(ds, new sapXepTheoTenMon());
        for (MonHoc d : ds) {
            System.out.println(d);
        }
        //In ra file
        PrintWriter printWriter1 = new PrintWriter(new File("NHOM_MONHOC.OUT"));
        for (MonHoc d : ds) {
            printWriter1.println(d);
        }
        printWriter1.close();
    }   
}
