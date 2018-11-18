/**
 * 
 */
$(function (){
	

	var HOME_HOST=getHost();

	var interval;
	$(".regcode_get").click(function(){
		var elem=$(this);
		var code=$("#inputCode").val();
		var key=$(this).attr("data-key");
		
		if(code.trim().length>0){
			$("#inputCode").css("border","1px solid #d2d2d2");
			$.post(HOME_HOST+"captcha/checkCode.json",{imgcode:code},function(data){
				if(data==true){
					if($(".phone_number").val().trim().length==11){
						$(".phone_number").css("border","1px solid #d2d2d2");

						var time=30;
						elem.val(time+"秒后重试")
						elem.attr("disabled","disabled")
						interval=setInterval(function(){
							time--;
							elem.val(time+"秒后重试");
							if(time==0){
								window.clearInterval(interval);
								elem.val("获取短信验证码");
								elem.removeAttr("disabled");
							}
						},1000);//1000为1秒钟

						$.post(HOME_HOST+"sms/"+key+"/get",{mobile:$(".phone_number").val(),randCode:code},function(data){
							console.log("发送结果:"+data)
							if(data=="sendMore"){
								alert("您的手机号发送短信过于频繁");
							}
						});
					}else{
						$(".phone_number").css("border","1px solid red");
					}
				}else{
					$("#inputCode").css("border","1px solid red");
				}
			});	

		}else{
			$("#inputCode").css("border","1px solid red");
		}
	});


	//获取公共手机校验码
	$(".comsms_get").click(function(){
		var elem=$(this);
		var html=elem.val();
		var key=$(this).attr("data-key");
		var code=$("#randcode").val();
		if(code.trim().length>0){
			$("#randcode").css("border","1px solid #d2d2d2");
			var time=30;
			elem.val(time+"秒后重试")
			elem.attr("disabled","disabled")
			interval=setInterval(function(){
				time--;
				elem.val(time+"秒后重试");
				if(time==0){
					window.clearInterval(interval);
					elem.val(html);
					elem.removeAttr("disabled");
				}
			},1000);//1000为1秒钟
			
	
			$.post(HOME_HOST+"sms/"+key+"/get",{mobile:$("#phoneNumber").val(),randCode:code},function(data){
				console.log("发送结果:"+data)
				if(data=="sendMore"){
					alert("您的手机号发送短信过于频繁");
				}
			});
		}else{
			$("#randcode").css("border","1px solid red");
		}
	});
	
});