/**
 * 
 */
jQuery(document).ready(function() {    
		   App.init(); 
});
new showPalyersData().getPlayersList(1,7);


function sendMsg(id){
	layer.open({
		type: 2,
		title: '个人消息发送',
		fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['400px', '250px'],
		content: "../layer/sendMsg?id="+id,
	});
}
function setState(state, id){
	var msg;
	if(state == 2){
		msg = "你确认禁用该用户？";
	}
	if (state == 1) {
		msg = "你确认解禁该用户？"
	}
	layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
		$.post("updateUserState",{state:state,id:id},function(e){
			if(e.code==100){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}
function setSpeak(state, id){
	var cont;
	if(state == 2){
        cont = "你确认禁言该用户？";
	}
	if (state == 1) {
		cont ="你确认要解除该用户禁言？"
	}
	layer.confirm(cont, {icon: 3, title:'提示'}, function(index){
		$.post("updateUserSpeakState",{state:state, id:id},function(e){
			if(e.code==100){
				location.reload();
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
		layer.close(index);
	});
}


function SetBackList(state,id){
    var msg;
    if(state == 2){
        msg = "你确认把该用户加入黑名单？";
    }
    layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
        $.post("updateUserListState",{id:id,state:state},function(e){
            if(e.code==200){
                location.reload();
            }else{
                layer.alert(e.msg,{icon:5});
            }
        })
        layer.close(index);
    });
}

$("#serach_niceName").click(function(){
	var name=$('[name=nice_name]').val();
	new showPalyersData().getSearchPlayersList(1, 7, 1, name, 1);
    $('[name=nice_name]').val("");
});
$('#select').change(function () {
	console.log($(this).val());
    var type = $(this).val();
    new showPalyersData().getUsersListByType(1, 7, type);
});
$('#sendMsg2').click(function(){
    layer.open({
        type: 2,
        title: '站内消息发送',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['400px', '250px'],
        content: "../layer/sendAllMsg",
    });
});


