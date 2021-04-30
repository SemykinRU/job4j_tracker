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
    public void whenWithoutItemsFindAllAction() {
       Output out = new StubOutput();
       Input in = new StubInput(new String[]{"0", "1"});
       Tracker tracker = new Tracker();
       UserAction[] actions = {new ShowAllItemAction(out), new CloseAction()};
       new StartUI(out).init(in, tracker, actions);
       assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Show all items ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator() +
                                            "Хранилище еще не содержит заявок" + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. === Show all items ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithItemFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        tracker.add(new Item("Test100"));
        UserAction[] actions = {new ShowAllItemAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Show all items ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator() +
                                            "Item{id=1, name='Test100'}" + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. === Show all items ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithoutItemFindByNameAction() {
        Output out = new StubOutput();
        String name = "Test10";
        Input in = new StubInput(new String[]{"0", name, "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new FindItemByNameAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Find items by name ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator() +
                                            "Заявки с именем: " + name + " не найдены." + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. === Find items by name ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithItemsFindByNameAction() {
        Output out = new StubOutput();
        String name = "Test10";
        Input in = new StubInput(new String[]{"0", name, "1"});
        Tracker tracker = new Tracker();
        tracker.add(new Item(name));
        UserAction[] actions = {new FindItemByNameAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Find items by name ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator() +
                                            "Item{id=1, name='Test10'}" + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. === Find items by name ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithoutItemFindByIdAction() {
        Output out = new StubOutput();
        int id = 0;
        Input in = new StubInput(new String[]{"0", String.valueOf(id), "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new FindItemByIDAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Find item by id ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator() +
                                            "Заявка с введенным id: " + id + " не найдена." + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. === Find item by id ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithItemFindByIdAction() {
        Output out = new StubOutput();
        int id = 11;
        Input in = new StubInput(new String[]{"0", String.valueOf(id), "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("Test220");
        tracker.add(item);
        item.setId(id);
        UserAction[] actions = {new FindItemByIDAction(out), new CloseAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator() +
                                            "0. === Find item by id ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator() +
                                            "Item{id=11, name='Test220'}" + System.lineSeparator() +
                                            "Menu." + System.lineSeparator() +
                                            "0. === Find item by id ====" + System.lineSeparator() +
                                            "1. === Exit ===" + System.lineSeparator()));
    }
}