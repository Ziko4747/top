package kz.kaznitu.lesson.controllers;

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
@RequestMapping(path = "/zhurnal")
public class ZhurnalController {
    @Autowired
    private ZhurnalRepository zhurnalRepository ;
    private long a;

    @RequestMapping("/add")
    public String show(Model model){
        model.addAttribute("zhurnal",new Zhurnal());
        return "zhurnal_add";
    }

    @RequestMapping("/addd")
    public String showw(Model model){
        model.addAttribute("zhurnall",new Zhurnal());
        return "zhurnal_update";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Zhurnal zhurnal){
        zhurnalRepository.save(zhurnal) ;
        return "redirect:/zhurnal/all" ;
    }

    @GetMapping("/all2")
    public @ResponseBody Iterable<Zhurnal> allZhurnals(){
        return zhurnalRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allZhurnals2(Model model){
        List<Zhurnal> zhurnals = (List<Zhurnal>) zhurnalRepository.findAll();
        model.addAttribute("zhurnals", zhurnals) ;
        return "zhurnals" ;
    }

    @PostMapping("/adds")
    public String addsZhurnal(@ModelAttribute Zhurnal zhurnal){
        Zhurnal zhurnal1 = new Zhurnal();
        zhurnal1.setId(a);
        zhurnal1.setFamilia(zhurnal.getFamilia());
        zhurnal1.setImia(zhurnal.getImia());
        zhurnal1.setBaga(zhurnal.getBaga());
        zhurnalRepository.save(zhurnal1) ;
        return "redirect:/zhurnal/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateZhurnals(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Zhurnal> zhurnal = (Optional <Zhurnal> ) zhurnalRepository.findById(id);
        model.addAttribute("zhurnall",zhurnal);
        return new ModelAndView("zhurnal_update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        zhurnalRepository.deleteById(idd);
        return new ModelAndView("redirect:/zhurnal/all");
    }
}
