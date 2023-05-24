package com.hogwart.gradebook.exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id) {
        super("The person id '" + id + "' does not exist in our records");
    }
}
