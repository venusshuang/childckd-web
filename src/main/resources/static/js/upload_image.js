function $$(id) {
	return document.getElementById(id);	
}

var uploader = new plupload.Uploader({
	multi_selection : false,
	runtimes : 'gears,html5,html4,flash,silverlight,browserplus',
	browse_button : 'pickfiles',
	container: 'container',
	max_file_size : '2mb',
	url : '../upload/UploadImage',
	//resize : {width : 320, height : 240, quality : 90},
	flash_swf_url : '../js/plupload/plupload.flash.swf',
	silverlight_xap_url : '../js/plupload/plupload.silverlight.xap',
	filters : [
		{title : "Image files", extensions : "jpg,gif,png,bmp"}
	]
});

function InitUpLoader()
{
	uploader.bind('Init', function(up, params) {
		$$('filelist').innerHTML = "";
	});
	
	uploader.init();

	uploader.bind('FilesAdded', function(up, files) {

		for ( var i in files) {
			$$('filelist').innerHTML = '<span id="' + files[i].id + '">'
					+ files[i].name + ' (' + plupload.formatSize(files[i].size)
					+ ') <b></b></span>';
			$("#fujianmingcheng").val(files[i].name);
		}
		uploader.start();
	});

	uploader.bind('UploadProgress', function(up, file) {
		$$(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	});

	uploader.bind('FileUploaded', function(up, file, response) {
		var mmResponse = (response.response).replace(/\\/g, "").replace(/(")/g, "");
	    var mmFileUrl = mmResponse;
	    console.log(mmFileUrl);
	   
	    //$("#imageurl").val(mmFileUrl);
	    $("input[name='renyuan_image']").val(mmFileUrl);
	    $("input[name='renyuan_image']")[0].dispatchEvent(new Event('input'));
	    $("#renyuan_image").attr("src",mmFileUrl);

	    file.value = unescape(mmFileUrl);
	});
	uploader.bind('Error', function(up, err) {
	    //alert("Error #" + err.code + ": " + err.message);
	});
}

function InitUpLoader2()
{
	uploader.bind('Init', function(up, params) {
		$$('filelist').innerHTML = "";
	});
	
	uploader.init();

	uploader.bind('FilesAdded', function(up, files) {

		for ( var i in files) {
			$$('filelist').innerHTML = '<span id="' + files[i].id + '">'
					+ files[i].name + ' (' + plupload.formatSize(files[i].size)
					+ ') <b></b></span>';
			$("#fujianmingcheng").val(files[i].name);
		}
		uploader.start();
	});

	uploader.bind('UploadProgress', function(up, file) {
		$$(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	});

	uploader.bind('FileUploaded', function(up, file, response) {
		var mmResponse = (response.response).replace(/\\/g, "").replace(/(")/g, "");
	    var mmFileUrl = mmResponse;
	    console.log(mmFileUrl);
	   
	    $("#imageurl").val(mmFileUrl);

	    file.value = unescape(mmFileUrl);
	});
	uploader.bind('Error', function(up, err) {
	    //alert("Error #" + err.code + ": " + err.message);
	});
}

var uploader3 = new plupload.Uploader({
	multi_selection : false,
	runtimes : 'gears,html5,html4,flash,silverlight,browserplus',
	browse_button : 'pickfiles3',
	container: 'container3',
	max_file_size : '2mb',
	url : '../../../../upload/UploadImage',
	//resize : {width : 320, height : 240, quality : 90},
	flash_swf_url : '../js/plupload/plupload.flash.swf',
	silverlight_xap_url : '../js/plupload/plupload.silverlight.xap',
	filters : [
		{title : "Image files", extensions : "jpg,gif,png,bmp"}
	]
});

function InitUpLoader3()
{
	uploader3.bind('Init', function(up, params) {
		$$('filelist3').innerHTML = "";
	});
	
	uploader3.init();

	uploader3.bind('FilesAdded', function(up, files) {

		for ( var i in files) {
			$$('filelist3').innerHTML = '<span id="' + files[i].id + '">'
					+ files[i].name + ' (' + plupload.formatSize(files[i].size)
					+ ') <b></b></span>';
		}
		uploader3.start();
	});

	uploader3.bind('UploadProgress', function(up, file) {
		$$(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	});

	uploader3.bind('FileUploaded', function(up, file, response) {
		var mmResponse = (response.response).replace(/\\/g, "").replace(/(")/g, "");
	    var mmFileUrl = mmResponse;
	    console.log(mmFileUrl);
	   
	    $("#url").val(mmFileUrl);
	    file.value = unescape(mmFileUrl);
	    
//
//	    var str = "<img width=262 height=262 src='"+ mmFileUrl +"'/>";
//	    var str2 = "<img width=800 src='"+ mmFileUrl +"'/>";
//	    
//      $("#preview").html(str);
//	    editor.execCommand("insertHTML",str2);
	    
	    createPreviewImage(mmFileUrl);
	});
	uploader3.bind('Error', function(up, err) {
	    //alert("Error #" + err.code + ": " + err.message);
	});

//	$("#uploadfiles").bind("onclick",function() {
//		uploader2.start();
//		return false;
//	});	
}

