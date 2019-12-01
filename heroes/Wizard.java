package heroes;

import abilities.Abilities;
import abilities.WizardAbilities;

public class Wizard extends Hero {
    private float damageReceived;
    public Wizard(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
        damageReceived = 0;
    }

    @Override
    public final int getValueOfHp() {
        final int initHP = 400;
        final int levelHp = 30;
        return initHP + levelHp * this.getLevel();
    }

    public final void setDamageReceived(final float damage) {
        this.damageReceived = damage;
    }
    public final float getDamageReceived() {
        return damageReceived;
    }
    public final void updateDamageReceived(final float damage) {
        this.damageReceived += damage;
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
        Abilities abilities = new WizardAbilities();
        if ((enemy.getType()).equals(HeroType.Wizard)) {
            ((Wizard) enemy).setDamageReceived(abilities.getDamageWithoutM(this, enemy));
        }
        int damage = abilities.getDamage(this, enemy);
        enemy.updateHp(damage);
    }
}
