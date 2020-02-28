# League-of-OOP
A MMO-style game that is taking place in a 2D universe. It was developed in Java without a graphic interface and is using design patterns.

## Requirement
The program reads from a file the details about the map, where are the heroes, the type of the heroes, the moving on the map, the angels and the place where they will appear on the end of the map.

## How does it works?
After the input was read the map is created with a Singleton class then the heroes will fight using Visitor design pattern until the rounds will end. <br/>
At the end of the game the angels are created with an Abstract Factory class and their strategies are implemented with Strategy pattern.They will appear on the map and will action on the heroes with the help of the Visitor design pattern. The Great Wizard observes the action of the angels on the heroes and the status of the heroes after a fight. The Great Wizard is implemented using Observer pattern.  

## Build with
Java - for an object-oriented based implementation using design patterns
