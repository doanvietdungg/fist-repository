/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_bai15;
import java.util.*;
/**
 *
 * @author Admin
 */
public class FieldCompartors {
    static class sortByClass implements Comparator<StudentPtit> {
        @Override
        public int compare(StudentPtit x, StudentPtit y) {
            return x.getLop().compareTo(y.getLop());
        }       
    }
    
    static class sortByPoint implements Comparator<StudentPtit> {
        @Override
        public int compare(StudentPtit x, StudentPtit y) {
            if(x.getDtb() > y.getDtb()) return 1;
            else if(x.getDtb() < y.getDtb()) return -1;
            else return 0;
        }        
    }
    
    static class sortByFirstName implements Comparator<StudentPtit> {
        @Override
        public int compare(StudentPtit x, StudentPtit y) {
            return x.getTen1().compareTo(y.getTen1());
        }       
    }
    
    static class sortByMiddleName implements Comparator<StudentPtit> {
        @Override
        public int compare(StudentPtit x, StudentPtit y) {
            return x.getTen2().compareTo(y.getTen2());
        }       
    }
    
    static class sortByLastName implements Comparator<StudentPtit> {
        @Override
        public int compare(StudentPtit x, StudentPtit y) {
            return x.getTen3().compareTo(y.getTen3());
        }       
    }
    
    static class sortByRank implements Comparator<StudentPtit> {
        @Override
        public int compare(StudentPtit x, StudentPtit y) {
            if(x.xl() > y.xl()) return 1;
            else if(x.xl() < y.xl()) return -1;
            else return 0;
        }        
    }
}
