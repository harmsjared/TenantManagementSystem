package TekSystems.TenantManagementSystem.DAOTests;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.entity.Apartment;
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
public class ApartmentDAOTest {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveUserTest() {

        Apartment apartment = Apartment.builder().floorPlan("1").baths("1").beds("2")
                .rent("1200").squareFeet("1000").status("Rented").build();

        apartmentDAO.save(apartment);

        Assertions.assertThat(apartment.getId()).isGreaterThan(0);
    }
}
