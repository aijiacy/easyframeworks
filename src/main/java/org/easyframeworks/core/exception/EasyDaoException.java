package org.easyframeworks.core.exception;

public class EasyDaoException extends EasyWorkRuntimeException {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = -3143637033692885083L;

	public EasyDaoException(String message) {
		super(message);
	}
	
	public EasyDaoException(Throwable e){
		super(e);
	}
	
	public EasyDaoException(String message, Throwable e){
		super(message, e);
	}
}
