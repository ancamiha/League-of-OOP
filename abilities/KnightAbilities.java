package abilities;

import heroes.Hero;
import map.TypeOfField;

public class KnightAbilities extends Abilities {

    @Override
    public final float getRaceModifierFirst(final Hero enemy) {
        final float rogueModifier = 1.15f;
        final float knightModifier = 1f;
        final float pyromancerModifier = 1.1f;
        final float wizardModifier = 0.8f;
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

    //execute
    @Override
    public final int firstAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 200;
        final int levelDamage = 30;
        final float limitHP = 0.2f;
        final float levelLimitHP = 0.01f;
        final float maxLimitHP = 0.4f;
        int damage = 0;
        if ((hero.getField()).equals(TypeOfField.Land)) {
            damage = Math.round(Math.round((baseDamage + hero.getLevel() * levelDamage)
                    * this.landAmplifKnight) * getRaceModifierFirst(enemy));
        } else {
            damage = Math.round(Math.round(baseDamage + hero.getLevel() * levelDamage)
                    * getRaceModifierFirst(enemy));
        }
        return damage;
    }

    //slam
    @Override
    public final int secondAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 100;
        final int levelDamage = 40;
        return 0;
    }

    @Override
    public final int getDamage(final Hero hero, final Hero enemy) {
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
