import java.io.Serializable;
import java.util.Objects;

public class Student extends Human implements Serializable{
    public static int IDC;
    private int id;
    private double mathPoint;
    private double physicalPoint;
    private double chemicalPoint;

    public Student() {
    }

    public Student(double mathPoint, double physicalPoint, double chemicalPoint) {

        this.mathPoint = mathPoint;
        this.physicalPoint = physicalPoint;
        this.chemicalPoint = chemicalPoint;
    }

    public Student(String name, int age, double mathPoint, double physicalPoint, double chemicalPoint) {
        super(name, age);
        this.id = ++IDC;
        this.mathPoint = mathPoint;
        this.physicalPoint = physicalPoint;
        this.chemicalPoint = chemicalPoint;
    }

    public int getId() {
        return id;
    }
    public int getIDC(){
        return IDC;
    }


    public void setId(int id) {
        this.id = id;
    }

    public double getAvgPoint(){
        return (mathPoint + physicalPoint + chemicalPoint)/3;
    }


    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getPhysicalPoint() {
        return physicalPoint;
    }

    public void setPhysicalPoint(double physicalPoint) {
        this.physicalPoint = physicalPoint;
    }

    public double getChemicalPoint() {
        return chemicalPoint;
    }

    public void setChemicalPoint(double chemicalPoint) {
        this.chemicalPoint = chemicalPoint;
    }
    public void display(){
        System.out.printf("%-15d", id);
        System.out.printf("%-25S", getName());
        System.out.printf("%-15S", getAge());
        System.out.printf("%-15.2f", getMathPoint());
        System.out.printf("%-15.2f", getPhysicalPoint());
        System.out.printf("%-15.2f", getChemicalPoint());
        System.out.printf("%-15.2f\n", getAvgPoint());
    }
    public String displayInformation(){
        return (String.format("%-5d%-25S%-15S%-15.2f%-15.2f%-15.2f%-15.2f", getId(), getName(), getAge(), getMathPoint(), getPhysicalPoint(), getChemicalPoint(), getAvgPoint()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
              super.toString()+
                ", mathPoint=" + mathPoint +
                ", physicalPoint=" + physicalPoint +
                ", chemicalPoint=" + chemicalPoint +
                '}';
    }
}
