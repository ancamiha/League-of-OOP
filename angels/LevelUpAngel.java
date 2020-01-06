package angels;

import heroes.Hero;

public class LevelUpAngel extends Angels {
    public LevelUpAngel(final int actionRound, final AngelType type, final int posX,
                        final int posY) {
        super(actionRound, type, posX, posY);
    }

    /**
     * Implement Visitor pattern angels-hero.
     */
    @Override
    public void actionOn(final Hero hero) {
        final int limit = 250;
        final int fifty = 50;
        final int xpLevelUp = limit + hero.getLevel() * fifty;
        final int xp = hero.getXp();
        hero.setOldLvl(hero.getLevel());
        switch (hero.getType()) {
            case Knight:
                final int xpK = xpLevelUp - xp;
                hero.setXp(xp + xpK);
                hero.levelUp();
                final float bonusK = 0.10f;
                hero.setBonus(bonusK);
                break;
            case Pyromancer:
                final int xpP = xpLevelUp - xp;
                hero.setXp(xp + xpP);
                hero.levelUp();
                final float bonusP = 0.20f;
                hero.setBonus(bonusP);
                break;
            case Rogue:
                final int xpR = xpLevelUp - xp;
                hero.setXp(xp + xpR);
                hero.levelUp();
                final float bonusR = 0.15f;
                hero.setBonus(bonusR);
                break;
            case Wizard:
                final int xpW = xpLevelUp - xp;
                hero.setXp(xp + xpW);
                hero.levelUp();
                final float bonusW = 0.25f;
                hero.setBonus(bonusW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
