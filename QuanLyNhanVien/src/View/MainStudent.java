package View;

import Controller.StudentManager;
import Model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainStudent {
    public MainStudent() {
    }

    public void studentMain() {
        Scanner sc = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        studentManager.readFileObject();
        int choice;
        do{
            System.out.println("-------------------\n");
            System.out.println("============MENU============");
            System.out.println("" +
                    "1. Add Student\n" +
                    "2. Edit Student\n" +
                    "3. Delete Student\n" +
                    "4. Display all Student\n" +
                    "5. Search Student\n" +
                    "6. Display all Student sort by avgPoint\n" +
                    "7. Display the student has highest avgPoint\n" +
                    "8. Save information\n" +
                    "9. Read information\n" +
                    "");
            System.out.println("In put your choice: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    studentManager.creatStudent(sc);
                    break;
                case 2:
                    studentManager.editStudent(sc);
                    break;
                case 3:
                    studentManager.deleteStudent(sc);
                    break;
                case 4:
                    System.out.printf("%-5S%-25S%-15S%-15S%-15S%-15S%S\n","ID", "Name", "Age", "Math Point", "PhysicalPoint", "Chemical Point", "avgPoint");
                    studentManager.displayAllStudent();
                    break;
                case 5:
                    break;
                case 6:
                    studentManager.sortByAvgPoint();
                    break;
                case 7:
                    ArrayList<Student> studentMax = studentManager.findHighestPoint();
                    System.out.printf("%-15S%-15S%-15S%-15S%-15S%-15S%S\n","ID", "Name", "Age", "Math Point", "PhysicalPoint", "Chemical Point", "avgPoint");
                    for (Student student:studentMax) {
                        student.display();
                    }
                    break;
                case 8:
                    studentManager.saveFileByObject();
                    break;
                case 9:
                    studentManager.readFileObject();
                    break;
            }

        }while (choice!=0);
    }
}
