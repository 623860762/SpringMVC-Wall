<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%@ page import="com.ceit.ebs.cn.assys.wall.entity.AssWall"%>
<% 
	AssWall assWall = (AssWall)request.getAttribute("assWall");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>挡土墙评估详细信息</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assIndex.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<div align="center" class="w840">
		<table class="table_common">
			<tr>
				<td colspan="4" style="text-align:center;">
					<span class="span_icon_head">
					<span class="column_head_word">新增挡土墙信息</span>
					</span>
				</td>
			</tr>	
	<tr>
    	<td colspan="4" class="head_padding_left">基本信息</td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙的名称:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallName" value="<%=assWall.getWallName()==null?"":assWall.getWallName() %>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">挡土墙所在地区:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallLocation" value="<%=assWall.getWallLocation()==null?"":assWall.getWallLocation() %>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙所属铁路局:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallOwer" value="<%=assWall.getWallOwer()==null?"":assWall.getWallOwer() %>"></input><font class="need_color">*</font></td>
    	<td colspan="2"></td>
    </tr>
    <tr>
    	<td colspan="4" class="head_padding_left">挡土墙检算资料</td>
    </tr>
    <tr>
    	<td class="table_td1">墙高(m):</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true"  name="wallHeight" value="<%=assWall.getWallHeight()==null?"": assWall.getWallHeight()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙顶宽(m):</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallTopWidhth" value="<%=assWall.getWallTopWidth()==null?"": assWall.getWallTopWidth()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙底宽:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallBottomWidth" value="<%=assWall.getWallBottomWidth()==null?"": assWall.getWallBottomWidth()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙背倾斜角:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="backSlopeGradient" value="<%=assWall.getBackSlopeGradient()==null?"": assWall.getBackSlopeGradient()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">填料重度:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="fillerCohesion" value="<%=assWall.getFillerCohesion()==null?"": assWall.getFillerCohesion()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">填料粘聚力:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="fillerSevere" value="<%=assWall.getFillerSevere()==null?"": assWall.getFillerSevere()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">填料内摩擦角:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="fillerInnerAngle" value="<%=assWall.getFillerInnerAngle()==null?"": assWall.getFillerInnerAngle()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体重度:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallSevere" value="<%=assWall.getWallSevere()==null?"": assWall.getWallSevere()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">基底摩擦系数:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="baseFrictionRatio" value="<%=assWall.getBaseFrictionRatio()==null?"": assWall.getBaseFrictionRatio()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体外摩擦角:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="outFrictionAngle" value="<%=assWall.getOutFrictionAngle()==null?"": assWall.getOutFrictionAngle()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙后填料表面倾斜角:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="backFilterAngle" value="<%=assWall.getBackFilterAngle()==null?"": assWall.getBackFilterAngle()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体摩擦系数:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="wallFrictionValue" value="<%=assWall.getWallFrictionValue()==null?"": assWall.getWallFrictionValue()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙顶位移最大值:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="topShiftMax" value="<%=assWall.getTopShiftMax()==null?"": assWall.getTopShiftMax()%>"></input><font class="need_color">*</font></td>
    	<td colspan="2"></td>
    </tr>
    <tr>
    	<td colspan="4" class="head_padding_left">检算参数规范值</td>
    </tr>
    <tr>
    	<td class="table_td1">抗滑系数容许值:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="antiSlipValue" value="<%=assWall.getAntiSlipValue()==null?"": assWall.getAntiSlipValue()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">抗倾覆系数容许值:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="antiOverturnValue" value="<%=assWall.getAntiOverturnValue()==null?"": assWall.getAntiOverturnValue()%>"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td class="table_td1">剪应力容许值:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="shearStressValue" value="<%=assWall.getShearStressValue()==null?"": assWall.getShearStressValue()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">基底应力偏心距:</td><td><input class="easyui-validatebox title_input" type="text" readOnly="true" name="baseStressDistance" value="<%=assWall.getBaseStressDistance()==null?"": assWall.getBaseStressDistance()%>"></input><font class="need_color">*</font></td>
    </tr>
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
	