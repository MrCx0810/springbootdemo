var MatchApi = function(){
	var _this=this;
	this.trim = function(str){
		return str.replace(/(^\s*)|(\s*$)/g,"");
	}
	this.getMyString = function(str){
		var a = document.getElementsByName(str);
		var res = "";
		var temp = "";
		for(var i=0;i<a.length;i++){
			if(a[i].checked){
				temp = a[i].value;
				res=res+","+temp;
			}
		}
		return res;
	}
	this.chooseAll = function(obj,obj1){
		var all = $("#"+obj1);
		var list = document.getElementsByName(obj);
		if(all.is(":checked")){
			for(var i=0;i<list.length;i++){
				list[i].checked=true;
			}
		}else{
			for(var i=0;i<list.length;i++){
				list[i].checked=false;
			}
		}
	}
	/*
	 * 获取匹配完成股权量列表
	 */
	this.getAccomplishData = function(pageNo,pageSize,content){
		$.post("getMatchAccomplishData",{pageNo:pageNo,pageSize:pageSize,content:content},function(e){
			if(e.code=100){
				var data = e.data;
				var body1 = template("totaltable",data);
				var footer1 = _this.getfooter(e.data.page)
				body1 = _this.trim(body1);
				var head1 ="<tr>";
					head1+="<th>买家</th>\
						<th>卖家</th>\
						<th>交易单价</th>\
						<th>交易数量</th>\
						<th>交易总额</th>\
						<th>完成时间</th>\
						</tr>";
			  if(body1!=""){
			  	$("#head1").html(head1);
			  	$("#body1").html(body1);
			  	$("#footer1").html(footer1);
			  }else{
				  var span = "<span>没有查到相关数据......</span>";
				  $("#head1").html("");
					$("#body1").html("");
					$("#footer1").html("");
				  $("#body1").html(span);
			  }
			}
		});
	}
	/*
	 * 获取买入股权量订单列表
	 */
	this.getBuyInterData = function(pageNo,pageSize,content){
		$.post("getBuyStockData",{pageNo:pageNo,pageSize:pageSize,content:content},function(e){
			if(e.code==100){
				var data = e.data;
				var body2 = template("buyTable",data);
				var footer2 = _this.getfooter1(e.data.page);
				body2 = _this.trim(body2);
				var head2 ="<tr>";
					head2+="<th style='width:8px;'><input id='buyhead' type='checkbox' class='group-checkable' data-set='#sample_1 .checkboxes' onclick=\"choose('buy','buyhead')\"/></th>"
						+"<th>用户</th>"
						+"<th>股权币</th>"
						+"<th>时间</th>"
						+"</tr>";
			  if(body2!=""){
			  	$("#head2").html(head2);
			  	$("#body2").html(body2);
			  	$("#footer2").html(footer2);
			  }else{
				
				  var span = "<span>没有查到相关数据......</span>"
					$("#head2").html("");
					$("#body2").html("");
					$("#footer2").html("");
				  $("#body2").html(span);
			  }
			}
		});
	}
	/*
	 * 获取卖出股权量订单列表
	 */
	this.getSellInterData = function(pageNo,pageSize,content){
		$.post("getSellStockData",{pageNo:pageNo,pageSize:pageSize,content:content},function(e){
			if(e.code==100){
				var data = e.data;
				var body3 = template("sellTable",data);
				var footer3 = _this.getfooter2(e.data.page)
				body3 = _this.trim(body3);
				var head3 ="<tr>";
					head3+="<th style='width:8px;'><input id='sellhead' type='checkbox' class='group-checkable' data-set='#sample_1 .checkboxes' onclick=\"choose('sell','sellhead')\"/></th>"
						+"<th>用户</th>"
						+"<th>数量</th>"
						+"<th>单价</th>"
						+"<th>总价</th>"
						+"<th>时间</th>"
						+"</tr>";
			  if(body3!=""){
			  	$("#head3").html(head3);
			  	$("#body3").html(body3);
			  	$("#footer3").html(footer3);
			  }else{
				  var span = "<span>没有查到相关数据......</span>";
				  $("#head3").html("");
					$("#body3").html("");
					$("#footer3").html("");
				  $("#body3").html(span);
			  }
			}
		})
	}
	this.getfooter = function(page){
		var headstr = '<div class="span6">'
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
		var headstr = '<div class="span6">'
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
			foot = '<li class="next disabled"><a href="javaScript:;" ><span class="hidden-480">下一页</span></a></li>\
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
			len = page.pageNo+5;
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
	this.getfooter2 = function(page){
		var headstr = '<div class="span6">'
			+'<div class="dataTables_info" id="sample_1_info">'
			+'<span style="margin-left:10px;size:10px;">当前页数第<span id="mypage2">'+page.pageNo+'</span>页  共'+page.totalPage+'页</span>'
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
				<li class="prev"><a href="javaScript:;" onclick="myfy2(-2)"><span class="hidden-480">上一页</span></a></li>';
		}
		if(page.pageNo==page.totalPage||page.totalPage==0){
			foot = '<li class="next disabled"><a href="javaScript:;" ><span class="hidden-480">下一页</span></a></li>\
				</ul></div></div>';
		}else{
			foot = '<li class="next"><a href="javaScript:;" onclick="myfy2(-1)"><span class="hidden-480">下一页</span></a></li>\
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
				center+='<li class="active"><a href="javaScript:;" onclick="myfy2('+i+')">'
				+i
				+'</a></li>';
			}else{
				center+='<li><a href="javaScript:;" onclick="myfy2('+i+')">'
				+i
				+'</a></li>';
			}
		}
		return headstr+center+foot;
	}
};