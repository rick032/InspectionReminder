package com.oil.ir.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role extends ModelBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ROLEID", unique = true, nullable = false, length = 10)
	private String roleId;

	@Column(name = "ROLENAME", nullable = false)
	private String roleName;

	@Column(name = "ROLELEVEL", nullable = false)
	private int roleLevel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	@Override
	public String toString() {
		return "Role [RoleId=" + roleId + ", RoleName=" + roleName
				+ ", RoleLevel=" + roleLevel + "]";
	}
}
