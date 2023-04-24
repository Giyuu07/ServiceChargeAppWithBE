package ph.com.alliance.ServiceChargeApp5.Role.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ph.com.alliance.ServiceChargeApp5.Role.entity.Role;
import ph.com.alliance.ServiceChargeApp5.Role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository, Gson gson) {
		super();
		this.roleRepository = roleRepository;
	}

	public List<Role> getAllRoles() {
		final List<Role> roleList = roleRepository.findAll();
		return roleList != null ? roleList : Collections.emptyList();

	}

	public Role createRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	public Role updateRole(int id, Role role) {
		Optional<Role> existingRole = roleRepository.findById(id);
	    if (existingRole.isPresent()) {
	    	role.setRole_id(id);
	        Role result = roleRepository.saveAndFlush(role);
	        return result;
	    } else {
	        return null;
	    }
	}

	public Role deleteRole(int id) {
	    Optional<Role> role = roleRepository.findById(id);
	    if (role.isPresent()) {
	    	roleRepository.deleteById(id);
	        return role.get();
	    } else {
	        return null;
	    }
	}

	public Role getRoleById(int id) {
		Optional<Role> role = roleRepository.findById(id);
	    return role.orElse(null);
	}

}
