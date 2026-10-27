package blaermanor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void testItemCreation() {
        Item key = new Item(
                "Library Key",
                "An old brass key found in the foyer"
        );

        assertEquals("Library Key", key.getName());
        assertEquals(
                "An old brass key found in the foyer",
                key.getDescription()
        );
    }

    @Test
    void testItemToString() {
        Item note = new Item(
                "Mysterious Note",
                "A handwritten note with a strange symbol"
        );

        assertEquals(
                "Mysterious Note: A handwritten note with a strange symbol",
                note.toString()
        );
    }
}
