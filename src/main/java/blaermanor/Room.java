package blaermanor;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final String name;
    private final String description;
    private final List<Room> neighbors;
    private final List<Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new ArrayList<>();
        this.items = new ArrayList<>();
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
}
