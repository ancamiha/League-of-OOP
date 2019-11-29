package heroes;

import abilities.Abilities;
import abilities.PyromancerAbilities;

public class Pyromancer extends Hero {
    //public final float landAmplif = 1.25f;
    public Pyromancer(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }

    @Override
    public final int getValueOfHp() {
        final int initHP = 500;
        final int levelHp = 50;
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
        Abilities abilities = new PyromancerAbilities();
        int damage = abilities.firstAbility(this, enemy)
                + abilities.secondAbility(this, enemy);
        //System.out.println("damage = " + damage);
        enemy.updateHp(damage);
    }
}
