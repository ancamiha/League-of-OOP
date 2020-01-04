package heroes;

import abilities.Abilities;
import abilities.RogueAbilities;
import angels.Angels;

public class Rogue extends Hero {
    public Rogue(final int id, final HeroType type, final int posX, final int posY) {
        super(id, type, posX, posY);
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
        hero.interactWith(this);
    }

    @Override
    public final void interactWith(final Hero enemy) {
        Abilities abilities = new RogueAbilities();
        int damage = abilities.getDamage(this, enemy);
        if ((enemy.getType()).equals(HeroType.Wizard)) {
            ((Wizard) enemy).setDamageReceived(abilities.getDamageWithoutM(this, enemy));
        }
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
