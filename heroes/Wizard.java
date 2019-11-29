package heroes;

import abilities.Abilities;
import abilities.WizardAbilities;

public class Wizard extends Hero {
    //private final float landAmplif = 1.1f;
    public Wizard(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }

    @Override
    public final int getValueOfHp() {
        final int initHP = 400;
        final int levelHp = 30;
        return initHP + levelHp * this.getLevel();
    }

    /**
     * Implement Visitor pattern.
     */
    @Override
    public final void accept(final Hero hero) {
        this.interactWith(hero);
    }

    @Override
    public final void interactWith(final Hero enemy) {
        Abilities abilities = new WizardAbilities();
        int damage = abilities.firstAbility(this, enemy)
                + abilities.secondAbility(this, enemy);
        //System.out.println("damage = " + damage);
        enemy.updateHp(damage);
    }
}
