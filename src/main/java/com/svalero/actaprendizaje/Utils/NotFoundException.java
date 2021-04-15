package com.svalero.actaprendizaje.Utils;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(long id) {
        super("Product not found: " + id);
    }

}
