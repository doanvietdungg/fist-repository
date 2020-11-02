/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;
import java.util.*;
/**
 *
 * @author Admin
 */
public class FileComparator {
    static class sortByNameOfStudent implements Comparator<Student> {
        @Override
        public int compare(Student x, Student y) {
            return x.getName().compareTo(y.getName());
        }       
    }
    
    static class sortByGrade implements Comparator<Student> {
        @Override
        public int compare(Student x, Student y) {
            return x.getGrade().compareTo(y.getGrade());
        }       
    }
}
