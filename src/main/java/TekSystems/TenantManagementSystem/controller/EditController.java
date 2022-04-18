package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import TekSystems.TenantManagementSystem.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class EditController {

    @Autowired
    private TenantDAO tenantDAO;

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/edit");

        return response;
    }

    @GetMapping("/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId")Long id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/edit");

        Tenant tenant = tenantDAO.findTenantById(id);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(tenant.getId());
        form.setEmail(tenant.getEmail());
        form.setFirstName(tenant.getFirstName());
        form.setLastName(tenant.getLastName());
        form.setPassword(tenant.getPassword());
        form.setStatus(tenant.getStatus());
        form.setContactNumber(tenant.getContactNumber());
        form.setConfirmPassword(tenant.getPassword());

        // in this case we are adding the RegisterFormBean to the model
        response.addObject("form", form); //putting form data in the model with the form object

        return response;
    }

    @PostMapping("/user/editSubmit/{userId}")
    public ModelAndView editUserSubmit(@Valid RegisterFormBean form, @PathVariable("userId") Long userId) {
    ModelAndView response = new ModelAndView();

    Tenant tenant = tenantDAO.findTenantById(userId);

        tenant.setId(form.getId());
        tenant.setEmail(form.getEmail());
        tenant.setFirstName(form.getFirstName());
        tenant.setLastName(form.getLastName());
        tenant.setPassword(form.getPassword());
        tenant.setStatus(form.getStatus());
        tenant.setContactNumber(form.getContactNumber());
//        tenant.setConfirmPassword(form.getPassword());

        tenantDAO.save(tenant);
        System.out.println(tenant);
        response.addObject("form", form);
        response.setViewName("redirect:/user/edit");

        return response;
    }
}