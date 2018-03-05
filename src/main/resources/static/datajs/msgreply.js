var showMessageReplyData = function() {
    var _this = this;
    this.trim = function (str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    };
    this.getMessageReplyList = function (type, pageNo, pageSize) {
        $.post('getMessageReply', {type: type, pageNo: pageNo, pageSize: pageSize}, function (e) {
            console.log(e.data)
            if (e.code == 200) {
                var data = e.data;
                var body1 = template("msgList", data);
                body1 = _this.trim(body1);
                if (body1 != "") {
                    if ($('.page ul').length == 0) {
                        _this.getfooter(data.page, type);
                    }
                }
                var head1 = "<tr>";
                head1 += "<th width='5%'>状态</th>\
								<th width='6%'>用户昵称</th>\
								<th width='15%'>提交内容</th>\
								<th width='10%'>提交时间</th>\
								<th width='5%'>操作</th>\
							</tr>";
                if (body1 != "") {
                    $("#head1").html(head1);
                    $("#body1").html(body1);
                } else {
                    $('.page div').remove();
                    $('.page ul').remove();
                    var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                    $("#head1").html("");
                    $("#body1").html(span);
                }
            } else {
                $('.page div').remove();
                $('.page ul').remove();
                var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                $("#head1").html("");
                $("#body1").html(span);
            }

        })
    };

    this.getfooter = function (Page, type) {
        $('.page').Page({
            totalPages: Page.totalPage,//分页总数
            liNums: 7,//分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack : function(page){
                _this.getMessageReplyList(type, page, Page.pageSize);
            }
        });
    };
}