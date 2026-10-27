package blaermanor.events;

import blaermanor.Player;
import blaermanor.Room;
import blaermanor.puzzles.CodePuzzle;
import blaermanor.puzzles.Puzzle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEventManagerTest {

    @Test
    void testObserverReceivesPuzzleSolvedEvent() {
        GameEventManager manager = new GameEventManager();
        GameProgressTracker tracker = new GameProgressTracker();

        manager.addObserver(tracker);

        Room study = new Room("Study", "An old study");
        Puzzle safe = new CodePuzzle("Safe", "Enter code", "1847");
        study.addPuzzle(safe);

        Player player = new Player("Explorer", study, manager);

        assertTrue(player.solvePuzzle(safe, "1847"));
        assertEquals(1, tracker.getSolvedPuzzleCount());
        assertTrue(tracker.hasCompletedPuzzle(safe));
    }

    @Test
    void testIncorrectAnswerDoesNotNotify() {
        GameEventManager manager = new GameEventManager();
        GameProgressTracker tracker = new GameProgressTracker();

        manager.addObserver(tracker);

        Room study = new Room("Study", "An old study");
        Puzzle safe = new CodePuzzle("Safe", "Enter code", "1847");
        study.addPuzzle(safe);

        Player player = new Player("Explorer", study, manager);

        assertFalse(player.solvePuzzle(safe, "1234"));
        assertEquals(0, tracker.getSolvedPuzzleCount());
    }

    @Test
    void testPuzzleOnlyCountedOnce() {
        GameEventManager manager = new GameEventManager();
        GameProgressTracker tracker = new GameProgressTracker();

        manager.addObserver(tracker);

        Room study = new Room("Study", "An old study");
        Puzzle safe = new CodePuzzle("Safe", "Enter code", "1847");
        study.addPuzzle(safe);

        Player player = new Player("Explorer", study, manager);

        player.solvePuzzle(safe, "1847");
        player.solvePuzzle(safe, "1847");

        assertEquals(1, tracker.getSolvedPuzzleCount());
    }

    @Test
    void testRemovingObserverStopsNotifications() {
        GameEventManager manager = new GameEventManager();
        GameProgressTracker tracker = new GameProgressTracker();

        manager.addObserver(tracker);
        manager.removeObserver(tracker);

        Room study = new Room("Study", "An old study");
        Puzzle safe = new CodePuzzle("Safe", "Enter code", "1847");
        study.addPuzzle(safe);

        Player player = new Player("Explorer", study, manager);

        player.solvePuzzle(safe, "1847");

        assertEquals(0, tracker.getSolvedPuzzleCount());
    }

    @Test
    void testMultipleObserversReceiveEvent() {
        GameEventManager manager = new GameEventManager();

        GameProgressTracker tracker1 = new GameProgressTracker();
        GameProgressTracker tracker2 = new GameProgressTracker();

        manager.addObserver(tracker1);
        manager.addObserver(tracker2);

        Room study = new Room("Study", "An old study");
        Puzzle safe = new CodePuzzle("Safe", "Enter code", "1847");
        study.addPuzzle(safe);

        Player player = new Player("Explorer", study, manager);

        player.solvePuzzle(safe, "1847");

        assertEquals(1, tracker1.getSolvedPuzzleCount());
        assertEquals(1, tracker2.getSolvedPuzzleCount());
    }
}