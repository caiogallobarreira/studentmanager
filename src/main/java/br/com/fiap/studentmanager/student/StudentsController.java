package br.com.fiap.studentmanager.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentsController {
    
    @Autowired
    StudentsService studentService;

    @Autowired
    MessageSource message;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user) {
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("students", studentService.findAll());
        return "students/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        if (studentService.delete(id)) {
            redirect.addFlashAttribute("success", getMessage("students.delete.success"));
        } else {
            redirect.addFlashAttribute("error", getMessage("students.notfound"));
        }
        return "redirect:/students";
    }

    @GetMapping("/new")
    public String form(Students student){
        return "students/form";
    }

    @PostMapping
    public String create(@Valid Students student, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) return "students/form";
        studentService.create(student);
        redirect.addFlashAttribute("success", getMessage("students.create.success"));
        return "redirect:/students";
    }

    private String getMessage(String code){
        return message.getMessage(code, null, LocaleContextHolder.getLocale());
    }
}
