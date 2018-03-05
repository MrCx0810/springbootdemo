jQuery(document).ready(function() {
    App.init();
});
new showLotteryLinkData().getLotteryLinkList();
function editLink(id) {
    layer.open({
        type: 2,
        title: '编辑开奖记录链接',
        fixed: true,
        shadeClose: true,
        maxmin: true,
        area: ['500px', '300px'],
        content: "../layer/setlotteryLog?id="+id
    });
}
