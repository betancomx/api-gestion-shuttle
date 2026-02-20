package mx.jbs.java.arq.la.api_gestion_shuttle.service.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String message){
        super(message);
    }
    public ServiceException(){
        super();
    }
    public ServiceException(Throwable cause){
        super(cause);
    }
    public ServiceException(String message, Throwable cause){
        super(message,cause);
    }
}