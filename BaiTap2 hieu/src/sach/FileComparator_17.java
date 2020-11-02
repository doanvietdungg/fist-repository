/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sach;
import java.util.*;
/**
 *
 * @author Admin
 */
public class FileComparator_17 {
    static class sortByPrice implements Comparator<Sach> {
        @Override
        public int compare(Sach x, Sach y) {
            if(x.getGiaBan() > y.getGiaBan()) return 1;
            else if(x.getGiaBan() < y.getGiaBan()) return -1;
            else return 0;
        }        
    }
    
    static class sortByNameOfBook implements Comparator<Sach> {
        @Override
        public int compare(Sach x, Sach y) {
            return x.getTenSach().compareTo(y.getTenSach());
        }       
    }
}
