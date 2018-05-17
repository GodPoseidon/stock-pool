$.extend(true, $.fn.dataTable.defaults, {
	"searching" : false,
	"ordering" : false,
	"paging" : true,
	"sPaginationType" : "full_numbers",
	"pagingType" : "full_numbers",
	"lengthChange" : true,
	"info" : true,


	"bAutoWidth":false,
	"serverSide" : true,
	"bStateSave" : false,
	'iDisplayLength' : 10,
	/*"bProcessing" : true,
	"processing" : true,*/
	"bLengthChange" : true,	
	
	"autoWidth" : false,
	"dom" : '<"top">rt<"bottom"ilp><"clear">',
	"language" : {
		"lengthMenu" : "_MENU_ 记录/页",
		"zeroRecords" : "没有匹配的记录",
		"info" : "显示第 _START_ 至 _END_ 项记录，共 _TOTAL_ 项",
		"infoEmpty" : "没有匹配的记录",
		"emptyTable" : "没有匹配的记录",	
		"infoFiltered" : "(由 _MAX_ 项记录过滤)",
		"search" : "过滤:",
		"paginate" : {
			"sFirst" : "首页",
			"sPrevious" : "上页",
			"sNext" : "下页",
			"sLast" : "末页"
		},
		select : {
			rows : {
				_ : "选中 %d 行"
			}
		}
	},
	"oLanguage" : {
		"sProcessing" : "处理中...",
		"sLengthMenu" : "_MENU_ 记录/页",
		"sZeroRecords" : "没有匹配的记录",
		"sInfo" : "显示第 _START_ 至 _END_ 项记录，共 _TOTAL_ 项",
		"sInfoEmpty" : "没有匹配的记录",
		"sEmptyTable" : "没有匹配的记录",	
		"sInfoFiltered" : "(由 _MAX_ 项记录过滤)",
		"sInfoPostFix" : "",
		"sSearch" : "过滤:",
		"sUrl" : "",
		"oPaginate" : {
			"sFirst" : "首页",
			"sPrevious" : "上页",
			"sNext" : "下页",
			"sLast" : "末页"
		},
		select : {
			rows : {
				_ : "选中 %d 行"
			}
		}
	}
});