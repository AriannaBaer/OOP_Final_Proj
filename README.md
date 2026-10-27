**Blaer Manor** 

**Team Members:** Eleanor Blair and Arianna Baer

**Java Version:** 25

**Project Overview**

Blaer Manor is a mystery escape-room game set inside an abandoned mansion. Players can 
explore the rooms of the mansion, collect items and clues, solve puzzles
and work towards escaping the mansion. As players solve puzzles, they will eventually 
be able to unlock new areas, interact with objects, and advance through the story.

For our mid-project checkpoint, we focused on building and testing the main game
architecture rather than completing the full game. We hope to keep expanding on it,
especially when it comes to making a UI and a better developed storyline.

**Current Implementation**

* Room: This represents a location in the mansion. Rooms have names, descriptions, neighboring rooms, 
items, and puzzles.
* Player: This represents the player actually exploring the mansion. A player can move between connected rooms,
    collect items, and solve puzzles.
* Item: This represents an object that can be collected and used during gameplay.
* Inventory: Stores the items collected by the player and allows items to be added, removed,
  and checked.
* Puzzle: An interface that defines the common methods for different types of puzzles.
* CodePuzzle: A puzzle that requires the player to enter the correct code.
* ItemPuzzle: A puzzle that requires the player to have a specific item in their inventory.
* RoomFactory: Creates individual rooms and connects them to build the mansion.
* GameObserver: An interface for objects that need to be notified when puzzles are solved.
* GameEventManager: Manages observers and notifies them when a puzzle is completed.
* GameProgressTracker: Tracks the puzzles that have been completed throughout the game.
* Main: Runs a basic demo of the game. It hasn't been fully updated, we just made it to see different things
during creation.

**Design Patterns**

We have focused on three main design patterns for our project: Factory, Strategy, and Observer.

**1. Factory Pattern**

We use the Factory Pattern in RoomFactory to handle creating rooms and connecting them to build the mansion.
This keeps room creation separate from the rest of the game and makes it easier to add more rooms as we 
continue working on the project.

**2. Strategy Pattern**

We currently use a Strategy-style approach for our puzzle system. The Puzzle interface allows us to create
different types of puzzles, such as CodePuzzle and ItemPuzzle, that each have their own solving logic. 
This makes it easier to add more puzzle types without changing how the player interacts with them. We plan to develop this
into a more explicit Strategy Pattern later.

**3. Observer Pattern**

We use the Observer Pattern to track events that happen throughout the game. When a player solves a puzzle, 
GameEventManager notifies registered observers, such as GameProgressTracker, which keeps track of completed puzzles. 
This will also allow us to add things like story updates and unlocking rooms as the game develops.


**Future Development**

Because this is only our mid-project checkpoint, there are still a lot of features
we plan to add before the final submission.

* Expand the mansion to include more rooms and connections.
* Add more types of puzzles and clues.
* Implement locked doors and rooms that can only be accessed after solving
  certain puzzles.
* Make the puzzle system more explicitly follow the Strategy Pattern.
* Develop a more complete storyline and mystery behind Blaer Manor.
* Create an interactive game where the player can choose where to move and
  which objects to interact with.
* Explore creating a graphical user interface using JavaFX.
* Use game events to trigger changes in rooms, puzzles, and story progression.