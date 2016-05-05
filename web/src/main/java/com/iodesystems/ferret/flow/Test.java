package com.iodesystems.ferret.flow;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;
import com.iodesystems.ferret.data.Kind;
import com.iodesystems.ferret.logic.data.ObjectReference;

public class Test {
    public static final String TARGET = "target";
    private Expression expression;

    public Test(Expression expression) {
        this.expression = expression;
    }

    public boolean test(Kind kind) throws EvaluationException {
        Context context = new Context();
        context.set(TARGET, new ObjectReference(kind));
        return Context.isTruthy(expression.eval(context));
    }
}
