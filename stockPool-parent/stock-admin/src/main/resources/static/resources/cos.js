var showName = "showName"; // 上传完成结果显示的标签ID
var flag = "IMAGE"; // 上传对象是图片还是视频
var showResult = "result"; // 上传完成，文件路径保存的标签ID

var myFolder = '/video/';// 需要操作的目录
$('.js-file-cos').off('change').on( 'change',
		function(e) {
			flag = $(this).attr("data-type");
			showResult = $(this).attr("data-result");
			showName = $(this).attr("data-show");
			/* flag:IMAGE：图片;VIDEO:视频; */
			if (flag != "") {
				$.ajax({
					url : "/system/cos/findFolder",
					type : "post",
					async : false,
					dataType : "json",
					data : {flag : flag},
					success : function (data) {
						if (data.success) {
							myFolder = data.data;
						}
					}
				});
			}
			var cos = new CosCloud({
				appid : '1251995088',// APPID 必填参数
				bucket : 'bucket-stock',// bucketName 必填参数
				region : 'sh',// 地域信息 必填参数 华南地区填gz 华东填sh 华北填tj
				getAppSign : function(callback) {// 获取签名 必填参数

					// 下面简单讲一下获取签名的几种办法

					// 1.搭建一个鉴权服务器，自己构造请求参数获取签名，推荐实际线上业务使用，优点是安全性好，不会暴露自己的私钥
					// 拿到签名之后记得调用callback
					/*
					 * $.ajax(sy.path+'cos/sign/appSign').done(function (data) {
					 * var sig = data.sign; callback(sig); });
					 */
					var timestamp = Date.parse(new Date());
					timestamp = timestamp / 1000;
					$.ajax({
						url : "/system/cos/sign/appSign",
						type : "post",
						async : false,
						dataType : "json",
						data : {
							bucketName : "bucket-stock",
							path : myFolder,
							expired : timestamp + 6000
							},
						success : function (data) {
							if (data.success) {
								callback(data.data);
							}
						}
					});
				},
				getAppSignOnce : function(callback) {// 单次签名，必填参数，参考上面的注释即可
					// 填上获取单次签名的逻辑
				}
			});

			var file = e.target.files[0];
			var filename = getNewFileName(file.name);
			var bucket = "bucket-stock";
			// 大文件也可以直接调用uploadFile
			cos.uploadFile(successCallBack, errorCallBack, progressCallBack,bucket, myFolder + filename, file, 0);
			// 也可以用sliceUploadFile，选一个即可
			// cos.sliceUploadFile(successCallBack, errorCallBack,
			// progressCallBack, bucket, myFolder+file.name, file, 0);
			return false;
		});

var successCallBack = function(result) {
	console.log('success:' + JSON.stringify(result));
	if (result.code == 0) {
		if (flag == "VIDEO") {
			$("#" + showResult).val(result.data.access_url);
		} else if (flag == "IMAGE") {
			$("#" + showResult).attr("src", result.data.access_url);
		}

		$("#" + showName).text("成功");
	} else {
		$("#" + showName).text("失败");
	}
};

var errorCallBack = function(result) {
	result = result || {};
	console.log('error:' + result.responseText);

	$("#" + showName).text("失败");
};

var progressCallBack = function(curr) {
	console.log('uploading... curr progress is ' + curr)
	$("#" + showName).text("上传中...");
};

function getNewFileName(fileName) {
	var extIndex = fileName.lastIndexOf('.');
	var ext = fileName.substring(extIndex);
	return new Date().getTime() + ext;
}