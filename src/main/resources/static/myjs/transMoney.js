var transMoneyApi = function(){
	var _this=this;
	this.trim = function(str){
		return str.replace(/(^\s*)|(\s*$)/g,"");
	}
	this.getMoneyInfo = function(pageNo,pageSize,content){
		$.post("getCashOrder",{pageNo:pageNo,pageSize:pageSize,content:content},function(e){
			if(e.code==100){
				var data = e.data;
				var body1 = template("moneyTable",data);
				var footer1 = _this.getfooter(e.data.page);
				var head1 ="<tr>";
				head1+="<th>ID</th>\
					<th>买方</th>\
					<th>卖方</th>\
					<th>交易数量</th>\
					<th>交易金额</th>\
					<th>完成时间</th>\
					</tr>";
				if(body1!=""){
				  	$("#head1").html(head1);
				  	$("#body1").html(body1);
				  	$("#footer1").html(footer1);
				  }else{
					  var span = "<span>没有查到相关数据......</span>"
					  $("#body1").html(span);
				  }
			}
		})
	}
	this.getMoneyNotInfo = function(pageNo,pageSize,content){
		$.post("getNotCashOrder",{pageNo:pageNo,pageSize:pageSize,content:content},function(e){
			if(e.code==100){
				var data = e.data;
				var body1 = template("moneyNotTable",data);
				var footer1 = _this.getfooter1(e.data.page);
				var head1 ="<tr>";
				head1+="<th>ID</th>\
					<th>买方</th>\
					<th>卖方</th>\
					<th>交易数量</th>\
					<th>交易金额</th>\
					<th>买入时间</th>\
					<th>买出时间</th>\
					<th>交易状态</th>\
					<th>操作</th>\
					</tr>";
				if(body1!=""){
					$("#head2").html(head1);
					$("#body2").html(body1);
					$("#footer2").html(footer1);
				}else{
					var span = "<span>没有查到相关数据......</span>"
						$("#body2").html(span);
				}
			}
		})
	}
	this.getfooter = function(page){
		var headstr ='<div class="span6">'
			        +'<div class="dataTables_info" id="sample_1_info">'
			        +'<span style="margin-left:10px;size:10px;">当前页数第<span id="mypage">'+page.pageNo+'</span>页  共'+page.totalPage+'页</span>'
			        +'</div></div>';
		headstr += "<div class='span6'>";
		var foot = "";
		if(page.pageNo<=1){
			headstr+='<div class="dataTables_paginate paging_bootstrap pagination" style="margin:-13px 64px;">\
				<ul>\
				<li class="prev disabled"><a href="javaScript:;"><span class="hidden-480">上一页</span></a></li>';
		}else{
			headstr+='<div class="dataTables_paginate paging_bootstrap pagination">\
				<ul>\
				<li class="prev"><a href="javaScript:;" onclick="myfy(-2)"><span class="hidden-480">上一页</span></a></li>';
		}
		if(page.pageNo==page.totalPage||page.totalPage==0){
			foot = '<li class="next disabled"><a href="javaScript:;"><span class="hidden-480">下一页</span></a></li>\
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
	this.getfooter1 = function(page){
		var headstr ='<div class="span6">'
			+'<div class="dataTables_info" id="sample_1_info">'
			+'<span style="margin-left:10px;size:10px;">当前页数第<span id="mypage1">'+page.pageNo+'</span>页  共'+page.totalPage+'页</span>'
			+'</div></div>';
		headstr += "<div class='span6'>";
		var foot = "";
		if(page.pageNo<=1){
			headstr+='<div class="dataTables_paginate paging_bootstrap pagination" style="margin:-13px 64px;">\
				<ul>\
				<li class="prev disabled"><a href="javaScript:;"><span class="hidden-480">上一页</span></a></li>';
		}else{
			headstr+='<div class="dataTables_paginate paging_bootstrap pagination">\
				<ul>\
				<li class="prev"><a href="javaScript:;" onclick="myfy1(-2)"><span class="hidden-480">上一页</span></a></li>';
		}
		if(page.pageNo==page.totalPage||page.totalPage==0){
			foot = '<li class="next disabled"><a href="javaScript:;"><span class="hidden-480">下一页</span></a></li>\
				</ul></div></div>';
		}else{
			foot = '<li class="next"><a href="javaScript:;" onclick="myfy1(-1)"><span class="hidden-480">下一页</span></a></li>\
				</ul></div></div>';
		}
		var center = "";
		var len = 0;
		if(page.pageNo+5>page.totalPage){
			len = page.totalPage;
		}else{
			len = pageNo+5;
		}
		for(var i=page.pageNo;i<=len;i++){
			var s = "";
			if(i==page.pageNo){
				center+='<li class="active"><a href="javaScript:;" onclick="myfy1('+i+')">'
				+i
				+'</a></li>';
			}else{
				center+='<li><a href="javaScript:;" onclick="myfy1('+i+')">'
				+i
				+'</a></li>';
			}
		}
		return headstr+center+foot;
	}
};