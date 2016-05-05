package com.iodesystems.ferret.logic.actions;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public abstract class Action extends Expression {

    @Override
    public Object eval(Context context) throws EvaluationException {
        perform(context);
        return null;
    }

    protected abstract void perform(Context context);
}
