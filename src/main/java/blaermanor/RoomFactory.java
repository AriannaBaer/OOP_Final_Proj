package blaermanor;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory {

    public static Room createFoyer() {
        return new Room(
                "Foyer",
                "The grand entrance to Blaer Manor."
        );
    }

    public static Room createLibrary() {
        return new Room(
                "Library",
                "A dusty room filled with old books."
        );
    }

    public static Room createStudy() {
        return new Room(
                "Study",
                "A quiet room with an old wooden desk."
        );
    }

    public static List<Room> createMansion() {
        Room foyer = createFoyer();
        Room library = createLibrary();
        Room study = createStudy();

        foyer.connect(library);
        library.connect(study);

        List<Room> rooms = new ArrayList<>();
        rooms.add(foyer);
        rooms.add(library);
        rooms.add(study);

        return rooms;
    }
}