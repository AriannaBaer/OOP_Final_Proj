package blaermanor.puzzles;

import blaermanor.Inventory;

public class CodePuzzle implements Puzzle {

    private final String name;
    private final String description;
    private final String correctCode;
    private boolean solved;

    public CodePuzzle(String name, String description,
                      String correctCode) {
        this.name = name;
        this.description = description;
        this.correctCode = correctCode;
        this.solved = false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean solve(String answer, Inventory inventory) {
        if (solved) {
            return true;
        }

        if (correctCode.equals(answer)) {
            solved = true;
            return true;
        }

        return false;
    }

    @Override
    public boolean isSolved() {
        return solved;
    }
}
