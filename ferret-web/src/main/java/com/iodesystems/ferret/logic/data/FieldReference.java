package com.iodesystems.ferret.logic.data;

import com.iodesystems.fn.Option;
import com.iodesystems.ferret.data.Field;
import com.iodesystems.ferret.data.Kind;
import com.iodesystems.ferret.logic.Context;
import com.iodesystems.ferret.logic.Expression;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;

public class FieldReference extends Expression {

    private final Expression objectReference;
    private final String fieldName;

    public FieldReference(Expression objectReference, String fieldName) {
        this.objectReference = objectReference;
        this.fieldName = fieldName;
    }

    @Override
    public Object eval(Context context) throws EvaluationException {
        Object eval = objectReference.eval(context);
        if (eval == null) {
            return null;
        } else {

            // Unwrap object reference
            if (eval instanceof ObjectReference) {
                eval = ((ObjectReference) eval).eval(context);
            }

            if (eval instanceof Kind) {
                Option<Field> field = ((Kind) eval).getField(fieldName);
                if (field.isEmpty()) {
                    throw new EvaluationException("No such field: " + fieldName);
                } else {
                    return field.get().getValue();
                }
            }

            // Perhaps use a field cache?
            try {
                return eval.getClass().getField(fieldName).get(eval);
            } catch (IllegalAccessException e) {
                throw new EvaluationException(e);
            } catch (NoSuchFieldException e) {
                throw new EvaluationException(e);
            }
        }
    }
}
