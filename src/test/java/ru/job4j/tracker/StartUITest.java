package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new CloseAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(out),
                new CloseAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(out),
                new CloseAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CloseAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
       Output out = new StubOutput();
       Input in = new StubInput(new String[]{"1"});
       Tracker tracker = new Tracker();
       UserAction[] actions = {new ShowAllItemAction(out), new CloseAction()};
       new StartUI(out).init(in, tracker, actions);
       assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Show all items ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new FindItemByNameAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Find items by name ====" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new FindItemByIDAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. === Find item by id ====" + System.lineSeparator() +
                "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenAllMenu() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"6"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out),
                new ShowAllItemAction(out),
                new ReplaceItemAction(out),
                new DeleteItemAction(out),
                new FindItemByIDAction(out),
                new FindItemByNameAction(out),
                new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                "0. Add new Item" + System.lineSeparator() +
                "1. === Show all items ====" + System.lineSeparator() +
                "2. === Edit item ====" + System.lineSeparator() +
                "3. === Delete item ====" + System.lineSeparator() +
                "4. === Find item by id ====" + System.lineSeparator() +
                "5. === Find items by name ====" + System.lineSeparator() +
                "6. === Exit ===" + System.lineSeparator()));
    }

}