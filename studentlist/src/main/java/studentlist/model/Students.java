package studentlist.model;

import java.util.ArrayList;
import java.util.List;

public class Students {

    private List<Student> students = new ArrayList<>();

    public void create(Student student) {
        // Generate ID
        int index = readAll().size();
        student.setStudentId(++index);
        students.add(student);
    }

    public Student read(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> readAll() {
        return students;
    }


    public boolean update(Student student) {
        for (Student st : students) {
            if (st.getStudentId() == student.getStudentId()) {
                students.remove(st);
                students.add(0, student);
                return true;
            }
        }

        return false;
    }


    public boolean delete(int id) {
        for (Student st : students) {
            if (st.getStudentId() == id) {
                students.remove(st);
                return true;
            }
        }
         return false;

    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
