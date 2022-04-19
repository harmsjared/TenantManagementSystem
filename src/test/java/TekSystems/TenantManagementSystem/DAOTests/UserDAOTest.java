package TekSystems.TenantManagementSystem.DAOTests;



import TekSystems.TenantManagementSystem.database.dao.UserDAO;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import TekSystems.TenantManagementSystem.database.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveUserTest() {

        User user = User.builder().firstName("Gunner").lastName("Harms").email("gunner@email.com")
                .password("password").contactNumber("6128675309").status("Waiting").build();

        userDAO.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
}
