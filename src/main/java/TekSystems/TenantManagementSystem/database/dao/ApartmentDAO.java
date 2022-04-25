package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApartmentDAO extends JpaRepository<Apartment, Long> {

    Apartment findApartmentById(@Param("id") Long id);

    List<Apartment> findApartmentByFloorPlan(@Param("floorPlan") String floorPlan);
}
