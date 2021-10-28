package ru.job4j.tracker;

public class CloseAction implements UserAction {

    @Override
    public String name() {
        return "=== Exit ===";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        return false;
    }
}
