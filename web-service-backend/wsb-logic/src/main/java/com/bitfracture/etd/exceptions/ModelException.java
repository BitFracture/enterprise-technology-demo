package com.bitfracture.etd.exceptions;

/**
 * Base level exception for all model data translation or validation errors.
 */
public class ModelException extends RuntimeException {
    public ModelException(String message) {
        super(message);
    }
    public ModelException(String message, Throwable cause) {
        super(message, cause);
    }
}
