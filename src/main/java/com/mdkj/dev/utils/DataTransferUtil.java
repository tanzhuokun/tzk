package com.mdkj.dev.utils;

import java.awt.CardLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mdkj.dev.annotation.ExcelImportAnnotation;

public class DataTransferUtil{

	final private static String TRA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static java.util.Date datetransfer(String dattype, String datetime){
		try{
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern(dattype);
			Date date = sdf.parse(datetime);
			return date;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public static java.sql.Date sqldatetransfer(long time) {
		java.sql.Date sqldate = new java.sql.Date(time);
		return sqldate;
	}


	public static String timeStampTransferStr(Timestamp date) {
		String str =null;
		if(date!=null){
			SimpleDateFormat formatDate = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			str = formatDate.format(date);
		}
		return str;
	}

	public static String dateTransferStr(Date date) {
		String str=null;
		if(date!=null){
			SimpleDateFormat formatDate = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
			str = formatDate.format(date);
		}
		return str;
	}

	public static String dateTransferStr(long date,String format) {
		SimpleDateFormat formatDate = new SimpleDateFormat(
				format);
		String str = formatDate.format(date);
		return str;
	}

	/**
	 * 
	 * @param strDate
	 *            要转换的日期字符串
	 * @param format
	 *            字符窜的格式
	 */
	public static Date string2Date(String format, String strDate) {


		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date = sdf.parse(strDate);
			return date;
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return null;
	}


	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		String nowdate = "";
		Calendar calendar = Calendar.getInstance();
		int Y = calendar.get(Calendar.YEAR);
		int M = calendar.get(Calendar.MONTH);
		int D = calendar.get(Calendar.DATE);
		int h = calendar.get(Calendar.HOUR);
		int m = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);

		nowdate = Y + "-" + M + "-" + D + " " + h + ":" + m + ":" + s;
		return nowdate;
	}

	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getDate(){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
		String date = dateFormat.format( now ); 

		return date;
	}

	/**
	 * 获取后几天时间
	 * @return
	 * @throws ParseException
	 */
	public static String getnextDay(int nextDay,String format){

		String nextday=getDate(format);
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();  
			c.add(Calendar.DATE, nextDay);  
			Date monday = c.getTime();
			nextday = sdf.format(monday);
		}catch(Exception e){
			e.printStackTrace();
		}
		return nextday;
	}

	public static String getnextDay(int nextDay,String format,Date date){
		String nextday="";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, nextDay);  
			Date monday = c.getTime();
			nextday = sdf.format(monday);
		}catch(Exception e){
			e.printStackTrace();
		}
		return nextday;
	}

	public static String getnextMonth(int nextMonth,String format,Date date){
		String nextday="";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.MONTH, nextMonth);  
			Date monday = c.getTime();
			nextday = sdf.format(monday);
		}catch(Exception e){
			e.printStackTrace();
		}
		return nextday;
	}


	/**
	 * 获取几天时间
	 * @return
	 * @throws ParseException
	 */
	public static String getbeforeDay(int beforeDay,String format){

		String preMonday=getDate(format);
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();  
			c.add(Calendar.DATE, - beforeDay);  
			Date monday = c.getTime();
			preMonday = sdf.format(monday);
		}catch(Exception e){
			e.printStackTrace();
		}
		return preMonday;
	}

	/**
	 * 获取几月前时间
	 * @return
	 * @throws ParseException
	 */
	public static String getbeforeMonth(int beforeMonth,String format){

		String preMonday=getDate(format);
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Calendar c = Calendar.getInstance();  
			c.add(Calendar.MONTH, - beforeMonth);  
			Date monday = c.getTime();
			preMonday = sdf.format(monday);
		}catch(Exception e){
			e.printStackTrace();
		}
		return preMonday;
	}


	public static List<HashMap<String, String>> getBeforTimes(){
		String format="yyyy-MM-dd HH:mm:ss";
		String[] timeskey={"三天","一周","一月","三月","半年","一年"};
		String[] timesvalue={getbeforeDay(3, format),getbeforeDay(7, format),getbeforeMonth(1, format),getbeforeMonth(3, format),getbeforeMonth(6, format),getbeforeMonth(12, format)};
		List<HashMap<String, String>> beforTimeList=new ArrayList<HashMap<String,String>>();
		for(int i=0;i<timeskey.length;i++){
			HashMap<String, String> beforTimeMap=new HashMap<String, String>();
			beforTimeMap.put(timeskey[i], timesvalue[i]);
			beforTimeList.add(beforTimeMap);
		}

		return beforTimeList;
	}

	/**
	 * 判断是否为纯数据
	 * @param longchar
	 * @return
	 */
	public static boolean isDigital(String longchar){
		for(char c:longchar.toCharArray()){
			if(!Character.isDigit(c)){
				return false;
			}
		}
		return true;
	}


	/**
	 * 微信提供的时间片
	 * @return
	 */
	public static String getWXTimeStamp(){

		return (new Date().getTime()+"").substring(0, 10);
	}

	/**
	 * 随机数
	 */
	public static String randomStr() {

		String randomStr = "";
		int random = 0;
		for (int i = 0; i < 2; i++) {
			do {
				random = new Random().nextInt(90);

			} while (random < 65 || random > 90);
			randomStr += (char) random;
		}
		return randomStr;
	}

	/**
	 * 生成管理员账户
	 * 
	 * @return
	 */
	public static String getAccountStr() {

		return "m"+getDate("yyyyMMddHHmmss")+randomStr();
	}


	/**
	 * 生成车辆评估单编号
	 * 
	 * @return
	 */
	public static String getVehicleStr() {

		return "RV"+getDate("yyyyMMddHHmmss");
	}

	/**
	 * 生成车辆评估单编号
	 * 
	 * @return
	 */
	public static String getFundingStr() {

		return "RZ"+getDate("yyyyMMddHHmmss");
	}

	/**
	 * 生成公共序列号
	 * 
	 * @return
	 */
	public static String getComSerial() {
		return getDate("yyyyMMddHHmmss")+System.nanoTime();
	}

	public static String getComsSerial() {
		return getDate("yyyyMMddHHmmssS")+randomStr();
	}

	public static String getNanoSerial() {

		return System.nanoTime()+getRandomString(4);
	}


	/**
	 * 生成公共订单
	 * 
	 * @return
	 */
	public static String getOrderSerial() {

		String time=new Date().getTime()+"";
		String a=time.substring(0,4);
		String b=time.substring(4,8);
		String c=time.substring(8,13);

		Integer ai=Integer.valueOf(a)+3109;
		Integer bi=Integer.valueOf(b)+2350;
		Integer ci=Integer.valueOf(c);

		String order=bi+""+ci+""+ai;
		return order;
	}


	/**
	 * 获取文章编号
	 * @return
	 */
	public static String getNewsNo(){
		String base = "9210345678";       
		StringBuffer sb = new StringBuffer();   
		char[] prefix=getDate("yyyyMM").toCharArray();
		for (int i = 0; i < prefix.length; i++) {   

			int number=Integer.valueOf(""+prefix[i]);  

			sb.append(base.charAt(number));     
		}        
		return sb.toString();
	}


	/**
	 * 获取产品编号
	 * @return
	 */
	public static String getProductNo(){
		String base = "9120354687";       
		StringBuffer sb = new StringBuffer();   
		char[] prefix=getDate("yyyyMMDDHHmmsszzz").toCharArray();
		for (int i = 0; i < prefix.length; i++) {   

			int number=Integer.valueOf(""+prefix[i]);  

			sb.append(base.charAt(number));     
		}        
		return sb.toString();
	}

	/**
	 * 获取产品编号
	 * @return
	 */
	public static String getBatchNo(){
		String base = "6120354987";       
		StringBuffer sb = new StringBuffer();   
		char[] prefix=getDate("yyyyMM").toCharArray();
		for (int i = 0; i < prefix.length; i++) {   

			int number=Integer.valueOf(""+prefix[i]);  

			sb.append(base.charAt(number));     
		}        
		return sb.toString();
	}


	/**
	 * 获取公共编号
	 * @return
	 */
	public static String getCommonNo(){
		String base = "8120359647";       
		StringBuffer sb = new StringBuffer();   
		char[] prefix=getDate("yyyyMM").toCharArray();
		for (int i = 0; i < prefix.length; i++) {   

			int number=Integer.valueOf(""+prefix[i]);  

			sb.append(base.charAt(number));     
		}        
		return sb.toString();
	}


	/**
	 * 委托申请书编号
	 * @return
	 */
	public static String getEntrust(){

		return "CX"+(new Date().getTime()+"").substring(0, 2)+"-"+(char)(new Random().nextInt(24)+65)+""+(new Random().nextInt(90)+10)+"-"+(char)(new Random().nextInt(24)+65);
	}


	//正则表达式，模型标签替换
	public static String getModuleLabel(String id,String labelContent,String RegEX){

		if(null==labelContent){return "";}

		Pattern pat = Pattern.compile(RegEX);
		Matcher mat = pat.matcher(labelContent);

		String labelContents=labelContent.replaceAll("\\{pa:model\\}", "[pa:model]")
				.replaceAll("\\{/pa:model\\}", "[/pa:model]");

		while(mat.find()){  

			String label=mat.group().replaceAll("\\{", "[")
					.replaceAll("\\}", "]");

			String labelM=label.replaceAll(",", "\",\"").
					replaceAll("\\[pa:model\\]", "<script id=\""+id+"\">loadMaterials(\""+id+"\",\"")
					.replaceAll("\\[/pa:model\\]", "\")</script>");


			labelContents=labelContents.replace(label, labelM);

		} 

		return labelContents;
	} 

	public static String getModuleLabel2(String id,String labelContent,Integer curPage,String RegEX){

		if(null==labelContent){return "";}

		Pattern pat = Pattern.compile(RegEX);
		Matcher mat = pat.matcher(labelContent);

		String labelContents=labelContent.replaceAll("\\{pa:model\\}", "[pa:model]")
				.replaceAll("\\{/pa:model\\}", "[/pa:model]");

		while(mat.find()){  

			String label=mat.group().replaceAll("\\{", "[")
					.replaceAll("\\}", "]");

			String labelM=label.replaceAll(",", "\",\"").
					replaceAll("\\[pa:model\\]", "<script id=\""+id+"\">loadMaterialsByPage(\""+id+"\",\"")
					.replaceAll("\\[/pa:model\\]", "\","+curPage+")</script>");


			labelContents=labelContents.replace(label, labelM);

		} 

		return labelContents;
	} 

	/**
	 * 获取类的所有方法，包括父类
	 * @param methods
	 * @param clazz
	 * @return
	 */
	public static <T> List<Method> getClassMethods(List<Method> methods,Class clazz){
		Class superClaszz=clazz.getSuperclass();
		methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
		if(!"Object".equals(superClaszz.getSimpleName())){
			methods.addAll(getClassMethods(methods, superClaszz));
		}
		return methods;
	}

	/**
	 * 将bean转换为Map
	 * @return
	 */
	public static <T> Map<String, String> javaBeanToMap(Map<String, String> params,Class clazz,T clazzObj){

		List<Method> methods=new ArrayList<>();

		methods=getClassMethods(methods, clazz);

		methods.stream().filter(method->method.getName().startsWith("get")?true:false).forEach(method->{
			try {
				String methodName=method.getName().replace("get", "");
				String firstKey=methodName.substring(0, 1);
				methodName=methodName.replaceFirst(firstKey, firstKey.toLowerCase());
				params.put(methodName, method.invoke(clazzObj)+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		return params;
	}


	public static <T> TreeMap<String, String> javaBeanToTreeMap(TreeMap<String, String> params,Class clazz,T clazzObj){

		List<Method> methods=new ArrayList<>();

		methods=getClassMethods(methods, clazz);

		methods.stream().filter(method->method.getName().startsWith("get")?true:false).forEach(method->{
			try {
				String methodName=method.getName().replace("get", "");
				String firstKey=methodName.substring(0, 1);
				methodName=methodName.replaceFirst(firstKey, firstKey.toLowerCase());
				params.put(methodName, method.invoke(clazzObj)+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		return params;
	}



	/**
	 * 针对easyui form 传输iso-8859-1乱码处理
	 * @param object
	 * @return
	 */
	public static Object zhcTouUtf8(Object object){

		try{
			Class clazz = object.getClass();

			Field[] fields = clazz.getDeclaredFields();

			for(Field field:fields){
				System.out.println(field.getName()+";"+field.getType());
				String paramType=field.getType().getName();
				Object reflectObj=null;
				Object valueObj=clazz.getMethod("get"+captureName(field.getName())).invoke(object);
				if(paramType.contains("String")){
					if(valueObj!=null){
						String str2utf8=new String(valueObj.toString().getBytes("iso-8859-1"),"utf-8");
						reflectObj=str2utf8;	
					}
				}else{
					reflectObj=valueObj;
				}
				clazz.getMethod("set"+captureName(field.getName()),field.getType()).invoke(
						object,
						reflectObj);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 针对泛型进行更新
	 * @param new_object 更新的对象
	 * @param exit_object  要被更新的对象
	 * @param 返回结果是:已被更新过的object2，
	 * @return
	 */
	public static Object updataObj(Object new_object,Object exit_object){

		try{
			Class clazz1 = new_object.getClass();
			Class clazz2 = exit_object.getClass();

			Field[] fields = clazz1.getDeclaredFields();

			for(Field field:fields){
				String paramType=field.getType().getName();
				Object valueObj=clazz1.getMethod("get"+captureName(field.getName())).invoke(new_object);

				clazz2.getMethod("set"+captureName(field.getName()),field.getType()).invoke(
						exit_object,
						valueObj);
			}
			//遍历父类
			if(clazz1.getGenericSuperclass()!=null){

				Field[] superFields = clazz1.getSuperclass().getDeclaredFields();

				for(Field field:superFields){
					String paramType=field.getType().getName();
					Object valueObj=clazz1.getSuperclass().getMethod("get"+captureName(field.getName())).invoke(new_object);

					clazz2.getSuperclass().getMethod("set"+captureName(field.getName()),field.getType()).invoke(
							exit_object,
							valueObj);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return exit_object;
	}

	/**
	 * 通过注解获取属性值
	 * @param clazz
	 * @return
	 */
	public static List<HashMap<String, Object>> annoBean(Class clazz){

		List<HashMap<String, Object>> res=new ArrayList<HashMap<String,Object>>();
		Method[] methods=clazz.getMethods();
		for(Method method:methods){
			//该方法是否使用了ExcelImportAnnotation这个注解类       
			boolean isExist = method.isAnnotationPresent(ExcelImportAnnotation.class) ;
			if(isExist){
				HashMap<String, Object> entity=new HashMap<String, Object>();
				ExcelImportAnnotation annotation = method.getAnnotation(ExcelImportAnnotation.class); 
				entity.put("propertyName",annotation.propertyName());
				entity.put("fieldName",annotation.fieldName());
				entity.put("fieldType",annotation.fieldType());
				entity.put("chineseName",annotation.chineseName());
				System.err.println(annotation.fieldName()+"="+annotation.chineseName());
				res.add(entity);
			}
		}

		return res;
	}


	/**
	 * 首字母大写
	 * @param name
	 * @return
	 */

	public static String captureName(String name) {


		//判断第一个字母是小写,//判断第二个字母是大写
		if(!(Character.isLowerCase(name.charAt(0))&&Character.isUpperCase(name.charAt(1)))){
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
		}


		return  name; 
	} 



	/**
	 * 针对解决 Could not write JSON
	 * @param object
	 * @return
	 */
	public static String JsonToString(Object value){
		String json="";
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			json = mapper.writeValueAsString(value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("打印："+json);
		return json;
	}


	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getDate(String format){
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);//可以方便地修改日期格式
		String date = dateFormat.format( now ); 

		return date;
	}

	/**
	 * 生成盐
	 * 
	 * @return
	 */
	public static String getSalt() {

		String accountStr = "";
		String time = new Date().getTime() + "";
		String year = new Date().toString() + "";

		accountStr = new String(year.getBytes(), year.length() - 4, 2)
				+ new String(time.getBytes(), time.length() - 6, 3);

		return accountStr;
	}

	/**
	 * 随机字符串
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) { //length表示生成字符串的长度  
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";     
		Random random = new Random();     
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < length; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}     
		return sb.toString();     
	} 

	/**
	 * 随机短信验证码
	 * @param length
	 * @return
	 */
	public static String getSMSString(int length) { //length表示生成字符串的长度  
		String base = "0123456789";     
		Random random = new Random();     
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < length; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}     
		return sb.toString();     
	} 


	/**
	 * 随机短信验证码
	 * @param length
	 * @return
	 */
	public static String getRandomDigitString(int length) { //length表示生成字符串的长度  
		String base = "0123456789";     
		Random random = new Random();     
		StringBuffer sb = new StringBuffer();     
		for (int i = 0; i < length; i++) {     
			int number = random.nextInt(base.length());     
			sb.append(base.charAt(number));     
		}     
		return sb.toString();     
	} 


	/**
	 * 获取单词缩写
	 * 一个单词 前四位
	 * 两个单词2+2
	 * 三个单词1+1+2
	 * @return
	 */
	public static String Abbreviation(String className){

		int index=0;
		List<Integer> upcase=new ArrayList<Integer>();	
		for(char c:className.toCharArray()){
			if(Character.isUpperCase(c)){
				upcase.add(index);
			}
			index++;
		}

		String backStr="";
		switch (upcase.size()) {
		case 1:
			for(Integer i:upcase){
				backStr+=className.substring(i, i+4);
			}
			break;
		case 2:
			for(Integer i:upcase){
				backStr+=className.substring(i, i+2);
			}
			break;
		case 3:
			int len=0;
			for(Integer i:upcase){
				len++;
				if(len==3){
					backStr+=className.substring(i, i+2);
				}else{
					backStr+=className.substring(i, i+1);
				}
			}
			break;
		}

		return backStr.toLowerCase();
	}


	/**
	 * 邮箱字符星号替换
	 * @param email
	 * @return
	 */
	public static String replaceEmail(String email){
		String sub="";
		if(!"".equals(email)&&null!=email){
			sub=email.substring(0,4);

			for(int i=4;i<email.length();i++){
				sub+="*";
			}	
			sub=sub+"@"+email.split("@")[1];
		}
		return sub;
	}

	/**
	 * 邮箱字符星号替换
	 * @param email
	 * @returnf
	 */
	public static String replaceIDCard(String card){

		return card.substring(0,4)+"***********"+card.substring(card.length()-4,card.length());
	}

	/**
	 * 替换姓名
	 * @param name
	 * @return
	 */
	public static String replaceRealName(String name){

		String star="";
		for(int i=0;i<name.length()-1;i++){
			star+="*";
		}

		return star+name.substring(name.length()-1,name.length());
	}

	/**
	 * 手机号字符星号替换
	 * @param email
	 * @return
	 */
	public static String replacePhone(String phone){

		return phone.substring(0,3)+"****"+phone.substring(7,11);
	}



	public static Integer sumPage(Integer sumpage,int pagesize){

		sumpage=(sumpage%pagesize==0)?sumpage/pagesize:sumpage/pagesize+1;
		sumpage=(sumpage==0)?1:sumpage;

		return sumpage;
	}

	public static Integer curPage(Integer curPage){
		return (curPage==null||curPage<=0)?1:curPage;
	}

	/**
	 * 判断是否有下一页
	 * @param queryedCount
	 * @return
	 */
	public static boolean isHaveNextPage(List<?> queryRes,int size){

		if(queryRes.size()<size+1){
			return false;
		}else{
			queryRes.remove(size);
		}

		return true;
	}

	/**
	 * 判断是新增还是更新
	 * @param serial
	 * @return true为新增
	 */
	public static boolean needNewSerial(String serial){

		boolean flag="".equals(serial)||null==serial?true:false;

		return flag;
	}

	public static boolean stringNotNull(String str){

		boolean flag=null!=str&&!"".equals(str.trim())?true:false;

		return flag;
	}

	public static boolean TimeNotNull(String starTime,String endTime){

		boolean flag=null!=starTime&&!"".equals(starTime)&&null!=endTime&&!"".equals(endTime)?true:false;

		return flag;
	}



	/**
	 *  密码强度
	 * @param pwd
	 * @return
	 */
	public static int checkPwdStrength(String pwd){

		String  strongRegex = "^(?=.{12,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$";  
		String  mediumRegex = "^(?=.{8,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$"; 
		String  enoughRegex = "(?=.{6,}).*"; 

		Pattern strongPattern = Pattern.compile(strongRegex);  
		Matcher strongMatcher = strongPattern.matcher(pwd);  

		Pattern mediumPattern = Pattern.compile(mediumRegex);  
		Matcher mediumMatcher = mediumPattern.matcher(pwd);  

		Pattern enoughPattern = Pattern.compile(enoughRegex);  
		Matcher enoughMatcher = enoughPattern.matcher(pwd);  

		if(strongMatcher.matches()){
			return 100;
		}

		if(mediumMatcher.matches()){
			return 60;
		}

		if(enoughMatcher.matches()){
			return 0;
		}

		return 0;
	}

	/**
	 * 计算年月日
	 */
	public static int getDay(String curDay,String endTime){
		try{
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date begin=dfs.parse(curDay);
			java.util.Date end = dfs.parse(endTime);

			long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒

			return Integer.valueOf(between/3600/24+"");
		}catch(Exception e){
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 获取域名
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request){
		StringBuffer url=request.getRequestURL();
		String domain;
		if("".equals(request.getContextPath())){
			domain= url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();  
		}else{
			domain= url.delete(url.length() - request.getRequestURI().length(), url.length()).toString()+request.getContextPath();
		}

		return domain;
	}


	public static String simpleMd5Hashpwd(String pwd,String salt,int hashIterations){

		SimpleHash simpleHash=new SimpleHash("md5", pwd, salt, hashIterations);

		String password=simpleHash.toString();
		return password;
	}

}
