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
<title>挡土墙信息修改</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assIndex.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<form id="Merge" method="post">
	<input type="hidden" name="wallId" value="<%=assWall.getWallId() %>"/>
	<div align="center" class="w840">
		<table class="table_common">
			<tr>
				<td colspan="4" style="text-align:center;">
					<span class="span_icon_head">
					<span class="column_head_word">修改挡土墙评估信息</span>
					</span>
				</td>
			</tr>	
	<tr>
    	<td colspan="4" class="head_padding_left">基本信息</td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙的名称:</td><td><input class="easyui-validatebox title_input" type="text"  name="wallName" value="<%=assWall.getWallName()==null?"":assWall.getWallName() %>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">挡土墙所在地区:</td><td><input class="easyui-validatebox title_input" type="text"  name="wallLocation" value="<%=assWall.getWallLocation()==null?"":assWall.getWallLocation() %>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙所属铁路局:</td><td><input class="easyui-validatebox title_input" type="text"  name="wallOwer" value="<%=assWall.getWallOwer()==null?"":assWall.getWallOwer() %>"></input><font class="need_color">*</font></td>
    	<td colspan="2"></td>
    </tr>
	<tr>
    	<td colspan="4" class="head_padding_left">挡土墙检算资料</td>
    </tr>
	<tr>
    	<td class="table_td1">墙高(m):</td><td><input class="easyui-validatebox title_input" type="text" name="wallHeight" value="<%=assWall.getWallHeight()==null?"": assWall.getWallHeight()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙顶宽(m):</td><td><input class="easyui-validatebox title_input" type="text" name="wallTopWidhth" value="<%=assWall.getWallTopWidth()==null?"": assWall.getWallTopWidth()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙底宽:</td><td><input class="easyui-validatebox title_input" type="text" name="wallBottomWidth" value="<%=assWall.getWallBottomWidth()==null?"": assWall.getWallBottomWidth()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙背倾斜角:</td><td><input class="easyui-validatebox title_input" type="text" name="backSlopeGradient" value="<%=assWall.getBackSlopeGradient()==null?"": assWall.getBackSlopeGradient()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">填料重度:</td><td><input class="easyui-validatebox title_input" type="text" name="fillerCohesion" value="<%=assWall.getFillerCohesion()==null?"": assWall.getFillerCohesion()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">填料粘聚力:</td><td><input class="easyui-validatebox title_input" type="text" name="fillerSevere" value="<%=assWall.getFillerSevere()==null?"": assWall.getFillerSevere()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">填料内摩擦角:</td><td><input class="easyui-validatebox title_input" type="text" name="fillerInnerAngle" value="<%=assWall.getFillerInnerAngle()==null?"": assWall.getFillerInnerAngle()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体重度:</td><td><input class="easyui-validatebox title_input" type="text" name="wallSevere" value="<%=assWall.getWallSevere()==null?"": assWall.getWallSevere()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">基底摩擦系数:</td><td><input class="easyui-validatebox title_input" type="text" name="baseFrictionRatio" value="<%=assWall.getBaseFrictionRatio()==null?"": assWall.getBaseFrictionRatio()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体外摩擦角:</td><td><input class="easyui-validatebox title_input" type="text" name="outFrictionAngle" value="<%=assWall.getOutFrictionAngle()==null?"": assWall.getOutFrictionAngle()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙后填料表面倾斜角:</td><td><input class="easyui-validatebox title_input" type="text" name="backFilterAngle" value="<%=assWall.getBackFilterAngle()==null?"": assWall.getBackFilterAngle()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体摩擦系数:</td><td><input class="easyui-validatebox title_input" type="text" name="wallFrictionValue" value="<%=assWall.getWallFrictionValue()==null?"": assWall.getWallFrictionValue()%>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙顶位移最大值:</td><td><input class="easyui-validatebox title_input" type="text" name="topShiftMax" value="<%=assWall.getTopShiftMax()==null?"": assWall.getTopShiftMax()%>"></input><font class="need_color">*</font></td>
    	<td colspan="2"></td>
    </tr>
    <tr>
    	<td colspan="4" class="head_padding_left">检算参数规范值</td>
    </tr>
    <tr>
    	<td class="table_td1">抗滑系数容许值:</td><td><input class="easyui-validatebox title_input" type="text"  name="antiSlipValue" value="<%=assWall.getAntiSlipValue()==null?"": assWall.getAntiSlipValue()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">抗倾覆系数容许值:</td><td><input class="easyui-validatebox title_input" type="text"  name="antiOverturnValue" value="<%=assWall.getAntiOverturnValue()==null?"": assWall.getAntiOverturnValue()%>"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td class="table_td1">剪应力容许值:</td><td><input class="easyui-validatebox title_input" type="text"  name="shearStressValue" value="<%=assWall.getShearStressValue()==null?"": assWall.getShearStressValue()%>"></input><font class="need_color">*</font></td>
    	<td class="table_td1">基底应力偏心距:</td><td><input class="easyui-validatebox title_input" type="text"  name="baseStressDistance" value="<%=assWall.getBaseStressDistance()==null?"": assWall.getBaseStressDistance()%>"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td colspan="4">
    		<span class="button_span_location">
    		<a id="save" class="easyui-linkbutton icon_margin" data-options="toggle:true">保存</a>&nbsp;
			<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">返回</a>
    		</span>
    	</td>
    </tr>
		</table>
	</div>
	</form>
		<script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/locale/easyui-lang-zh_CN.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.util.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/jquery.serializeJSON.js"></script>
<script>
	$(function(){
	
		var pareMoDiaObj = window.dialogArguments;
		
		$('#Merge').form({
		url:'assWallController.do?method=wallMerge',
		onSubmit:function(){
	    	var formJson = $('#Merge').serializeJSON();
			if(formJson.wallName==""){
				alert("挡土墙名称不能为空");
				return false;
				}
		},
		success:function(data){
				if(esourcing.util.isModalDialog(pareMoDiaObj)){
					parent.returnValue=data;
					window.close();
				}else{
					if(data=='2'){
						alert("修改挡土墙信息成功");
						esourcing.util.goUrlCloself();
						esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
					}else{
						alert("修改挡土墙信息失败");
						return false;
					}
				}
			}
	});
	
	$("#back").click(
		function(){
			if(isModalDialog()){
				window.close();
			}else{
				esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
			}
		}
	);
		
	$("#save").click(
		function(){
			$("#Merge").submit();
		}
	);
	
	function isModalDialog(){
	var pareMoDiaObj = window.dialogArguments;
		if(pareMoDiaObj && "isModalDialog"==pareMoDiaObj.isModalDialog){
			return true;
		}else{
			return false;
		}
	}
		
});
</script>
</body>
</html>
	