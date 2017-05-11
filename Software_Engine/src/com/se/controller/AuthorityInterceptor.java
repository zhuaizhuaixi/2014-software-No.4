package com.se.controller;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;


//权限检查拦截器继承AbstractInterceptor类
public class AuthorityInterceptor extends AbstractInterceptor
{
	//拦截Action处理的拦截方法
    public String intercept(ActionInvocation invocation)
		throws Exception
	{
    	//取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//取出名为user的Session属性
		String user = (String)session.get("username");
		if (user != null )
		{
			return invocation.invoke();  //放行
		}
		//直接返回login的逻辑视图
		return "login";
    }

}