<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
	<link href="${pageContext.request.contextPath}/static/tree/my/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/static/tree/my/css/style.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/tree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
</head>
<body class="white-bg">
<div class="ibox-content" style="width: 430px;">
<form method="post" class="form form-horizontal" style="margin-bottom:50px;">
		<table  class="table table-bordered">
			<div>
				<ul id="treeDiv" class="ztree">
					<c:forEach items="${pows}" var="pow">
						<li id="treeDiv_1" class="level0">
							<span id="${pow.id}" onclick="switch_fun(this.id)"  title="" class="button level0 switch ${empty pow.powers?'roots_close':'roots_open'}" ></span>
							<span id="x${pow.id}" get="my" value="${pow.id}" onclick="check_fun(this.id,0)" class="button chk ${pow.isLay==1?'checkbox_true_full':'checkbox_false_full'}"></span>
							<a id="treeDiv_1_a" class="level0" onclick="" target="_blank" style="" title="${pow.title}">
								<span id="treeDiv_1_ico" title="" class="button ico_open" style="width:0px;height:0px;"></span>
								<span id="treeDiv_1_span" class="node_name">${pow.title}</span>
							</a>
							<c:if test="${!empty pow.powers }">
								<ul id="treeDiv_1_ul" name="ul${pow.id}" class="level0 line" style="display:block">
									<c:forEach items="${pow.powers}" var="pw">
										<li id="treeDiv_2" class="level1" tabindex="0" >
											<span id="treeDiv_2_switch" title="" class="button level1 switch center_docu" >
											</span>
											<span id="${pw.id}" get="my" value="${pw.id}" name="x${pow.id}" onclick="check_fun1(this.id)"  class="button chk ${pow.isLay==1?'checkbox_true_full':'checkbox_false_full'}" ></span>
											<a id="treeDiv_2_a" class="level1" onclick="" target="_blank" style="" title="${pw.title}">
												<span id="treeDiv_2_ico" title="" class="button ico_docu" style="width:0px;height:0px;"></span>
												<span id="treeDiv_2_span" class="node_name">${pw.title}</span>
											</a>
										</li>
									</c:forEach>
								</ul>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</table>
	</form>
	<div style="position:fixed; bottom:0; left:0;width:100%;height:50px; ;background-color:white;">
		<table  class="table table-bordered">
			<tr style="text-align:center;">
				<td colspan="2">
					<button  type="button" class="btn btn-primary" onclick="update(${id})">修改</button>
				</td>
			</tr>
		</table>
	</div>
</div>
<%@include file="../adminLib/down.jsp" %>
<script type="text/javascript">
	function switch_fun(id){
		var s = $("#"+id).attr('class');
		$("#"+id).removeClass();
		ss = s.split(" ");
		var size = ss.length;
		if(ss[size-1]=="roots_close"){
			$("#"+id).addClass("button level0 switch roots_open");
		}else{
			$("#"+id).addClass("button level0 switch roots_close");
		}
		var list = $("ul[name=ul"+id+"]")
		for(var i=0;i<list.length;i++){
			var s = list[i].style.display;
			if(s=="block"){
				list[i].style.display = "none";
			}else{
				list[i].style.display = "block";
			}
		}
	}
	function check_fun(str,fg){
		var ss = str.split("x");
		var s = ss[1];
		var cs = $("#"+str).attr('class');
		$("#"+str).removeClass();
		var css = cs.split(" ");
		var ms = css[css.length-1];
		if(ms=="checkbox_true_full"){
			$("#"+str).addClass("button chk checkbox_false_full");
			if(fg==0){
				var list = document.getElementsByName(str);
				for(var i=0;i<list.length;i++){
					list[i].setAttribute('class',"button chk checkbox_false_full");
				}
			}
		}else{
			$("#"+str).addClass("button chk checkbox_true_full");
			if(fg==0){
				var list = document.getElementsByName(str);
				for(var i=0;i<list.length;i++){
					list[i].setAttribute('class',"button chk checkbox_true_full");
				}
			}
		}
	}
	function check_fun1(id){
		var s = $("#"+id).attr("class");
		var ss = s.split(" ");
		var ans = ss[ss.length-1];
		$("#"+id).removeClass();
		if(ans=="checkbox_true_full"){
			$("#"+id).addClass("button chk checkbox_false_full");
			var name = $("#"+id).attr("name");
			var list = document.getElementsByName(name);
			var len = list.length;
			console.log(len);
			var fg = false;
			for(var i=0;i<len;i++){
				var ms = list[i].getAttribute('class');
				var mss = ms.split(" ");
				var mans = mss[mss.length-1];
				if(mans=="checkbox_true_full"){
					fg = true;
				}
			}
			if(!fg){
				$("#"+name).removeClass();
				$("#"+name).addClass("button chk checkbox_false_full")
			}
		}else{
			$("#"+id).addClass("button chk checkbox_true_full");
			var name = $("#"+id).attr("name");
			$("#"+name).removeClass();
			$("#"+name).addClass("button chk checkbox_true_full")
		}
	}
	function update(id){
		var index = parent.layer.getFrameIndex(window.name); 
		var objList = $("span[get='my']");
		var len = objList.length;
		var str = "";
		for(var i=0;i<len;i++){
			var s = objList[i].getAttribute("class");
			var ss = s.split(" ");
			var ans = ss[ss.length-1];
			if(ans=="checkbox_true_full"){
				str=str+","+objList[i].getAttribute("value");
			}
		}
		if(str==""){
			layer.alert("请选择要分配的权限",{icon:5});
		}
		$.post("../admin/updatePower",{roleId:id,s:str},function(e){
			if(e.code==100){
				layer.alert("修改成功",{icon:6});
				parent.layer.close(index); 
			}else{
				layer.alert(e.msg,{icon:5});
			}
		})
	}
</script> 
</body>
</html>
