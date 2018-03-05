jQuery(document).ready(function() {
    App.init();
    UIGeneral.init();
});
new showMessageReplyData().getMessageReplyList(1, 1, 7);
$('#_select').change(function () {
    var type = $(this).val();
    new showMessageReplyData().getMessageReplyList(type, 1, 7);
});

function replayMsg(id) {
    layer.open({
        type: 2,
        title: '消息回复',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '300px'],
        content: "../layer/replyMessage?id="+id,
    });
}