package es.springwebapp.springpetclinic.controllers;

import es.springwebapp.springpetclinic.model.Owner;
import es.springwebapp.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Set;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        String response;

        // if last name is empty then it must search for all owners
        String searchString = Optional.ofNullable(owner.getLastName()).orElse(EMPTY);

        Set<Owner> ownersFound = ownerService.findAllByLastNameLike("%" + searchString + "%");
        if(ownersFound.isEmpty()){
            result.rejectValue("lastName", "notFound", "not found");
            response = "owners/findOwners";
        } else if(ownersFound.size() == 1){
            owner = ownersFound.iterator().next();
            response = "redirect:/owners/" + owner.getId();
        } else{
            model.addAttribute("selections", ownersFound);
            response = "owners/ownersList";
        }
        return response;
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        Owner owner = ownerService.findById(ownerId);
        mav.addObject(owner);
        return mav;
    }
}
