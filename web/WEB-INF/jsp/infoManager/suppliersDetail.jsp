<%--
  Created by IntelliJ IDEA.
  User: zhan
  Date: 2016/12/2
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/global.jsp"%>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
        <table class="grid">
            <tr>
                <td>供货商编号</td>
                <td>${supp.supp_id}</td>
                <td>拼音编码</td>
                <td>${supp.supp_spell_code}</td>
            </tr>
            <tr>
                <td>简称</td>
                <td>${supp.supp_shortname}</td>
                <td>名称</td>
                <td>${supp.supp_name}</td>
            </tr>
            <tr>
                <td>地址</td>
                <td>${supp.supp_address}</td>
                <td>邮编</td>
                <td>${supp.supp_postcode}</td>
            </tr>
            <tr>
                <td>类型</td>
                <td>${supp.supp_sort}</td>
                <td>电话</td>
                <td>${supp.supp_tel}</td>
            </tr>
            <tr>
                <td>传真</td>
                <td>${supp.supp_fax}</td>
                <td>开户行</td>
                <td>${supp.supp_bank}</td>
            </tr>
            <tr>
                <td>银行帐号</td>
                <td>${supp.supp_iban}</td>
                <td>库房地址</td>
                <td>${supp.supp_storage_address}</td>
            </tr>
            <tr>
                <td>库房电话</td>
                <td>${supp.supp_storage_tel}</td>
                <td>业务员编号</td>
                <td>${supp.oper_id}</td>
            </tr>
        </table>
    </div>
</div>
