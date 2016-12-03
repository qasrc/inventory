<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/3
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(function () {
        $('#supplierAddForm').form({

            url: '${path }/suppliers_bill/edit',
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
    })
</script>

<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title=""
         style="overflow: hidden; padding: 3px;">
        <form id="supplierAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>供货商编号</td>
                    <td>
                        <input name="supp_id" type="text" value="${supp.oper_id}" placeholder="请输入供货商编号"
                               class="easyui-validatebox span2" required="required">
                    </td>
                    <td>拼音编码</td>
                    <td>
                        <input name="supp_spell_code" value="${supp.supp_spell_code}" type="text" placeholder="请输入拼音编码"
                               class="easyui-validatebox span2" >
                    </td>
                </tr>
                <tr>
                    <td>简称</td>
                    <td>
                        <input name="supp_shortname" value="${supp.supp_shortname}" type="text" placeholder="请输简称"
                               class="easyui-validatebox span2">
                    </td>
                    <td>名称</td>
                    <td>
                        <input name="supp_name" value="${supp.supp_name}" type="text" placeholder="请输入名称"
                               class="easyui-validatebox span2" >
                    </td>
                </tr>
                <tr>
                    <td>地址</td>
                    <td>
                        <input name="supp_address" value="${supp.supp_address}" type="text" placeholder="请输入地址"
                               class="easyui-validatebox span2" >
                    </td>
                    <td>邮编</td>
                    <td>
                        <input name="supp_postcode" value="${supp.supp_postcode}" type="text" placeholder="请输入邮编"
                               class="easyui-validatebox span2" >
                    </td>
                </tr>
                <tr>
                    <td>类型</td>
                    <td>
                        <input name="supp_sort" value="${supp.supp_sort}" type="text" placeholder="请输入类型"
                               class="easyui-validatebox span2" >
                    </td>
                    <td>电话</td>
                    <td>
                        <input name="supp_tel" value="${supp.supp_tel}" type="text" placeholder="请输入电话"
                               class="easyui-validatebox span2" >
                    </td>
                </tr>
                <tr>
                    <td>传真</td>
                    <td>
                        <input name="supp_fax" value="${supp.supp_fax}" type="text" placeholder="请输入传真"
                               class="easyui-validatebox span2" >
                    </td>
                    <td>开户行</td>
                    <td>
                        <input name="supp_bank" value="${supp.supp_bank}" type="text" placeholder="请输入开户行"
                               class="easyui-validatebox span2" >
                    </td>
                </tr>
                <tr>
                    <td>银行帐号</td>
                    <td>
                        <input name="supp_iban" value="${supp.supp_iban}" type="text" placeholder="请输入银行帐号"
                               class="easyui-validatebox span2" >
                    </td>
                    <td>库房地址</td>
                    <td>
                        <input name="supp_storage_address" value="${supp.supp_storage_address}" type="text" placeholder="请输入库房地址"
                               class="easyui-validatebox span2" >
                    </td>
                </tr>
                <tr>
                    <td>库房电话</td>
                    <td>
                        <input name="supp_storage_tel" value="${supp.supp_storage_tel}" type="text" placeholder="请输入库房电话"
                               class="easyui-validatebox span2" >
                    </td>
                    <td>业务员编号</td>
                    <td>
                        <input name="oper_id" value="${supp.oper_id}" type="text" placeholder="请输入业务员编号"
                               class="easyui-validatebox span2"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
