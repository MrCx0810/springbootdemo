jQuery(document).ready(function() {
    App.init();
});
new showVerListData().getVerListList(1, 7);

$('#setBtn').on('click', function () {
    var version = $('[name="version"]').val();
    var msg = '您确认发布新版本？版本号：'+version;
    layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
        $.post("setVersion",{version:version},function(e){
            if(e.code===200){
                layer.open({
                    title:'消息提示',
                    icon:6,
                    content:"发布成功",
                    yes:function(e){
                        window.location.reload();
                    }
                })
            }else{
                layer.alert(e.msg,{icon:5});
            }
        });
        layer.close(index);
    });
});
function editVer(id) {
    layer.open({
        type: 2,
        title: '编辑版本',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['400px', '250px'],
        content: "../layer/editVersion?id="+id,
    });
}

function delVer(id) {
    layer.confirm("你确认删除此版本号？", {icon: 3, title:'提示'}, function(index){
        $.post("delVer",{id:id},function(e){
            if(e.code==200){
                layer.alert("删除成功", {icon:6, cancel:function(){window.parent.location.reload();}}, function(){
                    window.parent.location.reload();
                });
            }else{
                layer.alert(e.msg,{icon:5});
            }
        });
    });

}