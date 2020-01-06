package wizard;

import angels.Angels;
import heroes.Hero;

public class ObserveLevelChange extends TheGreatWizard {
    public ObserveLevelChange(final WizardSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public final void update(final Angels angel, final Hero hero1, final Hero hero2) {
        if (hero1.getLevel() != 0 && hero1.isReachedLv()) {
            System.out.println(hero1.getType() + " " + hero1.getId() + " reached level "
                    + hero1.getLevel());
            hero1.setReachedLv(false);
        }
    }
}
