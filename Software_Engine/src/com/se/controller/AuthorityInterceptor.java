package com.se.controller;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.*;


//Ȩ�޼���������̳�AbstractInterceptor��
public class AuthorityInterceptor extends AbstractInterceptor
{
	//����Action��������ط���
    public String intercept(ActionInvocation invocation)
		throws Exception
	{
    	//ȡ��������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//ȡ����Ϊuser��Session����
		String user = (String)session.get("username");
		if (user != null )
		{
			return invocation.invoke();  //����
		}
		//ֱ�ӷ���login���߼���ͼ
		return "login";
    }

}