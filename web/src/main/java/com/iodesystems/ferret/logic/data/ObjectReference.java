package com.iodesystems.ferret.logic.data;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class ObjectReference extends Expression {

    private final Object object;

    public ObjectReference(Object object) {
        this.object = object;
    }

    @Override
    public Object eval(Context context) throws EvaluationException {
        return object;
    }
}
