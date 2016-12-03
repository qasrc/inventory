<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/3
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(function () {
        $("#operatorFormAdd").form({
            url:'${path}/operator/add',
            onSubmit:function () {
                progressLoad();
                var isValid = $(this).form('validate');
                if(!isValid){
                    progressClose();
                }
                return isValid;
            },
            success:function (result) {
                progressClose();
                result = $.parseJSON(result);
                if (result.success) {
                    parent.$.modalDialog.openner_dataGrid.datagrid('reload');
                    parent.$.modalDialog.handler.dialog('close');
                } else {
                    parent.$.messager.alert('错误', result.msg, 'error');
                }
            }
        })
    })
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',fit:true,border:false"
         style="overflow: hidden;padding: 3px;">
        <form id="operatorFormAdd" method="post">
            <table class="grid">
                <tr>
                    <td>业务员编码</td>
                    <td>
                        <input name="oper_id" class="easyui-validatebox"
                        type="text" placeholder="请输入业务员编号" required="required"/>
                    </td>
                    <td>拼音编码</td>
                    <td>
                        <input name="oper_spell_code" class="easyui-validatebox"
                               type="text" placeholder="请输入业务员编号" required="required"/>
                    </td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td>
                        <input name="oper_name" class="easyui-validatebox"
                               type="text" placeholder="请输入业务员编号" required="required"/>
                    </td>
                    <td>性别</td>
                    <td>
                       <input name="oper_sex" type="radio" value="男"/>男
                        <input name="oper_sex" type="radio" value="女">女
                    </td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>
                        <input name="oper_tel" class="easyui-validatebox"
                               type="text" placeholder="请输入电话"/>
                    </td>
                    <td>手机</td>
                    <td>
                        <input name="oper_mobile_tel" class="easyui-validatebox"
                               type="text" placeholder="请输入手机号"/>
                    </td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td>
                        <input name="oper_address" class="easyui-validatebox"
                               type="text" placeholder="请输入地址"/>
                    </td>
                    <td>邮编</td>
                    <td>
                        <input name="oper_postcode" class="easyui-validatebox"
                               type="text" placeholder="请输入邮编"/>
                    </td>
                </tr>
                <tr>
                    <td>身份证号</td>
                    <td>
                        <input name="oper_ID_number" class="easyui-validatebox"
                               type="text" placeholder="请输入身份证号" required="required"/>
                    </td>
                    <td>类别</td>
                    <td>
                        <input name="oper_sort" class="easyui-validatebox"
                               type="text" placeholder="请输入类别" required="required"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>