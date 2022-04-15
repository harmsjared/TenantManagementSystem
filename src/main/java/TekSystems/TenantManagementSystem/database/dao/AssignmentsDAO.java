package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AssignmentsDAO extends JpaRepository<Assignment, Long> {


    public Assignment findById(@Param("id")Integer id);

}
