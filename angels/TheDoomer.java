package angels;

import heroes.Hero;

public class TheDoomer extends Angels {
    public TheDoomer(final int actionRound, final AngelType type, final int posX, final int posY) {
        super(actionRound, type, posX, posY);
    }

    /**
     * Implement Visitor pattern angels-hero.
     */
    @Override
    public void actionOn(final Hero hero) {
        if (!hero.isDead()) {
            hero.setDead(true);
            hero.setKilledByAngel(true);
        }
    }
}
