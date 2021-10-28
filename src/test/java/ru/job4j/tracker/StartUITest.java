package ru.job4j.tracker;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

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
        Store memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String id = String.valueOf(item.getId());
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", id, replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceItemAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        String id = String.valueOf(item.getId());
        Input in = new StubInput(
                new String[] {"0", id, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteItemAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Store memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenWithoutItemsFindAllAction() {
       Output out = new StubOutput();
       Input in = new StubInput(new String[]{"0", "1"});
       Store memTracker = new MemTracker();
       List<UserAction> actions = new ArrayList<>();
       actions.add(new ShowAllItemAction(out));
       actions.add(new CloseAction());
       new StartUI(out).init(in, memTracker, actions);
       assertThat(out.toString(), is("Menu." + System.lineSeparator()
               + "0. === Show all items ====" + System.lineSeparator()
               + "1. === Exit ===" + System.lineSeparator()
               + "Хранилище еще не содержит заявок" + System.lineSeparator()
               + "Menu." + System.lineSeparator()
               + "0. === Show all items ====" + System.lineSeparator()
               + "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithItemFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Test100"));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllItemAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Show all items ====" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Show all items ====" + System.lineSeparator()
                + "1. === Exit ===" + System.lineSeparator()));
    }

    @Test
    public void whenWithoutItemFindByNameAction() {
        Output out = new StubOutput();
        String name = "Test10";
        Input in = new StubInput(new String[]{"0", name, "1"});
        Store memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Find items by name ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator() + "Заявки с именем: "
                + name + " не найдены." + System.lineSeparator()
                + "Menu."
                + System.lineSeparator() + "0. === Find items by name ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator()));
    }

    @Test
    public void whenWithItemsFindByNameAction() {
        Output out = new StubOutput();
        String name = "Test10";
        Input in = new StubInput(new String[]{"0", name, "1"});
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item(name));
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Find items by name ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator() + item
                + System.lineSeparator() + "Menu."
                + System.lineSeparator() + "0. === Find items by name ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator()));
    }

    @Test
    public void whenWithoutItemFindByIdAction() {
        Output out = new StubOutput();
        int id = 0;
        Input in = new StubInput(new String[]{"0", String.valueOf(id), "1"});
        Store memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIDAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Find item by id ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator() + "Заявка с введенным id: " + id
                + " не найдена." + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. === Find item by id ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator()));
    }

    @Test
    public void whenWithItemFindByIdAction() {
        Output out = new StubOutput();
        int id = 11;
        Input in = new StubInput(new String[]{"0", String.valueOf(id), "1"});
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Test220"));
        item.setId(id);
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIDAction(out));
        actions.add(new CloseAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is("Menu." + System.lineSeparator()
                + "0. === Find item by id ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator() + item
                + System.lineSeparator() + "Menu."
                + System.lineSeparator() + "0. === Find item by id ===="
                + System.lineSeparator() + "1. === Exit ==="
                + System.lineSeparator()));
    }
}