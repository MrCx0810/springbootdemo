/**
 * 
 */
var showBlackPalyersData = function(){
		var _this = this;
		this.trim = function(str){
			return str.replace(/(^\s*)|(\s*$)/g,"");
		}
		this.getBlackPlayersList = function(pageNo,pageSize){ 
			$.post('getBlackPlayers',{pageNo:pageNo,pageSize:pageSize}, function(e){
				if(e.code=="200"){
					var data=e.players;
					var body1= template("BlackPlayers",data);
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
								<th width='10%'>操作</th>\
							</tr>";
					if(body1!=""){
						$("#head1").html(head1);
					  	$("#body1").html(body1);
					  		
					}else{
						var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
							$("#_html").html(span);
					}				
					
				}else{
					var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
				  	$("#_html").html(span);
				}
									
			})
		 }
		this.getSearchBlackPlayersList = function(pageNo,pageSize,state,name, listState){
			var name = _this.trim(name);
			$.post('getSearchPlayers',{pageNo:pageNo,pageSize:pageSize,state:state,name:name, listState:listState}, function(e){
				if(e.code=="200"){
					var data=e.search_players;
					var body2= template("SerachBlackPlayers",data);
					body2 = _this.trim(body2);
                    if (body2!="") {
                        if($('.page ul').length==0){
                            _this.getfooter(data.page);
                        }
                    }
					var head1="<tr>";
                    head1+="<th width='5%'>登录名</th>\
								<th width='6%'>密码</th>\
								<th width='7%'>昵称</th>\
								<th width='15%'>OpenId</th>\
								<th width='10%'>操作</th>\
							</tr>";
					if(body2!=""){
						$("#head1").html(head1);
						$("#body1").html(body2);
						
					}else{
						var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
							$("#body1").html(span);
							$("#head1").html("");
					}				
					
				}else{
					var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
						$("#body1").html(span);
						$("#head1").html("");
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
}