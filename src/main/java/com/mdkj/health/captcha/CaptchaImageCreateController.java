package com.mdkj.health.captcha;
import java.awt.image.BufferedImage;
import java.util.Properties;

import javax.imageio.ImageIO;  
import javax.servlet.ServletOutputStream;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;  

import com.google.code.kaptcha.Constants;  
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;  

/**
 * 
 * 
 * 描述:图片验证码
 *
 * @type_name 类名:CaptchaImageCreateController
 * @project_name 项目:HealthPlatform
 */
@RestController  
public class CaptchaImageCreateController {  

	private Producer captchaProducer = captchaProducer();  

	public DefaultKaptcha captchaProducer() {  
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties props=new Properties();
		props.setProperty("kaptcha.border.color", "105,179,90");
		props.setProperty("kaptcha.textproducer.font.color", "red");
		props.setProperty("kaptcha.image.width", "250");
		props.setProperty("kaptcha.image.height", "120");
		props.setProperty("kaptcha.textproducer.font.size", "80");
		props.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		props.setProperty("kaptcha.session.key", "code");
		props.setProperty("kaptcha.textproducer.char.length", "4");
		defaultKaptcha.setConfig(new Config(props));
		return defaultKaptcha;
	}  

	@RequestMapping("/captcha")  
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {  

		response.setDateHeader("Expires", 0);  
		// Set standard HTTP/1.1 no-cache headers.  
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).  
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
		// Set standard HTTP/1.0 no-cache header.  
		response.setHeader("Pragma", "no-cache");  
		// return a jpeg  
		response.setContentType("image/jpeg");  
		// create the text for the image  
		String capText = captchaProducer.createText();  
		// store the text in the session  
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);  
		// create the image with the text  
		BufferedImage bi = captchaProducer.createImage(capText);  
		ServletOutputStream out = response.getOutputStream();  
		// write the data out  
		ImageIO.write(bi, "jpg", out);  

		try {  
			out.flush();  
		} finally {  
			out.close();  
		}  
		return null;  
	}


	@RequestMapping("/getKaptcha")
	@ResponseBody
	public String getKaptcha(HttpServletRequest request){
		String code = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY); 
		return code;
	}

	@RequestMapping("/captcha/checkCode")
	@ResponseBody
	public boolean checkKaptcha(HttpServletRequest request,@RequestParam String imgcode){
		try{
			String Kaptcha= (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if(Kaptcha.equals(imgcode)){
				return true;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * 检验验证码是否正确
	 * @param request
	 * @param imgcode
	 * @return
	 */
	public static boolean static_checkKaptcha(HttpSession session,@RequestParam String imgcode){
		String Kaptcha= (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if(imgcode!=null&&Kaptcha!=null&&Kaptcha.equals(imgcode)){
			return true;
		}
		return false;
	}


}  