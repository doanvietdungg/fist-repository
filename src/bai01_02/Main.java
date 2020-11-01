package bai01_02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dao Cong Binh
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tạo một sinh viên (mã, tên, lớp, khóa) :");
        String id = scanner.next();
        id = id.toUpperCase();
        scanner.nextLine();
        String name = scanner.nextLine();
        name = chuanHoa(name);
        String className = scanner.next();
        className = className.toUpperCase();
        int garde = scanner.nextInt();
        Student student = new Student(id, name, className, garde);
        System.out.println(student);
        //yeu cau 2:
        System.out.println("Nhập số lượng sinh vien: ");
        int n = scanner.nextInt();
        List<Student> list = new ArrayList<>();
        while (n-- > 0) {
            System.out.println("Tạo sinh viên (mã, tên, lớp, khóa) :");
            id = scanner.next();
            id = id.toUpperCase();
            scanner.nextLine();
            name = scanner.nextLine();
            name = chuanHoa(name);
            className = scanner.next();
            className = className.toUpperCase();
            garde = scanner.nextInt();
            Student s = new Student(id, name, className, garde);
            list.add(s);
        }
        show(list);
        list = sortByName(list);
        show(list);
        System.out.println("Nhập tên lớp");
        String classFind = scanner.next();
        list = findClass(list, classFind);
        show(list);
    }

    private static List<Student> sortByName(List<Student> list) {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String name1 = o1.getName().trim();
                String name2 = o2.getName().trim();
                String n1 = name1.substring(name1.lastIndexOf(" "));
                String n2 = name2.substring(name2.lastIndexOf(" "));
                return n1.compareTo(n2);
            }
        });
        return list;
    }

    private static void show(List<Student> list) {
        System.out.println("Danh sach sinh vien: ");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    private static List<Student> findClass(List<Student> list, String classFind) {
        classFind = classFind.toUpperCase();
        List<Student> students = new ArrayList<>();
        for (Student student : list) {
            if (student.getClassName().equals(classFind)) {
                students.add(student);
            }
        }
        return students;
    }

    private static String chuanHoa(String s) {
        s = s.toLowerCase();
        String res = "";
        String[] strings = s.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > 0) {
                res += Character.toUpperCase(strings[i].charAt(0))
                        + strings[i].substring(1) + " ";
            }
        }
        return res;
    }

}
