package heroes;

import abilities.Abilities;
import abilities.PyromancerAbilities;
import angels.Angels;

public class Pyromancer extends Hero {
    public Pyromancer(final int id, final HeroType type, final int posX, final int posY) {
        super(id, type, posX, posY);
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
        hero.interactWith(this);
    }

    @Override
    public final void interactWith(final Hero enemy) {
        Abilities abilities = new PyromancerAbilities();
        if ((enemy.getType()).equals(HeroType.Wizard)) {
            ((Wizard) enemy).setDamageReceived(abilities.getDamageWithoutM(this, enemy));
        }
        int damage = abilities.getDamage(this, enemy);
        enemy.updateHp(damage);
    }

    /**
     * Implement Visitor pattern angels-heroes.
     */
    @Override
    public void acceptAngel(final Angels angel) {
        angel.actionOn(this);
    }
}
