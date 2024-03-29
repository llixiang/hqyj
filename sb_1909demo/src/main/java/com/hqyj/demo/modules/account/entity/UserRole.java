package com.hqyj.demo.modules.account.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户角色类
 * @author: HymanHu
 * @date: 2019年11月28日
 */
@Entity
@Table(name = "m_user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleId;
	private int userId;
	private int roleId;

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
