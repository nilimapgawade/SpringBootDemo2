package  com.collection.dcoreservices.exceptions;


public class InvalidTokenException extends Exception{

	
	 private final Object errorDetails;
	    public InvalidTokenException(String message, Object object){
	        super(message);
	        this.errorDetails = object;
	    }

	    public Object getErrorDetails(){
	        return errorDetails;
	    }
}
