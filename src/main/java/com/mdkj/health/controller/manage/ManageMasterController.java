package com.mdkj.health.controller.manage;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.dev.aop.SystemLog;
import com.mdkj.dev.utils.DataTransferUtil;
import com.mdkj.dev.utils.LayerResult;
import com.mdkj.dev.utils.Result;
import com.mdkj.health.base.BaseController;
import com.mdkj.health.entity.AdminAccount;

/**
 * 
 * 
 * 描述:管理员
 *
 * @type_name 类名:ManageMasterController
 * @project_name 项目:FodderAssociation
 */
@RestController
@RequestMapping("/cgi-bin/")
public class ManageMasterController extends BaseController{

	@RequestMapping("/master/list")
	public ModelAndView masterPermission(){
		Object params[] = {"page","/views/master/list.html"};

		return myView("views/temp/index",params);
	}

	/**
	 * 后台管理员
	 * @param page
	 * @param limit
	 * @return
	 */
	//@RequiresPermissions("manager_list")
	@PostMapping("/master/lists")
	@SystemLog(message="获取管理员数据",methods="getManageMaster")
	public Map<String, Object> getManageMaster(int page,int limit){
		try{
			List<AdminAccount> accounts = adminAccountService.findByCondition((page-1)*limit, limit);
			int count = adminAccountService.countByCondition();
			return LayerResult.success("获取管理员数据成功！", accounts, count);
		}catch (Exception e) {
			e.printStackTrace();
		}

		return LayerResult.error("获取管理员数据失败!");
	}

	/**
	 * 新增管理员
	 * @return
	 */
	//@RequiresPermissions("manager_publish")
	@PostMapping("/master/publish")
	@SystemLog(message="保存管理员数据",methods="addNewManage")
	public Result addNewManage(AdminAccount admin){
		try{
			String serial=admin.getSerial();
			if(DataTransferUtil.needNewSerial(serial)){
				int count=adminAccountService.countByAccountExit(admin.getAccount(), admin.getPhone());
				if(count==0){
					admin.setLastIp(getRequestIP());
					admin.setAccountPic("");
					admin.setLastLogin(DataTransferUtil.getDate(DATE_FORMAT1));
					String salt=DataTransferUtil.getSalt();
					admin.setSalt(salt);
					String intpwd="123456";
					admin.setPassword(DataTransferUtil.simpleMd5Hashpwd(intpwd, salt, SHIRO_HASH_ITERATIONS));
					admin.setPstrength(DataTransferUtil.checkPwdStrength(intpwd));
					admin.setSerial(DataTransferUtil.getComSerial());
					admin.setRegTime(DataTransferUtil.getDate(DATE_FORMAT1));
					admin.setSubTime(DataTransferUtil.getDate(DATE_FORMAT1));
					adminAccountService.save(admin);

					return Result.success("新增管理员成功！", null);
				}else{
					return Result.error("当前账号或手机号已存在！", null);
				}
			}else{
				AdminAccount adminAccount=adminAccountService.findBySerial(serial);
				if(adminAccount!=null){
					if(!adminAccount.getAccount().equals(admin.getAccount())||!adminAccount.getPhone().equals(admin.getPhone())){
						if(adminAccountService.countByAccountExit(admin.getAccount(), admin.getPhone())>0){
							return Result.error("当前账号或手机号已存在！");
						}
					}

					adminAccount.setAccount(admin.getAccount());
					adminAccount.setRoleName(admin.getRoleName());
					adminAccount.setRole(admin.getRole());
					adminAccount.setPhone(admin.getPhone());
					adminAccount.setMail(admin.getMail());
					adminAccount.setRealName(admin.getRealName());
					adminAccount.setGender(admin.getGender());
					adminAccount.setBirth(admin.getBirth());
					
					adminAccountService.update(adminAccount);

					return Result.success("更新管理员成功！", null);
				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

		return Result.error("新增管理员失败！", null);
	}

	/**
	 * 重置密码
	 * @return
	 */
	//@RequiresPermissions("manager_pwd_reset")
	@RequestMapping("/master/{admin}/reset/pwd")
	@SystemLog(message="管理员密码重置",methods="resetManagePwd")
	public Result resetManagePwd(@PathVariable String admin){
		try{
			AdminAccount account=adminAccountService.findBySerial(admin);
			if(account!=null){
				account.setSalt(DataTransferUtil.getSalt());
				String orin_pwd=DataTransferUtil.getRandomDigitString(6);
				String pwd=DataTransferUtil.simpleMd5Hashpwd(orin_pwd, account.getSalt(), 2);
				account.setPassword(pwd);
				adminAccountService.update(account);
				
				return Result.success("管理员密码重置成功！", orin_pwd);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return Result.error("新增管理员失败！", null);
	}

	/**
	 * 删除管理员
	 * @param admin
	 * @return
	 */
	//@RequiresPermissions("manager_remove")
	@RequestMapping("/master/{admin}/remove")
	@SystemLog(message="删除管理员",methods="removeManage")
	public Result removeManage(@PathVariable String admin){

		try{
			AdminAccount account=adminAccountService.findBySerial(admin);
			if(account!=null){
				account.setRemove(1);
				adminAccountService.update(account);
				
				return Result.success("删除管理员成功！", null);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Result.error("删除管理员失败！", null);
	}

}
