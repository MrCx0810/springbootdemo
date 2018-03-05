<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<% int ID = 1; %>
<script  id="BlackAdmins" type="text/html">
	{{if AdminsBlackList}}
			{{each AdminsBlackList}}
				<tr>
					<td>{{$value.loginName}}</td>
					<td>{{$value.loginPassword}}</td>
					<td>{{$value.name}}</td>
					<td>{{$value.roleName}}</td>
					{{if $value.state==1}}
					<td><button  class='btn mini green icn-only'><i class='icon-ok icon-white'></i></button></td>
					{{/if}}
					{{if $value.state==0}}
					<td><button class='btn mini red icn-only'><i class='icon-remove icon-white'></i></button></td>
					{{/if}}
					<td>
						<button id="{{$value.id}}" onclick="delAdmin(this.id)"  class="btn mini red"><i class="icon-trash"></i>删除</button>
						&nbsp;
						<button  id="{{$value.id}}"  onclick="RemoveBackList(1,this.id)" class="btn mini blue"><i class="icon-signout"></i>移除黑名单</button>
					</td>
				</tr>
			{{/each}}
        {{/if}}
</script>
<script  id="SearchBlackAdmins" type="text/html">
	{{if MyAdmins}}
			{{each MyAdmins}}
	<tr>
		<td>{{$value.loginName}}</td>
		<td>{{$value.loginPassword}}</td>
		<td>{{$value.name}}</td>
		<td>{{$value.roleName}}</td>
		{{if $value.state==1}}
		<td><button  class='btn mini green icn-only'><i class='icon-ok icon-white'></i></button></td>
		{{/if}}
		{{if $value.state==0}}
		<td><button class='btn mini red icn-only'><i class='icon-remove icon-white'></i></button></td>
		{{/if}}
		<td>
			<button id="{{$value.id}}" onclick="delAdmin(this.id)"  class="btn mini red"><i class="icon-trash"></i>删除</button>
			&nbsp;
			<button  id="{{$value.id}}"  onclick="RemoveBackList(1,this.id)" class="btn mini blue"><i class="icon-signout"></i>移除黑名单</button>
		</td>
	</tr>
			{{/each}}
        {{/if}}
</script>
<script  id="adminsData" type="text/html">
	{{if admins}}
		{{each admins}}
			<tr>
				<td>{{$value.loginName}}</td>
				<td>{{$value.loginPassword}}</td>
				<td>{{$value.name}}</td>
				<td>{{$value.roleName}}</td>
				{{if $value.state==1}}
				<td><button  class='btn mini green icn-only'><i class='icon-ok icon-white'></i></button></td>
				{{/if}}
				{{if $value.state==0}}
				<td><button class='btn mini red icn-only'><i class='icon-remove icon-white'></i></button></td>
				{{/if}}
				<td>

					{{if $value.state == 1}}
					<button id="{{$value.id}}" onclick="chageState(0,this.id)" class="btn mini red "><i class="icon-trash"></i>禁用</button>
					{{/if}}
					{{if $value.state == 0}}
					<button id="{{$value.id}}" onclick="chageState(1,this.id)"  class="btn mini green"><i class="icon-ok icon-white"></i>解禁</button>
					{{/if}}
					&nbsp;
					<button  id="{{$value.id}}"  onclick="editAdmin(this.id)" class="btn mini blue"><i class="icon-edit"></i>编辑</button>
					&nbsp;
					<button  id="{{$value.id}}"  onclick="SetAdminBackList(2,this.id)" class="btn mini black"><i class="icon-ban-circle"></i>加入黑名单</button>
				</td>
			</tr>
		{{/each}}
	{{/if}}
</script>







<script  id="BlackAdmins" type="text/html">
	{{if AdminsBlackList}}
			{{each AdminsBlackList}}
				<tr>
					<td>{{$value.id}}</td>
					<td>{{$value.loginName}}</td>
					<td>{{$value.name}}</td>
					<td>{{$value.carNumber!=0?$value.carNumber:"暂无"}}</td>
					<td>{{$value.roleName}}</td>
					<td>{{$value.phoneNumber}}</td>
					<td>{{$value.loginIp}}</td>
					<td>{{$value.lastLoginTime}}</td>
					{{if $value.state==1}}
							<td><button  class='btn mini green icn-only'><i class='icon-ok icon-white'></i></button></td>
					{{/if}}
					{{if $value.state==0}}
						<td><button class='btn mini red icn-only'><i class='icon-remove icon-white'></i></button></td>
					{{/if}}
					<td>
						<button  id="{{$value.id}}"  onclick="RemoveBackList(1,this.id)" class="btn mini blue"><i class="icon-signout"></i>移出黑名单</button>
					</td>
				</tr>
			{{/each}}
        {{/if}}
</script>
<script  id="SearchBlackAdmins" type="text/html">
	{{if AdminsBlackList}}
			{{each AdminsBlackList}}
				<tr>
					<td><%=ID++ %></td>
					<td>{{$value.loginName}}</td>
					<td>{{$value.name}}</td>
					<td>{{$value.carNumber!=0?$value.carNumber:"暂无"}}</td>
					<td>{{$value.roleName}}</td>
					<td>{{$value.phoneNumber}}</td>
					<td>{{$value.loginIp}}</td>
					<td>{{$value.lastLoginTime}}</td>
					{{if $value.state==1}}
							<td><button  class='btn mini green icn-only'><i class='icon-ok icon-white'></i></button></td>
					{{/if}}
					{{if $value.state==0}}
						<td><button class='btn mini red icn-only'><i class='icon-remove icon-white'></i></button></td>
					{{/if}}
					<td>
						<button  id="{{$value.id}}"  onclick="RemoveBackList(1,this.id)" class="btn mini blue"><i class="icon-signout"></i>移出黑名单</button>
					</td>
				</tr>
			{{/each}}
        {{/if}}
</script>