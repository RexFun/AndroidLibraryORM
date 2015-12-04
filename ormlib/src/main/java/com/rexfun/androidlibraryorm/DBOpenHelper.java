package com.rexfun.androidlibraryorm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper 
{
	private String[] createTableSqls;
	private String[] upgradeTableSqls;
	
	/**
	 * @param context 上下文对象
	 * @param name 数据库文件名（后缀名可写可不写）
	 * @param factory 传null代表使用系统默认的游标工厂
	 * @param version 数据库文件版本号
	 * @param createTableSqls 建表sqls，可写多条建表语句
	 * @param upgradeTableSqls 改表sqls，可写多条改表语句
	 */
	public DBOpenHelper(Context context, String name, CursorFactory factory,int version, String[] createTableSqls, String[] upgradeTableSqls)
	{
		super(context, name, factory, version);//FileExplorer位置：<包>/database/
		this.createTableSqls = createTableSqls;
		this.upgradeTableSqls = upgradeTableSqls;
	}

	@Override
	public void onCreate(SQLiteDatabase db) //是在数据库每一次被创建时调用的,可执行多条sql语句
	{
		for(int i=0;i<createTableSqls.length;i++)
		{
			db.execSQL(createTableSqls[i]);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) //数据库版本变更时调用的,可执行多条sql语句
	{
		for(int i=0;i<upgradeTableSqls.length;i++)
		{
			db.execSQL(upgradeTableSqls[i]);
		}
	}
}
