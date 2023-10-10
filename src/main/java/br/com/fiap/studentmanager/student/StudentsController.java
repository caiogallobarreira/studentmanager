package br.com.fiap.studentmanager.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/students")
public class StudentsController {
    
    @Autowired
    StudentsService studentService;

    @GetMapping
    public String index(Model model) {
        List<Students> students = studentService.findAll();
        model.addAttribute("students", students);
        return "students/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (studentService.delete(id)) {
            redirect.addFlashAttribute("success", "Aluno removido com sucesso");
        } else {
            redirect.addFlashAttribute("error", "Aluno não encontrado");
        }
        return "redirect:/students";
    }

}
