<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%@ page import="com.ceit.ebs.cn.assys.wall.entity.AssWall"%>
<% 
	AssWall assWall = (AssWall)request.getAttribute("assWall");
	String wallId = assWall.getWallId();
	String wallStatu = assWall.getAssWallStatu();
	String wallStatuVal = "";
	if("1".equals(wallStatu)){
		wallStatuVal = "挡土墙编辑";
	}else if("2".equals(wallStatu)){
		wallStatuVal = "正在总体评估";
	}else if("3".equals(wallStatu)){
		wallStatuVal = "总体评估完成";
	}else if("4".equals(wallStatu)){
		wallStatuVal = "正在细部评估";
	}else if("5".equals(wallStatu)){
		wallStatuVal = "细部评估完成";
	}else if("6".equals(wallStatu)){
		wallStatuVal = "评估完成";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挡土墙评估进度查看</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assIndex.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<div align="center" class="w840">
		<table class="table_common">
			<tr>
				<td colspan="4" style="text-align:center;">
					<span class="span_icon_head">
					<span class="column_head_word">挡土墙评估进度</span>
					</span>
				</td>
			</tr>	
	<tr>
    	<td colspan="4" class="head_padding_left">评估状态</td>
    </tr>
	<tr>
    	<td colspan="4" align="center" style="height:35px;background:#EAECF1;">
    		<a id="" name="flow_btns" class="easyui-linkbutton" data-options="plain:'true'">挡土墙编辑</a><a class="flow_line1"></a>
    		<a id="" name="flow_btns" class="easyui-linkbutton" data-options="plain:'true'">正在总体评估</a><a class="flow_line1"></a>
    		<a id="" name="flow_btns" class="easyui-linkbutton" data-options="plain:'true'">总体评估完成</a><a class="flow_line1"></a>
    		<a id="" name="flow_btns" class="easyui-linkbutton" data-options="plain:'true'">正在细部评估</a><a class="flow_line1"></a>
    		<a id="" name="flow_btns" class="easyui-linkbutton" data-options="plain:'true'">细部评估完成</a><a class="flow_line1"></a>
    		<a id="" name="flow_btns" class="easyui-linkbutton" data-options="plain:'true'">评估完成</a>
    	</td>
    </tr>
	<tr>
    	<td colspan="4" class="head_padding_left">基本信息<a id="viewWall" href="javascript:void(0)" class="head_more" style="float:right;margin-right:5px;">查看详细信息</a></td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙的名称:</td><td class="table_td3"><%=assWall.getWallName()==null?"":assWall.getWallName() %></td>
    	<td class="table_td1">挡土墙所在地区:</td><td class="table_td3"><%=assWall.getWallLocation()==null?"":assWall.getWallLocation() %></td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙所属铁路局:</td><td class="table_td3"><%=assWall.getWallOwer()==null?"":assWall.getWallOwer() %></td>
    	<td class="table_td1">评估状态:</td><td class="table_td3" style="color:red;"><%=wallStatuVal %></td>
    </tr>
	<tr>
    	<td colspan="4" class="head_padding_left">当前状态可进行的操作</td>
    </tr>
    
    <%
    	if("1".equals(wallStatu)){%>
			<tr>
		    	<td class="table_td4"><a id="mergeWall" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">修改挡土墙</a></td><td colspan="3" class="table_td4"></td>
		    </tr>
		    <tr>
	    	<td colspan="4">
	    		<span class="button_span_locNew">
				<a id="subOverAss" class="easyui-linkbutton" data-options="toggle:true,iconCls:'icon-ok'">提交总体评估</a>
	    		</span>
	    	</td>
    		</tr>
    	<%}else if("2".equals(wallStatu)){%>
			<tr>
		    	<td class="table_td4"><a id="expScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">专家打分</a></td><td colspan="3" class="table_td4"></td>
		    </tr>
		    <tr>
	    	<td colspan="4">
	    		<span class="button_span_locNew">
				<a id="sureOverAss" class="easyui-linkbutton" data-options="iconCls:'icon-ok',toggle:true,">确定总体评估</a>
	    		</span>
	    	</td>
    		</tr>
    	<%}else if("3".equals(wallStatu)){%>
			<tr>
		    	<td class="table_td4"><a id="viewExpScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看专家打分</a></td><td class="table_td4"><a id="viewOverScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看总体评估得分</a></td>
		    	<td colspan="2" class="table_td4"></td>
		    </tr>
		    <tr>
	    	<td colspan="4">
	    		<span class="button_span_locNew">
				<a id="subDetailAss" class="easyui-linkbutton" data-options="toggle:true,iconCls:'icon-ok'">提交细部评估</a>
	    		</span>
	    	</td>
    		</tr>
    	<%}else if("4".equals(wallStatu)){%>
		    <tr>
	    	<td colspan="4">
	    		<span class="button_span_locNew">
				<a id="sureDetailAss" class="easyui-linkbutton" data-options="toggle:true,iconCls:'icon-ok'">确定细部评估</a>
	    		</span>
	    	</td>
    		</tr>
    	<%}else if("5".equals(wallStatu)){%>
			<tr>
		    	<td class="table_td4"><a id="viewDetailScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看细部评估得分</a></td>
		    	<td colspan="3" class="table_td4"></td>
		    </tr>
		    <tr>
	    	<td colspan="4">
	    		<span class="button_span_locNew">
				<a id="endDetailAss" class="easyui-linkbutton" data-options="toggle:true,iconCls:'icon-ok'">结束评估</a>
	    		</span>
	    	</td>
    		</tr>    	
    	<%}else if("6".equals(wallStatu)){%>
			<tr>
		    	<td class="table_td4"><a id="viewOverScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看总体评估得分</a></td><td class="table_td4"><a id="viewDetailScore" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:'true'">查看细部评估得分</a></td>
		    	<td colspan="2" class="table_td4"></td>
		    </tr>
		    <tr>
	    	<td colspan="4">
	    		<span class="button_span_location">
				<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">返回</a>
	    		</span>
	    	</td>
    		</tr>
    	<%}
     %>
		</table>
	</div>
		<script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/locale/easyui-lang-zh_CN.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.util.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/jquery.serializeJSON.js"></script>
<script>
	$(function(){
	
	var pareMoDiaObj = window.dialogArguments;
		
	$("#back").click(
		function(){
			if(esourcing.util.isModalDialog(pareMoDiaObj)){
				window.close();
			}else{
				esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
			}
		}
	);
	var len = 0;
	$("a[name='flow_btns']").each(function(){
		if(len><%=wallStatu%>-1)
    		$(this).linkbutton('disable');
		len++;
  });
  $("#expScore").click(function(){
  		esourcing.util.goUrl('expertScoreController.do?method=forExpScoreList&wallId=<%=wallId%>');
  });
  $("#viewWall").click(function(){
  		esourcing.util.goUrl('assWallController.do?method=forWall&wallId=<%=wallId %>');
  });
  $("#mergeWall").click(function(){
  		esourcing.util.goUrl('assWallController.do?method=forWallMerge&wallId=<%=wallId %>');
  });
  $("#viewExpScore").click(function(){
  		esourcing.util.goUrl('assWallController.do?method=forWallMerge&wallId=<%=wallId %>');
  });
  $("#viewOverScore").click(function(){
  		esourcing.util.goUrl('assWallController.do?method=forOverScore&wallId=<%=wallId %>');
  });
  $("#viewDetailScore").click(function(){
  		esourcing.util.goUrl('assWallController.do?method=forDetailScore&wallId=<%=wallId %>');
  });
  $("#subOverAss").click(function(){
  	updateAssStatu('确定提交总体评分，提交后挡土墙基本信息将处于锁定状态不能修改！','提交总体评估',2,'<%=wallId %>');
  });
  $("#sureOverAss").click(function(){
  	$.messager.confirm('', '确定进行总体评分，提交后专家打分信息将处于锁定状态不能修改,您可以查看总体评估得分！', function(del){
  		if(del){
				$.ajax({
					type: "POST",
					url: "assWallController.do?method=CalExpScore",
					data:"assWallStatu=3&wallId=<%=wallId %>",
					success: function(data){
					if(data=='2'){
						alert("总体评估成功");
						esourcing.util.freshCurPage();
					}else{
						esourcing.util.rightMessage("提示","总体评估失败");
						return false;
					}
				}
			});
		}
	});
  });
  $("#sureDetailAss").click(function(){
  	$.messager.confirm('', '确定进行细部评分！', function(del){
  		if(del){
				$.ajax({
					type: "POST",
					url: "assWallController.do?method=CalDetailScore",
					data:"assWallStatu=5&wallId=<%=wallId %>",
					success: function(data){
					if(data=='2'){
						alert("细部评估成功");
						esourcing.util.freshCurPage();
					}else{
						esourcing.util.rightMessage("提示","细部评估失败");
						return false;
					}
				}
			});
		}
	});
  });
  $("#subDetailAss").click(function(){
 	updateAssStatu('确定提交细部评估，提交后将进入细部评估！','提交细部评估',4,'<%=wallId %>');
  });
  $("#endDetailAss").click(function(){
 	updateAssStatu('确定结束评估！','结束评估',6,'<%=wallId %>');
  });
  
  function updateAssStatu(sureMsg,altMsg,statuVal,wallId){
   	$.messager.confirm('', sureMsg, function(del){
  		if(del){
				$.ajax({
					type: "POST",
					url: "assWallController.do?method=uptWallStatu",
					data:"assWallStatu="+statuVal+"&wallId="+wallId,
					success: function(data){
					if(data=='2'){
						alert(altMsg+"成功！");
						esourcing.util.freshCurPage();
					}else{
						esourcing.util.rightMessage("提示",altMsg+"失败！");
						return false;
					}
				}
			});
		}
	}); 	
  };
});
</script>
</body>
</html>
	