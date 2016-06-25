var esourcing   = esourcing || {};
esourcing.util  = esourcing.util || {};

$.extend(esourcing.util, {
  checkTime: function(time1){
    if(typeof time1 !== 'string')
      return time1;
    var str1 = time1.replace(/-/g,"/");
    return new Date(str1).getTime();
  },
  formatD: function(date){
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
  },
  formatLongD: function(date) {
    return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
  },
  isJqueryImported: function(){
	if(typeof(jQuery)=="undefined"){
		return "jQuery is not imported";
	}else{
		return "jQuery is imported";
	}
  },
  goUrl: function(url){
	  window.open(url);
  },
  goUrlSelf: function(url){
	  window.open(url,"_self");
  },
  goUrlCloself: function(){
		window.opener.location.href=window.opener.location.href;
    	self.opener=null;
        self.close();
  },
  timeFormatter:function(val,row){
	  var date=new Date(val);
	  return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
  },
  freshCurPage:function(){
	  window.location.reload();
  },
  yesNoFormatter:function(val,row){
	if(val== 0){
		return "否";
	}else if(val== 1){
		return "是";
	}else{
		return "";
	}
  },
  getSelected:function(datagridId,jsonId){
	  	var row = $('#'+datagridId).datagrid('getSelected');
	if (row){
		return row[jsonId];
	}
  },
  getSelections:function(datagridId,jsonId){
	var ss = [];
	var rows = $('#'+datagridId).datagrid('getSelections');
	for(var i=0; i<rows.length; i++){
		var row = rows[i];
		ss.push(row[jsonId]);
	}
	if (ss){
		return ss;
	}
  },
  isModalDialog:function(Obj){
	  	if(Obj && "yes"==Obj.isModalDialog){
			return true;
		}else{
			return false;
		}
  },
  rightMessage:function(titleVal,msgVal){
		$.messager.show({
			title:titleVal,
			msg:msgVal,
			timeout:3000,
			showType:'slide'
		});
  },
  testAlert:function(){
	  alert("测试失败")
  },
  wallStatu:function(val,row){
	  		if(val== 1){
				return "挡土墙编辑";
			}else if(val== 2){
				return "正在总体评估";
			}else if(val == 3){
				return "总体评估完成";
			}else if(val == 4){
				return "正在细部评估";
			}else if(val == 5){
				return "细部评估完成";
			}else if(val == 6){
				return "评估完成";
			}else{
				return "";
			}
  },
  formSubmit: function(formId){
	  $("#"+formId).submit();
  }
});