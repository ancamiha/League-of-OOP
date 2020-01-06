package wizard;

import angels.Angels;
import heroes.Hero;

public abstract class TheGreatWizard {
    protected WizardSubject subject;

    /**
     * Aceasta metoda este apelatata de fiecare data cand starea unui obiect este schimbata.
     */
    public abstract void update(Angels angel, Hero hero1, Hero hero2);
}
