/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Admin
 */
import java.util.*;
public class Bai2 {
    public static void main(String[] args) {
        List<Student> listA = new ArrayList<>(); //Câu a
        List<Student> listB = new ArrayList<>(); //Câu b
        List<Student> listC = new ArrayList<>(); //Câu c
        Scanner in = new Scanner(System.in);
        System.out.println("Enter quantity student: "); //số lượng SV
        int t = in.nextInt();
        for(int z=1;z<=t;z++) {
            System.out.println("Enter person " + z);
            Student s = new Student();
            s.initStudent();
            listA.add(new Student(s.getId(), s.getName(), s.getGrade(), s.getCourse()));
            listB.add(new Student(s.getId(), s.getName(), s.getGrade(), s.getCourse()));
            listC.add(new Student(s.getId(), s.getName(), s.getGrade(), s.getCourse()));
        }
        /* In câu a */
        System.out.println("Câu a: ");
        for(Student s1: listA) {
            System.out.println(s1.toString());
        }
        
        /* In câu b */
        Collections.sort(listB, new SortByName());
        System.out.println("Câu b: ");
        for(Student s2: listB) {
            System.out.println(s2.toString());
        }
        
    }
}
