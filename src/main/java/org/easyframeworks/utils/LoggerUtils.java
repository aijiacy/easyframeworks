package org.easyframeworks.utils;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


/**
 * @class: LoggerUtils
 * @description : 日志辅助工具类,等级 DEBUG,INFO,WARN,ERROR,FATAL
 * @author CaoYong
 * @date 2014年5月1日 上午3:26:30
 */
public class LoggerUtils {
	
//	private static final String CONFIG_FILE = "log4j.properties";
	private static Logger logger = null;
	
	private static Logger getLogger(){
		if(logger == null){
			logger = LogManager.getLogger(LoggerUtils.class);
		}
		return logger;
	}
	
	/**
	 * 根据类对象获取日志对象
	 * @param clazz
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日上午3:34:11
	 */
	public static Logger getLogger(Class<?> clazz){
		logger = LogManager.getLogger(clazz);
		return logger;
	}
	/**
	 * 根据类名称获取日志对象
	 * @param clazzName
	 * @return
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日上午3:35:38
	 */
	public static Logger getLogger(String clazzName){
		logger = LogManager.getLogger(clazzName);
		return logger;
	}
	
	public static void debug(String message){
		logWriter("DEBUG", message);
	}
	
	public static void debug(String message, Throwable e){
		logWriter("DEBUG", message, e);
	}
	
	public static void info(String message){
		logWriter("INFO", message);
	}
	
	public static void info(String message, Throwable e){
		logWriter("INFO", message, e);
	}
	
	public static void warn(String message){
		logWriter("WARN", message);
	}
	
	public static void warn(String message, Throwable e){
		logWriter("WARN", message, e);
	}
	
	public static void error(String message){
		logWriter("ERROR", message);
	}
	
	public static void error(String message, Throwable e){
		logWriter("ERROR", message, e);
	}
	
	public static void fatal(String message){
		logWriter("FATAL", message);
	}
	
	public static void fatal(String message, Throwable e){
		logWriter("FATAL", message, e);
	}
	
	
	/**
	 * 根据日志等级，输出异常信息
	 * @param level
	 * @param message
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日上午3:55:53
	 */
	public static void logWriter(String level, String message){
		logWriter(level,message,null);
	}
	
	/**
	 * 根据日志等级，输出抛出的异常对象
	 * @param level
	 * @param e
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日上午3:55:17
	 */
	public static void logWriter(String level, Throwable e){
		logWriter(level, null, e);
	}
	
	/**
	 * 格式化输出日志
	 * @param level
	 * @param message
	 * @param e
	 * 
	 * @author CaoYong
	 * @date 2014年5月1日上午3:54:59
	 */
	public static void logWriter(String level, Object message, Throwable e)
	  {
	    try{
	      StringBuilder sb = new StringBuilder();
	      Throwable t = new Throwable();
	      StringWriter sw = new StringWriter();
	      PrintWriter pw = new PrintWriter(sw);
	      t.printStackTrace(pw);
	      String input = sw.getBuffer().toString();
	      StringReader sr = new StringReader(input);
	      BufferedReader br = new BufferedReader(sr);
	      for(int i=0;i<4;i++)
	        br.readLine(); 
	      String line = br.readLine();
	      //at com.media.web.action.DicManageAction.list(DicManageAction.java:89)
	      int paren = line.indexOf("at ");
	      line = line.substring(paren+3);
	      paren = line.indexOf('(');
	      String invokeInfo = line.substring(0, paren);
	      int period = invokeInfo.lastIndexOf('.');
	      sb.append('[');
	      sb.append(invokeInfo.substring(0,period));
	      sb.append(':');
	      sb.append(invokeInfo.substring(period+1));
	      sb.append("():");
	      paren = line.indexOf(':');
	      period = line.lastIndexOf(')');
	      sb.append(line.substring(paren+1,period));
	      sb.append(']');
	      sb.append(" - ");
	      sb.append(message);
	      getLogger().log((Priority) Level.toLevel(level), sb.toString(), e);
	    }catch(Exception ex){
	      LoggerUtils.info(ex.getLocalizedMessage());
	    }
	  }
}
