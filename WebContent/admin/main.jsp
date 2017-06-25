<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	function openTab(text,url,iconCls){
		if($("#tabs").tabs('exists',text)){//标签页已打开 
			$("#tabs").tabs('select',text);
		}else{ //标签页未打开  
			var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/admin/"+url+"'></iframe>";
			$("#tabs").tabs('add',{
				title: text,
				iconCls:iconCls,
				closable: true,
				content: content
			});
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div region="north" style="height:78px;background-color:#E0ECFF">
		<table style="padding: 5px;" width="100%">
			<tr>
				<td width="50%">
					<img src="${pageContext.request.contextPath}/images/bglogo.png"/>
				</td>
				<td valign="bottom" align="right" width="50%">
					<font size="3">&nbsp;&nbsp;<strong>欢迎：</strong>${currentUser.userName}</font>
				</td>
			</tr>
		</table>
	</div>
	<div region="center">
		<div class="easyui-tabs" fit="true" border="false" id="tabs">
			<div title="首页" data-options="iconCls:'icon-home'">
				<div align="center" style="padding-top: 100px;">
				<font size="10" color="red">欢迎使用易买网后台管理系统</font>
				</div>
			</div>
		</div>
	</div>
	<div region="west" style="width: 200px" title="导航菜单" split="true">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="用户管理" data-options="selected:true,iconCls:'icon-user'" style="padding: 10px;">
				<a href="javaScript:openTab('用户管理','userManage.jsp','icon-user')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理用户</a>
			</div>
			<div title="商品管理" data-options="iconCls:'icon-product'" style="padding: 10px;">
				<a href="javaScript:openTab('商品管理','productManage.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理商品</a>
				<a href="javaScript:openTab('商品大类管理','productBigTypeManage.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理商品大类</a>
				<a href="javaScript:openTab('商品小类管理','productSmallTypeManage.jsp','icon-product')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理商品小类</a>
			</div>
			<div title="订单管理" data-options="iconCls:'icon-order'" style="padding: 10px;">
				<a href="javaScript:openTab('订单管理','orderManage.jsp','icon-order')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理订单</a>
			</div>
			<div title="留言管理" data-options="iconCls:'icon-comment'" style="padding: 10px;">
				<a href="javaScript:openTab('留言管理','commentManage.jsp','icon-comment')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理留言</a>
			</div>
			<div title="公告管理" data-options="iconCls:'icon-notice'" style="padding: 10px;">
				<a href="javaScript:openTab('公告管理','noticeManage.jsp','icon-notice')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理公告</a>
			</div>
			<div title="新闻管理" data-options="iconCls:'icon-news'" style="padding: 10px;">
				<a href="javaScript:openTab('新闻管理','newsManage.jsp','icon-news')" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理新闻</a>
			</div>
			<div title="标签管理" data-options="iconCls:'icon-tag'" style="padding: 10px;">
				<a href="" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-manage'" style="width: 100px;">管理标签</a>
			</div>
			<div title="系统管理" data-options="iconCls:'icon-item'" style="padding: 10px;">
				<a href="" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 100px;">修改密码</a>
				<a href="" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-exit'" style="width: 100px;">安全退出</a>
				<a href="" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-refresh'" style="width: 100px;">刷新系统缓存</a>
			</div>
		</div>
	</div>
	<div region="south" style="height: 25px;padding: 5px;" align="center">
		版权所有 2017 易卖网
	</div>
</body>
</html>