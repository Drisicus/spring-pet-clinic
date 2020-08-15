package es.springwebapp.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.springwebapp.springpetclinic.services.VetService;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets.html", "/vets/index"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/vetsIndex";
    }
}
