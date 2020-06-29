/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prono.error;

/**
 *
 * @author alain
 */
public class PronoException extends Exception {
    // Attributes 
    private String errorCode;
    private Throwable javaException;

    public PronoException(String errorCode) {
        super(ErrorMessage.getMessage(errorCode));
        this.errorCode = errorCode;
    }

    public PronoException(String errorCode, Throwable cause) {
        super(ErrorMessage.getMessage(errorCode), cause);
        this.errorCode = errorCode;
        this.javaException = cause;
    }

    public Throwable getJavaException() {
        return javaException;
    }

    public String getErrorCode() {
        return errorCode;
    }


    
}
