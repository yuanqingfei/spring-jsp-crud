package com.koneu.user;

import java.util.concurrent.ExecutionException;

/**
 * Created by aaron on 16-7-3.
 */
public class UserExistException extends Exception {

    public UserExistException(String msg){
        super(msg);
    }
}
