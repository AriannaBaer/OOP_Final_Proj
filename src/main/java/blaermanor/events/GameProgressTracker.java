package blaermanor.events;

import blaermanor.puzzles.Puzzle;

import java.util.HashSet;
import java.util.Set;

public class GameProgressTracker implements GameObserver {

    private final Set<Puzzle> solvedPuzzles = new HashSet<>();

    @Override
    public void onPuzzleSolved(Puzzle puzzle) {
        if (puzzle != null && puzzle.isSolved()) {
            solvedPuzzles.add(puzzle);
        }
    }

    public int getSolvedPuzzleCount() {
        return solvedPuzzles.size();
    }

    public boolean hasCompletedPuzzle(Puzzle puzzle) {
        return solvedPuzzles.contains(puzzle);
    }
}