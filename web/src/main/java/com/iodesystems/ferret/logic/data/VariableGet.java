package com.iodesystems.ferret.logic.data;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class VariableGet extends Expression {
    private final String name;

    public VariableGet(String name) {
        this.name = name;
    }

    @Override
    public Object eval(Context context) throws EvaluationException {
        return context.get(name);
    }
}
