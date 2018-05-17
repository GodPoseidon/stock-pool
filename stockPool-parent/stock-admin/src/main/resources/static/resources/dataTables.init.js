$(document).ready(function() {
		$(".queryForm").submit(function() {
			if($.dataTable){
				$.dataTable.fnDraw();
			}
			return false;
		});
		$(".queryForm .formRest").click(function(){
			$(".queryForm").resetForm();
			$.resetSelect2();
			return false;
		});
		$(".queryForm .formRestsubmit").click(function(){
			$(".queryForm").resetForm();
			$(".queryForm").submit();
			$.resetSelect2();
			return false;
		});
		$(".queryForm .formSubmit").click(function() {
			$.dataTable.fnDraw();
		});
		
		$.refresh=($.refresh?true:false)
		
		$('table.table.table-striped input.checkall').on('ifChecked', function(event){ 
			//ifCreated 事件应该在插件初始化之前绑定 
		  $('table.table.table-striped tbody :checkbox').iCheck('check');
		});
		$('table.table.table-striped input.checkall').on('ifUnchecked', function(event){ 
			//ifCreated 事件应该在插件初始化之前绑定 
			$('table.table.table-striped tbody :checkbox').iCheck('uncheck');
		});
		
	});