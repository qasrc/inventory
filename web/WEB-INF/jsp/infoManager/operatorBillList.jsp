<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/3
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/commons/global.jsp"%>
<%@ include file="/commons/basejs.jsp"%>
<html>
<head>
    <title>业务员清单</title>
    <script type="text/javascript">
        var dataGrid;
        $(function () {
            $("#ss").searchbox({
                searcher:function (value) {
                    $.messager.alert("提示","功能暂未实现",'info');
                },
                prompt:'输入名字查询'
            });
            dataGrid = $('#dataGrid').datagrid({
                url:'${path}/operator/dataGrid',
                rownumbers:true,
                pagination:true,
                singleSelect:true,
                idField:'oper_id',
                sortName:'oper_id',
                sortOrder:'asc',
                pageSize:20,
                frozenColumns:[[{
                    width:'50',
                    field:'oper_id',
                    title:'id',
                    sortable:true
                },{
                    width:'100',
                    field:'oper_spell_code',
                    title:'拼音编码'
                },{
                    width:'100',
                    field:'oper_name',
                    title:'姓名'
                },{
                    width:'100',
                    field:'oper_sex',
                    title:'性别',
                    sortable:true
                },{
                    width:'100',
                    field:'oper_tel',
                    title:'电话',
                    sortable:true
                },{
                    width:'100',
                    field:'oper_address',
                    title:'地址'
                },{
                    width:'100',
                    field:'oper_sort',
                    title:'类别',
                    sortable:true
                },{
                    field: 'action',
                    title: '操作',
                    width: 300,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.clie_id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-cancel\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.clie_id);
                        return str;
                    }
                }]],
                onLoadSuccess:function (data) {
                    $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑', plain: true, iconCls: 'icon-edit'});
                    $('.role-easyui-linkbutton-del').linkbutton({text: '删除', plain: true, iconCls: 'icon-cancel'});
                },
                toolbar:'#toolbar'
            });
        });

        function editFun() {
            parent.$.modalDialog({
                iconCls:'icon-add',
                title:'添加',
                modal:true,
                width:800,
                height:400,
                href:'${path}/operator/editPage',
                buttons:[{
                    text:'确定',
                    handler:function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#operatorFormEdit');
                        f.submit();
                    }
                }]
            })
        }

        function addFun() {
            parent.$.modalDialog({
                iconCls:'icon-add',
                title:'添加',
                modal:true,
                width:800,
                height:400,
                href:'${path}/operator/addPage',
                buttons:[{
                    text:'确定',
                    handler:function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#operatorFormAdd');
                        f.submit();
                    }
                }]
            })
        }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',fit:true,border:false">
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
        <a onclick="addFun()" href="javascript:void(0);" class="easyui-linkbutton"
           data-options="plain:true,iconCls:'icon-add'">添加</a>
        <input id="ss"/>
    </div>
</body>
</html>
