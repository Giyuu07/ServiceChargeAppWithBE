package ph.com.alliance.ServiceChargeApp5.Role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ph.com.alliance.ServiceChargeApp5.Role.entity.Role;

@Service
public interface RoleService {
//	Role/User Type Management
//	List	
	List<Role> getAllRoles();
	Role getRoleById(final int id);
//	Add
	Role createRole(final Role role);
//	Edit
	Role updateRole(final int id, Role role);
//	Delete
	Role deleteRole(final int id);
	
}
