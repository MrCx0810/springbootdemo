var showHallInfoData = function() {
    var _this = this;
    this.trim = function (str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }
    this.getHallInfoList = function (pageNo, pageSize) {
        $.post('getArticle', {pageNo: pageNo, pageSize: pageSize}, function (e) {
            if (e.code == "200") {
                var data = e.data;
                var body1 = template("hallInfo", data);
                body1 = _this.trim(body1);
                if (body1!="") {
                    if($('.page ul').length==0){
                        _this.getfooter(data.page);
                    }
                }
                var head1 = "<tr>";
                head1 += "<th width='10%'>轮播图</th>\
                            <th width='15%'>标题</th>\
                            <th width='10%'>发布时间</th>\
                            <th width='10%'>操作</th>\
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
            /**
             * 图片预览
             * @type {NodeListOf<Element>}
             */
            var as = document.querySelectorAll('[ll-image]');
            console.log(as);
            for(var i=0;i<as.length;i++){
                var a = as[i];
                a.style.position = 'relative';
                (function(){
                    var image;
                    a.addEventListener('mouseenter',function(e){
                        var img_url = this.getAttribute('ll-image');
                        image = document.createElement('img');
                        image.src = img_url;
                        image.style.position = 'absolute';
                        image.style.maxWidth = '300px';
                        image.style.zIndex = 10;
                        image.style.left = e.offsetX+5+'px';
                        image.style.top = e.offsetY+5+'px';
                        this.appendChild(image);
                    });
                    a.addEventListener('mousemove',function(e){
                        image.style.left = e.offsetX+5+'px';
                        image.style.top = e.offsetY+5+'px';
                    })
                    a.addEventListener('mouseout',function(e){
                        image.remove();
                    })
                })();
            }
        })
    }

    this.getfooter = function (Page) {
        $('.page').Page({
            totalPages: Page.totalPage,//分页总数
            liNums: 7,//分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack : function(page){
                _this.getHallInfoList(page, Page.pageSize);
            }
        });
    };
};