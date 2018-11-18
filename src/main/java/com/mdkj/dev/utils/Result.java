package com.mdkj.dev.utils;

/**
 * 
 * 
 * 描述:结果返回
 *
 * @type_name 类名:Result
 * @project_name 项目:HealthPlatform
 */
public class Result {

	private int code;
	
	private String message;
	
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Result(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	
	public static Result error(String message,Object data){
		return new Result(1, message, data);	
	}
	
	public static Result error(String message){
		return new Result(1, message, null);	
	}

	public static Result success(String message,Object data){
		return new Result(0, message, data);	
	}
	
	public static Result success(String message){
		return new Result(0, message, null);	
	}
	
}
