package TekSystems.TenantManagementSystem.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class AssignmentsFormBean {

    private Integer id;

    @NotBlank(message = "Tenant Id is required.")
    private Long tenantId;

    @NotBlank(message = "Apartment Id is required.")
    private Long apartmentId;
}
