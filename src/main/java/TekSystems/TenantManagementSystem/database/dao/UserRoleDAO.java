package TekSystems.TenantManagementSystem.database.dao;

import TekSystems.TenantManagementSystem.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("user_id") Integer userId);
}

// create user_role table
// create entity
// create dao
// create login.jsp
// create login controller
// make sure spring security starts and you can get to your login page
// add spring security to pom
// create a spring cofiguration class for security
// copy boiler plate code for security and adjust as needed
// include bcrypt encoder in spring security config
// use a website to bcrypt a plain text password and store the encrypted password in database
// update users set password = "$2a$12$OIqV/5DPNlr/.yn5Fk0nWOi/yDJZxG5aK57NZyAFJAjsw6PuQ9aTG" where id > 0;
// create the UserDetailsServiceImpl class
// add the user details service impl to the security congif
