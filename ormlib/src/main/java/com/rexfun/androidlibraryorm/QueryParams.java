package com.rexfun.androidlibraryorm;

import java.util.ArrayList;
import java.util.List;

public class QueryParams 
{
	//where条件(如："id=? and name=?")
	private String selection = "";
	//where条件参数数组，数组长度需跟where条件的?号个数对应（如：new String[]{"001","张三"}）
	private String[] selectionArgs ={};
	private List<String> argList = new ArrayList<String>();
	
	public String getSelection() 
	{
		if(selection.length()>0) 
		{
			if(selection.startsWith("and "))
				selection = selection.substring(3);
			else if(selection.startsWith("or "))
				selection = selection.substring(2);
		}
		
		return selection;
	}
	
	public String[] getSelectionArgs() 
	{
		if(argList.size()>0) selectionArgs = argList.toArray(selectionArgs);
		return selectionArgs;
	}
	
	/**
	 * 
	 * @param and_or 运算符“and”或“or”
	 * @param key 参数名
	 * @param equation 等式符号“=”或“like”
	 */
	public void addSelection(String and_or, String key, String equation)
	{
		selection += and_or + " " + key + " " + equation + "? ";
	}
	
	/**
	 * 
	 * @param args 参数值
	 */
	public void addSelectionArgs(String value)
	{
		argList.add(value);
	}
}
