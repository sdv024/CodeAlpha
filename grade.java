import java.util.*;
class Student
{
    String name;
    double[] grades;
    int gradeCount;
    public Student(String name, int maxGrades)
    {
        this.name = name;
        this.grades = new double[maxGrades];
        this.gradeCount = 0;
    }
    public String getName()
    {
        return name;
    }
    public void addGrade(double grade)
    {
        if (grade < 0 || grade > 100)
        {
            System.out.println("Grade must be between 0 and 100.");
            return;
        }
        if (gradeCount < grades.length)
        {
            grades[gradeCount] = grade;
            gradeCount++;
        }
        else
        {
            System.out.println("Cannot add more grades. Maximum limit reached.");
        }
    }

    public double calculateAverage()
    {
        if (gradeCount == 0)
        {
            return 0.0;
        }
        double sum = 0;
        for (int i = 0; i < gradeCount; i++)
        {
            sum += grades[i];
        }
        return sum / gradeCount;
    }

    public void displayGrades()
    {
        System.out.print("Grades for " + name + ": ");
        for (int i = 0; i < gradeCount; i++)
        {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
    }
}

class GradeTracker
{
     Student[] students;
     int studentCount;

    public GradeTracker(int maxStudents)
    {
        this.students = new Student[maxStudents];
        this.studentCount = 0;
    }

    public void addStudent(Student student)
    {
        if (studentCount < students.length)
        {
            students[studentCount] = student;
            studentCount++;
        }
        else
            System.out.println("Cannot add more students. Maximum limit reached.");
    }

    public Student getStudent(String name)
    {
        for (int i = 0; i < studentCount; i++)
            if (students[i].getName().equalsIgnoreCase(name))
                return students[i];
        return null;
    }

    public void displayAllStudents()
    {
        System.out.println("All Students:");
        for (int i = 0; i < studentCount; i++)
            System.out.println(students[i].getName());
    }
}

class Main
{
    public static void main(String[] args)
    {
        final int MAX_STUDENTS = 100;
        final int MAX_GRADES = 10;

        GradeTracker tracker = new GradeTracker(MAX_STUDENTS);
        Scanner scanner = new Scanner(System.in);
        int choice=0;

        do
        {
            System.out.println("\nGrade Tracker Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Display Student Grades");
            System.out.println("4. Display Student Average");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice)
                {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        tracker.addStudent(new Student(name, MAX_GRADES));
                        break;
                    case 2:
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();
                        Student student = tracker.getStudent(name);
                        if (student != null)
                        {
                            System.out.print("Enter grade: ");
                            if (scanner.hasNextDouble())
                            {
                                double grade = scanner.nextDouble();
                                student.addGrade(grade);
                            }
                            else
                            {
                                System.out.println("Invalid grade input.");
                                scanner.next();
                            }
                        }
                        else
                            System.out.println("Student not found.");
                        break;
                    case 3:
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();
                        student = tracker.getStudent(name);
                        if (student != null)
                            student.displayGrades();
                        else
                            System.out.println("Student not found.");
                        break;
                    case 4:
                        System.out.print("Enter student name: ");
                        name = scanner.nextLine();
                        student = tracker.getStudent(name);
                        if (student != null)
                            System.out.println("Average grade for " + name + ": " + student.calculateAverage());
                        else
                            System.out.println("Student not found.");
                        break;
                    case 5:
                        tracker.displayAllStudents();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            else
            {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        while (choice != 6);
    }
}
