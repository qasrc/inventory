<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/2
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <title>供应商清单</title>
    <script type="text/javascript">

        var dataGrid;
        $(function () {

            $("#ss").searchbox({
                prompt:'输入供货商编号查询',
                searcher:function (value) {
                    $.messager.alert("提示", "功能暂未实现", "info");
                }
            });
            dataGrid = $("#dataGrid").datagrid({
                url:'${path}/suppliers_bill/dataGrid',
                striped:true,
                rownumbers:true,
                singleSelect: true,
                pagination:true,
                idField:'supp_id',
                sortName:'supp_id',
                sortOrder:'asc',
                pageSize:20,
                frozenColumns:[[{
                    width:150,
                    title:'供货商编号',
                    field:'supp_id',
                    sortable:true
                },{
                    width:150,
                    title:'拼音编码',
                    field:'supp_spell_code',
                    sortable:true
                },{
                    width:150,
                    title:'名称',
                    field:'supp_name'
                },{
                    width:200,
                    title:'地址',
                    field:'supp_address',
                    sortable:true
                },{
                    width:150,
                    title:'电话',
                    field:'supp_tel',
                    sortable:true
                },{
                    field:'action',
                    title:'操作',
                    width:300,
                    formatter:function (value,row,index) {
                        var str = ' ';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.supp_id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-cancel\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.supp_id);
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="role-easyui-linkbutton-ok" data-options="plain:true,iconCls:\'icon-ok\'" onclick="detailFun(\'{0}\');" >详细信息</a>', row.supp_id);
                        return str;
                    }
                }]],
                onLoadSuccess:function (data) {
                    $('.role-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                    $('.role-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-cancel'});
                    $('.role-easyui-linkbutton-ok').linkbutton({text: '详细信息', plain: true, iconCls: 'icon-ok'});
                },
                toolbar:'#toolbar'
            })
        });

        function editFun(supp_id) {
            if(supp_id==undefined){
                var rows = dataGrid.datagrid('getSelections');
                supp=rows[0].supp_id;
            }else{
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }

            parent.$.modalDialog({
                title:'编辑',
                width:800,
                height:400,
                href:'${path}/suppliers_bill/editPage?supp_id='+supp_id,
                buttons:[{
                    text:'确定',
                    handler:function () {
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#dataGrid');
                        f.submit();
                    }
                }]
            })

        }


        function deleteFun(supp_id) {
            if(supp_id==undefined){
                var rows = dataGrid.datagrid('getSelections');
                supp=rows[0].supp_id;
            }else{
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }

            parent.$.messager.confirm('询问', '您是否要删除当前供货商？', function (b) {
                if (b) {
                    progressLoad();
                    $.post('${path}/suppliers_bill/delete', {
                        supp_id: supp_id
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

        //查看详细信息
        function detailFun(id) {
            if (id == undefined) {
                //todo 获取选中的行？
                var rows = dataGrid.datagrid('getSelections');
                id = rows[0].clie_id;
            } else {
                dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
            }
            parent.$.modalDialog({
                iconCls:'icon-ok',
                title:'详细信息',
                width:800,
                height:400,
                modal:true,
                href:'${path}/suppliers_bill/detail?id='+id
            });
        }

        function addFun() {
            parent.$.modalDialog({
                iconCls:'icon-add',
                title:'添加',
                width:800,
                height:400,
                model:true,
                href:'${path}/suppliers_bill/addPage',
                buttons:[{
                    text:'确定',
                    handler:function () {
                        //todo 这句话为什么这么写
                        parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#supplierAddForm');
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
    <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton"
       data-options="plain:true,iconCls:'icon-add'">添加</a>
    <input id="ss"/>
</div>
</body>
</html>