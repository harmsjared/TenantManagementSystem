package TekSystems.TenantManagementSystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(AccessDeniedException.class)
    @RequestMapping(value = "/error/404")
    public String error404(HttpServletRequest request) {

        String originalUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
        log.error("Requested URL not found : " + request.getMethod() + " " + originalUri);

        return "error/404";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(HttpServletRequest request, Exception ex) {
        log.error("Error page exception : " + getRequestURL(request), ex);
        ModelAndView model = new ModelAndView();
        model.setViewName("error/500");
        String stackTrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));
        model.addObject("message", ex.getMessage());
        model.addObject("stackTrace", stackTrace);
        model.addObject("requestUrl", getRequestURL(request));
        if ( ex.getCause() != null ) {
            Throwable root = ExceptionUtils.getRootCause(ex);
            model.addObject("rootcause", root);
            String roottrace = getHTMLStackTrace(ExceptionUtils.getStackFrames(ex));
            model.addObject("roottrace", roottrace);
        }
        return model;
    }

    private String getRequestURL(HttpServletRequest request) {
        String result = request.getRequestURL().toString();
        if (request.getQueryString() != null) {
            result = result + "?" + request.getQueryString();
        }
        return result;
    }

    private String getHTMLStackTrace(String[] stack) {
        StringBuffer result = new StringBuffer();
        for (String frame : stack) {
            if (frame.contains("teksystems")) {
                result.append(" &nbsp; &nbsp; &nbsp;" + frame.trim().substring(3) + "<br>\n");
            } else if ( frame.contains("Caused by:")) {
                result.append("Caused By: " + frame + "<br>");
            }
        }
        return result.toString();
    }
}
