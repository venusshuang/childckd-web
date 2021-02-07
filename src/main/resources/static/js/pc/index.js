var vm_index = new Vue({
	el : "#index_div",
	data : {
		roletype : $("#roletype").val(),
		isfromlogin : $("#isfromlogin").val(),
	},
	created : function(){
		var _this = this;

		setTimeout(function(){

			_this.bindAdminPermission();
		},'1000');

		if(_this.isfromlogin == "yes"){
			setTimeout(function(){
				//	关闭所有tab页面
				_this.clearTab();
				// 把值设置为no
				location.href="/index.html?isfromlogin=no";
			},'500');
		}
	},
	methods : {

		bindAdminPermission : function(){

			var _this = this;
			layer.open({type:3});
			$.post('/Role/findPermissionByAdminid_V1',{
				rdm:Math.random()
			},function(ppData){

				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;

						var mmFirstPermission = data.FirstPermission;
						var mmNotFirstPermission = data.NotFirstPermission;
						var mmHtml="";
						for(var i=0;i<mmFirstPermission.length;i++)
						{
							mmHtml+="<li>";
							mmHtml+="<a href=\"javascript:;\">";
							mmHtml+="<i class=\"iconfont left-nav-li\" lay-tips="+mmFirstPermission[i].permisssionname+">&#xe723;</i>";
							mmHtml+="<cite>"+mmFirstPermission[i].permisssionname+"</cite>";
							mmHtml+="<i class=\"iconfont nav_right\">&#xe697;</i>";
							mmHtml+="</a>";
							mmHtml+="<ul class=\"sub-menu\">";
							for(var j=0;j<mmNotFirstPermission.length;j++)
							{
								if(mmNotFirstPermission[j].fatherid==mmFirstPermission[i].permissionid)
								{
									mmHtml+="<li>";
									mmHtml+="<a onclick=\"xadmin.add_tab('"+mmNotFirstPermission[j].permisssionname+"','/"+mmNotFirstPermission[j].url+"')\">";
									mmHtml+="<i class=\"iconfont\">&#xe6a7;</i>";
									mmHtml+="<cite>"+mmNotFirstPermission[j].permisssionname+"</cite>";
									mmHtml+="</a>";
									mmHtml+="</li>";
								}

							}
							mmHtml+="</ul>";
							mmHtml+="</li>";
						}

						$("#permission").html(mmHtml);


					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},


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