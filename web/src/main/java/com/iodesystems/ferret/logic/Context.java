package com.iodesystems.ferret.logic;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Expression> scope = new HashMap<String, Expression>();

    public static boolean isTruthy(Object object) {
        if (object == null) {
            return false;
        } else if (object instanceof Boolean) {
            return (Boolean) object;
        } else if (object instanceof String) {
            return ((String) object).length() > 0;
        } else if (object instanceof Number) {
            return ((Number) object).intValue() > 0;
        } else {
            return false;
        }
    }

    public static Boolean isEqual(Object left, Object right) {
        if ((left == null) != (right == null)) {
            // One is null, and other isn't
            return false;
        } else if (left == null) {
            // they are both null
            return true;
        } else {
            // This should be safe
            return left.equals(right);
        }
    }

    public void set(String name, Expression expression) {
        scope.put(name, expression);
    }

    public Object get(String name) {
        return scope.get(name);
    }
}
