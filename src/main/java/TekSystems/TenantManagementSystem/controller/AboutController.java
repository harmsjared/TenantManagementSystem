package TekSystems.TenantManagementSystem.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class AboutController {

    // this class defines the mapping for the about page. The page has no functionality except for a dropdown
    // in jsp that leads to the floorplans page

    @RequestMapping(value = "/user/about", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/about");

        return response;
    }
}
