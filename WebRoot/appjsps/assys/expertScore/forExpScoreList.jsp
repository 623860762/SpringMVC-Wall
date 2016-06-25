<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String wallId = (String)request.getAttribute("wallId");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家打分</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assys.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<div align="center">
	<div class="link_button_div">
	<table id="ListId"/></table>
	<div id="tb" style="height:auto">
		<a id="submExpScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">完成专家打分</a>
		<a id="viewWall" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查看挡土墙信息</a>
		<a id="messg_id" style="color:red;float:right;margin-right:16px;margin-top:3px;"></a>
	</div>
	</div>
</div>
		<script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/locale/easyui-lang-zh_CN.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.util.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/jquery.serializeJSON.js"></script>

<script type="text/javascript">
	$(function(){
		
		var ObjList;
		var currentIndex;
		var rowNum;
		var pareMoDiaObj = new Object();
		pareMoDiaObj.isModalDialog = "yes";
		
		$('#ListId').datagrid({
			url: 'expertScoreController.do?method=forListContent&wallId=<%=wallId%>',
			title: '专家打分',
			iconCls: 'icon-edit',
			width: 780,
			height: 352,
			rownumbers:true,
			fitColumns: true,
			pagination:true,	
			toolbar: '#tb',
			tools: [{   
    		   iconCls:'icon-add', 
   		   	   handler:function(){forAdd();}   
  		    },
  		    {   
    		   iconCls:'icon-remove', 
   		   	   handler:function(){forDelete();}   
  		    },
  		    {   
    		   iconCls:'icon-edit', 
   		   	   handler:function(){forMerge();}   
  		    },
  		    {   
               iconCls:'icon-search',   
               handler:function(){forView();}   
  			}],
			singleSelect: false,
			columns:[[
				{field:'checkBox',checkbox:true},
				{field:'expertName',title:'专家名称',width:90,align:'center',editor:'text'},
				{field:'steadyScore',title:'稳定性得分',width:150,align:'center',editor:'text'},
				{field:'baseScore',title:'基础得分',width:150,align:'center',editor:'text'},
				{field:'strenthScore',title:'强度得分',width:150,align:'center',editor:'text'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});
	
	$("#submExpScore").click(function(){
			$.messager.confirm('', '确定提交专家最终打分结果,提交后专家打分将不能修改!', function(del){
				 if (del){
							alert("提交专家打分成功！");
							esourcing.util.goUrlCloself();
						}
				});	
	});
	
		function forAdd(){
					var chidDiaVal = window.showModalDialog('expertScoreController.do?method=forExpScorePersist&wallId=<%=wallId%>',pareMoDiaObj,'dialogWidth:270px;dialogHeight=165px;center=yes;border=thick;status=no;help=no;scrollbars=no');
					if(chidDiaVal=="2"){
						esourcing.util.rightMessage("新增提示","新增专家打分成功");
						$('#ListId').datagrid('reload');
					}else if(typeof(chidDiaVal)=='undefined'){
							return false;
					}else{
						esourcing.util.rightMessage("新增提示","新增专家打分失败");
						return false;
					}	
		};
		function forMerge(){
					ObjList = esourcing.util.getSelections("ListId","expertScoreId");
					rowNum = ObjList.length;
					if(ObjList.length==1){
						var chidDiaVal = window.showModalDialog('expertScoreController.do?method=forExpScoreMerge&expertScoreId='+ObjList[0],pareMoDiaObj,'dialogWidth:270px;dialogHeight=165px;center=yes;border=thick;status=no;help=no;scrollbars=no');
						if(chidDiaVal=="2"){
							esourcing.util.rightMessage("修改提示","修改专家打分成功");
							$('#ListId').datagrid('reload');
						}else if(typeof(chidDiaVal)=='undefined'){
							return false;
						}else{
							esourcing.util.rightMessage("修改提示","修改专家打分失败");
							return false;
						}
					}else if(ObjList.length==0){
						$("#messg_id").html('请选择一条记录');
						return false;
					}else{
						$("#messg_id").html('只能选择一条记录');
						return false;
					}				
		};
		function forDelete(){
					ObjList = esourcing.util.getSelections("ListId","expertScoreId");
					var objIds = ObjList.join();
					rowNum = ObjList.length;
					if(rowNum==0){
						$("#messg_id").html('请选择一条或多条记录');
						return false;
						}
					$.messager.confirm('', '确定删除选中'+rowNum+'记录', function(del){
						if (del){
							$.ajax({
								   type: "POST",
								   url: "expertScoreController.do?method=expDelete",
								   data: "objIds="+objIds,
								   success: function(data){
											if(data=='2'){
												esourcing.util.rightMessage("删除提示","删除专家打分成功");  
											}else{
												esourcing.util.rightMessage("删除提示","删除专家打分失败");  
											}
										$('#ListId').datagrid('reload');
								   }
							});
						}
					});				
		};
		function forView(){
			
		};
		
		
});
</script>
</body>
</html>
	