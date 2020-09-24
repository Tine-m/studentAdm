package studentlist.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private String cpr;

    public Student(String firstName, String lastName, LocalDate enrollmentDate, String cpr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.cpr = cpr;
    }

    public Student(int id, String firstName, String lastName, LocalDate enrollmentDate, String cpr) {
        this.studentId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = enrollmentDate;
        this.cpr = cpr;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getCpr() {
        return cpr;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    //Til test
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", cpr='" + cpr + '\'' +
                '}';
    }
}
