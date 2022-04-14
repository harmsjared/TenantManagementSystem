package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.dao.AssignmentsDAO;
import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.entity.Assignments;
import TekSystems.TenantManagementSystem.formbean.AssignmentsFormBean;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jdt.internal.compiler.ast.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AssignmentsController {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Autowired
    private TenantDAO tenantDAO;

    @Autowired
    private AssignmentsDAO assignmentsDAO;

    @RequestMapping(value = "/user/assignments", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/assignments");

        return response;
    }

    @PostMapping("/user/assignmentsSubmit")
    public ModelAndView assign(@RequestParam Long t_id, @RequestParam Long a_id, @Valid AssignmentsFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        Assignments assignments = new Assignments();
        assignments.setApartment(apartmentDAO.getById(a_id));
        assignments.setTenant(tenantDAO.getById(t_id));
        assignmentsDAO.save(assignments);

        if (bindingResult.hasErrors() ) {
            // Hashmap errors = new HashMap();

            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                //errors.put( ((FieldError) error).getField(), error.getDefaultMessage());
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }


            response.addObject("form", form);
            // add the error list to the model
            // response.addObject("formErrors", errors);

            response.addObject("bindingResult", bindingResult);

        }

        response.setViewName("redirect:/user/assignments");
        return response;
    }
}
