package blaermanor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void testAddItem() {
        Inventory inventory = new Inventory();
        Item key = new Item("Library Key", "An old brass key");

        inventory.addItem(key);

        assertTrue(inventory.hasItem(key));
        assertEquals(1, inventory.getItems().size());
    }

    @Test
    void testRemoveItem() {
        Inventory inventory = new Inventory();
        Item key = new Item("Library Key", "An old brass key");

        inventory.addItem(key);

        assertTrue(inventory.removeItem(key));
        assertFalse(inventory.hasItem(key));
        assertEquals(0, inventory.getItems().size());
    }

    @Test
    void testRemoveMissingItem() {
        Inventory inventory = new Inventory();
        Item key = new Item("Library Key", "An old brass key");

        assertFalse(inventory.removeItem(key));
    }

    @Test
    void testGetItemsDoesNotExposeOriginalList() {
        Inventory inventory = new Inventory();
        Item note = new Item("Note", "A mysterious message");

        inventory.addItem(note);

        inventory.getItems().clear();

        assertTrue(inventory.hasItem(note));
        assertEquals(1, inventory.getItems().size());
    }
}

