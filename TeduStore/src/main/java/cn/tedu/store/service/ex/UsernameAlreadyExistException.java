package cn.tedu.store.service.ex;

public class UsernameAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UsernameAlreadyExistException(){

	}
	public UsernameAlreadyExistException(String msg){
		super(msg);
	}
}
