package com.iodesystems.ferret.logic.exceptions;

public class EvaluationException extends Exception {
    public EvaluationException(Exception e) {
        super(e);
    }

    public EvaluationException(String msg) {
        super(msg);
    }
}
