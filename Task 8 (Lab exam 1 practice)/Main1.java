import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

class Course {
    String courseName;
    ArrayList<Student> students;

    Course(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }

    public void addStudent(String name, double marks) {
        students.add(new Student(name, marks));
    }

    public String getHighestScorer() {
        if (students.isEmpty()) {
            return "No students";
        }

        Student highest = students.get(0);

        for (Student s : students) {
            if (s.marks > highest.marks) {
                highest = s;
            }
        }

        return highest.name + " (" + (int) highest.marks + ")";
    }


    public int countTopGrades(double threshold) {
        int count = 0;
        for (Student s : students) {
            if (s.marks >= threshold) {
                count++;
            }
        }
        return count;
    }
}

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String courseName = sc.next();

        Course course = new Course(courseName);
        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        while (n > 0) {
            n--;
            String name = sc.next();
            double marks = sc.nextDouble();
            course.addStudent(name, marks);
        }

        System.out.println("Highest Scorer: " + course.getHighestScorer());
        System.out.println("Number of A+ (80+): " + course.countTopGrades(80));

        sc.close();
    }
}
