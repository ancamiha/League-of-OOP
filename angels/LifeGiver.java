package angels;

import heroes.Hero;

public class LifeGiver extends Angels {
    public LifeGiver(final int actionRound, final AngelType type, final int posX, final int posY) {
        super(actionRound, type, posX, posY);
    }

    /**
     * Implement Visitor pattern angels-hero.
     */
    @Override
    public void actionOn(final Hero hero) {
        final int hp = hero.getHp();
        switch (hero.getType()) {
            case Knight:
                final int hpK = 100;
                hero.setHp(hp + hpK);
                break;
            case Pyromancer:
                final int hpP = 80;
                hero.setHp(hp + hpP);
                break;
            case Rogue:
                final int hpR = 90;
                hero.setHp(hp + hpR);
                break;
            case Wizard:
                final int hpW = 120;
                hero.setHp(hp + hpW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
