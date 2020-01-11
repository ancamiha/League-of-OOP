package abilities;

import heroes.Hero;
import map.TypeOfField;

public class RogueAbilities extends Abilities {
    @Override
    public final float getRaceModifierFirst(final Hero enemy, final float bonus) {
        final float rogueModifier = 1.2f;
        final float knightModifier = 0.9f;
        final float pyromancerModifier = 1.25f;
        final float wizardModifier = 1.25f;
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
        final float rogueModifier = 0.9f;
        final float knightModifier = 0.8f;
        final float pyromancerModifier = 1.2f;
        final float wizardModifier = 1.25f;
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

    //backstab
    @Override
    public final float firstAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 200;
        final int levelDamage = 20;
        final float criticalHit = 1.5f;
        final int overtimeRoundsWoods = 3;
        float damage;
        if ((hero.getField()).equals(TypeOfField.Woods)) {
            if (hero.getCounterR() == overtimeRoundsWoods || hero.getCounterR() == 0) {
                damage = (baseDamage + hero.getLevel() * levelDamage)
                        * landAmplifRogue * criticalHit;
            } else {
                damage = (baseDamage + hero.getLevel() * levelDamage) * landAmplifRogue;
            }
        } else {
            damage = baseDamage + hero.getLevel() * levelDamage;
        }
        hero.updateCounterR();
        return damage;
    }

    //paralysis
    @Override
    public final float secondAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 40;
        final int levelDamage = 10;
        final int time = 3;
        final int timeOnWoods = 6;
        int damage;
        if ((hero.getField()).equals(TypeOfField.Woods)) {
            damage = Math.round((baseDamage + hero.getLevel() * levelDamage) * landAmplifRogue);
            enemy.overTimeAbilities(timeOnWoods, Math.round(damage
                                   * getRaceModifierSecond(enemy, hero.getBonus())),
                                    true, timeOnWoods);
        } else {
            damage = Math.round(baseDamage + hero.getLevel() * levelDamage);
            enemy.overTimeAbilities(time, Math.round(damage
                                   * getRaceModifierSecond(enemy, hero.getBonus())), true, time);
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
        hero.decreaseCounterR();
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
