/**
 * 
 */
jQuery(document).ready(function() {    
		   App.init(); 
		   UIGeneral.init();
});
new showMyAdminsData().getMyAdminsInfo(1,7);

$("#addAdmin").click(function(){
	layer.open({
		  type: 2,
		  title: '添加代理商',
		  fixed: true,
          shadeClose: true,
          maxmin: true,
          area: ['500px', '450px'],
		  content: "../layer/addAdmin",
	});
});

function editAdmin(id){
	layer.open({
		  type: 2,
		  title: '编辑管理员',
		  fixed: true,
          shadeClose: true,
          maxmin: true,
          area: ['500px', '450px'],
		  content: "../layer/editAdmin?id="+id,
	});
}
function chageState(state,id){
	var msg = "";
	if(state==1){
		msg = "确定解禁该账号?"
	}else{
		msg = "确定禁用该账号?"
	}
	layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
		$.post("updateAdminState",{state:state,id:id},function(e){
			if(e.code==100){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}
function addCard(id){
	layer.open({
		type: 2,
		title: '房卡充值',
		fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '200px'],
		content: "../layer/addCard?id="+id,
	});
}
function SetBackList(state,id){
	var msg;
	if(state == 2){
		msg = "你确认把该代理商加入黑名单？";
	}
	layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
		$.post("updateAdminListState",{id:id,state:state},function(e){
			if(e.code==100){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}

$("#serach_niceName").click(function(){
	var name=$('[name=nice_name]').val()
	console.log(name);
	new showMyAdminsData().getSearchMyAdminsInfo(1, 7, name);
});
