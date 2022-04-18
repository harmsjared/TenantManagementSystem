package TekSystems.TenantManagementSystem.formbean;

import TekSystems.TenantManagementSystem.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class RegisterFormBean {

    // the below variables are used to create the formbean for registering a new tenant to the database

    // will be null in the case of create
    // will be populated with the user id in the case of an edit
    private Long id;

    @EmailUnique(message = "***Email already exists in database.")
    @NotBlank(message = "***Email is required.")
    @Pattern(regexp = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "***Email format invalid")
    private String email;

    @NotBlank(message = "***First name is required.")
    private String firstName;

    @NotBlank(message = "***Last name is required.")
    private String lastName;

    @NotBlank(message = "***Phone number is required.")
    private String contactNumber;

    @Length(min = 4, max = 10, message = "***Password must be between 4 and 10 characters.")
    @NotBlank(message = "***Password is required.")
    private String password;

    @NotBlank(message = "***Confirm password is required.")
    private String confirmPassword;

    @NotBlank(message = "***Status is required.")
    private String status;
}