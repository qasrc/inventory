<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/1
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge"/>
    <title>角色管理</title>
    <script type="text/javascript">
        var dataGrid;
        $(function () {
            dataGrid = $('#dataGrid').datagrid({
                url: '${path }' + '/client_bill/dataGrid',
                striped: true,
                rownumbers: true,
                pagination: true,
                singleSelect: true,
                idField: 'clie_id',
                sortName: 'clie_id',
                sortOrder: 'asc',
                pageSize: 20,
                pageList: [2, 10, 20, 30, 40, 50, 100, 200, 300, 400, 500],
                frozenColumns: [[{
                    width: '40',
                    title: 'id',
                    field: 'clie_id',
                    sortable: true
                }, {
                    width: '80',
                    title: '拼音编码',
                    field: 'clie_spell_code',
                    sortable: true
                }, {
                    width: '80',
                    title: '简称',
                    field: 'clie_shortname',
                    sortable: true
                }, {
                    width: '80',
                    title: '名称',
                    field: 'clie_name'
                }, {
                    width: '80',
                    title: '联系人',
                    field: 'clie_linkman'
                }, {
                    width: '80',
                    title: '地址',
                    field: 'clie_address'
                }, {
                    width: '80',
                    title: '邮编',
                    field: 'clie_postcode'
                }, {
                    width: '80',
                    title: '电话',
                    field: 'clie_tel'
                }/*, {
                    width: '80',
                    title: '传真',
                    field: 'clie_fax'
                }, {
                    width: '80',
                    title: '开户行',
                    field: 'clie_bank'
                }, {
                    width: '80',
                    title: '银行帐号',
                    field: 'clie_iban'
                }, {
                    width: '80',
                    title: '性质',
                    field: 'clie_sort'
                }, {
                    width: '80',
                    title: '业务员',
                    field: 'oper_id'
                }, {
                    width: '80',
                    title: '授信额度',
                    field: 'clie_creditlimt'
                }*/, {
                    field: 'action',
                    title: '操作',
                    width: 300,
                    formatter: function (value, row, index) {
                        var str = '';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.clie_id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-cancel\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.clie_id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'" onclick="grantFun(\'{0}\');" >详细信息</a>', row.clie_id);

                        return str;
                    }
                }]],
                onLoadSuccess: function (data) {
                    $('.role-easyui-linkbutton-edit').linkbutton({text: '编辑', plain: true, iconCls: 'icon-edit'});
                    $('.role-easyui-linkbutton-del').linkbutton({text: '删除', plain: true, iconCls: 'icon-cancel'});
                    $('.role-easyui-linkbutton-ok').linkbutton({text: '详细信息', plain: true, iconCls: 'icon-ok'});

                },
                toolbar: '#toolbar'
            });
        });

        function addFun() {
            parent.$.modalDialog({
                iconCls:'icon-add',
                modal:true,
                width:800,
                height:400,
                title: '添加',
                href: '${path }/client_bill/addPage',
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

        function editFun(id) {
            if (id == undefined) {
                var rows = dataGrid.datagrid('getSelections');
                id = rows[0].id;
            } else {
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }
            parent.$.modalDialog({
                title: '编辑',
                width: 500,
                height: 400,
                href: '${path }/client_bill/editPage?id=' + id,
                buttons: [{
                    text: '确定',
                    handler: function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#clientEditForm');
                        f.submit();
                    }
                }]
            });
        }

        function deleteFun(id) {
            if (id == undefined) {//点击右键菜单才会触发这个
                var rows = dataGrid.datagrid('getSelections');
                id = rows[0].id;
            } else {//点击操作里面的删除图标会触发这个
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }
            parent.$.messager.confirm('询问', '您是否要删除客户？', function (b) {
                if (b) {
                    progressLoad();
                    $.post('${path}/client_bill/delete', {
                        id: id
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

        function grantFun(id) {
            if (id == undefined) {
                //todo 获取选中的行？
                var rows = dataGrid.datagrid('getSelections');
                id = rows[0].clie_id;
            } else {
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }

            parent.$.modalDialog({
                title: '详细信息',
                iconCls:'icon-ok',
                width: 500,
                height: 500,
                href: '${path }/client_bill/detailPage?id=' + id,
                /*buttons: [{
                    text: '确定',
                    handler: function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#roleGrantForm');
                        f.submit();
                    }
                }]*/
            });
        }

    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
<div data-options="region:'center',fit:true,border:false">
    <table id="dataGrid" data-options="fit:true,border:false"></table>
</div>
<div id="toolbar" style="display: none;">
    <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'icon-add'">添加</a>
</div>
</body>
</html>