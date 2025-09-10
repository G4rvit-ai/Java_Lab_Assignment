import java.util.Scanner;

// Task 1: Student Class

class Student 
{
    String rollNo;
    String name;
    String course;
    double marks;
    String grade;
    Scanner sc = new Scanner(System.in);

    public void inputStudent() 
	{
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Course: ");
        course = sc.nextLine();

        System.out.print("Enter Marks: ");
        marks = sc.nextDouble();
        sc.nextLine(); 
       
        calculateGrade();
    }

    public void calculateGrade() 
	{
        if (marks >= 90) 
		{
            grade = "A+";
        }
		else if (marks >= 80) 
		{
            grade = "A";
        } 
		else if (marks >= 70) 
		{
            grade = "B";
        } 
		else if (marks >= 60) 
		{
            grade = "C";
        } 
		else if (marks >= 50) 
		{
            grade = "D";
        } 
		else 
		{
            grade = "F";
        }
    }

    public void displayStudent() 
	{
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }
}


// Task 2: Student Management System Class

class StudentManagementSystem 
{
    Student[] studentList;
    int count;  

    public void initializeSystem(int size) 
	{
        studentList = new Student[size];
        count = 0;
    }

    public void addStudent() 
	{
        if (count >= studentList.length) 
		{
            System.out.println("Sorry, cannot add more students. Limit reached!");
            return;
        }

        Student s = new Student();
        s.inputStudent();
        studentList[count] = s;
        count++;

        System.out.println("Student added successfully!");
    }

    public void displayAllStudents() 
	{
        if (count == 0) 
		{
            System.out.println("No records found. Please add students first.");
            return;
        }

        System.out.println("\n====== Student Records ======");
        for (int i = 0; i < count; i++) {
            studentList[i].displayStudent();
        }
    }
}

// Task 3: Main Driver Class

public class Main 
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        System.out.print("Enter the maximum number of students you want to store: ");
        int size = sc.nextInt();
        sc.nextLine();  
        sms.initializeSystem(size);

        int choice;
        do 
		{
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) 
			{
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    System.out.println("Exiting program... Bye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}

