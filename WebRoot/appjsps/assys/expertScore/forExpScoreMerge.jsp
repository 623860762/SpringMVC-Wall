<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ceit.common.util.StaticSource"%>
<%@page import="com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore"%>
<%
	AssExpertScore assExpertScore = (AssExpertScore)request.getAttribute("assExpertScore");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改专家打分</title>
	
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/assys/assys.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.CSS_PATH %>/common.css" />
	<link rel="stylesheet" type="text/css" href="<%=StaticSource.EASYUI_PATH%>/themes/icon.css">
</head>
<body>
		<form id="Persist" method="post">
		<input type="hidden" name="expertScoreId" value="<%=assExpertScore.getExpertScoreId()==null?"":assExpertScore.getExpertScoreId() %>"/>
	<div>
		<table class="table_common">
			<tr>
				<td colspan="2" style="text-align:center;">
					<span class="column_head_word2">修改专家打分</span>
				</td>
			</tr>	
	<tr>
    	<td class="table_td2">专家名称:</td><td class="wid_td2_table"><input class="easyui-validatebox" type="text" name="expertName" value="<%=assExpertScore.getExpertName()==null? "" : assExpertScore.getExpertName() %>"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td class="table_td2">稳定性得分:</td><td class="wid_td2_table"><input class="easyui-validatebox" type="text" name="steadyScore" value="<%=assExpertScore.getSteadyScore()==null? "" :assExpertScore.getSteadyScore() %>"></input><font class="need_color">*</font></td>
    </tr>
	<tr>
    	<td class="table_td2">基础得分:</td><td class="wid_td2_table"><input class="easyui-validatebox" type="text" name="baseScore" value="<%=assExpertScore.getBaseScore()==null? "" : assExpertScore.getBaseScore()%>"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
    	<td class="table_td2">强度得分:</td><td class="wid_td2_table"><input class="easyui-validatebox" type="text" name="strenthScore" value="<%=assExpertScore.getStrenthScore()==null? "" : assExpertScore.getStrenthScore()%>"></input><font class="need_color">*</font></td>
    </tr>
    <tr>
        <td colspan="2">
    	<span class="span_bot_mt">
    	<a id="save" class="easyui-linkbutton" data-options="toggle:true">确定</a>&nbsp;
		<a id="back" class="easyui-linkbutton" data-options="toggle:true">取消</a>
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

<script type="text/javascript">
$(function(){

	var pareMoDiaObj = window.dialogArguments;
	
	$('#Persist').form({
			url:'expertScoreController.do?method=expMerge',
			onSubmit:function(){
		    	var formJson = $('#Persist').serializeJSON();
				if(formJson.expertName==""){
					alert("专家名称不能为空");
					return false;
					}
			},
			success:function(data){
				if(esourcing.util.isModalDialog(pareMoDiaObj)){
					parent.returnValue=data;
					window.close();
				}else{
					if(data=='2'){
						alert("修改专家打分成功");
						esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
					}else{
						alert("修改专家打分失败");
						return false;
					}
				}
			}
		});
		
	$("#save").click(
		function(){
			$("#Persist").submit();
			//esourcing.util.goUrlSelf("assWallController.do?method=forWallList");
		}
	);
	
	$("#back").click(
		function(){
			window.close();
		}
	);
		
});
</script>
</body>
</html>