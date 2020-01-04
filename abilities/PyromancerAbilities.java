package abilities;

import heroes.Hero;
import map.TypeOfField;

public class PyromancerAbilities extends Abilities {

    @Override
    public final float getRaceModifierFirst(final Hero enemy, final float bonus) {
        final float rogueModifier = 0.8f;
        final float knightModifier = 1.2f;
        final float pyromancerModifier = 0.9f;
        final float wizardModifier = 1.05f;
        switch (enemy.getType()) {
            case Rogue:
                return rogueModifier + bonus;
            case Knight:
                return knightModifier + bonus;
            case Pyromancer:
                return pyromancerModifier + bonus;
            case Wizard:
                return wizardModifier + bonus;
            default:
                return 0;
        }
    }

    @Override
    public final float getRaceModifierSecond(final Hero enemy, final float bonus) {
        final float rogueModifier = 0.8f;
        final float knightModifier = 1.2f;
        final float pyromancerModifier = 0.9f;
        final float wizardModifier = 1.05f;
        switch (enemy.getType()) {
            case Rogue:
                return rogueModifier + bonus;
            case Knight:
                return knightModifier + bonus;
            case Pyromancer:
                return pyromancerModifier + bonus;
            case Wizard:
                return wizardModifier + bonus;
            default:
                return 0;
        }
    }

    //fireblast
    @Override
    public final float firstAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 350;
        final int levelDamage = 50;
        int damage;
        if ((hero.getField()).equals(TypeOfField.Volcanic)) {
            damage = Math.round((baseDamage + hero.getLevel() * levelDamage)
                    * landAmplifPyromancer);
        } else {
            damage = Math.round(baseDamage + hero.getLevel() * levelDamage);
        }
        return damage;
    }

    //ignite
    @Override
    public final float secondAbility(final Hero hero, final Hero enemy) {
        final int thisRoundBaseDamage = 150;
        final int thisRoundLevelDamage = 20;
        final int baseDamage = 50;
        final int levelDamage = 30;
        final int time = 2;
        int damage;
        if ((hero.getField()).equals(TypeOfField.Volcanic)) {
            damage = Math.round((thisRoundBaseDamage + hero.getLevel()
                               * thisRoundLevelDamage) * landAmplifPyromancer);
            int afterDamage;
            afterDamage = Math.round((baseDamage + hero.getLevel() * levelDamage)
                                    * landAmplifPyromancer);
            enemy.overTimeAbilities(time, Math.round(afterDamage
                                   * getRaceModifierSecond(enemy, hero.getBonus())), true, 0);
        } else {
            damage = Math.round(thisRoundBaseDamage + hero.getLevel() * thisRoundLevelDamage);
            int afterDamage;
            afterDamage = Math.round(baseDamage + hero.getLevel() * levelDamage);
            enemy.overTimeAbilities(time, Math.round(afterDamage
                    * getRaceModifierSecond(enemy, hero.getBonus())), true, 0);
        }
        return damage;
    }

    @Override
    public final int getDamage(final Hero hero, final Hero enemy) {
        return Math.round(firstAbility(hero, enemy) * getRaceModifierFirst(enemy, hero.getBonus()))
                + Math.round(secondAbility(hero, enemy)
                * getRaceModifierSecond(enemy, hero.getBonus()));
    }

    @Override
    public final float getDamageWithoutM(final Hero hero, final Hero enemy) {
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
