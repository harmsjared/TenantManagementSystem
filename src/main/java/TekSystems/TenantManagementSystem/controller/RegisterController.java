package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.dao.UserRoleDAO;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import TekSystems.TenantManagementSystem.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class RegisterController {

    @Autowired
    private TenantDAO tenantDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Long id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        try {
            RegisterFormBean form = new RegisterFormBean();
            Tenant newTenant = tenantDAO.findTenantById(id);
            if (newTenant != null) {

                form.setEmail(newTenant.getEmail());
                form.setPassword(newTenant.getPassword());
                form.setFirstName(newTenant.getFirstName());
                form.setContactNumber(newTenant.getContactNumber());
                form.setLastName(newTenant.getLastName());
                form.setStatus(newTenant.getStatus());
                form.setId(newTenant.getId());

            }
            response.addObject("form", form);

            return response;
        } catch (Exception e) {
            System.out.println("Tenant could not be registered.");
            return response;
        }
    }

    @RequestMapping(value = "/user/registerSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();


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

            response.addObject("bindingResult", bindingResult);

            // because there is 1 or more errors we do not want to process the logic below
            // that will create a new user in the database. We want to show the register.jsp
            response.setViewName("user/register");
            return response;
        }

        try {

            Tenant tenant = new Tenant();
            tenant.setEmail(form.getEmail());
            tenant.setFirstName(form.getFirstName());
            tenant.setLastName(form.getLastName());
            tenant.setPassword(form.getPassword());
            tenant.setContactNumber(form.getContactNumber());
            tenant.setStatus(form.getStatus());
//            tenant.setCreateDate(new Date());     //could be update date as well!!


            Tenant newTenant = tenantDAO.save(tenant);

            log.info(form.toString());

            // here instead of showing a view, we want to redirect to the edit page'
            // the edit page will then be responsible for loading the user fom the
            // database and dynamically creating the page
            // when you use redirect: as part of the view name, it triggers spring to tell the
            // browser to do a redirect to the URL after the :
            // redirect: uses an actual URL rather than a view name path
            response.setViewName("redirect:/user/register?id=" + newTenant.getId());
//            response.setViewName("redirect:/user/register" + newTenant.getId());
//        response.setViewName("redirect:/user/register/");
            return response;
        } catch (Exception e) {
            System.out.println("Tenant could not be registered.");
            return response;
        }
    }
}