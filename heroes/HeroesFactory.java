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

    /**
     * Metoda ce creeaza eroii.
     * @param id id-ul fiecarui erou
     * @param heroes lista de eroi
     * @param hero tipul eroului ce trebuie creat
     * @param xPos coordonata x de pe harta
     * @param yPos coordonata y de pe harta
     */
    public void createHeroes(final int id, final List<Hero> heroes, final String hero,
                             final int xPos, final int yPos) {
        switch (hero) {
            case "P":
                heroes.add(new Pyromancer(id, HeroType.Pyromancer, xPos, yPos));
                break;
            case "K":
                heroes.add(new Knight(id, HeroType.Knight, xPos, yPos));
                break;
            case "W":
                heroes.add(new Wizard(id, HeroType.Wizard, xPos, yPos));
                break;
            case "R":
                heroes.add(new Rogue(id, HeroType.Rogue, xPos, yPos));
                break;
            default:
                System.out.println("invalid type of player");
        }
    }
}
