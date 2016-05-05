package com.iodesystems.ferret.logic.operations;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class NotOperation extends Expression {
    private final Expression expression;

    public NotOperation(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Object eval(Context context) throws EvaluationException {
        return !Context.isTruthy(expression.eval(context));
    }
}
