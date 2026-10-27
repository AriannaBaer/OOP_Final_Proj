package blaermanor;

import blaermanor.puzzles.Puzzle;
import blaermanor.events.GameEventManager;

public class Player {
    private final String name;
    private Room currentRoom;
    private final Inventory inventory;
    private final GameEventManager eventManager;

    public Player(String name, Room startingRoom) {
        this(name, startingRoom, new GameEventManager());
    }

    public Player(String name, Room startingRoom,
                  GameEventManager eventManager) {
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
        this.eventManager = eventManager;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean moveTo(Room destination) {
        if (currentRoom.isConnectedTo(destination)) {
            currentRoom = destination;
            return true;
        }

        return false;
    }

    public boolean pickUpItem(Item item) {
        if (currentRoom.removeItem(item)) {
            inventory.addItem(item);
            return true;
        }

        return false;
    }

    public boolean solvePuzzle(Puzzle puzzle, String answer) {
        if (puzzle == null || !currentRoom.hasPuzzle(puzzle)) {
            return false;
        }

        boolean wasSolved = puzzle.isSolved();

        boolean success = puzzle.solve(answer, inventory);

        if (success && !wasSolved && puzzle.isSolved()) {
            eventManager.notifyPuzzleSolved(puzzle);
        }

        return success;
    }

}

