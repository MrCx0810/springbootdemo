
function initEditor(elem){
    if(!$("#"+elem).length)return;
    var editor = new wangEditor(elem);
    // 上传图片
    editor.config.uploadImgUrl = 'uploadArticle';
    editor.config.uploadParams = {
        // token1: 'abcde',
        // token2: '12345'
    };
    editor.config.uploadHeaders = {
        // 'Accept' : 'text/x-json'
    }
    // editor.config.uploadImgFileName = 'myFileName';

    // 隐藏网络图片
    editor.config.hideLinkImg = true;

    // 表情显示项
    editor.config.emotionsShow = 'icon';
    editor.config.emotions = {
        'default': {
            title: '默认',
            data: '../static/emotions.data'
        },
        'weibo': {
            title: '微博表情',
            data: [
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/7a/shenshou_thumb.gif',
                    value: '[草泥马]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/60/horse2_thumb.gif',
                    value: '[神马]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/bc/fuyun_thumb.gif',
                    value: '[浮云]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/c9/geili_thumb.gif',
                    value: '[给力]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/f2/wg_thumb.gif',
                    value: '[围观]'
                },
                {
                    icon: 'http://img.t.sinajs.cn/t35/style/images/common/face/ext/normal/70/vw_thumb.gif',
                    value: '[威武]'
                }
            ]
        }
    };

    // 只粘贴纯文本
    editor.config.pasteText = true;
    editor.create();
    return editor;
}

if($('#editor-trigger').length)
    initEditor("editor-trigger");




$('#addNotice').on('click', function(){
    layer.open({
        type: 2,
        title: '添加公告',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['1400px', '700px'],
        content: "../layer/addNotice",
    });
});

function editNotice(id) {
    layer.open({
        type: 2,
        title: '编辑公告',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['1400px', '700px'],
        content: "../layer/editNotice?id="+id,
    });
}
function setPageView(id) {
    layer.open({
        type: 2,
        title: '设置阅览量',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['400px', '200px'],
        content: "../layer/setPageView?id="+id,
    });
}

function delNotice(id) {
    layer.confirm("你确认删除此公告？", {icon: 3, title:'提示'}, function(index){
        $.post("deleteNotice",{id:id},function(e){
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


$('#_info').on('click', function () {
    // var msg = layui.layedit.getText(index);
    // var url = $('#url').val();
    var data=$("#create-info").serialize();
    console.log(data);
    $.post("../admin/updateNotice",data,function(e){
        if(e.code==200){
            layer.alert("修改成功", {icon:6, cancel:function(){window.parent.location.reload();}}, function(){
                window.parent.location.reload();
            });
        }else{
            layer.alert(e.msg, {icon:5});
        }
    });
    return false;
});

