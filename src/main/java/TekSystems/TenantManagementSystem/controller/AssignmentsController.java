package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.dao.AssignmentsDAO;
import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.entity.Assignment;
import TekSystems.TenantManagementSystem.formbean.AssignmentsFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/user/assignment", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/assignment");
        return response;
    }

    @PostMapping("/user/assignmentSubmit")
    public ModelAndView assign(@RequestParam Long t_id, @RequestParam Long a_id, @Valid AssignmentsFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        try {
            Assignment assignment = new Assignment();
            if (!apartmentDAO.existsById(a_id)) {
                System.out.println("Apartment does not exist. Assignment unsuccessful.");
            } else {
            assignment.setApartment(apartmentDAO.getById(a_id)); }
            if (!tenantDAO.existsById(t_id)) {
                System.out.println("Tenant does not exist. Assignment unsuccessful.");
            } else {
            assignment.setTenant(tenantDAO.getById(t_id)); }
            assignmentsDAO.save(assignment);
            if (bindingResult.hasErrors()) {
                List<String> errorMessages = new ArrayList<>();
                for (ObjectError error : bindingResult.getAllErrors()) {
                    errorMessages.add(error.getDefaultMessage());
                    log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
                }
                response.addObject("form", form);
                response.addObject("bindingResult", bindingResult);
            }
            response.setViewName("redirect:/user/assignment");
            return response;
        } catch (Exception e) {
            System.out.println("Assignment was unable to be executed.");
            return response;
        }
    }

    @GetMapping(value = "/user/assignmentSearch")
    public ModelAndView findAll() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/assignment");
        List<Assignment> assignment = null;
        assignment = assignmentsDAO.findAllAssignments();
        response.addObject("assignmentModelKey", assignment);
        return response;
    }
}
