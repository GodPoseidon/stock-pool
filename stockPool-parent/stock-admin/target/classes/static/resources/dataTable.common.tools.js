/**
 * 通信专用JS
 */
$.extend({
	/**
	 * 整体Post控制，可以在单独的事件中处理业务异常。
	 * 
	 * param参数是一个Object， 有url和data两个必须属性，同$.ajax一致。 其中还有四个非必需属性：success, error,
	 * berror和complete, 其中berror是新追加的方法， 可以将Java端业务异常参数传递进来，其他三个和$.ajax一致。
	 * 
	 * $.post({ data : xxxx, url : xxxx, function success(msg) { }, funciton
	 */
	showSystemErrorMsg : function(err) {
		$.showError(err.message);
		console.log("系统异常！", err);
	},
	showBusinessErrorMsg : function(err) {
		$.showError(err.message);
		console.log("业务错误！", err);
	},

	showSessionErrorMsg : function(err) {
		$.showError("会话过期，请重新登陆");
		console.log("会话过期！", err);
	},
	aikxianAjax : function(param) {
		/*console.log("路径:" + param.url);
		console.log("访问数据：" + JSON.stringify(param.data));*/
		$.loadingShow();
		var ajaxParam = {
			type : param.type,
			async : true,
			data : param.data,
			url : param.url,
			cache : false,
			dataType : param.dataType ? param.dataType : "json",
			success : function(msg) {
				$.loadingClose()
				if (msg && (msg.success==false|| msg.success=="false")) {
				//	$.showError(msg.message);
					ajaxParam.error.apply(this, [ msg ]);
				} else {
					/** 正常处理* */
					param.success.apply(this, [ msg ]);
				}
			},
			error : function(err) {
				$.loadingClose();
				// 判断是否定义了异常处理方法
				if (param.error) {
					//$.showSystemErrorMsg(err);
					param.error.apply(this, [ err ]);
				} else {
					$.showSystemErrorMsg(err);
				}
			}
		};
		$.ajax(ajaxParam.url, ajaxParam); // 调用JQuery的Ajax方法
	},
	aikxianPost : function(param) {
		param.type = "POST";
		$.aikxianAjax(param);
	},
	aikxianGet : function(param) {
		param.type = "GET";
		$.aikxianAjax(param);
	}
});

/**
 * DataTable的异常处理。
 */
$.extend($.fn.dataTable.ext.oApi, {
	_fnLog : function(settings, level, msg) {
		if (!msg.success) {
			// 服务器端异常发生时，消除检索中的提示。
			this._fnProcessingDisplay(settings, false);
			if (msg.success ==false) {
				if (msg.code == "-1") {
					$.showSessionErrorMsg();
				} else {
					$.showBusinessErrorMsg(msg.code, msg.message,
							msg.messageAttachs);
				}
			} else {
				$.showSystemErrorMsg();
			}
		} /*else {
			$.showSystemErrorMsg();
		}*/
	}
});

$(function() {
	/** loading show */
	$.loadingOpts = {
		"lines" : 13,
		"length" : 14,
		"width" : 11,
		"radius" : 32,
		"corners" : 1,
		"rotate" : 48,
		"trail" : 52,
		"speed" : 1.2,
		"direction" : 1
	};
	if ($(".loading").length == 0) {
		$(document.body).append(
				"<div class='loading' style='display:none;'></div>");
	}
	$(".loading").spin($.loadingOpts);
	$("form[action]:not(.hasInit)").addClass("hasInit").validate({
		submitHandler : function(form) {
			var type=$(form).attr("method");
			$.aikxianAjax({
				"url" : $(form).attr("action"),
				"data" : $(form).serializeArray(),
				type:type?type:"POST",
				success : function(data) {
					console.log(data);
					if (data && (data.success==false|| data.success=="false")) {
						$.showSystemErrorMsg(data);
					}else{
						$(form).closest('.modal').find('button.close').click();     
						  if($(".queryForm")){
							  $(".queryForm").submit();
						  }
						  $.showInfo("操作成功！");
					}
					
				},
				error : function(err) {
					$.showSystemErrorMsg(err);
				}
			});
			
		}
	});
});
$.extend({
	loadingShow : function() {
		$(".loading").fadeIn(500);
	},
	loadingClose : function() {
		$(".loading").fadeOut(500)
	},

	showInfo : function(msg, timer, fun) {
		var text = "";
		if (msg.length > 10) {
			text = msg;
			msg = "";
		}
		if (swal) {
			swal({
				title : msg,
				text : text,
				timer : timer == undefined || !timer ? 0 : timer,
				confirmButtonText : "关闭"
			}, function(isConfirm) {
				if (isConfirm && fun) {
					fun();
				} else if (isConfirm || (!isConfirm && isConfirm != null)) {
					swal.close();
				}
			});
		}
	},

	showSuccess : function(msg, timer, fun) {
		var text = "";
		if (msg.length > 10) {
			text = msg;
			msg = "";
		}
		if (swal) {
			swal({
				title : msg,
				text : text,
				type : "success",
				timer : timer == undefined || !timer ? 0 : timer,
				closeOnConfirm : false,
				closeOnCancel : false,
				confirmButtonText : "关闭"
			}, function(isConfirm) {
				if (isConfirm && fun) {
					fun();
				} else if (isConfirm || (!isConfirm && isConfirm != null)) {
					swal.close();
				}
			});
		}
	},

	showWarring : function(msg, timer, fun) {
		var text = "";
		if (msg.length > 10) {
			text = msg;
			msg = "";
		}
		if (swal) {
			swal({
				title : msg,
				text : text,
				type : "warning",
				timer : timer == undefined || !timer ? 0 : timer,
				closeOnConfirm : false,
				closeOnCancel : false,
				confirmButtonText : "关闭"
			}, function(isConfirm) {
				if (isConfirm && fun) {
					fun();
				} else if (isConfirm || (!isConfirm && isConfirm != null)) {
					swal.close();
				}
			});
		}
	},
	showError : function(msg, timer, fun) {
		var text = "";
		if (msg&&msg.length > 10) {
			text = msg;
			msg = "";
		}else if(msg==undefined){
			msg = "无法连接到服务器";
		}
		if (swal) {
			swal({
				title : msg,
				text : text,
				type : "error",
				timer : timer == undefined || !timer ? 0 : timer,
				closeOnConfirm : false,
				closeOnCancel : false,
				confirmButtonText : "关闭"
			}, function(isConfirm) {
				if (isConfirm && fun) {
					fun();
				} else if (isConfirm || (!isConfirm && isConfirm != null)) {
					swal.close();
				}
			});
		}
	},
	showConfirm : function(msg, fun) {
		var text = "";
		if (msg.length > 10) {
			text = msg;
			msg = "";
		}
		if (swal) {
			swal({
				title : msg,
				text : text,
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "确认",
				cancelButtonText : "取消",
				closeOnConfirm : false,
				closeOnCancel : false
			}, function(isConfirm) {
				if (isConfirm && fun) {
					fun();
				} else if (isConfirm || (!isConfirm && isConfirm != null)) {
					swal.close();
				}
			});
		}
	},
	closeMsg : function() {
		if (swal) {
			swal.close();
		}
	},
})