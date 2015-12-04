package com.rexfun.androidlibraryorm;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import android.content.ContentValues;
import android.database.Cursor;

public abstract class BaseService<T, PK extends Serializable>
{
	public abstract BaseDao<T, PK> getEntityDao();
	
	/**
	 * 新增记录
	 * @param o 实体对象
	 */
	public synchronized void add(T o)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().add(o);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 新增记录
	 * @param table 表名
	 * @param o 实体对象
	 */
	public synchronized void add(String table, T o)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().add(table, o);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 新增记录
	 * @param sql sql语句
	 * @param values insert语句values值数组
	 */
	public synchronized void add(String sql, Object...values)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().add(sql, values);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}

	/**
	 * 删除记录
	 * @param table 表名
	 * @param whereClause where条件(如："id=? and name=?")
	 * @param whereArgs where条件参数数组，数组长度需跟where条件的?号个数对应（如：new String[]{"001","张三"}）
	 */
	public synchronized void delete(String table, String whereClause, String[] whereArgs)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().delete(table, whereClause, whereArgs);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 删除记录
	 * @param table 表名
	 * @param primaryKey 主键值
	 */
	public synchronized void delete(String table, PK primaryKey)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().delete(table, primaryKey);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 删除记录(批量)
	 * @param table 表名
	 * @param pks PK[]主键值数组
	 */
	public synchronized void deleteBatch(String table, PK[] pks)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().deleteBatch(table, pks);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 删除记录(批量)
	 * @param table 表名
	 * @param pks 主键值集合
	 */
	public synchronized void deleteBatch(String table, List<PK> pks)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().deleteBatch(table, pks);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}	
	/**
	 * 删除记录(批量)
	 * @param table 表名
	 * @param pks 主键值集合字符串,以逗号隔开
	 */
	public synchronized void deleteBatch(String table, String pks)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().deleteBatch(table, pks);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}	
	/**
	 * 修改记录
	 * @param table 表名
	 * @param values 要修改的列的键值对
	 * @param whereClause where条件(如："id=? and name=?")
	 * @param whereArgs where条件参数数组，数组长度需跟where条件的?号个数对应（如：new String[]{"001","张三"}）
	 */
	public synchronized void update(String table, ContentValues values, String whereClause, String[] whereArgs)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(table, values, whereClause, whereArgs);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录（批量）
	 * @param o 实体对象
	 * @param ids 主键值数组
	 * @param fieldNames 需要修改的属性名
	 */
	public synchronized void update(T o, long[] ids, String[] fieldNames)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(o, ids, fieldNames);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录
	 * @param o 实体对象
	 * @param id 主键
	 * @param fieldNames 需要修改的属性名
	 */
	public synchronized void update(T o, Long id, String[] fieldNames)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(o, id, fieldNames);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录
	 * @param o 实体对象
	 * @param ids 主键值集合字符串，以逗号隔开
	 * @param fieldNames 需要修改的属性名
	 */
	public synchronized void update(T o, String ids, String[] fieldNames)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(o, ids, fieldNames);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录
	 * @param o 实体对象
	 */
	public synchronized void update(T o)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(o);
			getEntityDao().setTransactionSuccessful();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录（批量）
	 * @param o 实体对象
	 * @param ids 主键值数组
	 */
	public synchronized void update(T o, long[] ids)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(o, ids);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录（批量）
	 * @param o 实体对象
	 * @param ids 主键值集合字符串，以逗号隔开
	 */
	public synchronized void update(T o, String ids)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(o, ids);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 修改记录
	 * @param sql SQL的update语句
	 * @param values update语句对应的问号值
	 */
	public synchronized void udpate(String sql, Object...values)
	{
		getEntityDao().beginTransaction();
		try
		{
			getEntityDao().update(sql,values);
			getEntityDao().setTransactionSuccessful();
		}
		finally
		{
			getEntityDao().endTransaction();
		}
		getEntityDao().close();
	}
	/**
	 * 查询
	 * @param table 表名
	 * @param columns 列名数组
	 * @param selection where条件(如："id=? and name=?")
	 * @param selectionArgs where条件参数数组，数组长度需跟where条件的?号个数对应（如：new String[]{"001","张三"}）
	 * @param groupBy 分组
	 * @param having 分组条件
	 * @param orderBy 排序类
	 * @return
	 */
	public Cursor queryCursor(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
	{
		return getEntityDao().queryCursor(table, columns, selection, selectionArgs, groupBy, having, orderBy);
	}
	/**
	 * 分页查询
	 * @param o 实体对象
	 * @param m 查询参数Map
	 * @param groupBy 分组
	 * @param having 分组条件
	 * @param orderBy 排序类
	 * @param offset 跳过前面几条数据
	 * @param maxResult 获取几条
	 * @return 游标
	 */
	public Cursor queryPage(T o, Map<String, Object> m, String groupBy, String having, String orderBy, int offset, int maxResult)
	{
		return getEntityDao().queryPage(o, m, groupBy, having, orderBy, offset, maxResult);
	}
	/**
	 * 获取记录数
	 * @param sql sql count语句
	 * @param values where条件参数数组，数组长度需跟where条件的?号个数对应（如：new String[]{"001","张三"}）
	 * @return
	 */
	public int getCount(String table)
	{
		return getEntityDao().getCount(table);
	}
}
