package angels;

import heroes.Hero;

public class XPAngel extends Angels {
    public XPAngel(final int actionRound, final AngelType type, final int posX, final int posY) {
        super(actionRound, type, posX, posY);
    }

    /**
     * Implement Visitor pattern angels-hero.
     */
    @Override
    public void actionOn(final Hero hero) {
        final int xp = hero.getXp();
        switch (hero.getType()) {
            case Knight:
                final int xpK = 45;
                hero.setXp(xp + xpK);
                hero.levelUp();
                break;
            case Pyromancer:
                final int xpP = 50;
                hero.setXp(xp + xpP);
                hero.levelUp();
                break;
            case Rogue:
                final int xpR = 40;
                hero.setXp(xp + xpR);
                hero.levelUp();
                break;
            case Wizard:
                final int xpW = 60;
                hero.setXp(xp + xpW);
                hero.levelUp();
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
