package TekSystems.TenantManagementSystem.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class AssignmentsFormBean {

    private Integer id;

    @NotNull(message = "Tenant Id is required.")
    private Long t_id;

    @NotNull(message = "Apartment Id is required.")
    private Long a_id;
}
