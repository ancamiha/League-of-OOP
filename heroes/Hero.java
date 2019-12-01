package heroes;

import map.TypeOfField;

import static java.lang.Integer.max;

public abstract class Hero {
    private final HeroType type;
    private int posX;
    private int posY;
    private int level;
    private int xp;
    private int hp;
    private TypeOfField field;
    private int counterR;

    private int time;
    private int damage;
    private boolean stillApply;
    private int dontMove;

    public Hero(final HeroType type, final int posX, final int posY) {
        this.type = type;
        this.posX = posX;
        this.posY = posY;

        this.level = 0;
        this.xp = 0;
        this.hp = this.getValueOfHp();
        this.field = TypeOfField.Land;
        this.counterR = 0;
    }

    /**
     * Calculeaza Hp-ul maxim a eroului in functie de baseDamage si levelDamage.
     * @return valoarea maxima a hp-ului
     */
    public abstract int getValueOfHp();
    public final int getXp() {
        return xp;
    }
    public final int getHp() {
        return hp;
    }
    public final HeroType getType() {
        return type;
    }
    public final int getLevel() {
        return level;
    }
    public final int getPosX() {
        return posX;
    }
    public final int getPosY() {
        return posY;
    }
    public final TypeOfField getField() {
        return field;
    }
    public final int getCounterR() {
        return counterR;
    }
    public final void setField(final TypeOfField currentField) {
        this.field = currentField;
    }

    public final void updatePosX(final int newX) {
        this.posX += newX;
    }
    public final void updatePosY(final int newY) {
        this.posY += newY;
    }
    public final void updateHp(final int damageHp) {
        this.hp -= damageHp;
    }
    public final void updateCounterR() {
        this.counterR++;
    }
    public final boolean isNotDead() {
        return this.hp > 0;
    }
    public final void decreaseCounterR() {
        this.counterR--;
    }

    /**
     * Dupa ce are loc o lupta personajul ce a invins(a ucis celalalt personaj) va
     * creste in xp.
     * @param loser primeste ca paramentru personajul pierzator
     */
    public final void increaseXP(final Hero loser) {
        final int xpCalc = 200;
        final int forty = 40;
        this.xp = this.xp + max(0, xpCalc - (this.getLevel() - loser.getLevel()) * forty);
        this.levelUp();
    }

    /**
     * Creste in nivel personajul daca a depasit limita superiara a nivelului.
     */
    private void levelUp() {
        final int limit = 250;
        final int fifty = 50;
        int xpLevelUp = limit + this.getLevel() * fifty;
        while (this.getXp() >= xpLevelUp) {
            this.level++;
            this.hp = this.getValueOfHp();
            xpLevelUp = limit + this.getLevel() * fifty;
        }
    }

    /**
     * Realizeaza deplasarea personajului pe harta.
     * @param letter primeste o litera ce corespunde miscarii
     */
    public final void moveHero(final char letter) {
        if (this.getDontMove() == 0) {
            switch (letter) {
                case 'U':
                    this.updatePosX(-1);
                    break;
                case 'D':
                    this.updatePosX(1);
                    break;
                case 'L':
                    this.updatePosY(-1);
                    break;
                case 'R':
                    this.updatePosY(1);
                    break;
                default:
                    this.updatePosX(0);
                    this.updatePosY(0);
            }
        } else {
            if (this.getDontMove() == 1) {
                this.updateDontMove();
            }
        }
    }

    @Override
    public final String toString() {
        return "Hero{" + "type=" + type + ", posX=" + posX + ", posY=" + posY + ", level="
                + level + ", xp=" + xp + ", hp=" + hp + ", field=" + field + '}';
    }
    public final void overTimeAbilities(final int rounds, final int overtimeDamage,
                                        final boolean apply, final int stay) {
        this.time = rounds;
        this.damage = overtimeDamage;
        this.stillApply = apply;
        this.dontMove = stay;
    }

    public final int getTime() {
        return time;
    }
    public final int getDamage() {
        return damage;
    }
    public final boolean getStillApply() {
        return stillApply;
    }
    public final int getDontMove() {
        return dontMove;
    }
    public final void updateStillApply() {
        this.stillApply = false;
    }
    public final void updateTime() {
        this.time--;
    }
    public final void updateDontMove() {
        this.dontMove--;
    }
    /**
     * Implement Visitor pattern.
     */
    public abstract void accept(Hero hero);
    public abstract void interactWith(Hero enemy);
}
