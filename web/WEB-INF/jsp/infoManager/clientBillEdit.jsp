<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/2
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/1
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function () {
        $('#clientEditForm').form({
            url: '${path}/client_bill/edit',
            onSubmit: function () {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success: function (result) {
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
        <form id="clientEditForm" method="post">
            <table class="grid">
                <tr>
                    <td>客户编号</td>
                    <td><input name="clie_id" type="text" placeholder="请输入客户编号"
                               class="easyui-validatebox span2" data-options="required:true"
                               value="${client.clie_id}"></td>
                    <td>拼音编码</td>
                    <td><input name="clie_ spell_code" value="${client.clie_spell_code}" class="easyui-validatebox"
                               style="width: 140px; height: 29px;"
                               data-options="editable:true"></td>
                </tr>
                </tr>

                <tr>
                    <td>简称</td>
                    <td><input name="clie_shortname" class="easyui-validatebox" value="${client.clie_shortname}" required="required"
                               data-options="editable:true"></td>
                    <td>名称</td>
                    <td><input name="clie_name" class="easyui-validatebox" required="required" value="${client.clie_name}"
                               data-options="editable:true"></td>
                </tr>

                <tr>
                    <td>联系人</td>
                    <td><input name="clie_linkman" class="easyui-validatebox" value="${client.clie_linkman}" required="required"
                               data-options="editable:true"></td>
                    <td>地址</td>
                    <td><input name="clie_address" class="easyui-validatebox" value="${client.clie_address}" required="required"
                               data-options="editable:true"></td>
                </tr>

                <tr>
                    <td>邮编</td>
                    <td><input name="clie_postcode" class="easyui-validatebox" value="${client.clie_postcode}"
                               data-options="editable:true"></td>
                    <td>电话</td>
                    <td><input name="clie_tel" class="easyui-validatebox" value="${client.clie_tel}" required="required"
                               data-options="editable:true"></td>
                </tr>

                <tr>
                    <td>传真</td>
                    <td><input name="clie_fax" class="easyui-validatebox" value="${client.clie_fax}" required="required"
                               data-options="editable:true"></td>
                    <td>开户行</td>
                    <td><input name="clie_bank" class="easyui-validatebox" value="${client.clie_bank}" required="required"
                               data-options="editable:true"></td>
                </tr>

                <tr>
                    <td>银行帐号</td>
                    <td><input name="clie_iban" class="easyui-validatebox" value="${client.clie_iban}" required="required"
                               data-options="editable:true"></td>
                    <td>性质</td>
                    <td><input name="clie_sort" class="easyui-validatebox" value="${client.clie_sort}" required="required"
                               data-options="editable:true"></td>
                </tr>

                <tr>
                    <td>业务员</td>
                    <td>
                        <select style="width:150px" class="easyui-combobox">
                            <c:forEach items="${names}"  var="name">
                            <option value="${name.user_id}" >${name.user_name}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>授信额度</td>
                    <td><input name="clie_creditlimt" class="easyui-validatebox" value="${client.clie_creditlimt}"
                               data-options="editable:true"></td>
                </tr>
            </table>
        </form>
    </div>
</div>