package wizard;

import angels.Angels;
import heroes.Hero;

public class ObserveAppearance extends TheGreatWizard {
    public ObserveAppearance(final WizardSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public final void update(final Angels angel, final Hero hero1, final Hero hero2) {
        if (angel != null && !angel.isHasAppeared()) {
            System.out.println("Angel " + angel.getType() + " was spawned at " + angel.getPosX()
                    + " " + angel.getPosY());
            angel.setHasAppeared(true);
        }
    }
}
