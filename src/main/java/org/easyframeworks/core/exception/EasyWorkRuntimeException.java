package org.easyframeworks.core.exception;

/**
 * 框架运行时异常类
 * @class: EasyWorkException
 * @description : (class function information)
 * @author CaoYong
 * @date 2014年5月1日 下午6:10:20
 */
public class EasyWorkRuntimeException extends RuntimeException {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 7078500925239825517L;

	public EasyWorkRuntimeException(String message) {
		super(message);
	}
	
	public EasyWorkRuntimeException(Throwable e) {
		super(e);
	}
	
	public EasyWorkRuntimeException(String message, Throwable e) {
		super(message, e);
	}

}
