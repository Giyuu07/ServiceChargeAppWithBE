package ph.com.alliance.ServiceChargeApp5.Role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.alliance.ServiceChargeApp5.Role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
