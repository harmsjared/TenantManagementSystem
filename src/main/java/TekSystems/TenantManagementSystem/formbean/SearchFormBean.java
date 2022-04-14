package TekSystems.TenantManagementSystem.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class SearchFormBean {

    // used in /user/search to search for a tenant by first name
    @NotBlank(message = "First name is required.")
    private String firstName;

    // used in /user/search to search for a tenant by first name
    @NotBlank(message = "Floor plan is required.")
    private String floorPlan;
}