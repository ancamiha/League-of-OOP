package angels;

import heroes.Hero;

public class Dracula extends Angels {
    public Dracula(final int actionRound, final AngelType type, final int posX, final int posY) {
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
                final float bonusK = -0.2f;
                hero.setBonus(bonusK);
                final int hpK = 60;
                hero.setHp(hp - hpK);
                break;
            case Pyromancer:
                final float bonusP = -0.3f;
                hero.setBonus(bonusP);
                final int hpP = 40;
                hero.setHp(hp - hpP);
                break;
            case Rogue:
                final float bonusR = -0.1f;
                hero.setBonus(bonusR);
                final int hpR = 35;
                hero.setHp(hp - hpR);
                break;
            case Wizard:
                final float bonusW = -0.4f;
                hero.setBonus(bonusW);
                final int hpW = 20;
                hero.setHp(hp - hpW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
