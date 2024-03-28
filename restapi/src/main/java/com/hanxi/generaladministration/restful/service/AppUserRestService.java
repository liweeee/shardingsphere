package com.hanxi.generaladministration.restful.service;

import com.hanxi.generaladministration.account.entities.AccountEntity;
import com.hanxi.generaladministration.account.repository.IAccountJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


/**
 * appUser的rest service
 * 
 * @author Kiven_zhou@aliyun.com
 */
@RestController
@RequestMapping(value = "/api/app/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppUserRestService extends BaseRestService {

	@Autowired
	private IAccountJpaRepository accountJpaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;


	/**
	 * shardingsphere新增时加密调试
	 * @param param
	 * @return
	 */
	@PostMapping("/shardingsphere/add")
	public RestResponse shardingsphereAdd(AccountDto param) {
		AccountEntity accountEntity = new AccountEntity(param.getUsername(),param.getUsername(),
				param.getPassword(),"145","123122");
		accountJpaRepository.save(accountEntity);
		// 成功返回的状态信息
		return getSuccessRestResponse("注册成功！");
	}

	@GetMapping("/shardingsphere/mobile/eq")
	public RestResponse shardingsphereMobileEq(@RequestParam String mobile) {
		AccountEntity byMobile = accountJpaRepository.findByMobile(mobile);
		// 成功返回的状态信息
		return getSuccessRestResponse("成功！",byMobile);
	}

	@GetMapping("/shardingsphere/mobile/like")
	public RestResponse shardingsphereMobileLike(@RequestParam String mobile) {
//		String qMobile = "%" + mobile + "%";
		List<AccountEntity> byMobile = accountJpaRepository.findByMobileLike1(mobile);
		// 成功返回的状态信息
		return getSuccessRestResponse("成功！",byMobile);
	}

	@GetMapping("/shardingsphere/username/like")
	public RestResponse shardingsphereUsernameLike(@RequestParam String username) {
		List<AccountEntity> usernameList = accountJpaRepository.findByUserNameLike(username);
		// 成功返回的状态信息
		return getSuccessRestResponse("成功！",usernameList);
	}


	@GetMapping("/shardingsphere/mobile/like/jdbct")
	public RestResponse shardingsphereUsernameLikeJdbcQuery(@RequestParam String mobile) {
		String sql = " select * from t_account where mobile like  '%"+ mobile + "%'";
		List<AccountEntity> usernameList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(AccountEntity.class));
		// 成功返回的状态信息
		return getSuccessRestResponse("成功！",usernameList);
	}
}
