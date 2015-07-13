package sales.infrastructure.jpa;

public class NoExistingCustomerException extends RuntimeException{

	public NoExistingCustomerException() {
		super();
	}

	public NoExistingCustomerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoExistingCustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExistingCustomerException(String message) {
		super(message);
	}

	public NoExistingCustomerException(Throwable cause) {
		super(cause);
	}

}
