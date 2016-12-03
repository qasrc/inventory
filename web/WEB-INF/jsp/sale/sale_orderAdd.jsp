<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2016/12/1
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<script type="text/javascript">
    $(function() {
        $('#roleAddForm').form({
            url : '${path }/salecontroller/Add',
            onSubmit : function() {
                progressLoad();
                var isValid = $(this).form('validate');
                if (!isValid) {
                    progressClose();
                }
                return isValid;
            },
            success : function(result) {
                alert(result);
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
            url : '/salecontroller/searchJson',
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
    $('#dt,#sbd,#sd').datetimebox({
        value: '1/12/2016 0:0',
        showSeconds: true
    });



</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'center',border:false" title=""
         style="overflow: hidden; padding: 3px;">
        <form id="roleAddForm" method="post">
            <table class="grid">
                <tr>
                    <td>销售订单编号</td>
                    <td><input name="so_id" type="text" placeholder="请输入销售订单编号"
                               class="easyui-validatebox span2" data-options="required:true"></td>
                </tr>
                <tr>
                    <td>客户编号</td>
                    <td><input id="clie_id" class="easyui-combobox" name="clie_id"
                               data-options="valueField:'id',textField:'text'"/>

                    </td>
                </tr>
                <tr>
                    <td>销售日期</td>
                    <td><input id="dt" type="text" name="so_date"></input>
                    </td>
                <tr>
                    <td>有效起日</td>
                    <td><input id="sbd" type="text" name="so_begain_date"></input>
                    </td>
                </tr>
                <tr>
                    <td>有效止日</td>
                    <td><input id="sd" type="text" name="so_end_date"></input>
                    </td>
                </tr>

                <tr>
                    <td>业务员编号</td>
                    <td><input id="OPER_ID" class="easyui-combobox" name="oper_id"
                               data-options="valueField:'id',textField:'text'"/>

                        <%--<c:forEach items="${soIds}" var="id">
                            <p>id</p>
                        </c:forEach>--%>
                    </td>
                </tr>
                <tr>
                    <td>制单人</td>
                    <td><input name="cbill" type="text" placeholder="请输入制单人姓名"
                               class="easyui-validatebox span2" data-options="required:true"></td>
                  </tr>


                </table>
        </form>
    </div>
</div>