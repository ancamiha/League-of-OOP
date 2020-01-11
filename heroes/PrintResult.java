package heroes;

import java.util.List;

/**
 * Singleton class.
 */
public final class PrintResult {
    private static PrintResult instance;
    private PrintResult() {

    }
    public static PrintResult getInstance() {
        if (instance == null) {
            instance = new PrintResult();
        }
        return instance;
    }

    public static void printR(final List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (!hero.isNotDead() || hero.isDead()) {
                char c = hero.getType().toString().charAt(0);
                System.out.println(c + " dead");
            }
            if (hero.isNotDead() && !hero.isDead()) {
                char c = hero.getType().toString().charAt(0);
                System.out.println(c + " " + hero.getLevel() + " " + hero.getXp()
                        + " " + hero.getHp() + " " + hero.getPosX() + " " + hero.getPosY());
            }
        }
    }
}
