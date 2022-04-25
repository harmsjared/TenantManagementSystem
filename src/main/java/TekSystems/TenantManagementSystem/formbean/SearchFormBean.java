package TekSystems.TenantManagementSystem.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class SearchFormBean {

    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Floor plan is required.")
    private String floorPlan;
}