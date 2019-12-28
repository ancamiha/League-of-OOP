package heroes;

import java.util.List;

/**
 * Clasa ce implementeaza design pattern-ul Factory pentru crearea eroilor.
 */
public final class HeroesFactory {
    private static HeroesFactory instance;
    private HeroesFactory() {

    }
    public static HeroesFactory getInstance() {
        if (instance == null) {
            instance = new HeroesFactory();
        }
        return instance;
    }

    public void createHeroes(final List<Hero> heroes, final String hero, final int xPos,
                             final int yPos) {
        switch (hero) {
            case "P":
                heroes.add(new Pyromancer(HeroType.Pyromancer, xPos, yPos));
                break;
            case "K":
                heroes.add(new Knight(HeroType.Knight, xPos, yPos));
                break;
            case "W":
                heroes.add(new Wizard(HeroType.Wizard, xPos, yPos));
                break;
            case "R":
                heroes.add(new Rogue(HeroType.Rogue, xPos, yPos));
                break;
            default:
                System.out.println("invalid type of player");
        }
    }
}
