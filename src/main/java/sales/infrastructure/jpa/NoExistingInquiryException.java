package sales.infrastructure.jpa;

public class NoExistingInquiryException extends Exception {

	public NoExistingInquiryException() {
		super();
	}

	public NoExistingInquiryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoExistingInquiryException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoExistingInquiryException(String message) {
		super(message);
	}

	public NoExistingInquiryException(Throwable cause) {
		super(cause);
	}

}
