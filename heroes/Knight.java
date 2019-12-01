package heroes;

import abilities.Abilities;
import abilities.KnightAbilities;

public class Knight extends Hero {
    public Knight(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }

    @Override
    public final int getValueOfHp() {
        final int initHP = 900;
        final int levelHp = 80;
        return initHP + levelHp * this.getLevel();
    }

    /**
     * Implement Visitor pattern.
     */
    @Override
    public final void accept(final Hero hero) {
        hero.interactWith(this);
    }

    @Override
    public final void interactWith(final Hero enemy) {
        Abilities abilities = new KnightAbilities();
        if ((enemy.getType()).equals(HeroType.Wizard)) {
            ((Wizard) enemy).setDamageReceived(abilities.getDamageWithoutM(this, enemy));
        }
        int damage = abilities.getDamage(this, enemy);
        enemy.updateHp(damage);
    }
}
