package com.iodesystems.ferret.logic.actions;

import com.iodesystems.ferret.event.Bus;
import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class EmitEventAction extends Action {
    private final Bus bus;
    private final Expression eventProducer;

    public EmitEventAction(Bus bus, Expression eventProducer) {
        this.bus = bus;
        this.eventProducer = eventProducer;
    }

    @Override
    protected void perform(Context context) {
        try {
            Object eval = eventProducer.eval(context);

        } catch (EvaluationException e) {
            e.printStackTrace();
        }
    }
}
