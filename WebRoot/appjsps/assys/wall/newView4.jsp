<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表观状况</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assIndex.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
	<div align="center" class="w840" style="margin-top:150px;">
		<table class="table_common">
			<tr>
				<td colspan="8" style="text-align:center;">
					<span class="span_icon_head">
					<span class="column_head_word">表观状况</span>
					</span>
				</td>
			</tr>	
	<tr style="text-align:center;">
    	<td></td><td>权重</td>
    	<td>良好</td><td>较好</td>
    	<td>一般</td><td>较差</td>
    	<td>差</td><td>危险</td>
    </tr>
	<tr>
    	<td class="table_td2">墙身:</td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    </tr>
	<tr>
    	<td class="table_td2">墙顶:</td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    </tr>
	<tr>
    	<td class="table_td2">基础:</td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    </tr>
	<tr>
    	<td class="table_td2">伸缩缝:</td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    </tr>
	<tr>
    	<td class="table_td2">排水设施:</td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    	<td class=""><input style="width:45px;" type="text"/></td><td><input style="width:45px;" type="text"/></td>
    </tr>
    <tr>
    	<td colspan="8">
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
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/esourcing.util.js"></script>
	    <script type="text/javascript" src="<%=StaticSource.JS_PATH %>/jquery.serializeJSON.js"></script>
</body>
</html>
	