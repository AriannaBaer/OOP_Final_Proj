package blaermanor;

public class Player {
    private final String name;
    private Room currentRoom;
    private final Inventory inventory;

    public Player(String name, Room startingRoom) {
        this.name = name;
        this.currentRoom = startingRoom;
        this.inventory = new Inventory();
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
}

