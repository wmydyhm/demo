package com.example.demo.test.conf;

/**
 * @Description
 * @Author wmy
 * @Date 2020/1/7 13:34
 */
public class CatchException extends RuntimeException{


    public CatchException() {
    }


    public CatchException(String message) {
        super(message);
    }


    public CatchException(String message, Throwable cause) {
        super(message, cause);
    }


    public CatchException(Throwable cause) {
        super(cause);
    }


    public CatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
