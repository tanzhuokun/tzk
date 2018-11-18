package com.mdkj.dev.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ValidatorUtil {
	
	/**
	 * 封装hibernate validator错误
	 * @param params
	 * @param bindingResult
	 * @return
	 */
	public static boolean packageValidated(List<Object> params,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			for(ObjectError error:bindingResult.getAllErrors()){
				System.err.println("表单验证错误："+error.getDefaultMessage());
				String messages[]=error.getDefaultMessage().split(":");
				params.add(messages[0]);
				params.add(messages[1]);
			}
			return true;
		}
		
		return false;
	}

}
