package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

//    User findByUserId(@Param("id")Long id);

    User findByEmail(@Param("email")String email);

    User findByFirstName(@Param("first") String first);

//    void assignTenantToApartment(String email, int apartmentId);

//    @Query(value = "select t from Tenant t where t.firstName = :firstName")
//    public List<Tenant> getByPassword(@Param("password") String password);
}
