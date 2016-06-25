<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%@ page import="com.ceit.ebs.cn.assys.wall.entity.AssWall"%>
<%@page import="com.ceit.ebs.cn.assys.overallScore.entity.AssOverallScore"%>
<%@page import="java.util.List"%>
<%@page import="com.ceit.ebs.cn.assys.detailScore.entity.AssDetailScore"%>
<% 
	AssWall assWall = (AssWall)request.getAttribute("assWall");
	List<AssDetailScore> DetailScoreList = (List<AssDetailScore>)request.getAttribute("detailScorelist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挡土墙评估详细信息</title>
	
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
					<span class="column_head_word">挡土墙细部得分</span>
					</span>
				</td>
			</tr>	
    <tr>
    	<td colspan="4" class="head_padding_left">基本信息<a id="viewWall" href="javascript:void(0)" class="head_more" style="float:right;margin-right:5px;">查看详细信息</a></td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙的名称:</td><td class="table_td3"><%=assWall.getWallName()==null?"":assWall.getWallName() %></td>
    	<td class="table_td1">挡土墙所在地区:</td><td class="table_td3"><%=assWall.getWallLocation()==null?"":assWall.getWallLocation() %></td>
    </tr>
    <%for(int i = 0;i<DetailScoreList.size();i++){
    	AssDetailScore ass = DetailScoreList.get(i);
    %>
    <tr>
    	<td colspan="4" class="head_padding_left"><%=ass.getScoreName()==null?"":ass.getScoreName() %></td>
    </tr>
	<tr>
    	<td class="table_td1">结果值:</td><td class="table_td3"><%=ass.getDetailScore()==null?"":ass.getDetailScore() %></td>
    	<td class="table_td1">安全等级:</td><td class="table_td3"><%=ass.getSecurityLevel()==null?"":ass.getSecurityLevel() %></td>
    </tr>
	<tr>
    	<td class="table_td1">安全状态:</td><td class="table_td3" style="color:red;"><%=ass.getSecurityStatus()==null?"":ass.getSecurityStatus() %></td>
    	<td class="table_td1">总体评价:</td><td class="table_td3"><%=ass.getWallSecuRemark()==null?"":ass.getWallSecuRemark() %></td>
    </tr>
    <%} %>
    
    <tr>
    	<td colspan="4">
    		<span class="button_span_location">
			<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">返回</a>
    		</span>
    	</td>
    </tr>
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
				esourcing.util.goUrlCloself();
			}
		}
	);
		
});
</script>
</body>
</html>
	