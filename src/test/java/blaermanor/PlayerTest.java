package blaermanor;

import org.junit.jupiter.api.Test;
import blaermanor.puzzles.CodePuzzle;
import blaermanor.puzzles.ItemPuzzle;
import blaermanor.puzzles.Puzzle;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerCreation() {
        Room foyer = new Room("Foyer", "The entrance");
        Player player = new Player("Eleanor", foyer);

        assertEquals("Eleanor", player.getName());
        assertEquals(foyer, player.getCurrentRoom());
        assertTrue(player.getInventory().getItems().isEmpty());
    }

    @Test
    void testMoveToConnectedRoom() {
        Room foyer = new Room("Foyer", "The entrance");
        Room library = new Room("Library", "Old books");
        foyer.connect(library);

        Player player = new Player("Eleanor", foyer);

        assertTrue(player.moveTo(library));
        assertEquals(library, player.getCurrentRoom());
    }

    @Test
    void testCannotMoveToUnconnectedRoom() {
        Room foyer = new Room("Foyer", "The entrance");
        Room study = new Room("Study", "A locked study");

        Player player = new Player("Eleanor", foyer);

        assertFalse(player.moveTo(study));
        assertEquals(foyer, player.getCurrentRoom());
    }

    @Test
    void testPickUpItem() {
        Room library = new Room("Library", "Old books");
        Item key = new Item("Brass Key", "An old key");
        library.addItem(key);

        Player player = new Player("Eleanor", library);

        assertTrue(player.pickUpItem(key));
        assertTrue(player.getInventory().hasItem(key));
        assertFalse(library.getItems().contains(key));
    }

    @Test
    void testCannotPickUpMissingItem() {
        Room foyer = new Room("Foyer", "The entrance");
        Item key = new Item("Brass Key", "An old key");

        Player player = new Player("Eleanor", foyer);

        assertFalse(player.pickUpItem(key));
        assertFalse(player.getInventory().hasItem(key));
    }

    @Test
    void testCollectItemsAcrossRooms() {
        Room foyer = new Room("Foyer", "The entrance");
        Room library = new Room("Library", "Old books");
        foyer.connect(library);

        Item note = new Item("Note", "A mysterious message");
        Item key = new Item("Key", "An old brass key");

        foyer.addItem(note);
        library.addItem(key);

        Player player = new Player("Eleanor", foyer);

        assertTrue(player.pickUpItem(note));
        assertTrue(player.moveTo(library));
        assertTrue(player.pickUpItem(key));

        assertEquals(2, player.getInventory().getItems().size());
        assertTrue(player.getInventory().hasItem(note));
        assertTrue(player.getInventory().hasItem(key));
    }


    @Test
    void testPlayerSolvesCodePuzzle() {
        Room study = new Room("Study", "An old study");
        Player player = new Player("Explorer", study);

        Puzzle safe = new CodePuzzle(
                "Locked Safe",
                "Enter the four-digit code",
                "1847"
        );

        study.addPuzzle(safe);

        assertTrue(player.solvePuzzle(safe, "1847"));
        assertTrue(safe.isSolved());
    }

    @Test
    void testPlayerSolvesItemPuzzle() {
        Room library = new Room("Library", "Old books");
        Player player = new Player("Explorer", library);

        Item key = new Item("Brass Key", "An old key");
        library.addItem(key);

        Puzzle desk = new ItemPuzzle(
                "Locked Desk",
                "Requires a brass key",
                key
        );

        library.addPuzzle(desk);

        assertTrue(player.pickUpItem(key));
        assertTrue(player.solvePuzzle(desk, ""));
        assertTrue(desk.isSolved());
    }

    @Test
    void testCannotSolvePuzzleInDifferentRoom() {
        Room foyer = new Room("Foyer", "The entrance");
        Room study = new Room("Study", "An old study");

        Player player = new Player("Explorer", foyer);

        Puzzle safe = new CodePuzzle(
                "Locked Safe",
                "Enter the code",
                "1847"
        );

        study.addPuzzle(safe);

        assertFalse(player.solvePuzzle(safe, "1847"));
        assertFalse(safe.isSolved());
    }

}