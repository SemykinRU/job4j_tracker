package ru.job4j.tracker;

public class FindItemByIDAction implements UserAction {

    private final Output out;

    public FindItemByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) {
        int id = input.askInt("Enter id: ");
        Item item = memTracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
