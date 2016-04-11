package com.iodesystems.ferret.logic.statements;

import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

import java.util.List;

public class IfStatement extends Statement {
    private final Expression test;
    private final List<Expression> then;
    private final List<Expression> otherwise;

    public IfStatement(Expression test, List<Expression> then, List<Expression> otherwise) {
        this.test = test;
        this.then = then;
        this.otherwise = otherwise;
    }

    @Override
    public Object eval(Context context) throws EvaluationException {
        Object testResult = test.eval(context);

        Object result = null;
        if (testResult instanceof Boolean && testResult == Boolean.TRUE) {
            for (Expression expression : then) {
                result = expression.eval(context);
            }
        } else {
            for (Expression expression : otherwise) {
                result = expression.eval(context);
            }
        }
        return result;
    }
}
