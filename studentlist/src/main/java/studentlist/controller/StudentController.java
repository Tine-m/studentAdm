package studentlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import studentlist.model.Student;
import studentlist.model.Students;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class StudentController {

    Students students = new Students();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", students.readAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        //klargør tomt objekt, som create.html skal bruge
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request) {
        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String dato = request.getParameter("enrollmentDate");
        String split[] = dato.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        LocalDate enrolled = LocalDate.of(year, month, day);
        String cpr = request.getParameter("cpr");
        Student s = new Student(fn,ln, enrolled, cpr);
        students.create(s);
        return "redirect:/";
    }

   @GetMapping("/details")
    public String details(@RequestParam("id") int id, Model model) {
        Student found = students.read(id);
        model.addAttribute("student", found);
        return "details";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model){
        model.addAttribute("student", students.read(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(HttpServletRequest request) {
        String id = request.getParameter("studentId");
        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String dato = request.getParameter("enrollmentDate");
        String cpr = request.getParameter("cpr");
        String split[] = dato.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        LocalDate enrolled = LocalDate.of(year, month, day);
        Student s = new Student(Integer.parseInt(id), fn,ln, enrolled, cpr);
        students.update(s);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {
        model.addAttribute("stu", students.read(id));
        return "delete";
    }
}
