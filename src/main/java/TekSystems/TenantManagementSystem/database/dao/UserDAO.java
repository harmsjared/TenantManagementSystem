package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findByEmail(@Param("email")String email);

    User findByFirstName(@Param("first") String first);
}
