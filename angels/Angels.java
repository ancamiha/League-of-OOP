package angels;

import heroes.Hero;

public abstract class Angels {
    private final int actionRound;
    private final AngelType type;
    private final int posX;
    private final int posY;
    private boolean hasAppeared;

    public Angels(final int actionRound, final AngelType type, final int posX, final int posY) {
        this.actionRound = actionRound;
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.hasAppeared = false;
    }

    public final int getActionRound() {
        return actionRound;
    }
    public final AngelType getType() {
        return type;
    }
    public final int getPosX() {
        return posX;
    }
    public final int getPosY() {
        return posY;
    }
    public final boolean isHasAppeared() {
        return hasAppeared;
    }
    public final void setHasAppeared(final boolean hasAppeared) {
        this.hasAppeared = hasAppeared;
    }

    @Override
    public final String toString() {
        return "Angels{" + "actionRound=" + actionRound + ", type=" + type + ", posX="
                       + posX + ", posY=" + posY + '}';
    }

    /**
     * Implementare design pattern-ul Visitor pentru eroi-ingeri.
     */
    public abstract void actionOn(Hero hero);
}
