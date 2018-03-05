<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script  id="Players" type="text/html">
	{{if allPlayer}}
			{{each allPlayer}}
					<tr>
						<td>{{$value.loginName}}</td>
						<td>{{$value.password}}</td>
						<td>{{$value.niceName}}</td>
						<td>{{$value.openId}}</td>
						<td>
							{{if $value.state == 1}}
							<button class="btn mini green icn-only">
								<i class="icon-ok icon-white"></i>
							</button>
							{{/if}}
							{{if $value.state == 2}}
							<button  class="btn mini red icn-only">
								<i class="icon-remove icon-white"></i>
							</button>
							{{/if}}
						</td>
						<td>
							{{if $value.speakState == 1}}
							<button class="btn mini green icn-only">
								<i class="icon-ok icon-white"></i>
							</button>
							{{/if}}
							{{if $value.speakState == 2}}
							<button  class="btn mini red icn-only">
								<i class="icon-remove icon-white"></i>
							</button>
							{{/if}}
						</td>
						<td>
							<button  id="{{$value.id}}"  onclick="sendMsg(this.id)" type="button" class="btn mini blue"><i class="icon-envelope m-icon-white"></i>发送消息</button>
							{{if $value.speakState == 1}}
							<button  id="{{$value.id}}"  onclick="setSpeak(2,this.id)" type="button" class="btn mini yellow"><i class="icon-ban-circle"></i>禁言</button>
							{{/if}}
							{{if $value.speakState == 2}}
							<button  id="{{$value.id}}"  onclick="setSpeak(1,this.id)" type="button" class="btn mini green"><i class="icon-ban-circle"></i>解禁</button>
							{{/if}}
							{{if $value.state == 1}}
							<button  id="{{$value.id}}"  onclick="setState(2,this.id)" type="button" class="btn mini red"><i class="icon-ban-circle"></i>禁用</button>
							{{/if}}
							{{if $value.state == 2}}
							<button  id="{{$value.id}}"  onclick="setState(1,this.id)" type="button" class="btn mini green"><i class="icon-ban-circle"></i>启用</button>
							{{/if}}
							<button  id="{{$value.id}}"  onclick="SetBackList(2,this.id)" type="button" class="btn mini black"><i class="icon-ban-circle"></i>加入黑名单</button>
						</td>
					</tr>
			{{/each}}
        {{/if}}
</script>
<script  id="searchPlayer" type="text/html">
	{{if allplayers}}
			{{each allplayers}}
				<tr>
					<td>{{$value.loginName}}</td>
					<td>{{$value.password}}</td>
					<td>{{$value.niceName}}</td>
					<td>{{$value.openId}}</td>
					<td>
						{{if $value.state == 1}}
						<button class="btn mini green icn-only">
							<i class="icon-ok icon-white"></i>
						</button>
						{{/if}}
						{{if $value.state == 2}}
						<button  class="btn mini red icn-only">
							<i class="icon-remove icon-white"></i>
						</button>
						{{/if}}
					</td>
					<td>
						{{if $value.speakState == 1}}
						<button class="btn mini green icn-only">
							<i class="icon-ok icon-white"></i>
						</button>
						{{/if}}
						{{if $value.speakState == 2}}
						<button  class="btn mini red icn-only">
							<i class="icon-remove icon-white"></i>
						</button>
						{{/if}}
					</td>
					<td>
						<button  id="{{$value.id}}"  onclick="sendMsg(this.id)" type="button" class="btn mini blue"><i class="icon-envelope m-icon-white"></i>发送消息</button>
						{{if $value.speakState == 1}}
						<button  id="{{$value.id}}"  onclick="setSpeak(2,this.id)" class="btn mini yellow"><i class="icon-ban-circle"></i>禁言</button>
						{{/if}}
						{{if $value.speakState == 2}}
						<button  id="{{$value.id}}"  onclick="setSpeak(1,this.id)" class="btn mini green"><i class="icon-ban-circle"></i>解禁</button>
						{{/if}}
						{{if $value.state == 1}}
						<button  id="{{$value.id}}"  onclick="setState(2,this.id)" class="btn mini red"><i class="icon-ban-circle"></i>禁用</button>
						{{/if}}
						{{if $value.state == 2}}
						<button  id="{{$value.id}}"  onclick="setState(1,this.id)" class="btn mini green"><i class="icon-ban-circle"></i>启用</button>
						{{/if}}
						<button  id="{{$value.id}}"  onclick="SetBackList(2,this.id)" class="btn mini black"><i class="icon-ban-circle"></i>加入黑名单</button>
				   </td>
				</tr>
			{{/each}}
        {{/if}}
</script>
<script  id="selectPlayer" type="text/html">
	{{if allplayers}}
	{{each allplayers}}
	<tr>
		<td>{{$value.loginName}}</td>
		<td>{{$value.password}}</td>
		<td>{{$value.niceName}}</td>
		<td>{{$value.openId}}</td>
		<td>
			{{if $value.state == 1}}
			<button class="btn mini green icn-only">
				<i class="icon-ok icon-white"></i>
			</button>
			{{/if}}
			{{if $value.state == 2}}
			<button  class="btn mini red icn-only">
				<i class="icon-remove icon-white"></i>
			</button>
			{{/if}}
		</td>
		<td>
			{{if $value.speakState == 1}}
			<button class="btn mini green icn-only">
				<i class="icon-ok icon-white"></i>
			</button>
			{{/if}}
			{{if $value.speakState == 2}}
			<button  class="btn mini red icn-only">
				<i class="icon-remove icon-white"></i>
			</button>
			{{/if}}
		</td>
		<td>
			<button  id="{{$value.id}}"  onclick="sendMsg(this.id)" type="button" class="btn mini blue"><i class="icon-envelope m-icon-white"></i>发送消息</button>
			{{if $value.speakState == 1}}
			<button  id="{{$value.id}}"  onclick="setSpeak(2,this.id)" class="btn mini yellow"><i class="icon-ban-circle"></i>禁言</button>
			{{/if}}
			{{if $value.speakState == 2}}
			<button  id="{{$value.id}}"  onclick="setSpeak(1,this.id)" class="btn mini green"><i class="icon-ban-circle"></i>解禁</button>
			{{/if}}
			{{if $value.state == 1}}
			<button  id="{{$value.id}}"  onclick="setState(2,this.id)" class="btn mini red"><i class="icon-ban-circle"></i>禁用</button>
			{{/if}}
			{{if $value.state == 2}}
			<button  id="{{$value.id}}"  onclick="setState(1,this.id)" class="btn mini green"><i class="icon-ban-circle"></i>启用</button>
			{{/if}}
			<button  id="{{$value.id}}"  onclick="SetBackList(2,this.id)" class="btn mini black"><i class="icon-ban-circle"></i>加入黑名单</button>
		</td>
	</tr>
	{{/each}}
	{{/if}}
</script>