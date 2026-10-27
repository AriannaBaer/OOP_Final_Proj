package blaermanor.puzzles;

import blaermanor.Inventory;
import blaermanor.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleTest {

    @Test
    void testCorrectCodeSolvesPuzzle() {
        Puzzle puzzle = new CodePuzzle(
                "Safe",
                "Enter the combination",
                "1847"
        );

        assertTrue(puzzle.solve("1847", new Inventory()));
        assertTrue(puzzle.isSolved());
    }

    @Test
    void testIncorrectCodeDoesNotSolvePuzzle() {
        Puzzle puzzle = new CodePuzzle(
                "Safe",
                "Enter the combination",
                "1847"
        );

        assertFalse(puzzle.solve("1234", new Inventory()));
        assertFalse(puzzle.isSolved());
    }

    @Test
    void testItemPuzzleWithRequiredItem() {
        Item key = new Item("Brass Key", "An old key");
        Inventory inventory = new Inventory();
        inventory.addItem(key);

        Puzzle puzzle = new ItemPuzzle(
                "Locked Desk",
                "Requires a brass key",
                key
        );

        assertTrue(puzzle.solve("", inventory));
        assertTrue(puzzle.isSolved());
    }

    @Test
    void testItemPuzzleWithoutRequiredItem() {
        Item key = new Item("Brass Key", "An old key");
        Inventory inventory = new Inventory();

        Puzzle puzzle = new ItemPuzzle(
                "Locked Desk",
                "Requires a brass key",
                key
        );

        assertFalse(puzzle.solve("", inventory));
        assertFalse(puzzle.isSolved());
    }

    @Test
    void testPolymorphismWithDifferentPuzzles() {
        Item key = new Item("Brass Key", "An old key");
        Inventory inventory = new Inventory();
        inventory.addItem(key);

        Puzzle[] puzzles = {
                new CodePuzzle("Safe", "Enter code", "1847"),
                new ItemPuzzle("Desk", "Use key", key)
        };

        assertTrue(puzzles[0].solve("1847", inventory));
        assertTrue(puzzles[1].solve("", inventory));

        for (Puzzle puzzle : puzzles) {
            assertTrue(puzzle.isSolved());
        }
    }

    @Test
    void testSolvedPuzzleStaysSolved() {
        Puzzle puzzle = new CodePuzzle(
                "Safe",
                "Enter code",
                "1847"
        );

        assertTrue(puzzle.solve("1847", new Inventory()));
        assertTrue(puzzle.solve("wrong", new Inventory()));
        assertTrue(puzzle.isSolved());
    }
}