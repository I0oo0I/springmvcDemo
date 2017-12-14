package springmvcDemo.demo1_controller.exception_handler;

/**
 * 自定义抛出错误
 * @ResponseStatus 的功能就是就错误映射为特定的状态码，这里设置成了 NOT_FOUND（404），抛出这个错误时，抛出的是404, 感觉没多大用
 * @author Administrator
 *
 */
//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="没有找到资源")
public class SystemException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5156144612317663574L;
	
	private String errorCode;
	
	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}
	
	public static SystemException init(String errorCode, String message) {
		SystemException ex = new SystemException(message);
		ex.errorCode = errorCode;
		return ex;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
