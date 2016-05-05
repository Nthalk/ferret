package com.iodesystems.ferret.flow;

import java.util.HashMap;
import java.util.Map;

public class State {
    private String name;
    private Map<Test, State> transitions = new HashMap<Test, State>();

    public State(String name) {
        this.name = name;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Test, State> getTransitions() {
        return transitions;
    }

    public void setTransitions(Map<Test, State> transitions) {
        this.transitions = transitions;
    }

    @Override
    public String toString() {
        return "State{" +
            "name='" + name + '\'' +
            '}';
    }
}
