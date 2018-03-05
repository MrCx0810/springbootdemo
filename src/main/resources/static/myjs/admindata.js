jQuery(document).ready(function() {
    App.init();
    new showAdminsData().getAdminsDataList(1, 7);
});

$("#addAdmin").click(function(){
    layer.open({
        type: 2,
        title: '添加管理员',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '350px'],
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
        area: ['500px', '350px'],
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
function SetAdminBackList(state,id){
    var msg = "";
    if(state==2) {
        msg = "确定把该管理员移入黑名单?"
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