package com.iodesystems.ferret.flow;

import com.iodesystems.ferret.data.Field;
import com.iodesystems.ferret.data.Kind;
import com.iodesystems.ferret.data.exceptions.InvalidKindException;
import com.iodesystems.ferret.data.exceptions.InvalidStateException;
import com.iodesystems.ferret.data.storage.KindStorage;
import com.iodesystems.ferret.logic.exceptions.EvaluationException;
import com.iodesystems.fn.Condition;
import com.iodesystems.fn.Fn;
import com.iodesystems.fn.Option;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Flow {
    private static final int MAX_TRANSITIONS = 20;

    private String name;
    private State initialState;

    public Flow(String name) {
        this.name = name;
    }

    public Flow() {
    }

    public State transitionState(Kind kind, KindStorage kindStorage) throws EvaluationException, InvalidKindException, InvalidStateException {
        State state = currentState(kind);
        for (int i = 0; i < MAX_TRANSITIONS; i++) {
            for (Map.Entry<Test, State> transition : state.getTransitions().entrySet()) {
                if (transition.getKey().test(kind)) {
                    state = transition.getValue();
                    currentStateField(kind).setValue(state.getName());
                    kindStorage.store(kind);
                    break;
                }
            }
        }
        return state;
    }

    private Field currentStateField(Kind kind) throws InvalidKindException {
        Option<Field> field = kind.getField(getName());
        if (field.isEmpty()) {
            throw new InvalidKindException();
        }

        return field.get();
    }

    public State currentState(Kind kind) throws InvalidKindException, InvalidStateException {
        Object value = currentStateField(kind).getValue();

        if (value == null) {
            return initialState;
        } else {
            Option<State> state = getState(value.toString());
            if (state.isEmpty()) {
                throw new InvalidStateException();
            } else {
                return state.get();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    public Option<State> getState(final String name) {
        return Fn.first(getStates(), new Condition<State>() {
            @Override
            public boolean is(State state) {
                return state.getName().equals(name);
            }
        });
    }

    public Set<State> getStates() {
        Set<State> found = new HashSet<State>();
        found.add(getInitialState());
        boolean more;
        do {
            more = false;
            for (State state : found) {
                if (found.addAll(state.getTransitions().values())) {
                    more = true;
                }
            }
        } while (more);
        return found;
    }

    @Override
    public String toString() {
        return "Flow{" +
            "name='" + name + '\'' +
            '}';
    }
}
