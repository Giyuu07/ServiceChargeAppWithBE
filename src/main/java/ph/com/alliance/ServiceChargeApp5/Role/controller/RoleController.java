package ph.com.alliance.ServiceChargeApp5.Role.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.ServiceChargeApp5.Role.entity.Role;
import ph.com.alliance.ServiceChargeApp5.Role.messages.RoleMessages;
import ph.com.alliance.ServiceChargeApp5.Role.service.RoleService;
import ph.com.alliance.ServiceChargeApp5.common.models.ApiResponse;

@RestController
public class RoleController {
	private RoleService roleService;

	@Autowired
	public RoleController(final RoleService roleService) {
		this.roleService = roleService;
	}

	@GetMapping("/roles")
	public ApiResponse getAllRoles() {
		List<Role> result = roleService.getAllRoles();
		if (null == result) {
			return ApiResponse.CreateError(null, RoleMessages.ROLE_UNSUCCESSFUL_GETALL);
		} else {
			return ApiResponse.CreateSuccess(result, RoleMessages.ROLE_SUCCESSFUL_GETALL);
		}
	}

	@GetMapping("/roles/{id}")
	public ApiResponse getRoleById(final @PathVariable int id) {
		Role result = roleService.getRoleById(id);
		if (null == result) {
			return ApiResponse.CreateError(null, RoleMessages.ROLE_UNSUCCESSFUL_GET);
		} else {
			return ApiResponse.CreateSuccess(result, RoleMessages.ROLE_SUCCESSFUL_GET);
		}
	}

	@PostMapping("/role/create")
	public ApiResponse createRole(@RequestBody Role role) {
		Role result = roleService.createRole(role);
		if (null == result) {
			return ApiResponse.CreateError(null, RoleMessages.ROLE_UNSUCCESSFUL_ADD);
		} else {
			return ApiResponse.CreateSuccess(result, RoleMessages.ROLE_SUCCESSFUL_ADD);
		}
	}

	@DeleteMapping("/role/delete/{roleId}")
	public ApiResponse deleteRole(@PathVariable int roleId) {
		Role result = roleService.deleteRole(roleId);
		if (null == result) {
			return ApiResponse.CreateError(null, RoleMessages.ROLE_NOT_DELETED);
		} else {
			return ApiResponse.CreateSuccess(result, RoleMessages.ROLE_DELETED);
		}
	}

	@PutMapping("/role/update/{roleId}")
	public ApiResponse updateRole(@PathVariable int roleId, @RequestBody Role role) {
		Role result = roleService.updateRole(roleId, role);
		if (null == result) {
			return ApiResponse.CreateError(null, RoleMessages.ROLE_UNSUCCESSFUL_UPDATE);
		} else {
			return ApiResponse.CreateSuccess(result, RoleMessages.ROLE_SUCCESSFUL_UPDATE);
		}
	}
}
