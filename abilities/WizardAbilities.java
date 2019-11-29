package abilities;

import heroes.Hero;
import heroes.HeroType;
import map.TypeOfField;

public class WizardAbilities extends Abilities {

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
        final float rogueModifier = 1.2f;
        final float knightModifier = 1.4f;
        final float pyromancerModifier = 1.3f;
        final float wizardModifier = 0f;
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

    //drain
    @Override
    public final int firstAbility(final Hero hero, final Hero enemy) {
        final float baseDamage = 0.2f;
        final float levelDamage = 0.05f;
        final float minHP = 0.3f;
        int damage = 0;
        if ((hero.getField()).equals(TypeOfField.Desert)) {
            float percent = baseDamage + enemy.getLevel() * levelDamage;
            float result = Float.min(minHP * enemy.getValueOfHp(), enemy.getHp());
            result *= getRaceModifierFirst(enemy) * percent * landAmplifWizard;
            damage = Math.round(result);
        } else {
            float percent = baseDamage + enemy.getLevel() * levelDamage;
            float result = Float.min(minHP * enemy.getValueOfHp(), enemy.getHp());
            result *= getRaceModifierSecond(enemy) * percent;
            damage = Math.round(result);
        }
        return damage;
    }

    //deflect
    @Override
    public final int secondAbility(final Hero hero, final Hero enemy) {
        final float baseDamage = 0.35f;
        final float levelDamage = 0.02f;
        final float maxHP = 0.7f;
        if ((enemy.getType()).equals(HeroType.Wizard)) {
            return 0;
        }
        return 0;
    }

    @Override
    public final int getDamage(final Hero hero, final Hero enemy) {
        return firstAbility(hero, enemy) + secondAbility(hero, enemy);
    }
}
