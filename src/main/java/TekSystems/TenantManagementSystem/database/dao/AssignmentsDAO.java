package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.Assignments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AssignmentsDAO extends JpaRepository<Assignments, Long> {


    public Assignments findById(@Param("id")Integer id);

}
