package Mistake;

@SuppressWarnings("serial")
public class MyException extends Exception {

	public void Exception() {
		
	}

	public MyException(int weight) {
		super();
		
	}

	public MyException(Throwable cause) {
		super(cause);
		
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
