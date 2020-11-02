/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc;
import java.util.*;
/**
 *
 * @author Admin
 */
public class FileComparator_18 {
    static class sapXepTheoSoTinChi implements Comparator<MonHoc> {
        @Override
        public int compare(MonHoc x, MonHoc y) {
            if(x.getSoTinchi() > y.getSoTinchi()) return 1;
            else if(x.getSoTinchi() < y.getSoTinchi()) return -1;
            else return 0;
        }      
    }
    
    static class sapXepTheoTenMon implements Comparator<MonHoc> {
        @Override
        public int compare(MonHoc x, MonHoc y) {
            return x.getTenMon().compareTo(y.getTenMon());
        }      
    }
}
