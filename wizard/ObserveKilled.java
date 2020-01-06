package wizard;

import angels.Angels;
import heroes.Hero;

public class ObserveKilled extends TheGreatWizard {
    public ObserveKilled(final WizardSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public final void update(final Angels angel, final Hero hero1, final Hero hero2) {
        if (angel != null && hero1.isDead() && hero1.isKilledByAngel() && !hero1.isHasAppeared()) {
            System.out.println("Player " + hero1.getType() + " " + hero1.getId()
                    + " was killed by an angel");
            hero1.setHasAppeared(true);
        }
        if (hero2 != null && hero1.getId() != hero2.getId()) {
            if (hero2.isDead() && !hero2.isKilledByAngel() && !hero2.isHasAppeared()) {
                System.out.println("Player " + hero2.getType() + " " + hero2.getId()
                        + " was killed by " + hero1.getType() + " " + hero1.getId());
                hero2.setHasAppeared(true);
            }
            if (hero1.isDead() && !hero1.isKilledByAngel() && !hero1.isHasAppeared()) {
                System.out.println("Player " + hero1.getType() + " " + hero1.getId()
                        + " was killed by " + hero2.getType() + " " + hero2.getId());
                hero1.setHasAppeared(true);
            }
        }
    }
}
