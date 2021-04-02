var vm_forgotPassword = new Vue({
	el : "#forgotpass",
	data : {
		shoujihaoma : "",
		name : "",
		type : "",
		password : "",

		/*InterValObj:"", //timer变量，控制时间
		count : 5, //间隔函数，1秒执行
		curCount:"",//当前剩余秒数
		code : "", //验证码
		codeLength : 6,//验证码长度*/
	},
	created : function(){

	},
	methods : {

		/*tosendyanzhengma:function (){
			var _this = this;

			for ( var i = 0; i < _this.codeLength; i++) {
				_this.code += parseInt(Math.random() * 9).toString();
			}
			_this.curCount = _this.count;
			$("#btnSend").attr("disabled", "true");
			$("#btnSend").val("请在" + _this.curCount + "秒内输入验证码");
			_this.InterValObj = window.setInterval(_this.SetRemainTime, 1000); // 启动计时器，1秒执行一次
			layer.alert(_this.code);
			/!*$.post('/patient_login/sendyanzhengma',{
				shoujihaoma : _this.shoujihaoma,
				code : _this.code,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");

				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;

						_this.zhuanzhenlist = data;

						// 根据医生id查询是否有未读消息
						_this.findIsWeiduXiaoxi();

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");*!/
		},*/

		// 点击“找回密码”按钮
		toFindPassword : function(){
			var _this = this;
			
			// 清空message
			_this.cleanMessage();
			$("#password").css("display","none");

			if(!_this.shoujihaoma){
				_this.showMessage("请填写手机号！");
				return false;
			}

			var mobileReg =  /^\d{11}$/;
			if(!mobileReg.test(this.shoujihaoma)){
				_this.showMessage("手机号码必须为11位数字！");
				return false;
			}

			if(!_this.name){
				_this.showMessage("请填写姓名!");
				return false;
			}

			if(!_this.type){
				_this.showMessage("请选择用户类型！");
				return false;
			}

			layer.open({type:3});

			if(_this.type == '1'){
				// 医生
				$.post('../doctor_login/find_by_loginname_and_name', {
					loginname : _this.shoujihaoma,
					name : _this.name,
					rdm : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");

						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							$("#password").css("display","block");
							_this.password = data.loginpassword;
							_this.cleanForm();
						}else{
							$("#message").html(message);
						}

					}
				},"json");
			}
			else if(_this.type =='2'){
				// 患者
				$.post('../patient_login/find_by_loginname_and_name', {
					loginname : _this.shoujihaoma,
					name : _this.name,
					rdm : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");

						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							$("#password").css("display","block");
							_this.password = data.loginpassword;
							_this.cleanForm();
						}else{
							$("#message").html(message);
						}
					}
				},"json");
			}
		},

		// 清空输入框
		cleanForm : function(){
			this.shoujihaoma = "";
			this.name = "";
			this.type = "";
		},

		// 提示
		showMessage : function(ppMessage){
			var _this = this;
			$("#message").html(ppMessage);
			setTimeout(function(){
				_this.cleanMessage();
			},'3000');
		},

		// 清空提示
		cleanMessage:function(){
			$("#message").html("");
		},

		/*SetRemainTime:function () {
			var _this = this;
			if (_this.curCount == 0) {
				window.clearInterval(_this.InterValObj);// 停止计时器
				$("#btnSend").removeAttr("disabled");// 启用按钮
				$("#btnSend").val("重新发送验证码");
				_this.code = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
			}else {
				_this.curCount--;
				$("#btnSend").val("请在" + _this.curCount + "秒内输入验证码");
			}
		}*/

	},
})
