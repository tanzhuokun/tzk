package com.mdkj.health.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.QueryUtils;
import com.mdkj.health.base.BaseService;
import com.mdkj.health.base.StaticParameterService;
import com.mdkj.health.entity.AdminAccount;

/**
 * 
 * 
 * 描述:管理员业务
 *
 * @type_name 类名:AdminAccountService
 * @project_name 项目:HealthPlatform
 */
@Service
public class AdminAccountService extends BaseService<AdminAccount> implements StaticParameterService{

	public AdminAccount findByLogin(String account, String pwd) {
		/**
		 * 1:账号为昵称
		 * 2:账号为手机号
		 */
		if(account.length()==11&&DataTransferUtil.isDigital(account)){//手机号
			AdminAccount admin=(AdminAccount) getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE phone=? AND isremove=0 ")
					.setParameter(0, account)
					.uniqueResult();

			if(null!=admin){
				String dpwd=DataTransferUtil.simpleMd5Hashpwd(pwd, admin.getSalt(), SHIRO_HASH_ITERATIONS);
				if(dpwd.equals(admin.getPassword())){
					//两次密码输入相同
					return admin;
				}
			}
		}else{
			AdminAccount admin=(AdminAccount) getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE account=? AND isremove=0 ")
					.setParameter(0, account)
					.uniqueResult();

			if(null!=admin){
				String dpwd=DataTransferUtil.simpleMd5Hashpwd(pwd, admin.getSalt(), SHIRO_HASH_ITERATIONS);
				if(dpwd.equals(admin.getPassword())){
					//两次密码输入相同
					return admin;
				}
			}
		}

		return null;
	}

	public List<AdminAccount> findByCondition(int cur, int maxsize) {

		return getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE isremove=0")
				.setFirstResult(cur)
				.setMaxResults(maxsize)
				.list();
	}
	
	public Integer countByCondition() {

		return QueryUtils.packageCountQuery(getJdbcTemplate(), "select count(*) FROM tbl_admin_account WHERE isremove=0");
	}


	public Integer countByAccountExit(String account, String phone) {
		// TODO Auto-generated method stub
		Map<String, Object> params=new HashMap<>();
		params.put("account",account);
		params.put("phone",phone);
		String sql=" SELECT COUNT(*) FROM tbl_admin_account WHERE isremove=0 AND (account=:account OR phone=:phone)";
		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql, params);
	}

	
	public Integer countAll(){
		String sql=" SELECT COUNT(*) FROM tbl_admin_account WHERE isremove=0 ";
		return QueryUtils.packageCountQuery(getJdbcTemplate(), sql);
	}
	
	public AdminAccount findByAccount(String account,String phone){
		
		return (AdminAccount) getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE account=:account OR phone=:phone  AND isremove=0")
				.setParameter("account", account)
				.setParameter("phone", phone)
				.uniqueResult();
	}
	
	public List<AdminAccount> findByComplaintNotice(String businessType){
		return getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE adac_complaint_notice=1 AND isremove=0 AND adac_business_type=? ")
				.setParameter(0, businessType)
				.list();
	}
	
	public AdminAccount findByPhone(String phone) {
		return (AdminAccount) getSession().createQuery(" FROM "+clazz.getSimpleName()+" WHERE phone=:phone  AND isremove=0")
				.setParameter("phone", phone)
				.uniqueResult();
	}
	
}
