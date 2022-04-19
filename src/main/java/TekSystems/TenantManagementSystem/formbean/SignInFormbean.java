package TekSystems.TenantManagementSystem.formbean;

import TekSystems.TenantManagementSystem.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class SignInFormbean {

    @EmailUnique(message = "***Email already exists in database.")
    @NotBlank(message = "***Email is required.")
    @Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "***Email format invalid")
    private String email;

    @Length(min = 4, max = 10, message = "***Password must be between 4 and 10 characters.")
    @NotBlank(message = "***Password is required.")
    private String password;
}
