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
public class Student {
    Scanner in = new Scanner(System.in);
    private String id;     //mã SV
    private String name;   //tên
    private String grade;  //lớp
    private String course; //khóa học    

    /* dùng ở bài 1 */
    public Student() {
    }
    
    /* dùng ở bài 2 */
    public Student(String id, String name, String grade, String course) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }
    
    public void initStudent(){
        System.out.println("Enter ID number: ");
        this.id = in.next();
        in.nextLine();
        System.out.println("Enter name's student: ");
        this.name = in.nextLine();
        System.out.println("Enter grade's student: ");
        this.grade = in.next();
        System.out.println("Enter course's student: ");
        this.course = in.next();

    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + grade + "\t" + course;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    public String getCourse() {
        return course;
    }
    
}
