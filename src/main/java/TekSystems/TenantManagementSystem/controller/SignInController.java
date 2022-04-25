package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.formbean.SignInFormbean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;


@Slf4j
@Controller
public class SignInController {

    @RequestMapping(value = "/user/signin", method = RequestMethod.GET)
    public ModelAndView login(@Valid SignInFormbean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
            response.setViewName("user/signin");
            return response;
    }
}