package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.UserDAO;
import TekSystems.TenantManagementSystem.database.dao.UserRoleDAO;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import TekSystems.TenantManagementSystem.database.entity.User;
import TekSystems.TenantManagementSystem.database.entity.UserRole;
import TekSystems.TenantManagementSystem.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/user/admin", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/admin");

        return response;
    }

    @RequestMapping(value = "/user/adminSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
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

            response.addObject("bindingResult", bindingResult);

            // because there is 1 or more errors we do not want to process the logic below
            // that will create a new user in the database. We want to show the register.jsp
            response.setViewName("user/admin");
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

        try {

            User user = new User();
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setPassword(form.getPassword());
            user.setContactNumber(form.getContactNumber());
            user.setStatus(form.getStatus());
                //could be update date as well!!

            String password = passwordEncoder.encode(form.getPassword());
            user.setPassword(password);

            User newUser = userDAO.save(user);

            UserRole userRole = new UserRole();
            userRole.setUserId(Math.toIntExact(user.getId()));
            userRole.setUserRole("ADMIN");

            userRoleDAO.save(userRole);

            log.info(form.toString());

            // here instead of showing a view, we want to redirect to the edit page'
            // the edit page will then be responsible for loading the user fom the
            // database and dynamically creating the page
            // when you use redirect: as part of the view name, it triggers spring to tell the
            // browser to do a redirect to the URL after the :
            // redirect: uses an actual URL rather than a view name path
            response.setViewName("redirect:/user/admin?id=" + newUser.getId());
//        response.setViewName("redirect:/user/register/");
            return response;
        } catch (Exception e) {
            System.out.println("User could not be registered.");
            return response;
        }
    }
}
