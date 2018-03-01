<%@ page language="java" pageEncoding="UTF-8"%>
<#if (table.hasDateColumn)>
<%@ page language="java" import="com.sxkj.frame.utils.DateUtil" %>
</#if>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title><!-- page/${moduleName}/${moduleName}View.jsp --></title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <%@include file="/common/meta.jsp"%>
        <script type="text/javascript" src="<%=basePath%>script/${moduleName}.js?<%=date.getTime()%>"></script>
        <script type="text/javascript">
            var fixedObj=0;
            function customHeightSet(contentHeight){
                $("#scrollContent").height(contentHeight-fixedObj);
            }
        </script>
    </head>
    <body>
        <div id="scrollContent">
            <div class="box1">
                <s:form method="post" id="${moduleName}Form">
                    <s:hidden id="id" name="${moduleName}.id" />
                    <table class="tableStyle" formMode="view">
                    <#list table.baseColumns as column>
                        <tr>
                            <td>${column.remarks}：</td>
                            <#if (column.isDate() )>
                            <td><s:date name="${moduleName}.${column.javaProperty}" format="yyyy-MM-dd" /></td>
                        	<#else>
                        	<td><s:property value="${moduleName}.${column.javaProperty}" /></td>
                        	</#if>
                        </tr>
                    </#list>
                    </table>
                </s:form>
            </div>
        </div>
    </body>
</html>