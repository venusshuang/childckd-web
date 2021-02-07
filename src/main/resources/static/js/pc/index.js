var vm_index = new Vue({
	el : "#index_div",
	data : {
		roletype : $("#roletype").val(),
		isfromlogin : $("#isfromlogin").val(),
	},
	created : function(){
		var _this = this;
		if(this.isfromlogin == "yes"){
			setTimeout(function(){
				//	关闭所有tab页面
				_this.clearTab();
				// 把值设置为no
				location.href="/index.html?isfromlogin=no";
			},'500');
		}
	},
	methods : {
		// 退出登录
		logout : function(){
			var _this = this;

			layer.open({type:3});
			$.post('/administrator/logout',{
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData){
					window.location.href="/manage/login.html";

					_this.clearTab();
				}
			},"json");
		},

		//	关闭所有tab页面
		clearTab : function(){
			$('.layui-tab-title li[lay-id]').find('.layui-tab-close').click();
		},

	},
})