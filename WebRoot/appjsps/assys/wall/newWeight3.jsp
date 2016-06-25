<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>既有线挡土墙安全评估</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assIndex.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<div align="center" class="w840" style="margin-top:150px;">
		<table class="table_common">
			<tr>
				<td colspan="2" style="text-align:center;">
					<span class="span_icon_head">
					<span class="column_head_word">既有线挡土墙安全评估</span>
					</span>
				</td>
			</tr>	
	<tr>
    	<td colspan="2" style="text-align:right;padding-right:70px;">权重</td>
    </tr>
	<tr>
    	<td class="table_td2">表现状况:</td><td><input class="easyui-validatebox title_input" type="text" name="wallName"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td2">材质状况:</td><td><input class="easyui-validatebox title_input" type="text" name="wallOwer"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td2">受力状况:</td><td><input class="easyui-validatebox title_input" type="text" name="wallOwer"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td colspan="2">
    		<span class="button_span_location">
    		<a id="save" class="easyui-linkbutton icon_margin" data-options="toggle:true">确定</a>&nbsp;
			<a id="back" class="easyui-linkbutton icon_margin" data-options="toggle:true">重置</a>
    		</span>
    	</td>
    </tr>
		</table>
	</div>
			<script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/jquery.easyui.min.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.EASYUI_PATH %>/locale/easyui-lang-zh_CN.js"></script>
</body>
</html>
	