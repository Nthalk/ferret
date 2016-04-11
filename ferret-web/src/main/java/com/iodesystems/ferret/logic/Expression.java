package com.iodesystems.ferret.logic;

import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public abstract class Expression {
    public abstract Object eval(Context context) throws EvaluationException;
}
