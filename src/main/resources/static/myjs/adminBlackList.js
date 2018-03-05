/**
 * 
 */
jQuery(document).ready(function() {    
		   App.init(); 
});
new showBlackAdminsData().getBlackAdminsList(1,7);


function RemoveBackList(state, id){
	var msg;
	if(state == 1){
		msg = "你确认把该管理员移出黑名单？";
	}
	layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
		$.post("updateAdminListState",{listState:state,id:id},function(e){
			if(e.code==100){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}
function delAdmin(id){
	layer.confirm("你确认删除此管理员？", {icon: 3, title:'提示'}, function(index){
		$.post("delAdmin",{id:id},function(e){
			if(e.code==100){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}

$('#serach_b_admin').click(function(){
	var name = $('[name=nice_name]').val();
	new showBlackAdminsData().getSearchBlackAdminsList(1, 7, 2, name);
})

