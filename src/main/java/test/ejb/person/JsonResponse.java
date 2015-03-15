/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... UserAdmin<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 23 ����. 2015 �.<br>
 * <br>
 */
package test.ejb.person;

/**
 * @author annik
 *
 */
public class JsonResponse<T> {

    /**
     */
    public enum StatusResponse {
        OK, // 
        ERROR, //
    }

    private StatusResponse status = StatusResponse.ERROR;

    private String message;

    private T result;

    /**
     * Getter.
     * 
     * @return the status
     */
    public StatusResponse getStatus() {

        return status;
    }

    /**
     * Setter.
     * 
     * @param status
     *            the status to set
     */
    public void setStatus( StatusResponse status ) {

        this.status = status;
    }

    /**
     * Getter.
     * 
     * @return the object
     */
    public T getObject() {

        return result;
    }

    /**
     * Setter.
     * 
     * @param object
     *            the object to set
     */
    public void setObject( T object ) {

        this.result = object;
    }

    /**
     * Getter.
     * 
     * @return the message
     */
    public String getMessage() {

        return message;
    }

    /**
     * Setter.
     * 
     * @param message
     *            the message to set
     */
    public void setMessage( String message ) {

        this.message = message;
    }

}
