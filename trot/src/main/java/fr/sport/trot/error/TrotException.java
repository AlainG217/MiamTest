/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sport.trot.error;

/**
 *
 * @author alain
 */
public class TrotException extends Exception {
    // Attributes 
    private String errorCode;
    private Throwable javaException;
    private String tableName;
    private String methodName;
    

    public TrotException(String errorCode) {
        super(ErrorMessage.getMessage(errorCode));
        this.errorCode = errorCode;
        this.tableName = null;
        this.methodName = null;
    }

    public TrotException(String errorCode, String m) {
        super(ErrorMessage.getMessage(errorCode));
        this.errorCode = errorCode;
        this.tableName = null;
        this.methodName = m;
    }

    public TrotException(String errorCode, Throwable cause) {
        super(ErrorMessage.getMessage(errorCode), cause);
        this.errorCode = errorCode;
        this.tableName = null;
        this.methodName = null;
        this.javaException = cause;
    }

    public TrotException(String errorCode, Throwable cause, String t, String m) {
        super(ErrorMessage.getMessage(errorCode), cause);
        this.errorCode = errorCode;
        this.tableName = t;
        this.methodName = m;
        this.javaException = cause;
    }
    
    public void show () {
            System.out.println("Erreur " + this.errorCode + " - " + this);
            System.out.println("Erreur " + getJavaException());
            if ( !(tableName == null))
                System.out.println("Table " + this.tableName);
            if ( !(methodName == null))
                System.out.println("Méthode " + this.methodName);
            for (StackTraceElement element : getStackTrace()) {
                System.out.println(element.toString());
            }
        
    }

    public Throwable getJavaException() {
        return javaException;
    }

    public String getErrorCode() {
        return errorCode;
    }


    
}
