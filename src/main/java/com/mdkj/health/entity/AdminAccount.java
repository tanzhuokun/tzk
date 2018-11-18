package com.mdkj.health.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mdkj.health.entity.supper.User;

/**
 * 
 * 
 * 描述:管理员账号
 *
 * @type_name 类名:AdminAccount
 * @project_name 项目:HealthPlatform
 */
@Entity
@Table(name="tbl_admin_account")
public class AdminAccount extends User{


	@Column(name="adac_realname",columnDefinition="varchar(10) not null comment '管理员真实姓名'")
	private String realName;//真实姓名

	@Column(name="adac_role")
	public String role;
	
	@Column(name="adac_role_name")
	public String roleName;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}	
}
