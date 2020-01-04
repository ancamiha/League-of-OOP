package angels;


import heroes.Hero;

public class DamageAngel extends Angels {
    public DamageAngel(final int actionRound, final AngelType type, final int posX,
                       final int posY) {
        super(actionRound, type, posX, posY);
    }

    /**
     * Implement Visitor pattern angels-hero.
     */
    @Override
    public void actionOn(final Hero hero) {
        switch (hero.getType()) {
            case Knight:
                final float bonusK = 0.15f;
                hero.setBonus(bonusK);
                break;
            case Pyromancer:
                final float bonusP = 0.2f;
                hero.setBonus(bonusP);
                break;
            case Rogue:
                final float bonusR = 0.3f;
                hero.setBonus(bonusR);
                break;
            case Wizard:
                final float bonusW = 0.4f;
                hero.setBonus(bonusW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
