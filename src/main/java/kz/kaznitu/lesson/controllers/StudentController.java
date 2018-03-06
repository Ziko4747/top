package kz.kaznitu.lesson.controllers;

import kz.kaznitu.lesson.models.Student;
import kz.kaznitu.lesson.models.Zhurnal;
import kz.kaznitu.lesson.repositories.ZhurnalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private ZhurnalRepository zhurnalRepository ;

    @GetMapping("/all")
    public String allZhurnals2(Model model){
        List<Zhurnal> zhurnals = (List<Zhurnal>) zhurnalRepository.findAll();
        model.addAttribute("students", zhurnals) ;
        return "students" ;
    }

}
