jQuery(document).ready(function() {
    App.init();
});
new showFastBetData().getFastBetList();
function editLink(id) {
    layer.open({
        type: 2,
        title: '编辑快速投注',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '300px'],
        content: "../layer/setFastBet?id="+id
    });
}
