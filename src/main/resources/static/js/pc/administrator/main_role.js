var Role_Vue = new Vue({
	el : '#Role',
	data : {
		
		rolename : $("#rolename").val(),
		rolelist : [],
		role : {},	
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		roleid : '',	

	},
	
	created : function() {
		var _this = this;

		_this.bindRoleList();
	},
	
	
	methods : {
		setpermission : function(ppRoleid){
			var _this = this;
			$('#editPermissionModal').modal();
			$("#myModalLabel_Permission").html("角色权限设置");
			_this.roleid = ppRoleid;
			$("#permission").html("");
			_this.bindPermission();
			//_this.bindRolePermission();
			//_this.$forceUpdate();
		},

		bindPermission : function(){

			var _this = this;
			layer.open({type:3});
			$.post('/Role/findPermission',{
				type : 'role',
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

							mmHtml+="<input style=\"zoom:150%;vertical-align:text-bottom\" type=\"checkbox\" name=\"permissionCheckbox\"  value=\""+mmFirstPermission[i].permissionid+"\" id=\"allCheckRole\">"+mmFirstPermission[i].permisssionname+"<br/>";
							for(var j=0;j<mmNotFirstPermission.length;j++)
							{
								if(mmNotFirstPermission[j].fatherid==mmFirstPermission[i].permissionid)
								{
									mmHtml+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style=\"zoom:150%;vertical-align:text-bottom\" type=\"checkbox\" name=\"permissionCheckbox\"  value=\""+mmNotFirstPermission[j].permissionid+"\" id=\"allCheckRole\">"+mmNotFirstPermission[j].permisssionname+"<br/>";
								}

							}
						}
						$("#permission").html(mmHtml);

						_this.bindRolePermission();

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		bindRolePermission : function(){

			var _this = this;
			layer.open({type:3});
			$.post('/Role/findPermissionByRoleid',{
				roleid : _this.roleid,
				rdm:Math.random()
			},function(ppData){

				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;


						for(var i=0;i<data.length;i++)
						{

							$("input[name='permissionCheckbox'][value="+data[i].permissionid+"]").prop('checked',true);
						}

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		 
	
		bindRoleList : function(){
			
			var _this = this;
			layer.open({type:3});
			$.post('/Role/findRoleByRoleName',{
				rolename:_this.rolename,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						_this.rolelist =ppData.resultContent;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.rolename='';
			$("#rolename").val("");
		},
		
		perparetoAddRole : function(){
			$('#editRoleModal').modal();
			$("#myModalLabel_role").html("新增角色信息");
			this.editFlag = 0;
			this.role = {};
			this.roleid="";
			
		
		},
		
		
		
		perpareToModifyRole : function(ppRoleId){

			$('#editRoleModal').modal();
			$("#myModalLabel_role").html("修改角色信息");
			this.editFlag = 1;

			this.roleid = ppRoleId;
			this.bindRoleList();
			this.bindRole();
			
		},
		
		bindRole : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/Role/find_one', {
				roleid : _this.roleid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.role = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		addRole : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/Role/saveRole',{
					roleid:_this.roleid,
					rolename:_this.role.rolename,
					displayname : !_this.role.displayname ? "" : $.trim(_this.role.displayname),
					beizhu : !_this.role.beizhu ? "" : $.trim(_this.role.beizhu),
					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"新增成功!",
							});
							$("#editRoleModal").modal("hide");
							_this.bindRoleList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},

		savePermission : function(){
			var _this = this;

			var mmPermissionIdList="";
			$("[name=permissionCheckbox]:checked").each(function(){
				mmPermissionIdList+="|"+this.value;
			})
			mmPermissionIdList=mmPermissionIdList!=""?mmPermissionIdList.substring(1):"";

			if(mmPermissionIdList == ""){
				layer.alert("请选择权限！");
				return false;
			}


			layer.open({type:3});
			$.post('/Role/savePermission',{
				id:_this.roleid,
				type:'role',
				permissionIdList:mmPermissionIdList,
				random : Math.random()
			},function(ppData){
				if(ppData != null){
					layer.closeAll("loading");
					if(ppData.result == "1"){
						layer.open({
							time:1000,
							btn:[],
							content:"新增成功!",
						});
						//	$("#editRolePermissionModal").modal("hide");

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json")

		},
		
		
		
		
		
		//检查输入信息
		checkInputData : function(){
			var _this = this;
			
			var rolename = !_this.role.rolename ? "" : $.trim(_this.role.rolename);
			if("" == rolename){
				layer.alert("请填写角色名！");
	    		return false;
			}
			
			var displayname = !_this.role.displayname ? "" : $.trim(_this.role.displayname);
			if("" == displayname){
				layer.alert("请填写展示名称！");
	    		return false;
			}
			
			var beizhu = !_this.role.beizhu ? "" : $.trim(_this.role.beizhu);
			if("" == beizhu){
				layer.alert("请填写备注！");
	    		return false;
			}

			return true;
		},
		
		allCheckRole : function(){
			var _this = this;
			
			//var mmValue=$("#allCheckPaiban:checked").val();
			
			if($("#allCheckRole").is(":checked"))
			{
			    $("input[name='roleCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='roleCheckbox']").prop('checked',false);
			}
			
			
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmRoleIdList="";
			$("[name=roleCheckbox]:checked").each(function(){
				mmRoleIdList+="|"+this.value;
			})
			mmRoleIdList=mmRoleIdList!=""?mmRoleIdList.substring(1):"";
			
			if(mmRoleIdList == ""){
				layer.alert("请选择要删除的角色！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/Role/deleteRoleIdList',{
				roleIdList :mmRoleIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindRoleList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},
			
		
		
		
		modifyRole : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/Role/saveRole',{
					roleid:_this.roleid,
					rolename:_this.role.rolename,
					displayname : !_this.role.displayname ? "" : $.trim(_this.role.displayname),
					beizhu : !_this.role.beizhu ? "" : $.trim(_this.role.beizhu),
					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"修改成功!",
							});
							$("#editRoleModal").modal("hide");
							_this.bindRoleList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},
		
		toDelete : function(ppRoleId){
			var _this = this;
			layer.confirm("确定删除该角色信息吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/Role/deleteRole", {
					roleid : ppRoleId,
					random : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");
						if(ppData.result != "1"){
							layer.alert(ppData.message);
						}else{
							layer.open({
								time:1000,
								btn:[],
								content:"删除成功!",
							});
							_this.bindRoleList();
						}
					}
				},"json");
			})
		},
		
		
		
		
		
		
	}
})
