/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;
import java.util.*;
/**
 *
 * @author Admin
 */
public class FileComparator_16 {
    static class sortByPrice implements Comparator<MatHang> {
        @Override
        public int compare(MatHang x, MatHang y) {
            if(x.getGiaBan() > y.getGiaBan()) return 1;
            else if(x.getGiaBan() < y.getGiaBan()) return -1;
            else return 0;
        }  
        
    }
    
    static class sortByGroup implements Comparator<MatHang> {
        @Override
        public int compare(MatHang x, MatHang y) {
            return x.getNhom().compareTo(y.getNhom());
        }        
    }
}
