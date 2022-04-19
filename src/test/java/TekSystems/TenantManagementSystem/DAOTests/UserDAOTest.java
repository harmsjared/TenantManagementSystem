package TekSystems.TenantManagementSystem.DAOTests;



import TekSystems.TenantManagementSystem.database.dao.UserDAO;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import TekSystems.TenantManagementSystem.database.entity.User;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @ParameterizedTest
    @Order(1)
    @ValueSource(longs = {1, 2 ,3, 4, 5})
    void testUserArray(long arg) {
        User user = User.builder().firstName("Gunner").lastName("Harms").email("gunner@email.com")
                .password("password").contactNumber("6128675309").status("Waiting").build();

        userDAO.save(user);

        Assertions.assertThat(arg == user.getId());
    }
}
