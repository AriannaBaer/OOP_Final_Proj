package blaermanor.events;

import blaermanor.puzzles.Puzzle;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {

    private final List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyPuzzleSolved(Puzzle puzzle) {
        for (GameObserver observer : new ArrayList<>(observers)) {
            observer.onPuzzleSolved(puzzle);
        }
    }
}
