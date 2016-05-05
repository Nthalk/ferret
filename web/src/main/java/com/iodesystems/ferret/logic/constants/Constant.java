package com.iodesystems.ferret.logic.constants;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class Constant<T> extends Expression {
    private T value;

    public Constant(T value) {
        this.value = value;
    }

    @Override
    public final Object eval(Context context) throws EvaluationException {
        return value;
    }
}
