/**
 * 
 */
var showPalyersData = function(){
		var _this = this;
		this.trim = function(str){
			return str.replace(/(^\s*)|(\s*$)/g,"");
		};
		this.getPlayersList = function(pageNo,pageSize){ 
			$.post('getPlayers',{pageNo:pageNo,pageSize:pageSize}, function(e){
				if(e.code=="200"){
					var data=e.players;
					var body1= template("Players",data);
					body1 = _this.trim(body1);
					if (body1!="") {
                        if($('.page ul').length==0){
                            _this.getfooter(data.page);
                        }
					}
                    var head1="<tr>";
						head1+="<th width='5%'>登录名</th>\
								<th width='6%'>密码</th>\
								<th width='7%'>昵称</th>\
								<th width='15%'>OpenId</th>\
								<th width='5%'>禁用状态</th>\
								<th width='5%'>禁言状态</th>\
								<th width='15%'>操作</th>\
							</tr>";
					if(body1!=""){
						$("#head1").html(head1);
					  	$("#body1").html(body1);
					}else{
                        $('.page div').remove();
                        $('.page ul').remove();
                        var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                        $("#head1").html("");
                        $("#body1").html(span);
                    }
				}else{
                    $('.page div').remove();
                    $('.page ul').remove();
                    var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                    $("#head1").html("");
                    $("#body1").html(span);
				}
									
			})
		};
		
		this.getSearchPlayersList = function(pageNo,pageSize,state,name, listState){
			var name=this.trim(name);
			$.post('getSearchPlayers',{pageNo:pageNo,pageSize:pageSize,state:state, name:name,listState:listState}, function(e){
				if(e.code=="200"){
					var data=e.search_players;
					var body2= template("searchPlayer",data);
					body2 = _this.trim(body2);
					if (body2!="") {
                        // console.log("lll2===="+$('.page').length)
                        // console.log("length ul:"+$('.page ul').length);
                        // console.log("fff2===="+$('.mySearch').length);
                        if ($('.mySearch').length==0) {
                            $('.page div').remove();
                            $('.page ul').remove();
                            $('.page').addClass("mySearch");
                            _this.getfooter2(data.page, state, name, listState);
                        }
                    }
					var head1="<tr>";
                        head1+="<th width='5%'>登录名</th>\
                                <th width='6%'>密码</th>\
                                <th width='7%'>昵称</th>\
                                <th width='15%'>OpenId</th>\
                                <th width='5%'>禁用状态</th>\
                                <th width='5%'>禁言状态</th>\
                                <th width='15%'>操作</th>\
                                </tr>";
					if(body2!=""){
						$("#head1").html(head1);
						$("#body1").html(body2);
                    }else{
                        $('.page div').remove();
                        $('.page ul').remove();
                        $('.page').removeClass("mySearch");
                        var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                        $("#head1").html("");
                        $("#body1").html(span);
                    }
                }else{
                    $('.page div').remove();
                    $('.page ul').remove();
                    $('.page').removeClass("mySearch");
                    var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                    $("#head1").html("");
                    $("#body1").html(span);
				}
				
			})
	 };
		this.getUsersListByType = function(pageNo,pageSize,type){
			$.post('getUsersListByType',{pageNo:pageNo,pageSize:pageSize,type:type}, function(e){
				if(e.code=="200"){
					var data=e.search_players;
					var body3= template("selectPlayer",data);
					body3 = _this.trim(body3);
                    if (body3!="") {
                        if($('.type').length==0){
                            $('.page div').remove();
                            $('.page ul').remove();
                            $('.page').addClass("type");
                            _this.getfooter3(data.page, type);
                        }

                    }
                    if (type==0) {
                        $('.page div').remove();
                        $('.page ul').remove();
                        $('.page').removeClass("type");
                        _this.getfooter(data.page);
                    }
                    var head1="<tr>";
                    head1+="<th width='5%'>登录名</th>\
							<th width='6%'>密码</th>\
							<th width='7%'>昵称</th>\
							<th width='15%'>OpenId</th>\
							<th width='5%'>禁用状态</th>\
							<th width='5%'>禁言状态</th>\
							<th width='15%'>操作</th>\
							</tr>";
					if(body3!=""){
						$("#head1").html(head1);
						$("#body1").html(body3);
					}else{
                        $('.page div').remove();
                        $('.page ul').remove();
                        $('.page').removeClass("type");
						var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                        $("#head1").html("");
                        $("#body1").html(span);
                    }
				}else{
                    $('.page div').remove();
                    $('.page ul').remove();
                    $('.page').removeClass("type");
                    var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
                    $("#head1").html("");
                    $("#body1").html(span);
				}

			})
	 };
    this.getfooter = function (Page) {
        $('.page').Page({
            totalPages: Page.totalPage,//分页总数
            liNums: 7,//分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack : function(page){
				_this.getPlayersList(page, Page.pageSize);
            }
        });
    };
    this.getfooter2 = function (Page, state, name, listState) {
        $('.page').Page({
            totalPages: Page.totalPage,//分页总数
            liNums: 7,//分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack : function(page){
				_this.getSearchPlayersList(page, Page.pageSize, state, name, listState);
            }
        });
    };
    this.getfooter3 = function (Page, type) {
        $('.page').Page({
            totalPages: Page.totalPage,//分页总数
            liNums: 7,//分页的数字按钮数(建议取奇数)
            activeClass: 'activP', //active 类样式定义
            callBack : function(page){
                _this.getUsersListByType(page, Page.pageSize, type);
            }
        });
    };
};