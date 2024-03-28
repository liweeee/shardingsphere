package com.hanxi.generaladministration.account.entities;

import cn.hutool.core.lang.UUID;
import cn.hutool.crypto.digest.BCrypt;
import jakarta.persistence.Entity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户账号
 */
@Data
@Entity
@Table(name="t_account")
public class AccountEntity {

	@Id
	@Column(name = "account_id")
	private String accountId;

	/**
	 * 用户名
	 */
	@Column(unique=true)
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 注册来源（1: App，2:Web）
	 */
	private Integer createFrom = 1;

	/**
	 * 最后一次登录方式（1:手机，2:用户名，3:QQ，4:微信）
	 */
	private Integer lastLoginChannel;

	/**
	 * 手机号
	 */
	@Column(unique=true)
	private String mobile;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 创建时间（注册时间）
	 */
	private LocalDateTime createDate;

	/**
	 * 最后更新时间
	 */
	private LocalDateTime lastUpdateDate;

	/**
	 * 最后一次登录时间
	 */
	private LocalDateTime lastLoginDate;

	/**
	 * 状态，0：正常；-1：不通过，-2：删除；1：冻结;2待审核
	 */
	private Integer status = 0 ;

	/**
	 *
	 */
	private String orgId;
	/**
	 * 用户类型ID
	 */
	private String userLevel;

	/**
	 * 驳货理由
	 */
	private String rejectReason;


	public AccountEntity(String mobile, String username, String password,String orgId,String userLevel) {

		this();
		this.status = 2;

		Assert.state(StringUtils.isNotBlank(username),"用户名不能为空");
		Assert.state(StringUtils.isNotBlank(password),"密码不能为空");

		this.username = username;
		this.mobile = mobile;
		this.password = BCrypt.hashpw(password.trim().toLowerCase(), BCrypt.gensalt(12));
		this.orgId = orgId;
		this.userLevel = userLevel;
	}

	public AccountEntity() {
		this.accountId = UUID.fastUUID().toString();

		LocalDateTime now = LocalDateTime.now();
		this.createDate = now;
		this.lastUpdateDate =now;

		this.status = 1;

	}


}
