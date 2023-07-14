package com.userLocation.ambula.exceptions;

//we created our own exception
public class UserException extends  Exception {
    UserException(){

    }

    public UserException(String m){
        super(m);
    }

}
