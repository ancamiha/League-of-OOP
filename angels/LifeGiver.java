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
        int hp = hero.getHp();
        switch (hero.getType()) {
            case Knight:
                final int hpK = 100;
                hp = hp + hpK;
                if (hp > hero.getValueOfHp()) {
                    hp = hero.getValueOfHp();
                }
                hero.setHp(hp);
                break;
            case Pyromancer:
                final int hpP = 80;
                hp = hp + hpP;
                if (hp > hero.getValueOfHp()) {
                    hp = hero.getValueOfHp();
                }
                hero.setHp(hp);
                break;
            case Rogue:
                final int hpR = 90;
                hp = hp + hpR;
                if (hp > hero.getValueOfHp()) {
                    hp = hero.getValueOfHp();
                }
                hero.setHp(hp);
                break;
            case Wizard:
                final int hpW = 120;
                hp = hp + hpW;
                if (hp > hero.getValueOfHp()) {
                    hp = hero.getValueOfHp();
                }
                hero.setHp(hp);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
