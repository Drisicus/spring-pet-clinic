package es.springwebapp.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.springwebapp.springpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index"})
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/ownersIndex";
    }
}
