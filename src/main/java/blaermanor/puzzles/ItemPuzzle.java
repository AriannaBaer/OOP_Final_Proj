package blaermanor.puzzles;

import blaermanor.Inventory;
import blaermanor.Item;

public class ItemPuzzle implements Puzzle {

    private final String name;
    private final String description;
    private final Item requiredItem;
    private boolean solved;

    public ItemPuzzle(String name, String description,
                      Item requiredItem) {
        this.name = name;
        this.description = description;
        this.requiredItem = requiredItem;
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

        if (inventory != null && inventory.hasItem(requiredItem)) {
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
