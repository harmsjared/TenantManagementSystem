package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.AssignmentsDAO;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ContactController {

    @Autowired
    private AssignmentsDAO assignmentsDAO;

    @RequestMapping(value = "/user/contact", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/contact");


        return response;
    }
}
