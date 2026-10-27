//adding this for me to test gameplay as i code so i can see things
package blaermanor;

public class Main {

    public static void main(String[] args) {

        // create the rooms
        Room foyer = new Room(
                "Foyer",
                "The grand entrance to Blaer Manor."
        );

        Room library = new Room(
                "Library",
                "A dusty room filled with old books."
        );

        Room study = new Room(
                "Study",
                "A quiet room with a locked desk."
        );

        // connect the rooms
        foyer.connect(library);
        library.connect(study);

        // create items
        Item note = new Item(
                "Mysterious Note",
                "A handwritten note with a strange symbol."
        );

        Item key = new Item(
                "Brass Key",
                "An old key hidden behind a bookshelf."
        );

        // place items in rooms
        foyer.addItem(note);
        library.addItem(key);

        // create the player
        Player player = new Player("Explorer", foyer);

        System.out.println("WELCOME TO BLAER MANOR");
        System.out.println("----------------------");

        // start exploring
        System.out.println("Starting in: "
                + player.getCurrentRoom().getName());

        // collect the note
        player.pickUpItem(note);
        System.out.println("Picked up: " + note.getName());

        // move to the library
        if (player.moveTo(library)) {
            System.out.println("Moved to: "
                    + player.getCurrentRoom().getName());
        }

        // collect the key
        player.pickUpItem(key);
        System.out.println("Picked up: " + key.getName());

        // move to the study
        if (player.moveTo(study)) {
            System.out.println("Moved to: "
                    + player.getCurrentRoom().getName());
        }

        // display inventory
        System.out.println("\nInventory:");
        for (Item item : player.getInventory().getItems()) {
            System.out.println("- " + item.getName());
        }

        System.out.println("\nEnd of demo!");
    }
}
