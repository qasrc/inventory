<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2016/11/28
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <title>销售管理</title>
    <script type="text/javascript">
        var dataGrid;
        $(function () {
            alert("...................................");
            dataGrid = $('#dataGrid').datagrid({
                url: '${path}'+'/salecontroller/dataGrid',
                striped: true,
                rownumbers: true,
                pagination: true,
                singleSelect: true,
                idField: 'so_id',
                sortName: 'so_id',
                fitColumns: 'true',
                sortOrder: 'asc',
                pageSize: 20,
                pageList: [5, 10, 20, 30, 40, 50, 100, 200, 300, 400, 500],
                frozenColumns: [[{
                    width: '150',
                    title: '销售订单编号',
                    field: 'so_id',
                    sortable: true
                }, {
                    width: '150',
                    title: '客户编号',
                    field: 'clie_id',
                    sortable: true

                },
                    {
                        width: '150',
                        title: '销售日期',
                        field: 'so_date',
                        sortable: true

                    },
                    {
                        width: '150',
                        title: '有效起日',
                        field: 'so_begain_date',
                        sortable: true

                    },
                    {
                        width: '150',
                        title: '有效止日',
                        field: 'so_end_date',
                        sortable: true

                    },
                    {
                        width: '150',
                        title: '业务员编号',
                        field: 'oper_id',
                        sortable: true

                    },
                    {
                        width: '150',
                        title: '制单人',
                        field: 'cbill',
                        sortable: true

                    },

                    {
                        field: 'action',
                        title: '操作',
                        width: 200,
                        formatter: function (value, row, index) {
                            var str = '';
                            str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'" onclick="grantFun(\'{0}\');" >授权</a>', row.so_id);
                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                            str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.so_id);
                            str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                            str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-clear\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.so_id );

                            return str;
                        }
                    }]],
                onLoadSuccess: function (data) {
                    $('.role-easyui-linkbutton-ok').linkbutton({text: '授权', plain: true, iconCls: 'icon-ok'});
                    $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑', plain: true, iconCls: 'icon-edit'});
                    $('.role-easyui-linkbutton-del').linkbutton({text: '删除', plain: true, iconCls: 'icon-clear'});
                },
                toolbar: '#toolbar'
            });
        });

        function editFun(so_id) {
            if (so_id == undefined) {
                var rows = dataGrid.datagrid('getSelections');
                so_id = rows[0].id;
            } else {
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }
            parent.$.modalDialog({
                title: '编辑',
                width: 500,
                height: 300,
                href: '${path }/salecontroller/editPage?id=' + id,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#studentEditForm');
                        f.submit();
                    }
                }]
            });
        }
        function deleteFun(so_id) {
            //alert(so_id);
            if (so_id == undefined) {//点击右键菜单才会触发这个
                var rows = dataGrid.datagrid('getSelections');
                so_id = rows[0].so_id;
            } else {//点击操作里面的删除图标会触发这个
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }
            parent.$.messager.confirm('询问', '您是否要删除当前的销售订单？', function (b) {
                if (b) {
                    progressLoad();
                    $.post('${path}/salecontroller/delete', {
                        so_id: so_id
                    }, function (result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            dataGrid.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
            });
        }

        function addFun() {
            parent.$.modalDialog({
                title: '添加',
                width: 500,
                height: 300,
                href: '${path}/salecontroller/addPage',
                buttons: [{
                    text: '确定',
                    handler: function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#roleAddForm');
                        f.submit();
                    }
                }]
            });
        }


    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',fit:true,border:false">
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="toolbar">
    <a onclick="addFun()" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'icon-add'">添加</a>
</div>
</body>
</html>