<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/1
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<script type="text/javascript">
    $(function() {
        $('#roleAddForm').form({
            url : '${path }/popedom/addPope',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        });
    });

    /*var myloader = function(param, success, error) {
        var q = param.q || '';
        if (q.length < 1) {
            return false
        }
        $.ajax({
            url : '/role/searchJson',
            type : "post",
            dataType : 'json',
            data : {
                param : q
            },
            success : function(data) {
                var jsona = data.obj;
                console.log("i am in success-->" + jsona);
                obj= $.parseJSON(jsona);

                var items = $.each(obj, function(value) {
                    return value;
                });
                success(items);
            }

        });
    }*/
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title=""
         style="overflow: hidden; padding: 3px;">
        <form id="roleAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>角色名称</td>
                    <td><input name="pope_name" type="text" placeholder="请输入角色名称"
                               class="easyui-validatebox span2" data-options="required:true"
                               value=""></td>
                </tr>


            </table>
        </form>
    </div>
</div>