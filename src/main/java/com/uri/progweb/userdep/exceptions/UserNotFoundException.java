package com.uri.progweb.userdep.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException () {
        super("Usuário não encontrado!");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

}
