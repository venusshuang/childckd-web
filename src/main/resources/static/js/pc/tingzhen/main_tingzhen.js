var vm_tingzhen = new Vue({
	el : "#tingzhen",
	data : {
		tingzhenlist : [],		// 停诊列表

		tingzhen : {},
		tingzhenid : "",

		expertlist : [],

		editFlag : 0,			// 0:新增  1：修改
	},
	created : function(){
		// 绑定停诊信息
		this.bindTingzhenList();
	},
	methods : {
		getStartRiqi : function() {
			var _this = this;
			_this.tingzhen.starttime = $("#starttime").val(); 
		},
		getEndRiqi : function() {
			var _this = this;
			_this.tingzhen.endtime = $("#endtime").val(); 
		},

		// 绑定停诊信息
		bindTingzhenList : function(){
			var _this = this;
			layer.open({type:3});

			$.post('/tingzhen/find_valid',{
				rdm : Math.random()
			},function(ppData){

				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == '1'){

						_this.tingzhenlist = ppData.resultContent;

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		// 点击全选按钮
		allCheckTingzhen : function(){
			var _this = this;

			if($("#allCheckTingzhen").is(":checked"))
			{
				$("input[name='tingzhenCheckbox']").prop('checked',true);
			}
			else
			{
				$("input[name='tingzhenCheckbox']").prop('checked',false);
			}

		},

		// 点击“批量删除”按钮
		toDeleteChecked : function(){
			var _this = this;

			var mmTingzhenIdList = "";
			$("[name=tingzhenCheckbox]:checked").each(function(){
				mmTingzhenIdList += "," + this.value;
			})
			mmTingzhenIdList = mmTingzhenIdList != "" ? mmTingzhenIdList.substring(1) : "";

			if(mmTingzhenIdList == ""){
				layer.alert("请选择要删除的停诊信息！");
				return false;
			}

			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
				layer.open({type:3});

				$.post('/tingzhen/delete_by_tingzhenidlist',{
					tingzhenidlist : mmTingzhenIdList,			
					rdm : Math.random()
				},function(ppData){
					layer.closeAll("loading");

					if(ppData != null){
						if(ppData.result == '1'){

							layer.alert("批量删除成功!");	
							_this.bindTingzhenList();

							$("input[name='tingzhenAllCheckbox']").prop('checked',false);
						}else{
							layer.alert(ppData.message);
						}
					}
				},"json");

			})
		},

		// 点击“删除”按钮
		toDelete : function(ppTingzhenId){
			var _this = this;

			layer.confirm("是否确定删除该停诊信息？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});

				$.post("/tingzhen/delete", {
					tingzhenid : ppTingzhenId,
					rdm : Math.random()
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
							_this.bindTingzhenList();
						}
					}
				},"json");
			})
		},

		// 点击"新增停诊" 按钮
		toAddTingzhen : function(){
			$('#editTingzhenModal').modal();
			$("#myModalLabel_tingzhen").html("新增停诊信息");

			this.editFlag = 0;
			this.tingzhen = {};
			this.tingzhenid = "";
			this.bindExpertList();
		},

		// 点击"修改" 按钮
		toModifyTingzhen : function(ppTingzhenId){
			$('#editTingzhenModal').modal();
			$("#myModalLabel_tingzhen").html("修改停诊信息");

			this.editFlag = 1;
			this.tingzhenid = ppTingzhenId;
			this.bindExpertList();
			this.bindTingzhen();
		},

		// 绑定专家下拉列表
		bindExpertList : function(){
			var _this = this;

			layer.open({type:3});
			$.post('/expert/findExpertByName', {
				name : "",
				rdm : Math.random()
			},function(ppData) {
				layer.closeAll("loading");

				if (ppData != null) {
					if(ppData.result == "1"){
						_this.expertlist = ppData.resultContent;
					}
				}
			},"json");
		},

		// 根据停诊id查找停诊信息
		bindTingzhen : function(){
			var _this = this;

			layer.open({type:3});
			$.post('/tingzhen/find_one', {
				tingzhenid : _this.tingzhenid,
				rdm : Math.random()
			},function(ppData) {
				layer.closeAll("loading");

				if (ppData != null) {
					if(ppData.result == "1"){
						_this.tingzhen = ppData.resultContent;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		// 新增停诊
		addTingzhen : function(){
			var _this = this;

			if(_this.checkInputData()){
				layer.open({type:3});

				$.post('/tingzhen/add',{
					expertid : _this.tingzhen.expertid,
					starttime : _this.tingzhen.starttime,
					endtime : _this.tingzhen.endtime,
					isam : _this.tingzhen.isam,
					ispm : _this.tingzhen.ispm,
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

							$("#editTingzhenModal").modal("hide");
							_this.bindTingzhenList();
						}else{
							layer.alert(ppData.message);
						}
					}
				},"json")
			}
		},

		// 修改停诊
		modifyTingzhen : function(){
			var _this = this;

			if(_this.checkInputData()){
				layer.open({type:3});

				$.post('/tingzhen/modify',{
					tingzhenid : _this.tingzhenid,
					expertid : _this.tingzhen.expertid,
					starttime : _this.tingzhen.starttime,
					endtime : _this.tingzhen.endtime,
					isam : _this.tingzhen.isam,
					ispm : _this.tingzhen.ispm,
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

							$("#editTingzhenModal").modal("hide");
							_this.bindTingzhenList();
						}else{
							layer.alert(ppData.message);
						}
					}
				},"json")
			}
		},

		// 输入检查
		checkInputData : function(){
			var _this = this;

			_this.tingzhen.expertid = !_this.tingzhen.expertid ? "" : $.trim(_this.tingzhen.expertid);
			if("" == _this.tingzhen.expertid){
				layer.alert("请选择专家姓名！");
				return false;
			}

			_this.tingzhen.starttime = !_this.tingzhen.starttime ? "" : $.trim(_this.tingzhen.starttime);
			if("" == _this.tingzhen.starttime){
				layer.alert("请选择停诊开始日期！");
				return false;
			}

			_this.tingzhen.endtime = !_this.tingzhen.endtime ? "" : $.trim(_this.tingzhen.endtime);
			if("" == _this.tingzhen.endtime){
				layer.alert("请选择停诊结束日期！");
				return false;
			}

			if(_this.tingzhen.starttime > _this.tingzhen.endtime){
				layer.alert("停诊开始日期不能大于停诊结束日期！");
				return false;
			}

			if(_this.tingzhen.isam === "" || _this.tingzhen.isam == undefined || _this.tingzhen.isam == null){
				layer.alert("请选择是否上午停诊！");
				return false;
			}

			if(_this.tingzhen.ispm === "" || _this.tingzhen.ispm == undefined || _this.tingzhen.ispm == null){
				layer.alert("请选择是否下午停诊！");
				return false;
			}

			return true;
		},

	}
})