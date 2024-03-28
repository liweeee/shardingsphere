package com.hanxi.generaladministration.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hanxi.generaladministration.account.entities.AccountEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountJpaRepository extends JpaRepository<AccountEntity, String> {
	@Query("select u from AccountEntity u where u.username=?1")
	AccountEntity findByUsername(String username);

	@Query("select u from AccountEntity u where u.mobile=?1 AND u.status = 0")
	AccountEntity findByMobile(String mobile);
	
	@Query("select u from AccountEntity u where u.accountId=?1 ")
	AccountEntity findByAccountId(String accountId);
//
//	@Query("select u from AccountEntity u where u.mobile=?1")
//	AccountEntity findByMobile(String mobile);


	List<AccountEntity> findAllByOrgId(String orgId);

	@Query("select u from AccountEntity u where u.username=?1 and u.userLevel = ?2")
	AccountEntity findByUserNameAndLevel(String userName,String userLevel);


	@Query("select u from AccountEntity u where u.mobile LIKE  %?1%")
	List<AccountEntity> findByMobileLike1(String mobile);

	@Query("select u from AccountEntity u where u.username like  %?1%")
	List<AccountEntity> findByUserNameLike(String username);

	@Query("select u from AccountEntity u where u.mobile like CONCAT('%', :mobile, '%') ")
	List<AccountEntity> findByMobileLike(@Param("mobile")String mobile);



}
