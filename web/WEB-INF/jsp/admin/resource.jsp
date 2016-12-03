<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/1
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="/commons/basejs.jsp" %>
    <meta http-equiv="X-UA-Compatible" content="edge" />
    <title>资源管理</title>
    <script type="text/javascript">
        var treeGrid;
        $(function() {
            treeGrid = $('#treeGrid').treegrid({
                url : '${path }/resource/dataTree',
                idField : 'id',
                treeField : 'name',
                parentField : 'pid',
                fit : true,
                fitColumns : false,
                border : false,
                frozenColumns : [ [ {
                    title : '编号',
                    field : 'id',
                    width : 40
                } ] ],
                columns : [ [ {
                    title : '资源名称',
                    field : 'name',
                    width : 150
                }, {
                    title : '资源路径',
                    field : 'url',
                    width : 200
                }, {
                    title : '排序',
                    field : 'seq',
                    width : 40
                }, {
                    title : '图标',
                    field : 'iconCls',
                    width : 90
                }, {
                    title : '资源类型',
                    field : 'resourcetype',
                    width : 80,
                    formatter : function(value, row, index) {
                        switch (value) {
                            case 0:
                                return '菜单';
                            case 1:
                                return '按钮';
                        }
                    }
                }, {
                    field : 'pid',
                    title : '上级资源ID',
                    width : 150,
                    hidden : true
                }, {
                    field : 'status',
                    title : '状态',
                    width : 40,
                    formatter : function(value, row, index) {
                        switch (value) {
                            case 0:
                                return '正常';
                            case 1:
                                return '停用';
                        }
                    }
                }, {
                    field : 'action',
                    title : '操作',
                    width : 130,
                    formatter : function(value, row, index) {
                        var str = '';
                        <shiro:hasRole name="admin">
                        str += $.formatString('<a href="javascript:void(0)" class="resource-easyui-linkbutton-edit" data-options="plain:true,iconCls:\'icon-edit\'" onclick="editFun(\'{0}\');" >编辑</a>', row.id);
                        </shiro:hasRole>
                        <shiro:hasRole name="admin">
                        str += '&nbsp;&nbsp;|&nbsp;&nbsp;';
                        str += $.formatString('<a href="javascript:void(0)" class="resource-easyui-linkbutton-del" data-options="plain:true,iconCls:\'icon-cancel\'" onclick="deleteFun(\'{0}\');" >删除</a>', row.id);
                        </shiro:hasRole>
                        return str;
                    }
                } ] ],
                onLoadSuccess:function(data){
                    $('.resource-easyui-linkbutton-edit').linkbutton({text:'编辑',plain:true,iconCls:'icon-edit'});
                    $('.resource-easyui-linkbutton-del').linkbutton({text:'删除',plain:true,iconCls:'icon-cancel'});
                },
                toolbar : '#toolbar'
            });
        });

        function editFun(id) {
            if (id != undefined) {
                treeGrid.treegrid('select', id);
            }
            var node = treeGrid.treegrid('getSelected');
            if (node) {
                parent.$.modalDialog({
                    title : '编辑',
                    width : 500,
                    height : 350,
                    href : '${path }/resources/editPage?id=' + node.id,
                    buttons : [ {
                        text : '确定',
                        handler : function() {
                            parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                            var f = parent.$.modalDialog.handler.find('#resourceEditForm');
                            f.submit();
                        }
                    } ]
                });
            }
        }

        function deleteFun(id) {
            if (id != undefined) {
                treeGrid.treegrid('select', id);
            }
            var node = treeGrid.treegrid('getSelected');
            if (node) {
                parent.$.messager.confirm('询问', '您是否要删除当前资源？删除当前资源会连同子资源一起删除!', function(b) {
                    if (b) {
                        progressLoad();
                        $.post('${pageContext.request.contextPath}/resource/delete', {
                            id : node.id
                        }, function(result) {
                            if (result.success) {
                                parent.$.messager.alert('提示', result.msg, 'info');
                                treeGrid.treegrid('reload');
                                parent.layout_west_tree.tree('reload');
                            }
                            progressClose();
                        }, 'JSON');
                    }
                });
            }
        }

        function addFun() {
            parent.$.modalDialog({
                title : '添加',
                width : 500,
                height : 350,
                href : '${path }/resource/addPage',
                buttons : [ {
                    text : '添加',
                    handler : function() {
                        parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
                        var f = parent.$.modalDialog.handler.find('#resourceAddForm');
                        f.submit();
                    }
                } ]
            });
        }
    </script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false"  style="overflow: hidden;">
        <table id="treeGrid"></table>
    </div>
</div>

<div id="toolbar" style="display: none;">
    <shiro:hasRole name="admin">
        <a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">添加</a>
    </shiro:hasRole>
</div>
</body>
</html>

.
















.