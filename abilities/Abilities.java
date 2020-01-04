package abilities;

import heroes.Hero;

public abstract class Abilities {
    protected final float landAmplifPyromancer = 1.25f;
    protected final float landAmplifKnight = 1.15f;
    protected final float landAmplifWizard = 1.1f;
    protected final float landAmplifRogue = 1.15f;

    /**
     * Determina modificatorul de rasa specific primei abilitati.
     * @param enemy victima
     * @return valoarea modificatorului de rasa
     */
    public abstract float getRaceModifierFirst(Hero enemy, float bonus);
    /**
     * Determina modificatorul de rasa specific celei de a doua abilitati.
     * @param enemy victima
     * @return valoarea modificatorului de rasa
     */
    public abstract float getRaceModifierSecond(Hero enemy, float bonus);
    /**
     * Contine implementarea primei abilitati.
     * @param hero eroul
     * @param enemy victima
     * @return valoarea damage-ului
     */
    public abstract float firstAbility(Hero hero, Hero enemy);
    /**
     * Contine implementarea celei de a doua abilitati.
     * @param hero eroul
     * @param enemy victima
     * @return valoarea damage-ului
     */
    public abstract float secondAbility(Hero hero, Hero enemy);
    /**
     * Calculeaza damage-ul total rezultat in urma aplicarii ambelor abilitati
     * cu tot cu race modifiers.
     * @param hero eroul
     * @param enemy victima
     * @return valoarea damage-ului total cu race modifiers
     */
    public abstract int getDamage(Hero hero, Hero enemy);
    /**
     * Calculeaza damage-ul total rezultat in urma aplicarii ambelor abilitati.
     * @param hero eroul
     * @param enemy victima
     * @return valoarea damage-ului total
     */
    public abstract float getDamageWithoutM(Hero hero, Hero enemy);
}
