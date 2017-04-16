<%@ page  pageEncoding="utf-8"%>
<script>
function gotoPage(pagenum){
  document.PageForm.pageNo.value = pagenum;
  document.PageForm.submit();
  return ;
}
</script>
每页<%=pageBean.rowsPerPage%>行
共<%=pageBean.maxRowCount%>行
第<%=pageBean.curPage%>页
共<%=pageBean.maxPage%>页
<br/>
<%
   if(pageBean.curPage==1){ 
        out.print(" 首页 上一页");   
   }else{  
 %>   
<a href="javascript:gotoPage(1)">首页</a>
<a href="javascript:gotoPage(<%=pageBean.curPage-1%>)">上一页</a>
<%}%>
<%
   if(pageBean.curPage==pageBean.maxPage){ 
        out.print("下一页 尾页");  
   }else{  
 %>   
<a href="javascript:gotoPage(<%=pageBean.curPage+1%>)">下一页</A>
<a href="javascript:gotoPage(<%=pageBean.maxPage%>)">尾页</A>
<%}%>
转到第<input type="text" name="pageNo" style="width:50px;"/>页
<input type="submit" value="提交">

 