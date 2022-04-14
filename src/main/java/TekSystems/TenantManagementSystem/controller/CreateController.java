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
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class CreateController {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/create");

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
    }

    @RequestMapping(value = "/user/createSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createSubmit(@Valid CreateFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

//        int i = 10/0;

        if (bindingResult.hasErrors() ) {
            // Hashmap errors = new HashMap();

            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors() ) {
                //errors.put( ((FieldError) error).getField(), error.getDefaultMessage());
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }


            response.addObject("form", form);
            // add the error list to the model
            // response.addObject("formErrors", errors);

//            response.addObject("bindingResult", bindingResult);

            // because there is 1 or more errors we do not want to process the logic below
            // that will create a new user in the database. We want to show the register.jsp
            response.setViewName("user/create");
            return response;
        }

        // first thing we want to do here is load the user from the database
        // using the incoming id on the form
//        Tenant tenant = tenantDAO.findById(form.getId());
//
//        // if user is not null we know it is an edit
//        if (tenant == null ) {
//            // now if the user from the database is null then it means we did not
//            // find the user. Therefore, it is a create.
//            tenant = new Tenant();
//        }
        Apartment apartment = new Apartment();
        apartment.setStatus(form.getStatus());
        apartment.setFloorPlan(form.getFloorPlan());
        apartment.setBaths(form.getBaths());
        apartment.setBeds(form.getBeds());
        apartment.setRent(form.getRent());
        apartment.setSquareFeet(form.getSquareFeet());
        apartment.setCreateDate(new Date());     //could be update date as well!!


        Apartment newApartment = apartmentDAO.save(apartment);

        log.info(form.toString());

        // here instead of showing a view, we want to redirect to the edit page'
        // the edit page will then be responsible for loading the user fom the
        // database and dynamically creating the page
        // when you use redirect: as part of the view name, it triggers spring to tell the
        // browser to do a redirect to the URL after the :
        // redirect: uses an actual URL rather than a view name path
        response.setViewName("redirect:/user/create?id=" + newApartment.getId());
//        response.setViewName("redirect:/user/register/");
        return response;
    }
}
