/**
 * 
 */
var showMyAdminsData = function(){
		var _this = this;
		this.trim = function(str){
			return str.replace(/(^\s*)|(\s*$)/g,"");
		}
		this.getMyAdminsInfo = function(pageNo,pageSize,state){ 
			$.post('getMyAdmins',{pageNo:pageNo,pageSize:pageSize}, function(e){
				if(e.code=="200"){
					var data=e.myadmins;
					body1= template("MyAdmins",data);
					if($('#_footer li').length==0){
						_this.getfooter(data.page);
					}
//					var footer1 = _this.getfooter(data.page);
					body1 = _this.trim(body1);
					var head1="<tr>";
						head1+="<th >序号</th>\
								<th>账号</th>\
								<th >姓名</th>\
								<th >房卡数</th>\
								<th >角色</th>\
								<th >手机号</th>\
								<th >登录IP</th>\
								<th >上次登录时间</th>\
								<th >状态</th>\
								<th >操作</th>\
							</tr>";
					if(body1!=""){
						$("#head1").html(head1);
					  	$("#body1").html(body1);
//					  	$("#_footer").html(footer1);
					}else{
						var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
						  $("#body1").html(span);
					}				
					
				}else{
					var span = "<div class=\"html-notice\" ><span>没有查到相关数据......</span></div>"
				  	$("#body1").html(span);
					$("#head1").html("");
				}
									
			})
		 }
		this.getSearchMyAdminsInfo = function(pageNo,pageSize,name){ 
			$.post('getSearchMyAdmins',{pageNo:pageNo,pageSize:pageSize,name:name}, function(e){
				if(e.code=="200"){
					var data=e.myadmins;
					body1= template("SearchMyAdmins",data);
//					if($('#_footer li').length==0){
//						_this.getfooter(e.allsell.page);
//					}
					var footer1 = _this.getfooter(data.page);
					body1 = _this.trim(body1);
					var head1="<tr>";
					head1+="<th >序号</th>\
						<th>账号</th>\
						<th >姓名</th>\
						<th >房卡数</th>\
						<th >角色</th>\
						<th >手机号</th>\
						<th >登录IP</th>\
						<th >上次登录时间</th>\
						<th >状态</th>\
						<th >操作</th>\
						</tr>";
					if(body1!=""){
						$("#head1").html(head1);
						$("#body1").html(body1);
						$("#footer1").html(footer1);
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
		
		this.getfooter = function(page){
			$(".pagination").createPage({
				totalPage:page.totalPage,
				currPage:page.pageNo,
				turndown:'true',
				backFn:function(p){
					$('.curPage').html(p);
					_this.getMyAdminsInfo(p,page.pageSize)
				}
			});
		}
		
		this.getfooter = function(page){
			var headstr ='<div class="span6 pull-left">'
				        +'<div class="dataTables_info" id="sample_1_info">'
				        +'<span style="margin-left:10px;size:10px;">当前页数第<span id="mypage">'+page.pageNo+'</span>页  共'+page.totalPage+'页</span>'
				        +'</div></div>';
			headstr += "<div class='span6'>";
			var foot = "";
			if(page.pageNo<=1){
				headstr+='<div class="dataTables_paginate paging_bootstrap pagination pull-right" style="margin:-13px 64px;">\
					<ul>\
					<li class="prev disabled"><a href="javaScript:;" onclick="myfy(-2)"><span class="hidden-480">上一页</span></a></li>';
			}else{
				headstr+='<div class="dataTables_paginate paging_bootstrap pagination">\
					<ul>\
					<li class="prev"><a href="javaScript:;" onclick="myfy(-2)"><span class="hidden-480">上一页</span></a></li>';
			}
			if(page.pageNo==page.totalPage||page.totalPage==0){
				foot = '<li class="next disabled"><a href="javaScript:;" onclick="myfy(-1)"><span class="hidden-480">下一页</span></a></li>\
					</ul></div></div>';
			}else{
				foot = '<li class="next"><a href="javaScript:;" onclick="myfy(-1)"><span class="hidden-480">下一页</span></a></li>\
					</ul></div></div>';
			}
			var center = "";
			var len = 0;
			if(page.pageNo+5>page.totalPage){
				len = page.totalPage;
			}else{
				len = page.pageNo+5;
			}
			for(var i=page.pageNo;i<=len;i++){
				var s = "";
				if(i==page.pageNo){
					center+='<li class="active"><a href="javaScript:;" onclick="myfy('+i+')">'
						+i
						+'</a></li>';
				}else{
					center+='<li><a href="javaScript:;" onclick="myfy('+i+')">'
						+i
						+'</a></li>';
				}
			}
			return headstr+center+foot;
		}
	};