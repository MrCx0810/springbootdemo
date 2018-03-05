var showLotteryLinkData = function() {
    var _this = this;
    this.trim = function (str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    };
    this.getLotteryLinkList = function () {
        $.post('getLotteryLinkList', function (e) {
            if (e.code == 200) {
                var data = e.data;
                var body1 = template("LotteryLink", data);
                body1 = _this.trim(body1);
                var head1 = "<tr>";
                head1 += "<th width='10%'>类型</th>\
								<th width='20%'>链接地址</th>\
								<th width='15%'>操作</th>\
							</tr>";
                if (body1 != "") {
                    $("#head1").html(head1);
                    $("#body1").html(body1);
                } else {
                    var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                    $("#head1").html("");
                    $("#body1").html(span);
                }
            } else {
                var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                $("#head1").html("");
                $("#body1").html(span);
            }

        })
    };
}