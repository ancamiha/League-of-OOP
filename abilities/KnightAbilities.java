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
    public final float firstAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 200;
        final int levelDamage = 30;
        final float proc = 0.2f;
        final float levelLimitHP = 0.01f;
        final float maxLimitHP = 0.4f;
        int damage;
        float hpLimit = proc * enemy.getValueOfHp() + levelLimitHP * enemy.getLevel();
        if (hpLimit > maxLimitHP) {
            hpLimit = maxLimitHP;
        }
        if (enemy.getHp() <= hpLimit) {
            return enemy.getHp();
        }
        if ((hero.getField()).equals(TypeOfField.Land)) {
            damage = Math.round((baseDamage + hero.getLevel() * levelDamage) * landAmplifKnight);
        } else {
            damage = Math.round(baseDamage + hero.getLevel() * levelDamage);
        }
        return damage;
    }

    //slam
    @Override
    public final float secondAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 100;
        final int levelDamage = 40;
        int damage;
        if ((hero.getField()).equals(TypeOfField.Land)) {
            damage = Math.round((baseDamage + hero.getLevel() * levelDamage) * landAmplifKnight);
            enemy.overTimeAbilities(0, 0, false, 1);
        } else {
            damage = Math.round(baseDamage + hero.getLevel() * levelDamage);
            enemy.overTimeAbilities(0, 0, false, 1);
        }
        return damage;
    }

    @Override
    public final int getDamage(final Hero hero, final Hero enemy) {
        return Math.round(firstAbility(hero, enemy) * getRaceModifierFirst(enemy))
                + Math.round(secondAbility(hero, enemy) * getRaceModifierSecond(enemy));
    }

    @Override
    public final float getDamageWithoutM(final Hero hero, final Hero enemy) {
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
