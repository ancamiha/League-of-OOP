package wizard;

import angels.AngelType;
import angels.Angels;
import heroes.Hero;

public class ObserveAngelAction extends TheGreatWizard {

    public ObserveAngelAction(final WizardSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public final void update(final Angels angel, final Hero hero1, final Hero hero2) {
        if (angel != null) {
            if (!hero1.isDead()) {
                if ((angel.getType()).equals(AngelType.DarkAngel)
                        || (angel.getType()).equals(AngelType.Dracula)) {
                    System.out.println(angel.getType() + " hit " + hero1.getType() + " "
                            + hero1.getId());
                } else {
                    System.out.println(angel.getType() + " helped " + hero1.getType() + " "
                            + hero1.getId());
                }
            }
            if (hero1.isDead()) {
                if (angel.getType().equals(AngelType.Spawner)) {
                    System.out.println(angel.getType() + " helped " + hero1.getType() + " "
                            + hero1.getId());
                }
                if (angel.getType().equals(AngelType.TheDoomer) && !hero1.isWasHit()
                        && hero1.isKilledByAngel()) {
                    System.out.println(angel.getType() + " hit " + hero1.getType() + " "
                            + hero1.getId());
                    hero1.setWasHit(true);
                }
            }
        }
    }
}
