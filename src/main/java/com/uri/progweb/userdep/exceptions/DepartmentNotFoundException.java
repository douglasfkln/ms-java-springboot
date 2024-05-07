package com.uri.progweb.userdep.exceptions;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException () {
        super("Departamento não encontrado!");
    }

    public DepartmentNotFoundException(String msg) {
        super(msg);
    }
}
