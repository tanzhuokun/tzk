/**
 * 表单验证
 */

//价格金额验证
jQuery.validator.addMethod("isPrice", function(value,element){
	var price=/^(([1-9]\d{0,9})|0)(\.\d{1,2})?$/;
	return this.optional(element) || (price.test(value));  
},"价格格式不正确");

//邮政编码验证    
jQuery.validator.addMethod("isZipCode", function(value, element) {    
	var zip = /^[0-9]{6}$/;    
	return this.optional(element) || (zip.test(value));    
}, "请正确填写您的邮政编码!");   

//身份证号码验证
jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
	var idCard = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;   
	return this.optional(element) || (idCard.test(value));    
}, "请输入正确的身份证号码!"); 

//手机号码验证    
jQuery.validator.addMethod("isMobile", function(value, element) {    
	var length = value.length;    
	return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));    
}, "请正确填写您的手机号码!");

//电话号码验证    
jQuery.validator.addMethod("isPhone", function(value, element) {    
	var tel = /^(\d{3,4}-?)?\d{7,9}$/g;    
	return this.optional(element) || (tel.test(value));    
}, "请正确填写您的电话号码!")

//用户名字符验证    
jQuery.validator.addMethod("username", function(value, element) {    
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);    
}, "用户名只能包括中文字、英文字母、数字和下划线!");   

//特殊字符开头验证    
jQuery.validator.addMethod("isnotstart", function(value, element) { 

	return this.optional(element) || /^(?!_)(.*)$/.test(value);    
}, "用户名不能以_、.*等特殊字符开头!");   

//交易密码
jQuery.validator.addMethod("traceCode", function(value, element) { 

	return this.optional(element) || /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/.test(value);    
}, "交易密码长度为8-16，数字、字母、字符至少包含两种!");  

jQuery.validator.addMethod("isPassword", function(value, element) { 

	return this.optional(element) || /((?=.*\d)(?=.*\D)|(?=.*[a-zA-Z])(?=.*[^a-zA-Z]))^.{8,16}$/.test(value);    
}, "密码长度为8-16，数字、字母、字符至少包含两种!");  


//联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isTel", function(value,element) {   
	var length = value.length;   
	var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;   
	var tel = /^\d{3,4}-?\d{7,9}$/;   
	return this.optional(element) || (tel.test(value) || mobile.test(value));   
}, "请正确填写您的联系电话!");  

//IP地址验证   
jQuery.validator.addMethod("ip", function(value, element) {    
	return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);    
}, "请填写正确的IP地址！");

//身份号码验证   
jQuery.validator.addMethod("idcard", function(value, element) {    
	return this.optional(element) || /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/.test(value);    
}, "请填写正确的身份证号码！");

//下拉选择 
jQuery.validator.addMethod("iselect", function(value, element) {  
	if(value=="none"||value==""){
		return false;
	}
	return this.optional(element) || value!=0 ;    
}, "请选择");

//坐标
jQuery.validator.addMethod("isxy", function(value, element) {
	var re = /^[1-9]+[0-9]*]*$/;
	if(value.split(",").length==2){

		if (re.test(value.split(",")[0])&&re.test(value.split(",")[1]))  
		{  
			return true;  
		}  

	}else{
		return false;
	}
	return false;    
}, "坐标类型不正确");



$().ready(function() {

	/**
	 * 表单验证案例
	 */
	$("#productForm").validate({
		rules: {
			name:  {
				required: true
			},
			brand: {
				required: true
			},
			desc:{
				required: true
			},
			price: {
				isPrice: true,
				required: true
			},
			priceMarket: {
				isPrice: true,
				required: true
			},
			freight: {
				isPrice: true
			},
			totalInventory: {
				required: true,
				digits: true
			}
		},
		messages: {
			name:  {
				required: "请输入商品名称"
			},
			brand: {
				required: "请输入商品品牌",
			},
			desc:{
				required: "请输入商品简介"
			},
			price: {
				isPrice: "商品价格格式不正确",
				required: "请输入商品价格"
			},
			priceMarket: {
				isPrice: "商品价格格式不正确",
				required: "请输入商品价格"
			},
			freight: {
				isPrice: "运费格式不正确"
			},
			totalInventory: {
				required: "请输入商品总库存",
				digits: "商品总库存格式不正确"
			}
		}
	});

	

});