/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;
import java.util.*;
import student.FileComparator.*;
/**
 *
 * @author Admin
 */
public class Bai2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(); //Câu a
        Scanner in = new Scanner(System.in);
        System.out.println("Enter quantity student: "); //số lượng SV
        int t = in.nextInt();
        for(int z=1;z<=t;z++) {
            System.out.println("Enter person " + z);
            Student s = new Student();
            s.initStudent();
            list.add(new Student(s.getId(), s.getName(), s.getGrade(), s.getCourse()));
        }
        /* In câu a */
        System.out.println("Câu a: In toàn bộ danh sách ra màn hình");
        for(Student s1: list) {
            System.out.println(s1.toString());
        }
        
        /* In câu b */
        Collections.sort(list, new sortByNameOfStudent());
        System.out.println("Câu b: Sắp xếp danh sách theo tên sinh viên");
        for(Student s2: list) {
            System.out.println(s2.toString());
        }
        
        /* In cao c */
        Collections.sort(list, new sortByGrade());
        System.out.println("Câu c: Sắp xếp danh sách theo lớp");
        for(Student s3: list) {
            System.out.println(s3.toString());
        }
        
    }
}
