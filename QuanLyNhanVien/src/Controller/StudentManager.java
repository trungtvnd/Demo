package Controller;

import Model.Student;

import java.io.*;
import java.util.*;

public class StudentManager {
    private static int ID;
    private ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public StudentManager(ArrayList<Student> students) {
    }

    public void displayAllStudent() {
        sortById();
        for (Student student : students) {
            System.out.println(student.displayInformation());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void creatStudent(Scanner sc) {
        sc.nextLine();
        System.out.println("Input name");
        String name = sc.nextLine();

        System.out.println("Input age: ");
        int age = sc.nextInt();

        System.out.println("Input Math point: ");
        double mathPoint = sc.nextDouble();

        System.out.println("Input Physical point: ");
        double physicalPoint = sc.nextDouble();

        System.out.println("Input Chemical point: ");
        double chemicalPoint = sc.nextDouble();

        Student student = new Student(name, age, mathPoint, physicalPoint, chemicalPoint);
        ID = student.getIDC();
        for (Student student1 : students) {
            if (student1.getId() == student.getId()) {
            }
        }
        addStudent(student);
    }

    public void deleteStudent(Scanner sc) {
        System.out.println("Input id you want to delete");
        int id = sc.nextInt();
        students.removeIf(student -> id == student.getId());
        displayAllStudent();
    }

    public void editStudent(Scanner sc) {
        Student studentEdit = null;
        System.out.println("Input ID you want to edit");
        int id = sc.nextInt();
        for (Student student : students) {
            if (id == student.getId()) {
                studentEdit = student;
                sc.nextLine();
                System.out.println("Input new name"); studentEdit.setName(sc.nextLine());

                System.out.println("Input new age: "); studentEdit.setAge(sc.nextInt());

                System.out.println("Input new Math point: ");studentEdit.setMathPoint(sc.nextDouble());

                System.out.println("Input newPhysical point: "); studentEdit.setPhysicalPoint(sc.nextDouble());

                System.out.println("Input  new Chemical point: "); studentEdit.setChemicalPoint(sc.nextDouble());

            }
        }
    }

    public void sortByAvgPoint() {
        students.sort(Comparator.comparingDouble(Student::getAvgPoint));
    }
    public void sortById(){
        students.sort(Comparator.comparingInt(Student::getId));
    }

    public ArrayList<Student> findHighestPoint() {
        ArrayList<Student> studentMax = new ArrayList<>();
        double avg = students.get(0).getAvgPoint();
        for (Student student : students) {
            if (student.getAvgPoint() > avg) {
                avg = student.getAvgPoint();
            }
        }
        for (Student student : students) {
            if (student.getAvgPoint() == avg) {
                studentMax.add(student);
            }
        }
        return studentMax;
    }

    public void saveInfo() {
        File file = new File("C:\\TRUNGTV\\HOC TAP\\JAVA\\TUHOC\\quanlysinhvien\\src\\saveFile.txt");
        try {
            PrintWriter pw = new PrintWriter(file);
            for (Student student : students) {
                pw.println(student.displayInformation());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveInforByFileWrite() {
        File file = new File("C:\\TRUNGTV\\HOC TAP\\JAVA\\TUHOC\\quanlysinhvien\\src\\saveFile.txt");
        if (!file.exists()) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bf = new BufferedWriter(fw);
            for (Student student : students) {
                bf.write(student.displayInformation());
            }
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFileByObject() {
        File file = new File("C:\\TRUNGTV\\HOC TAP\\JAVA\\TUHOC\\QuanLyNhanVien\\src\\Data\\employee.txt");
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (Student student:students) {
                oos.writeObject(student);
            }
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileObject() {
        File file = new File("C:\\TRUNGTV\\HOC TAP\\JAVA\\TUHOC\\QuanLyNhanVien\\src\\Data\\employee.txt");
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            Student student;
            while (true) {
                Object obj = ois.readObject();
                if (obj == null) {
                    break;
                }
                else  {
                    student = (Student) obj;
                    this.students.add(student);
                    Student.IDC = chooseId(students);
                }
            }
            ois.close();
        } catch (Exception e) {
            System.err.println();
        }
    }
    public int chooseId(ArrayList<Student> students){
        int max = students.get(0).getId();
        for (Student student:students) {
            if(max < student.getId()){
                max = student.getId();
            }
        }return max;
    }
}

