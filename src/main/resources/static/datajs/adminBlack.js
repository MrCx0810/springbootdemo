/**
 * 
 */
var showBlackAdminsData = function(){
		var _this = this;
		this.trim = function(str){
			return str.replace(/(^\s*)|(\s*$)/g,"");
		}
		this.getBlackAdminsList = function(pageNo,pageSize){ 
			$.post('getBlackAdmins',{pageNo:pageNo,pageSize:pageSize}, function(e){
				if(e.code=="200"){
					var data=e.data;
					var body1= template("BlackAdmins",data);
					body1 = _this.trim(body1);
                    if (body1!="") {
                        if($('.page ul').length==0){
                            _this.getfooter(data.page);
                        }
                    }
					var head1="<tr>";
                    head1+="<th width='5%'>账号</th>\
								<th width='6%'>密码</th>\
								<th width='6%'>名字</th>\
								<th width='7%'>角色</th>\
								<th width='10%'>状态</th>\
								<th width='15%'>操作</th>\
							</tr>";
					if(body1!=""){
						$("#head1").html(head1);
					  	$("#body1").html(body1);
					  		
					}else{
						var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
						  $("#body1").html(span);
					}				
					
				}else{
					var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
				  	$("#body1").html(span);
				}
									
			})
		 }
		this.getSearchBlackAdminsList = function(pageNo,pageSize,state,name){ 
			var name = _this.trim(name);
			$.post('getSearchBalckAdmins',{pageNo:pageNo,pageSize:pageSize,state:state,name:name}, function(e){
				if(e.code=="200"){
					var data=e.search_admins;
					body1= template("SearchBlackAdmins",data);
					body1 = _this.trim(body1);
					var head1="<tr>";
                    head1+="<th width='5%'>账号</th>\
								<th width='6%'>密码</th>\
								<th width='7%'>角色</th>\
								<th width='15%'>状态</th>\
								<th width='10%'>操作</th>\
							</tr>";
					if(body1!=""){
						$("#head1").html(head1);
						$("#body1").html(body1);
						
					}else{
						var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
							$("#body1").html(span);
					}				
					
				}else{
					var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
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
					_this.getHallInfoList(page, Page.pageSize);
				}
			});
		};
}