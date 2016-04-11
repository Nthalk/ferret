package com.iodesystems.ferret.logic.operations;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class EqualsOperation extends Operation {

    public EqualsOperation(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object eval(Context context) throws EvaluationException {
        return Context.isEqual(left.eval(context), right.eval(context));
    }
}
