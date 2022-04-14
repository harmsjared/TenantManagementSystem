package TekSystems.TenantManagementSystem.controller;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.entity.Apartment;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
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

        List<Tenant> tenants = null;

        if (!firstName.isEmpty()) {
            String search = firstName;
            tenants = tenantDAO.findByFirstName(search);
            log.info(firstName);
        }


        response.addObject("usersModelKey", tenants);
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



}
