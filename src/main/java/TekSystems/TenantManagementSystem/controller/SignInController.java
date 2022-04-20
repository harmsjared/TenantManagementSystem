package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.formbean.SignInFormbean;
import lombok.extern.slf4j.Slf4j;
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
public class SignInController {

    @RequestMapping(value = "/user/signin", method = RequestMethod.GET)
    public ModelAndView login(@Valid SignInFormbean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

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

            response.setViewName("user/signin");

            return response;

    }
}