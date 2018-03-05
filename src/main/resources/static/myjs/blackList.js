/**
 * 
 */
jQuery(document).ready(function() {    
		   App.init(); 
});
new showBlackPalyersData().getBlackPlayersList(1,7);


function setBlackList(state, id){
	var msg;
	if(state == 1){
		msg = "你确认把该玩家移出黑名单？";
	}
	layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
		$.post("updateUserListState",{state:state,id:id},function(e){
			if(e.code==200){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}
function delPlayer(id){
	layer.confirm("你确认删除此玩家？", {icon: 3, title:'提示'}, function(index){
		$.post("delUser",{id:id},function(e){
			if(e.code==200){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}

$('#serach_b_player').click(function(){
	var name = $('[name=nice_name]').val();
	new showBlackPalyersData().getSearchBlackPlayersList(1, 7, 2, name, 2);
})

