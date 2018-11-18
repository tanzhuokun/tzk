package com.mdkj.health.entity.supper;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * 
 * 描述:用户抽样类
 *
 * @type_name 类名:User
 * @project_name 项目:HealthPlatform
 */
@MappedSuperclass
public class User extends CityLinkage{

	/**
	 * 账户
	 */
	@Column(name="account",columnDefinition="varchar(30) not null comment '用户账号'")
	//@NotNull(message="{User.account.isNull}")
	//@Size(min=2,max=30,message="{User.account.size}")
	private String account;//用户账户
	
	/**
	 * 账号图像
	 */
	@Column(name="account_pic",columnDefinition="varchar(200) not null comment '账号图像'")
	//@NotNull(message="{User.accountPic.isNull}")
	private String accountPic;//账号图像
	
	/**
	 * 昵称
	 */
	@Column(name="nickname",columnDefinition="varchar(10) comment '用户昵称'")
	//@Size(max=10,message="{User.nickname.size}")
	private String nickname;//用户昵称

	/**
	 * 密码
	 */
	@Column(name="password",columnDefinition="varchar(200) comment '登录密码'")
	private String password;//登录密码

	/**
	 * 密码强度
	 */
	@Column(name="password_strength",columnDefinition="int(2) not null default 0 comment '密码强度:默认值为0'")
	private int pstrength;//密码强度

	/**
	 * 盐
	 */
	@Column(name="salt",columnDefinition="varchar(12) not null default '20481218' comment '密码盐:默认值为20481218'")
	//@NotNull(message="{User.salt.isNull}")
	//@Size(max=12,message="{User.salt.size}")
	private String salt;//密码盐

	/**
	 * 手机号
	 */
	@Column(name="phone",columnDefinition="varchar(12) comment '用户手机号:不能为null'")
	//@NotNull(message="{User.phone.isNull}")
	//@Size(max=12,message="{User.phone.size}")
	private String phone;	//手机号	
	
	
	@Column(name="birth",columnDefinition="varchar(20) comment '出生日期'")
	//@Size(max=20,message="{User.birth.size}")
	private String birth;	//出生	
	
	
	@Column(name="gender",columnDefinition="varchar(2) comment '性别'")
	//@Size(max=2,message="{User.gender.size}")
	private String gender;	//性别
	
	/**
	 * 邮箱
	 */
	@Column(name="mail",columnDefinition="varchar(30) comment '用户邮箱'")
	//@Size(max=30,message="{User.mail.size}")
	private String mail;	//邮箱	

	/**
	 * 注册时间
	 */
	@Column(name="regtime",columnDefinition="varchar(20) comment '注册时间:格式（2015-12-23 10:12:10）'")
	private String regTime;//注册时间

	/**
	 * 上次登录时间
	 */
	@Column(name="lastlogin",columnDefinition="varchar(20) comment '上次登录时间:格式（2015-12-23 10:12:10）'")
	private String lastLogin;//上次登录时间

	/**
	 * 上次登录ip
	 */
	@Column(name="lastip",columnDefinition="varchar(24) comment '上次登录ip地址'")
	private String lastIp;//上次登录ip
	
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountPic() {
		return accountPic;
	}

	public void setAccountPic(String accountPic) {
		this.accountPic = accountPic;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPstrength() {
		return pstrength;
	}

	public void setPstrength(int pstrength) {
		this.pstrength = pstrength;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

}
