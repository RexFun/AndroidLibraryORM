package com.rexfun.androidlibraryorm;

import android.database.sqlite.SQLiteOpenHelper;

public abstract class BaseDBHelper 
{
	private SQLiteOpenHelper dbHelper;
	//实现类初始化SQLiteOpenHelper
	protected abstract SQLiteOpenHelper initDBHelper();
	//单例模式获取SQLiteOpenHelper,不用单例模式的话会抛出isLocked异常
	public SQLiteOpenHelper getDBHelper()
	{
		if(dbHelper == null)
		{
			dbHelper = initDBHelper();
		}
		return dbHelper;
	}
}
