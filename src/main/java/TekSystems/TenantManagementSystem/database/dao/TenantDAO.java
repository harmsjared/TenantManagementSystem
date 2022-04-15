package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TenantDAO extends JpaRepository<Tenant, Long> {

    Tenant findTenantById(@Param("id")Long id);

    public void deleteTenantById(@Param("id")Long id);

    List<Tenant> findByFirstName(@Param("first") String first);
}
