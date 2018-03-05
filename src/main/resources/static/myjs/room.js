jQuery(document).ready(function() {
    App.init();
});
new showRoomListData().getRoomsList(1,7);

$('#addRoom').on('click', function () {
    layer.open({
        type: 2,
        title: '添加聊天室',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '200px'],
        content: "../layer/addRoom",
    });
});


function editRoom(id) {
    layer.open({
        type: 2,
        title: '编辑聊天室',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '350px'],
        content: "../layer/editRoom?id="+id,
    });
}

function delRoom(id) {
    layer.confirm("你确认删除此聊天室？", {icon: 3, title:'提示'}, function(index){
        $.post("deleteRoom",{id:id},function(e){
            if(e.code==100){
                layer.alert("删除成功", {icon:6, cancel:function(){window.parent.location.reload();}}, function(){
                    window.parent.location.reload();
                });
            }else{
                layer.alert(e.msg,{icon:5});
            }
        });
    });

}