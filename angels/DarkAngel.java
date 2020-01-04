package angels;

import heroes.Hero;

public class DarkAngel extends Angels {
    public DarkAngel(final int actionRound, final AngelType type, final int posX, final int posY) {
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
                final int hpK = 40;
                hero.setHp(hp - hpK);
                break;
            case Pyromancer:
                final int hpP = 30;
                hero.setHp(hp - hpP);
                break;
            case Rogue:
                final int hpR = 10;
                hero.setHp(hp - hpR);
                break;
            case Wizard:
                final int hpW = 20;
                hero.setHp(hp - hpW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
