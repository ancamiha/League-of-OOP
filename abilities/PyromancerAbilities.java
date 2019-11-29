package abilities;

import heroes.Hero;
import map.TypeOfField;

public class PyromancerAbilities extends Abilities {

    @Override
    public final float getRaceModifierFirst(final Hero enemy) {
        final float rogueModifier = 0.8f;
        final float knightModifier = 1.2f;
        final float pyromancerModifier = 0.9f;
        final float wizardModifier = 1.05f;
        switch (enemy.getType()) {
            case Rogue:
                return rogueModifier;
            case Knight:
                return knightModifier;
            case Pyromancer:
                return pyromancerModifier;
            case Wizard:
                return wizardModifier;
            default:
                return 0;
        }
    }

    @Override
    public final float getRaceModifierSecond(final Hero enemy) {
        final float rogueModifier = 0.8f;
        final float knightModifier = 1.2f;
        final float pyromancerModifier = 0.9f;
        final float wizardModifier = 1.05f;
        switch (enemy.getType()) {
            case Rogue:
                return rogueModifier;
            case Knight:
                return knightModifier;
            case Pyromancer:
                return pyromancerModifier;
            case Wizard:
                return wizardModifier;
            default:
                return 0;
        }
    }

    //fireblast
    @Override
    public final int firstAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 300;
        final int levelDamage = 50;
        int damage = 0;
        if ((hero.getField()).equals(TypeOfField.Volcanic)) {
            damage = Math.round(Math.round((baseDamage + hero.getLevel() * levelDamage)
                    * this.landAmplifPyromancer) * getRaceModifierFirst(enemy));
        } else {
            damage = Math.round(Math.round(baseDamage + hero.getLevel() * levelDamage)
                    * getRaceModifierFirst(enemy));
        }
        return damage;
    }

    //ignite
    @Override
    public final int secondAbility(final Hero hero, final Hero enemy) {
        final int thisRoundBaseDamage = 150;
        final int thisRoundLevelDamage = 20;
        final int baseDamage = 50;
        final int levelDamage = 30;
        return 0;
    }

    @Override
    public final int getDamage(final Hero hero, final Hero enemy) {
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
