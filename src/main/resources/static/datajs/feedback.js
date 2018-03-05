/**
 * 
 */
var showSuggestionData = function(){
	
	var _this = this;
	this.trim = function(str){
		return str.replace(/(^\s*)|(\s*$)/g,"");
	}
	this.getSuggestionList = function(pageNo,pageSize){ 
		$.post('getSuggestion',{pageNo:pageNo,pageSize:pageSize}, function(e){
			if(e.code=="200"){
//				console.log(e);
				var data=e.suggestion;
				body1= template("Suggestions",data);
//				if($('#_footer li').length==0){
//					_this.getfooter(e.allsell.page);
//				}
				body1 = _this.trim(body1);
				var head1="<tr>";
					head1+="<th width='10%'>序号</th>\
							<th width='10%'>用户ID</th>\
							<th width='10%'>昵称</th>\
							<th width='10%'>时间</th>\
							<th width='30%'>反馈内容</th>\
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
	
}