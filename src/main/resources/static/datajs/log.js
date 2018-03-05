var showLogsData = function() {
    var _this = this;
    this.trim = function (str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
    this.getLogsList = function (pageNo, pageSize) {
        $.post('getOperationLog', {pageNo: pageNo, pageSize: pageSize}, function (e) {
            if (e.code == "200") {
                var data = e.data;
                body1 = template("log", data);
                body1 = _this.trim(body1);
                if (body1!="") {
                    if($('.page ul').length==0){
                        _this.getfooter(data.page);
                    }
                }
                var head1 = "<tr>";
                head1 += "<th width='8%'>标题</th>\
                            <th width='20%'>日志内容</th>\
                            <th width='10%'>操作者</th>\
                            <th width='10%'>操作时间</th>\
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
    }

    this.getfooter = function (Page) {
        $('.page').Page({
            totalPages: Page.totalPage,//分页总数
            liNums: 7,//分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack : function(page){
                _this.getLogsList(page, Page.pageSize);
            }
        });
    };
};
