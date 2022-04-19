package TekSystems.TenantManagementSystem.DAOTests;

import TekSystems.TenantManagementSystem.database.dao.ApartmentDAO;
import TekSystems.TenantManagementSystem.database.entity.Apartment;
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

import javax.persistence.EntityNotFoundException;
import java.util.List;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class ApartmentDAOTest {

    @Autowired
    private ApartmentDAO apartmentDAO;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveApartmentTest() {

        Apartment apartment = Apartment.builder().floorPlan("1").baths("1").beds("2")
                .rent("1200").squareFeet("1000").status("Rented").build();

        apartmentDAO.save(apartment);

        Assertions.assertThat(apartment.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getApartmentTest() {
//
        Apartment apartment = apartmentDAO.getById(1L);
        Assertions.assertThat(apartment.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfApartments() {
        List<Apartment> apartments = apartmentDAO.findAll();
        Assertions.assertThat(apartments.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateApartmentTest() {
        Apartment apartment = apartmentDAO.getById(1L);
        apartment.setBaths("2");
        Assertions.assertThat(apartmentDAO.getById(1L).getFloorPlan()).isEqualTo(apartment.getFloorPlan());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteApartmentTest() throws EntityNotFoundException {

        Apartment apartment = apartmentDAO.getById(1L);
        apartmentDAO.delete(apartment);

        Apartment tempApartment = null;
        if (!apartmentDAO.findById(apartment.getId()).isEmpty()) {
            tempApartment = apartmentDAO.findById(apartment.getId()).get();
        }
        Assertions.assertThat(tempApartment).isNull();
    }
}
