package TekSystems.TenantManagementSystem.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AgentsController {

    // this class generates a list of "agents" via javascript who the user could use to get in contact
    // with in their respective state

    @RequestMapping(value = "/user/agents", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/agents");

        return response;
    }
}