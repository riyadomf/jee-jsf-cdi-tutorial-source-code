package com.jee.tutorial.jsfcdiexample.jsflifecycle;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;

public class LifecycleLogger implements PhaseListener {
    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Before phase: " +
                event.getPhaseId());
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("After phase: " +
                event.getPhaseId());
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}