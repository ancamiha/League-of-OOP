package angels;

import heroes.Hero;

public class SmallAngel extends Angels {
    public SmallAngel(final int actionRound, final AngelType type, final int posX, final int posY) {
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
                final float bonusK = 0.10f;
                hero.setBonus(bonusK);
                final int hpK = 10;
                hero.setHp(hp + hpK);
                break;
            case Pyromancer:
                final float bonusP = 0.15f;
                hero.setBonus(bonusP);
                final int hpP = 15;
                hero.setHp(hp + hpP);
                break;
            case Rogue:
                final float bonusR = 0.05f;
                hero.setBonus(bonusR);
                final int hpR = 20;
                hero.setHp(hp + hpR);
                break;
            case Wizard:
                final float bonusW = 0.10f;
                hero.setBonus(bonusW);
                final int hpW = 25;
                hero.setHp(hp + hpW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
