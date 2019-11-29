package abilities;

import heroes.Hero;

public abstract class Abilities {
    protected final float landAmplifPyromancer = 1.25f;
    protected final float landAmplifKnight = 1.15f;
    protected final float landAmplifWizard = 1.1f;
    protected final float landAmplifRogue = 1.15f;

    public abstract float getRaceModifierFirst(Hero enemy);
    public abstract float getRaceModifierSecond(Hero enemy);
    public abstract int firstAbility(Hero hero, Hero enemy);
    public abstract int secondAbility(Hero hero, Hero enemy);
    public abstract int getDamage(Hero hero, Hero enemy);
}
