package abilities;

import heroes.Hero;
import map.TypeOfField;

public class RogueAbilities extends Abilities {
    @Override
    public final float getRaceModifierFirst(final Hero enemy) {
        final float rogueModifier = 1.20f;
        final float knightModifier = 0.9f;
        final float pyromancerModifier = 1.25f;
        final float wizardModifier = 1.25f;
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
        final float rogueModifier = 0.9f;
        final float knightModifier = 0.8f;
        final float pyromancerModifier = 1.2f;
        final float wizardModifier = 1.25f;
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

    //backstab
    @Override
    public final int firstAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 200;
        final int levelDamage = 20;
        final float bonusOnWoods = 1.5f;
        final int overtimeRoundsWoods = 3;
        int damage = 0;
        if ((hero.getField()).equals(TypeOfField.Woods)) {
            if (hero.nrOfRounds == overtimeRoundsWoods) {
                damage = Math.round(Math.round((baseDamage + hero.getLevel() * levelDamage)
                        * this.landAmplifRogue * bonusOnWoods) * getRaceModifierFirst(enemy));
            } else {
                damage = Math.round(Math.round((baseDamage + hero.getLevel() * levelDamage)
                        * this.landAmplifRogue) * getRaceModifierFirst(enemy));
            }
        } else {
            damage = Math.round(Math.round(baseDamage + hero.getLevel() * levelDamage)
                    * getRaceModifierFirst(enemy));
        }
        hero.nrOfRounds++;
        return damage;
    }

    //paralysis
    @Override
    public final int secondAbility(final Hero hero, final Hero enemy) {
        final int baseDamage = 40;
        final int levelDamage = 10;
        final int overtimeRounds = 3;
        final int overtimeRoundsWoods = 6;
        int damage = 0;
        if ((hero.getField()).equals(TypeOfField.Woods)) {
            damage = Math.round(Math.round((baseDamage + hero.getLevel() * levelDamage)
                    * this.landAmplifRogue) * getRaceModifierFirst(enemy));
            enemy.overTimeAbilities(overtimeRoundsWoods, damage, true);
        } else {
            damage = Math.round(Math.round(baseDamage + hero.getLevel() * levelDamage)
                    * getRaceModifierFirst(enemy));
            enemy.overTimeAbilities(overtimeRounds, damage, true);
        }
        return 0;
    }

    @Override
    public final int getDamage(final Hero hero, final Hero enemy) {
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
