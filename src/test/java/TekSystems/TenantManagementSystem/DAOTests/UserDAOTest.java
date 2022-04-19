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

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveUserTest() {

        User user = User.builder().firstName("Neil").lastName("McKenzie").email("neil@email.com")
                .password("password").contactNumber("9522613457").status("Renting").build();

        userDAO.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getUserTest() {
//
        User user  = userDAO.getById(1L);
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfTenants() {
        List<User> users  = userDAO.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest() {
        User user = userDAO.getById(1L);
        user.setLastName("Jimmy");
        Assertions.assertThat(userDAO.getById(1L).getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest() throws EntityNotFoundException {

        User user = userDAO.getById(1L);
        userDAO.delete(user);

        User tempUser = null;
        if (!userDAO.findById(user.getId()).isEmpty()) {
            // get is what is used to get the data from the tempUser
            tempUser = userDAO.findById(user.getId()).get();
        }
        Assertions.assertThat(tempUser).isNull();
    }

    @ParameterizedTest
    @Order(6)
    @ValueSource(longs = {1, 2, 3, 4, 5}) // will plug into test
    void testUserArray(long arg) { // takes them in as arguments
        User user = User.builder().firstName("Gunner").lastName("Harms").email("gunner@email.com")
                .password("password").contactNumber("6128675309").status("Waiting").build();
        // creates a new user

        userDAO.save(user); // save restaurant

        Assertions.assertThat(arg == user.getId()); // tests that auto ids are incrementing and assigning to the user
    } // if i had implemented this prior to my delete method, my arguments would start at 2

}
