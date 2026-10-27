package blaermanor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomFactoryTest {

    @Test
    void testCreateFoyer() {
        Room foyer = RoomFactory.createFoyer();

        assertEquals("Foyer", foyer.getName());
        assertEquals(
                "The grand entrance to Blaer Manor.",
                foyer.getDescription()
        );
    }

    @Test
    void testCreateLibrary() {
        Room library = RoomFactory.createLibrary();

        assertEquals("Library", library.getName());
    }

    @Test
    void testCreateStudy() {
        Room study = RoomFactory.createStudy();

        assertEquals("Study", study.getName());
    }

    @Test
    void testCreateMansionHasThreeRooms() {
        List<Room> rooms = RoomFactory.createMansion();

        assertEquals(3, rooms.size());
    }

    @Test
    void testMansionConnections() {
        List<Room> rooms = RoomFactory.createMansion();

        Room foyer = rooms.get(0);
        Room library = rooms.get(1);
        Room study = rooms.get(2);

        assertTrue(foyer.isConnectedTo(library));
        assertTrue(library.isConnectedTo(study));

        assertFalse(foyer.isConnectedTo(study));
    }

    @Test
    void testMansionsAreIndependent() {
        List<Room> firstMansion = RoomFactory.createMansion();
        List<Room> secondMansion = RoomFactory.createMansion();

        assertNotSame(firstMansion.get(0), secondMansion.get(0));

        firstMansion.get(0).addItem(
                new Item("Key", "An old brass key")
        );

        assertTrue(secondMansion.get(0).getItems().isEmpty());
    }
}
