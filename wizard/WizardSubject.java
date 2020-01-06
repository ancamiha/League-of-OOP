package wizard;

import angels.Angels;
import heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public class WizardSubject {
    private List<TheGreatWizard> observers = new ArrayList<TheGreatWizard>();
    private Angels angel;
    private Hero hero1;
    private Hero hero2;

    public final void setAngel(final Angels angel) {
        this.angel = angel;
    }
    public final void setHero1(final Hero hero1) {
        this.hero1 = hero1;
    }
    public final void setHero2(final Hero hero2) {
        this.hero2 = hero2;
    }

    public final void attach(final TheGreatWizard observer) {
        observers.add(observer);
    }

    public final void notifyAllObservers() {
        for (TheGreatWizard observer : observers) {
            observer.update(angel, hero1, hero2);
        }
    }
}
