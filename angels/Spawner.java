package angels;

import heroes.Hero;

public class Spawner extends Angels {
    public Spawner(final int actionRound, final AngelType type, final int posX, final int posY) {
        super(actionRound, type, posX, posY);
    }

    /**
     * Implement Visitor pattern angels-hero.
     */
    @Override
    public void actionOn(final Hero hero) {
        switch (hero.getType()) {
            case Knight:
                final int hpK = 200;
                hero.setDead(false);
                hero.setHp(hpK);
                break;
            case Pyromancer:
                final int hpP = 150;
                hero.setDead(false);
                hero.setHp(hpP);
                break;
            case Rogue:
                final int hpR = 180;
                hero.setDead(false);
                hero.setHp(hpR);
                break;
            case Wizard:
                final int hpW = 120;
                hero.setDead(false);
                hero.setHp(hpW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
