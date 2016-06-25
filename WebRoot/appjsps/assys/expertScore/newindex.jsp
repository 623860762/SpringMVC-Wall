<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
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
	<div class="datagrid_div">
	<div class="link_button_div">
		<span class="button_position_link">
			<a id="Del" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:'true'">删除</a>
			<a id="Merge" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:'true'">修改</a>
			<a id="view" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看</a>
			<a id="overaAss" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">总体评估</a>
			<a id="detailAss" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">细部评估</a>
			<div id="messg_id" class="message_div"></div>
		</span>
	<table id="ListId"/></table>
	<div id="tb" style="height:auto">
		<a id="addNew" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:'true'">增加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除专家打分</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存专家打分</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">撤销所有修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
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
		
		$('#ListId').datagrid({
			url: 'expertScoreController.do?method=forListContent',
			title: '专家打分',
			iconCls: 'icon-edit',
			width: 780,
			height: 352,
			rownumbers:true,
			fitColumns: true,
			pagination:true,	
			toolbar: '#tb',
			onClickRow: onClickRow,
			singleSelect: true,
			columns:[[
				{field:'button',title:'操作',formatter:function(val,rec){return '<a class="saveIcon">保存</a>';}},
				{field:'expertName',title:'专家名称',width:90,align:'center',editor:'text'},
				{field:'steadyScore',title:'稳定性得分',width:150,align:'center',editor:'text'},
				{field:'baseScore',title:'基础得分',width:150,align:'center',editor:'text'},
				{field:'strenthScore',title:'强度得分',width:150,align:'center',editor:'text'}
			]],
			onLoadSuccess:function(){
				//ObjList = $('#ListId').data('datagrid').data;
		}
	});
	
			$("#addNew").click(
				function(){
					var chidDiaVal = window.showModalDialog('expertScoreController.do?method=forExpScorePersist&wallId=22','','dialogWidth:270px;dialogHeight=165px;center=yes;border=thick;status=no;help=no;scrollbars=no');
					if(chidDiaVal=="2"){
						alert("新增专家打分成功");
						$('#ListId').datagrid('reload');
					}else if(chidDiaVal=="1"){
						alert("新增专家打分失败");
						return false;
					}else{
						return false
					}
				}
			);
});
</script>
	<script type="text/javascript">
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){return true}
			if ($('#ListId').datagrid('validateRow', editIndex)){
				$('#ListId').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#ListId').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#ListId').datagrid('selectRow', editIndex);
				}
			}
		}
		function append(){
			if (endEditing()){
				$('#ListId').datagrid('appendRow',{expertName: '某专家',baseScore: '111'});
				console.log($('#ListId').datagrid('getRows').length);
				editIndex = $('#ListId').datagrid('getRows').length-1;
				$('#ListId').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);
			}
		}
		function removeit(){
			if (editIndex == undefined){return}
			$('#ListId').datagrid('cancelEdit', editIndex)
					.datagrid('deleteRow', editIndex);
			editIndex = undefined;
		}
		function accept(){
			if (endEditing()){
				$('#ListId').datagrid('acceptChanges');
			}
		}
		function reject(){
			$('#ListId').datagrid('rejectChanges');
			editIndex = undefined;
		}
		function getChanges(){
			var rows = $('#ListId').datagrid('getChanges');
			alert(rows.length+' rows are changed!');
		}
	</script>
</body>
</html>
	