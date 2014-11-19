package org.easyframeworks.core.defintions;

/**
 * MyBatis 映射id定义
 * 
 * @author CaoYong
 * @date 2014年4月7日下午10:37:50
 */
public interface SqlMapDefines {
	public String SQL_INSERT = "insertRecord";
	public String SQL_DELETE = "deleteRecord";
	public String SQL_DELETE_BY_ID = "deleteById";
	public String SQL_UPDATE = "updateRecord";
	public String SQL_UPDATE_BY_ID = "updateById";
	public String SQL_SELECT = "selectAll";
	public String SQL_SELECT_BY_ID = "selectById";
	public String SQL_SELECT_COUNT = "selectCount";
}
