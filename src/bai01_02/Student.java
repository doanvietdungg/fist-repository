package bai01_02;

/**
 *
 * @author Dao Cong Binh
 */
public class Student {

    private String id;
    private String name;
    private String className;
    private int grade;

    public Student() {
    }

    public Student(String id, String name, String className, int grade) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", className="
                + className + ", grade=" + grade + '}';
    }

}
