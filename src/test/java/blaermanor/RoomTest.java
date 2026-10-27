package blaermanor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testRoomCreation() {
        Room library = new Room(
                "Library",
                "A dusty room filled with old books"
        );

        assertEquals("Library", library.getName());
        assertEquals(
                "A dusty room filled with old books",
                library.getDescription()
        );
    }

    @Test
    void testConnectRooms() {
        Room foyer = new Room("Foyer", "The mansion entrance");
        Room library = new Room("Library", "A dusty library");

        foyer.connect(library);

        assertTrue(foyer.isConnectedTo(library));
        assertTrue(library.isConnectedTo(foyer));
    }

    @Test
    void testNoDuplicateConnections() {
        Room foyer = new Room("Foyer", "The entrance");
        Room library = new Room("Library", "Old books");

        foyer.connect(library);
        foyer.connect(library);

        assertEquals(1, foyer.getNeighbors().size());
        assertEquals(1, library.getNeighbors().size());
    }

    @Test
    void testCannotConnectRoomToItself() {
        Room foyer = new Room("Foyer", "The entrance");

        foyer.connect(foyer);

        assertTrue(foyer.getNeighbors().isEmpty());
    }

    @Test
    void testAddAndRemoveItems() {
        Room library = new Room("Library", "Old books");
        Item key = new Item("Brass Key", "An old key");

        library.addItem(key);

        assertTrue(library.getItems().contains(key));

        assertTrue(library.removeItem(key));
        assertFalse(library.getItems().contains(key));
    }

    @Test
    void testRoomListsAreProtected() {
        Room foyer = new Room("Foyer", "The entrance");
        Room library = new Room("Library", "Old books");
        Item note = new Item("Note", "A clue");

        foyer.connect(library);
        foyer.addItem(note);

        foyer.getNeighbors().clear();
        foyer.getItems().clear();

        assertTrue(foyer.isConnectedTo(library));
        assertTrue(foyer.getItems().contains(note));
    }
}

