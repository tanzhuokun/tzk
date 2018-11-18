package com.mdkj.health.entity.supper;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.ColumnDefault;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * 
 * 描述:基础实体类
 *
 * @type_name 类名:BaseEntity
 * @project_name 项目:HealthPlatform
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_id")
	private Integer id;
	/**
	 * 模型编号
	 */
	@Column(name="serial",columnDefinition="varchar(100) not null comment '编号'")
	private String serial;

	/**
	 * 是否可用
	 */
	@Column(name="isremove",columnDefinition="int(2) not null default 0 comment '是否删除:1、已删除;0、未删除'")
	private int remove;

	/**
	 * 提交时间
	 */
	@Column(name="subtime",columnDefinition="varchar(20) comment '新增时间:格式（2015-12-23 10:12:10）'")
	public String subTime;


	/**
	 * 更新时间
	 */
	@JsonIgnore
	@Column(name="updatetime",columnDefinition="varchar(20) comment '更新时间:格式（2015-12-23 10:12:10）'")
	public String updateTime;


	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getSubTime() {
		return subTime;
	}


	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	public int getRemove() {
		return remove;
	}

	@ColumnDefault(value="default int 1")
	public void setRemove(int remove) {
		this.remove = remove;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



}
