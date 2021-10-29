package ru.job4j.tracker;

import org.junit.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Before
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveSomeLikeByNameItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item 1");
        Item item1 = new Item("item 1");
        Item item2 = new Item("item 1");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        List<Item> items = List.of(item, item1, item2);
        assertThat(tracker.findByName(item.getName()), is(items));
    }

    @Test
    public void whenSaveItemAndDeleteItemThenTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item 1");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
    }

    @Test
    public void whenSaveItemAndReplaceItemThenTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item 1");
        Item item1 = new Item("newItem");
        tracker.add(item);
        assertTrue(tracker.replace(item.getId(), item1));
        assertThat(tracker.findById(item.getId()).getName(), is(item1.getName()));
    }

}
