<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%
	String nextUrl = request.getParameter("nextUrl")==null?"":request.getParameter("nextUrl");
	System.out.println(nextUrl);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增挡土墙评估信息</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assIndex.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<form id="Persist" method="post">
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
    	<td class="table_td1">挡土墙的名称:</td><td><input class="easyui-validatebox title_input" type="text" name="wallName"></input><font class="need_color">*</font></td>
    	<td class="table_td1">挡土墙所在地区:</td><td><input class="easyui-validatebox title_input" type="text" name="wallLocation"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">挡土墙所属铁路局:</td><td><input class="easyui-validatebox title_input" type="text" name="wallOwer"></input><font class="need_color">*</font></td>
    	<td colspan="2"></td>
    </tr>
	<tr>
    	<td colspan="4" class="head_padding_left">挡土墙检算资料</td>
    </tr>
	<tr>
    	<td class="table_td1">墙高(m):</td><td><input class="easyui-validatebox title_input" type="text" name="wallHeight"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙顶宽(m):</td><td><input class="easyui-validatebox title_input" type="text" name="wallTopWidhth"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙底宽:</td><td><input class="easyui-validatebox title_input" type="text" name="wallBottomWidth"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙背倾斜角:</td><td><input class="easyui-validatebox title_input" type="text" name="backSlopeGradient"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">填料重度:</td><td><input class="easyui-validatebox title_input" type="text" name="fillerCohesion"></input><font class="need_color">*</font></td>
    	<td class="table_td1">填料粘聚力:</td><td><input class="easyui-validatebox title_input" type="text" name="fillerSevere"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">填料内摩擦角:</td><td><input class="easyui-validatebox title_input" type="text" name="fillerInnerAngle"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体重度:</td><td><input class="easyui-validatebox title_input" type="text" name="wallSevere"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">基底摩擦系数:</td><td><input class="easyui-validatebox title_input" type="text" name="baseFrictionRatio"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体外摩擦角:</td><td><input class="easyui-validatebox title_input" type="text" name="outFrictionAngle"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙后填料表面倾斜角:</td><td><input class="easyui-validatebox title_input" type="text" name="backFilterAngle"></input><font class="need_color">*</font></td>
    	<td class="table_td1">墙体摩擦系数:</td><td><input class="easyui-validatebox title_input" type="text" name="wallFrictionValue"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td1">墙顶位移最大值:</td><td><input class="easyui-validatebox title_input" type="text" name="topShiftMax"></input><font class="need_color">*</font></td>
    	<td colspan="2"></td>
    </tr>
    <tr>
    	<td colspan="4" class="head_padding_left">检算参数规范值</td>
    </tr>
    <tr>
    	<td class="table_td1">抗滑系数容许值:</td><td><input class="easyui-validatebox title_input" type="text" name="antiSlipValue"></input><font class="need_color">*</font></td>
    	<td class="table_td1">抗倾覆系数容许值:</td><td><input class="easyui-validatebox title_input" type="text" name="antiOverturnValue"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td class="table_td1">剪应力容许值:</td><td><input class="easyui-validatebox title_input" type="text" name="shearStressValue"></input><font class="need_color">*</font></td>
    	<td class="table_td1">基底应力偏心距:</td><td><input class="easyui-validatebox title_input" type="text" name="baseStressDistance"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td colspan="4">
    		<span class="button_span_location">
    		<a id="save" class="easyui-linkbutton icon_margin" data-options="toggle:true">确定</a>&nbsp;
			<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">重置</a>
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
		
		$('#Persist').form({
		url:'assWallController.do?method=wallPersist',
		onSubmit:function(){
	    	var formJson = $('#Persist').serializeJSON();
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
						alert("新增挡土墙信息成功");
						if(""=='<%=nextUrl%>')
							esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
						else{
							esourcing.util.goUrlSelf("<%=nextUrl%>");
						}
					}else{
						alert("新增挡土墙信息失败");
						return false;
					}					
				}
		}
	});
	
	$("#back").click(
		function(){
			$('#Persist')[0].reset();
		}
	);
		
	$("#save").click(
		function(){
			$("#Persist").submit();
			//esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
		}
	);
	
		
});
</script>
</body>
</html>
	