package blaermanor.events;

import blaermanor.puzzles.Puzzle;

public interface GameObserver {

    void onPuzzleSolved(Puzzle puzzle);
}

