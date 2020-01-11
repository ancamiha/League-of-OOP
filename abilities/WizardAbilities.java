package abilities;

import heroes.Hero;
import heroes.HeroType;
import heroes.Wizard;
import map.TypeOfField;

public class WizardAbilities extends Abilities {

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
        final float rogueModifier = 1.2f;
        final float knightModifier = 1.4f;
        final float pyromancerModifier = 1.3f;
        final float wizardModifier = 0f;
        switch (enemy.getType()) {
            case Rogue:
                return rogueModifier + bonus;
            case Knight:
                return knightModifier + bonus;
            case Pyromancer:
                return pyromancerModifier + bonus;
            case Wizard:
                return wizardModifier;
            default:
                return 0;
        }
    }

    //drain
    @Override
    public final float firstAbility(final Hero hero, final Hero enemy) {
        final float baseDamage = 0.2f;
        final float levelDamage = 0.05f;
        final float minHP = 0.3f;
        float damage;
        float proc = baseDamage + enemy.getLevel() * levelDamage;
        float result = Float.min(minHP * enemy.getValueOfHp(), enemy.getHp());
        if ((hero.getField()).equals(TypeOfField.Desert)) {
            result *= proc * landAmplifWizard;
            damage = result;
        } else {
            result *= proc;
            damage = result;
        }
        return damage;
    }

    //deflect
    @Override
    public final float secondAbility(final Hero hero, final Hero enemy) {
        final float baseDamage = 0.35f;
        final float levelDamage = 0.02f;
        final float maxProc = 0.7f;
        float damageReceived = ((Wizard) hero).getDamageReceived();
        float damage;
        if ((enemy.getType()).equals(HeroType.Wizard)) {
            return 0;
        }
        float proc = baseDamage + hero.getLevel() * levelDamage;
        if (proc > maxProc) {
            proc = maxProc;
        }
        if ((hero.getField()).equals(TypeOfField.Desert)) {
            damage = proc * damageReceived * landAmplifWizard;
        } else {
            damage = proc * damageReceived;
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
