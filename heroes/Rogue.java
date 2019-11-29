package heroes;

import abilities.Abilities;
import abilities.RogueAbilities;

public class Rogue extends Hero {
    //private final float landAmplif = 1.15f;
    public Rogue(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }

    @Override
    public final int getValueOfHp() {
        final int initHP = 600;
        final int levelHp = 40;
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
        Abilities abilities = new RogueAbilities();
        int damage = abilities.getDamage(this, enemy);
        //System.out.println("damage = " + damage);
        enemy.updateHp(damage);
    }
}
