package blaermanor;

import java.util.ArrayList;
import java.util.List;
import blaermanor.puzzles.Puzzle;

public class Room {
    private final String name;
    private final String description;
    private final List<Room> neighbors;
    private final List<Item> items;
    private final List<Puzzle> puzzles;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new ArrayList<>();
        this.items = new ArrayList<>();
        this.puzzles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void connect(Room room) {
        if (room == null || room == this) {
            return;
        }

        if (!neighbors.contains(room)) {
            neighbors.add(room);
        }

        if (!room.neighbors.contains(this)) {
            room.neighbors.add(this);
        }
    }

    public List<Room> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

    public boolean isConnectedTo(Room room) {
        return neighbors.contains(room);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    public void addPuzzle(Puzzle puzzle) {
        puzzles.add(puzzle);
    }

    public boolean hasPuzzle(Puzzle puzzle) {
        return puzzles.contains(puzzle);
    }

    public List<Puzzle> getPuzzles() {
        return new ArrayList<>(puzzles);
    }

}
