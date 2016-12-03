<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/2
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <table class="grid">
            <tr>
                <td>传真</td>
                <td>${client.clie_fax}</td>
                <td>开户行</td>
                <td>${client.clie_bank}</td>
            </tr>
            <tr>
                <td>银行帐号</td>
                <td>${client.clie_iban}</td>
                <td>性质</td>
                <td>${client.clie_sort}</td>
            </tr>
            <tr>
                <td>业务员</td>
                <td>${client.oper_id}</td>
                <td>授信额度</td>
                <td>${client.clie_creditlimt}</td>
            </tr>
        </table>
    </div>
</div>
