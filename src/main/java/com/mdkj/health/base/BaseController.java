package com.mdkj.health.base;

import java.util.HashMap;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mdkj.health.entity.AdminAccount;
import com.mdkj.health.service.AdminAccountService;
import com.mdkj.health.service.SMSService;
import com.mdkj.health.service.ServerService;
import com.mdkj.health.service.SysLogService;

import freemarker.template.Configuration;

/**
 * 
 * 
 * 描述:业务管理
 *
 * @type_name 类名:BaseController
 * @project_name 项目:HealthPlatform
 */
@RestController
public class BaseController implements StaticParameterService{

	@Resource
	protected ApplicationContext myContext;
	
	@Resource
	protected EhCacheCacheManager cacheManager;
	
	@Resource
	protected Configuration configuration;

	@Resource
	protected WebConfig webConfig;
	
	@Resource
	protected AdminAccountService adminAccountService;
	
	@Resource
	protected SMSService smsService;
	
	@Resource
	protected SysLogService sysLogService;
	
	@Resource
	protected ServerService serverService;
	


	/**
	 * 获取当前管理员
	 * @return
	 */
	public AdminAccount getCurAdmin(){
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		Object user=request.getSession().getAttribute(LOGIN_ADMIN);
		if(null!=user){
			return (AdminAccount) user;
		}

		return null;
	}


	/**
	 * 前台view视图数据传输
	 * @return
	 */
	public ModelAndView myView(String targView,Object[] params){

		HashMap<String, Object> parameters=new HashMap<String, Object>();

		if(targView.indexOf("redirect")==-1){
			parameters.put("site", webConfig.getDomain());
			parameters.put("siteName", webConfig.getName());
		}

		if(null!=params){
			for(int i=0;i<params.length-1;i=i+2){
				parameters.put(params[i].toString(),params[i+1]);
			}
		}

		return new ModelAndView(targView,parameters);
	}
	
	
	public ModelAndView myView(String targView){

		HashMap<String, Object> parameters=new HashMap<String, Object>();

		if(targView.indexOf("redirect")==-1){
			parameters.put("site", webConfig.getDomain());
			parameters.put("siteName", webConfig.getName());
		}

		return new ModelAndView(targView,parameters);
	}

	/**
	 * 获取客户户的IP地址
	 * 
	 * @return
	 */

	public String getRequestIP() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 获取上下文
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {

		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}



}
