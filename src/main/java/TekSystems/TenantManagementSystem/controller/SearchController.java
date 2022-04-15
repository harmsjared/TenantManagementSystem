package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.entity.Apartment;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import java.util.List;

@Slf4j
@Controller
public class SearchController {

    @Autowired
    private TenantDAO tenantDAO;


    @GetMapping(value = "/user/search")
    public ModelAndView search(@RequestParam(required = false, defaultValue = "") String firstName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<Tenant> tenant = null;

        if (!firstName.isEmpty()) {
            String search = firstName;
            tenant = tenantDAO.findByFirstName(search);
            log.info(firstName);
        }


        response.addObject("usersModelKey", tenant);
        response.addObject("firstName", firstName);

        return response;
    }

    @Autowired
    private ApartmentDAO apartmentDAO;

    @GetMapping(value = "/user/search2")
    public ModelAndView search2(@RequestParam(required = false, defaultValue = " ") String floorPlan) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<Apartment> apartments = null;

        if (!floorPlan.isEmpty()) {
            String bologna = floorPlan;
            apartments = apartmentDAO.findApartmentByFloorPlan(bologna);
            log.info(floorPlan);
        }

        response.addObject("apartmentsModelKey", apartments);
        response.addObject("floorPlan", floorPlan);

        return response;
    }

    @Transactional
    @GetMapping("/user/delete")
    public ModelAndView delete(@RequestParam(required = false, defaultValue = " ") Long id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        tenantDAO.deleteTenantById(id);

//        response.addObject();
//        response.addObject();


        return response;
    }


}
