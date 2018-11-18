var webDomain='http://127.0.0.1:8081';
/**
 * 网站公用
 */
String.prototype.trim=function(){
 return this.replace(/(^\s*)|(\s*$)/g, "");
}

/**
 * 判断设备类型
 */
var ua = navigator.userAgent;
var ipad = ua.match(/(iPad).*OS\s([\d_]+)/),
    isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),
    isAndroid = ua.match(/(Android)\s+([\d.]+)/),
    isMobile = isIphone || isAndroid;
    

function getCookie(c_name)
{
	if (document.cookie.length>0)
	{
		c_start=document.cookie.indexOf(c_name + "=")
		if (c_start!=-1)
		{ 
			c_start=c_start + c_name.length+1 
			c_end=document.cookie.indexOf(";",c_start)
			if (c_end==-1) c_end=document.cookie.length
			return unescape(document.cookie.substring(c_start,c_end))
		} 
	}
	return ""
}

function setCookie(c_name,value,expiredays)
{
	var exdate=new Date()
	exdate.setDate(exdate.getDate()+expiredays)
	document.cookie=c_name+ "=" +escape(value)+
	((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}

//获取域名
function getHost(){
	var host=window.location.host;

	var reg=/^(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\:(\d{2,5})$/;

	if(reg.test(host)){
		var href=window.location.href;

		if(href.indexOf("https")>-1){
			href=href.replace("https://"+host+"/","");
			href=href.split("/")[0]
			host="https://"+host+"/"+href+"/";
		}else{
			href=href.replace("http://"+host+"/","");
			href=href.split("/")[0]
			host="http://"+host+"/"+href+"/";
		}

	}else{
		var href=window.location.href;

		if(href.indexOf("https")>-1){
			host="https://"+host+"/";
		}else{
			host="http://"+host+"/";
		}
	}

	return host;
}


function showMsg(data){
	if(JSON.stringify(data).indexOf("loginPage")>-1){
		data={code:1,message:"您的账号已经掉线，请重新登录！"};
	}
	var msgType=data.code==0?"success":"danger";
	new $.zui.Messager(data.message, {
	    type: msgType,
	    placement:"center",
	    time: 2000 // 不进行自动隐藏
	}).show();
}

//截取URL参数
function getQueryString(name) {
  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
  var r = window.location.search.substr(1).match(reg);
  if (r != null) {
      return decodeURI(r[2]);
  }
  return null;
}

//复制到剪切板
function clipboard(){
	try{
		if(typeof(Clipboard)=="function"){
			var clipboard = new Clipboard('.copy_btn');
			clipboard.on('success', function(e) {
			    //您可以加入成功提示
			    console.info('Action:', e.action);
			    console.info('Text:', e.text);
			    console.info('Trigger:', e.trigger);

			    e.clearSelection();
			});
			clipboard.on('error', function(e) {
			    //您可以加入失败提示
			    console.error('Action:', e.action);
			    console.error('Trigger:', e.trigger);
			});
		}
	}catch(e){
		console.log(e);
	}
	
}


//日期格式
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


var validateRegExp = {
		decmal: "^([+-]?)\\d*\\.\\d+$",
		// 浮点数
		decmal1: "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$",
		// 正浮点数
		decmal2: "^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$",
		// 负浮点数
		decmal3: "^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$",
		// 浮点数
		decmal4: "^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$",
		// 非负浮点数（正浮点数 + 0）
		decmal5: "^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$",
		// 非正浮点数（负浮点数 +
		// 0）
		intege: "^-?[1-9]\\d*$",
		// 整数
		intege1: "^[1-9]\\d*$",
		// 正整数
		intege2: "^-[1-9]\\d*$",
		// 负整数
		num: "^([+-]?)\\d*\\.?\\d+$",
		// 数字
		num1: "^[1-9]\\d*|0$",
		// 正数（正整数 + 0）
		num2: "^-[1-9]\\d*|0$",
		// 负数（负整数 + 0）
		ascii: "^[\\x00-\\xFF]+$",
		// 仅ACSII字符
		chinese: "^[\\u4e00-\\u9fa5]+$",
		// 仅中文
		color: "^[a-fA-F0-9]{6}$",
		// 颜色
		date: "^\\d{4}(\\-|\\/|\.)\\d{1,2}\\1\\d{1,2}$",
		// 日期
		email: "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$",
		// 邮件
		idcard: "^[1-9]([0-9]{14}|[0-9]{17})$",
		// 身份证
		ip4: "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$",
		// ip地址
		letter: "^[A-Za-z]+$",
		// 字母
		letter_l: "^[a-z]+$",
		// 小写字母
		letter_u: "^[A-Z]+$",
		// 大写字母
		mobile: "^0?(13|15|18|14|17)[0-9]{9}$",
		// 手机
		notempty: "^\\S+$",
		// 非空
		password: "^.*[A-Za-z0-9\\w_-]+.*$",
		// 密码
		fullNumber: "^[0-9]+$",
		// 数字
		picture: "(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$",
		// 图片
		qq: "^[1-9]*[1-9][0-9]*$",
		// QQ号码
		rar: "(.*)\\.(rar|zip|7zip|tgz)$",
		// 压缩文件
		tel: "^[0-9\-()（）]{7,18}$",
		// 电话号码的函数(包括验证国内区号,国际区号,分机号)
		url: "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$",
		// url
		username: "^[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+$",
		// 户名
		deptname: "^[A-Za-z0-9_()（）\\-\\u4e00-\\u9fa5]+$",
		// 单位名
		zipcode: "^\\d{6}$",
		// 邮编
		realname: "^[A-Za-z\\u4e00-\\u9fa5]+$",
		// 真实姓名
		companyname: "^[A-Za-z0-9_()（）\\-\\u4e00-\\u9fa5]+$",
		companyaddr: "^[A-Za-z0-9_()（）\\#\\-\\u4e00-\\u9fa5]+$",
		companysite: "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&#=]*)?$"
};

function pwdLevel(value) {
	var pattern_1 = /^.*([\W_])+.*$/i;
	var pattern_2 = /^.*([a-zA-Z])+.*$/i;
	var pattern_3 = /^.*([0-9])+.*$/i;
	var level = 0;
	if (value.length > 10) {
		level++;
	}
	if (pattern_1.test(value)) {
		level++;
	}
	if (pattern_2.test(value)) {
		level++;
	}
	if (pattern_3.test(value)) {
		level++;
	}
	if (level > 3) {
		level = 3;
	}
	return level;
}


function pwdStrength(){
	$("input[name='pwdstrength']").val(pwdLevel($("#pwd").val()))
}

//刷新验证码
function createCaptchaCode(){
	var imgsrc=$("#randCode").attr("src");
	$("#randCode").attr("src",imgsrc+"?time="+new Date().getMilliseconds())
}

function refreshCaptchaCode(elem){
	var imgsrc=$(elem).attr("data-src");
	$(elem).attr("src",imgsrc+"?time="+new Date().getMilliseconds())
}


//同意/不同意
function checkBoxAggree(checkbox,subtn){
	var aggree=$("#"+checkbox).attr("checked");
	if(aggree=="checked"){
		$("#"+subtn).removeAttr("disabled");
		$("#"+subtn).css("background","#ea544a");
	}else{
		$("#"+subtn).attr("disabled","disabled");
		$("#"+subtn).css("background","#dedede");
	}
}

//获取时间
function myGetDateTime(type){
	var date = new Date();
	this.year = date.getFullYear();
	this.month = date.getMonth() + 1;
	this.date = date.getDate();
	this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];
	this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	if(type==0){
		return this.year + "年" + this.month + "月" + this.date + "日 " +" "+ this.day+" "+this.hour + ":" + this.minute + ":" + this.second + " " ;
	}else if(type==1){
		return this.year + "年" + this.month + "月" + this.date + "日 " +" "+this.hour + ":" + this.minute + ":" + this.second + " " ;
	}else if(type==2){
		return this.year + "-" + this.month + "-" + this.date + " " +" "+this.hour + ":" + this.minute + ":" + this.second + " " ;
	}	
}

//刷新验证码
function refreshCode(elem){
	var date = new Date();
	var srchtml=$(elem).attr("data-src")+"?t="+date.getMilliseconds();
	$(elem).attr("src",srchtml);
}



//结束帷幕
function finishPage(){
	$("#backdrop").slideUp(2000);
	setCookie("first_page", "1",24*60*60*1000);
}

//帷幕
function backdrop(starTime,endTime,enable){
	if(enable){

		var stimes=starTime.split("-");
		var stime=new Date(stimes[0],stimes[1],stimes[2]).getTime();

		var etimes=endTime.split("-");
		var etime=new Date(etimes[0],etimes[1],etimes[2]).getTime();
		var date=new Date();
		var ctime=new Date(date.getFullYear(),date.getMonth()+1,date.getDate()).getTime();

		if(ctime>stime&&ctime<etime){
			var open=getCookie("first_page");
			if(open==""){	
				$("#backdrop").show();
				setTimeout("finishPage()",3000); 
			}else{
				$("#backdrop").hide();
			}
		}else{
			$("#backdrop").hide();
		}
	}
}


//确认对话框
function alertDialog(msg,type,callback){
	$('#alertModal #confirmAction').attr("class","btn btn-"+type)
	$('#alertModal').on('show.zui.modal', function() {
		$('#alertModal .message').html(msg);
	});
	$('#alertModal').modal("show");
	$("body").one("click",'#alertModal #confirmAction',function(){
		if(callback&&typeof(callback)==="function")
	        callback();
	});
}


$(function(){
	
	clipboard();
	
	$("#checkall").click(function(){
		var checked=$(this).attr("checked");
		if(checked==undefined){
			$(this).attr("checked","checked");
		}else{
			$(this).removeAttr("checked");
		}

		$("input[name='ck']").each(function(){
			if(checked==undefined){
				$(this).prop("checked","checked");
			}else{
				$(this).removeAttr("checked");
			}
		});
	});
	
	//获取邮箱验证码
	$(".mailcode_get").click(function(){
		var elem=$(this);
		var html=elem.val();
		var code=$("#emailNumber").val();
		if(code.trim().length>0){
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
			
			$.post(getHost()+"/user/email/getcode.json",{email:code},function(data,status){

				if("ok"==data){
					//发生成功
				}else{
					//发生失败
				}
			});
		}else{
			$("#emailNumber").css("border","1px solid red");
		}
	});
	
	
	$(".refresh").click(function(){
		window.location.reload(true);
	});
	
	$("#contentType").click(function(){

		if($(this).attr("checked")==undefined){
			$(this).attr("checked","checked");
			$(".modelmade").show();
			$("#codeContent").show();
			$("#richContent").hide();
		}else{
			$(this).removeAttr("checked");
			$(".modelmade").hide();
			$("#codeContent").hide();
			$("#richContent").show();
		}
	});
	
	/* 前台 */
	$("#topmenu li").hover(function(){
		$(this).find(".sub_menu").slideDown("slow");
	},function(){
		$(this).find(".sub_menu").slideUp("slow");
	});
	
	$(".sub_menu li").hover(function(){
		$(this).find(".third_menu").slideDown("slow");
	},function(){
		$(this).find(".third_menu").slideUp("slow");
	});
	
	$(".tab .tab_title>li").hover(function(){
		var index=$(this).index();
		var tab=$(this).parents(".tab");

		tab.find(".tab_content>li").eq(index).addClass("on").removeClass("unon").siblings().addClass("unon").removeClass("on");
		$(this).addClass("on").removeClass("unon").siblings().addClass("unon").removeClass("on");;
	});
	
	$(".shop.searchBtn").click(function(){
		var key=$(".searchText").val();
		if(key.trim().length>0){
			$("#seachForm").submit();
		}
	});
	
	/* 店铺开启  */
	$(".shopenable").click(function(){
		$.post(getHost()+"/firm/shop/status/open.html",{},function(data){
			if(data=="ok"){
				window.location.reload(true);
			}
		})
	});
	
	/**
	 * 2.分页
	 */
	$("#pagination .page span").click(function(){
		$("#curPage").val($(this).html());
		$(this).parents("#searchForm").submit();
	});
	
	$("#pagination .previous").click(function(){
		var curPage=parseInt($("#curPage").val());
		var upPage=curPage-1;
		if(upPage>0){
			$("#curPage").val(upPage)
			$(this).parents("#searchForm").submit();
		}
	});
	
	$("#pagination .next").click(function(){
		var curPage=parseInt($("#curPage").val());
		var nextPage=curPage+1;
		var countPage=parseInt($("#pageCount").attr("data-val"));
		if(nextPage<=countPage){
			$("#curPage").val(nextPage)
			$(this).parents("#searchForm").submit();
		}
	});
	
	
	$("#pagination .go .cangopage").click(function(){
		var goPage=parseInt($(".go .pagego").val());
		$("#curPage").val(goPage);
		$(this).parents("#searchForm").submit();
	});

	
	if($("#cgibin").length==1){
		$("html").niceScroll({styler:"fb",cursorcolor:"#65cea7", cursorwidth: '6', cursorborderradius: '0px', background: '#424f63', spacebarenabled:false, cursorborder: '0',  zindex: '1000'});
	    
		$("body").on("click",".mynav .menu-list",function(){
			$(this).addClass("mynav-active ").siblings().removeClass("mynav-active ");
		})
	    
	    $(".myaccount").hover(function(){
	    	$("#accountBox").removeClass("hide");
	    },function(){
	    	$("#accountBox").addClass("hide");
	    });
	    
	    $(".switch-menu").click(function(){
	    	if($("body").attr("class").indexOf("small-nav")>-1){
	    		$("body").removeClass("small-nav");
	    	}else{
	    		$("body").addClass("small-nav");
	    	}
	    	
	    });
	}
	
})
