package com.mdkj.dev.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * 
 * 描述:页面静态化
 *
 * @type_name 类名:PageStaticUtil
 * @project_name 项目:HealthPlatform
 */
public class PageStaticUtil {


	/**
	 * 项目文件内
	 * @param servletContext
	 * @param configuration
	 * @param template
	 * @param params
	 * @param path
	 */
	public static void pageStatic(ServletContext servletContext,Configuration configuration,String template,Map<String, Object> params,String path){

		try{

			File file=new File(servletContext.getRealPath(path));
			File parent=file.getParentFile();
			if(parent!=null&&!parent.exists()){  
				parent.mkdirs();  
			}  
			if(!file.exists()){
				file.createNewFile();
			}
			
			System.err.println(file.getPath());

			try(Writer out = new FileWriter(file)){
				configuration.setOutputEncoding("UTF-8");
				Template mTemplate= configuration.getTemplate(template);
				mTemplate.process(params, out);
			}catch (Exception e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 绝对路径下的文件静态化
	 * @param configuration
	 * @param template
	 * @param params
	 * @param path
	 */
	public static void pageRelativeStatic(Configuration configuration,String template,Map<String, Object> params,String path){

		try{

			File file=new File(path);
			File parent=file.getParentFile();
			if(parent!=null&&!parent.exists()){  
				parent.mkdirs();  
			}  
			if(!file.exists()){
				file.createNewFile();
			}

			try(Writer out = new FileWriter(file)){
				Template mTemplate= configuration.getTemplate(template);
				mTemplate.process(params, out);
			}catch (Exception e) {
				e.printStackTrace();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}

	}


}
