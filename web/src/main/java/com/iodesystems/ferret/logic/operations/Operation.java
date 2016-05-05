package com.iodesystems.ferret.logic.operations;

import com.iodesystems.ferret.logic.Expression;

public abstract class Operation extends Expression {
    protected final Expression left;
    protected final Expression right;

    protected Operation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
