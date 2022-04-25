package TekSystems.TenantManagementSystem.DAOTests;

import TekSystems.TenantManagementSystem.database.dao.TenantDAO;
import TekSystems.TenantManagementSystem.database.entity.Tenant;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;
import javax.persistence.EntityNotFoundException;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class TenantDAOTest {

    @Autowired
    private TenantDAO tenantDAO;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void saveTenantTest() {
        Tenant tenant = Tenant.builder().firstName("Neil").lastName("McKenzie").email("neil@email.com")
                .password("password").contactNumber("9522613457").status("Renting").build();
        tenantDAO.save(tenant);
        Assertions.assertThat(tenant.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getTenantTest() {
        Tenant tenant = tenantDAO.getById(1L);
        Assertions.assertThat(tenant.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfTenants() {
        List<Tenant> tenants = tenantDAO.findAll();
        Assertions.assertThat(tenants.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateTenantTest() {
        Tenant tenant = tenantDAO.getById(1L);
        tenant.setFirstName("Timothy");
        Assertions.assertThat(tenantDAO.getById(1L).getPassword()).isEqualTo(tenant.getPassword());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteTenantTest() throws EntityNotFoundException {
        Tenant tenant = tenantDAO.getById(1L);
        tenantDAO.delete(tenant);
        Tenant tempTenant = null;
        if (!tenantDAO.findById(tenant.getId()).isEmpty()) {
            tempTenant = tenantDAO.findById(tenant.getId()).get();
        }
        Assertions.assertThat(tempTenant).isNull();
    }
}
