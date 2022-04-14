package TekSystems.TenantManagementSystem.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class CreateFormBean {

    // the below variables are used to create a new apartment on the /user/create page

    private Integer id;

    @NotBlank(message = "Rental status is required.")
    private String status;

    @NotBlank(message = "Floor plan is required.")
    private String floorPlan;

    @NotBlank(message = "Number of bathrooms is required.")
    private String baths;

    @NotBlank(message = "Number of bedrooms is required.")
    private String beds;

    @NotBlank(message = "Rent amount is required.")
    private String rent;

    @NotBlank(message = "Square footage is required.")
    private String squareFeet;
}
