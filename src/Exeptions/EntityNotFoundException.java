package Exeptions;

import ddbb.Entity;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
        super("Cannot find entity");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(int id) {
        super("Cannot find entity with id={" + id + "}");
    }
}

