package org.easyframeworks.utils;


/**
 * @class: SystemPath
 * @description : 得到当前应用的系统路径
 * @author CaoYong
 * @date 2014年5月2日 下午7:40:35
 */
public class SystemPath {

	public static String getSysPath()
	{
		String path= Thread.currentThread().getContextClassLoader().getResource("").toString();
		String temp=path.replaceFirst("file:/", "").replaceFirst("WEB-INF/classes/", "");
		String separator= System.getProperty("file.separator");
		String resultPath=temp.replaceAll("/", separator+separator);
		return resultPath;
	}
	public static String getClassPath()
	{
		String path= Thread.currentThread().getContextClassLoader().getResource("").toString();
		String temp=path.replaceFirst("file:/", "");
		String separator= System.getProperty("file.separator");
		String resultPath=temp.replaceAll("/", separator+separator);
		return resultPath;
	}
	public static String getSystempPath()
	{
		return System.getProperty("java.io.tmpdir");
	}
	public static String getSeparator()
	{
		return System.getProperty("file.separator");
	}
	
	public static void main(String[] args){
		LoggerUtils.info(getSysPath());
		LoggerUtils.info(System.getProperty("java.io.tmpdir"));
		LoggerUtils.info(getSeparator());
		LoggerUtils.info(getClassPath());
	}
}
