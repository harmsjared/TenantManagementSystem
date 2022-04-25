package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.UserDAO;
import TekSystems.TenantManagementSystem.database.dao.UserRoleDAO;
import TekSystems.TenantManagementSystem.database.entity.User;
import TekSystems.TenantManagementSystem.database.entity.UserRole;
import TekSystems.TenantManagementSystem.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
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
        if (bindingResult.hasErrors() ) {
            List<String> errorMessages = new ArrayList<>();
            for (ObjectError error : bindingResult.getAllErrors() ) {
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);
            return response;
        }
        try {

            User user = new User();
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setPassword(form.getPassword());
            user.setContactNumber(form.getContactNumber());
            user.setStatus(form.getStatus());
            String password = passwordEncoder.encode(form.getPassword());
            user.setPassword(password);
            User newUser = userDAO.save(user);
            UserRole userRole = new UserRole();
            userRole.setUserId(Math.toIntExact(user.getId()));
            userRole.setUserRole("ADMIN");
            userRoleDAO.save(userRole);
            log.info(form.toString());
            response.setViewName("redirect:/user/admin?id=" + newUser.getId());
            return response;
        } catch (Exception e) {
            System.out.println("User could not be registered.");
            return response;
        }
    }
}
