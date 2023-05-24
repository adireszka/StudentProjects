package com.hogwart.gradebook.exception;

public class SpellNotFoundException extends RuntimeException{
    public SpellNotFoundException(Long id) {
        super("The spell id '" + id + "' does not exist in our records");
    }
}
