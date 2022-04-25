package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.entity.Apartment;
import TekSystems.TenantManagementSystem.formbean.CreateFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CreateController {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Long id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/create");
        try {
            CreateFormBean form = new CreateFormBean();
            Apartment newApartment = apartmentDAO.findApartmentById(id);
            if (newApartment != null) {
                form.setStatus(newApartment.getStatus());
                form.setFloorPlan(newApartment.getFloorPlan());
                form.setBaths(newApartment.getBaths());
                form.setBeds(newApartment.getBeds());
                form.setRent(newApartment.getRent());
                form.setSquareFeet(newApartment.getSquareFeet());
                form.setId(newApartment.getId());
            }
            response.addObject("form", form);
            return response;
        } catch (Exception e) {
            System.out.println("New apartment could not be created.");
            e.printStackTrace();
            return response;
        }
    }

    @RequestMapping(value = "/user/createSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createSubmit(@Valid CreateFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        if (bindingResult.hasErrors() ) {
            List<String> errorMessages = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors() ) {
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            return response;
        }
        try {
            Apartment apartment = new Apartment();
            apartment.setStatus(form.getStatus());
            apartment.setFloorPlan(form.getFloorPlan());
            apartment.setBaths(form.getBaths());
            apartment.setBeds(form.getBeds());
            apartment.setRent(form.getRent());
            apartment.setSquareFeet(form.getSquareFeet());
            Apartment newApartment = apartmentDAO.save(apartment);
            log.info(form.toString());
            response.setViewName("redirect:/user/create?id=" + newApartment.getId());
            return response;
        } catch (Exception e) {
            System.out.println("New apartment could not be created.");
            e.printStackTrace();
            return response;
        }
    }
}
