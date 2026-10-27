package blaermanor.puzzles;

import blaermanor.Inventory;

public interface Puzzle {

    String getName();

    String getDescription();

    boolean solve(String answer, Inventory inventory);

    boolean isSolved();
}
