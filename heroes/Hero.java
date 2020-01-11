package heroes;

import angels.Angels;
import map.TypeOfField;
import static java.lang.Integer.max;

public abstract class Hero {
    private int id;
    private final HeroType type;
    private int posX;
    private int posY;
    private int level;
    private int xp;
    private int hp;
    private TypeOfField field;
    private int counterR;
    private boolean isDead;

    private int time;
    private int damage;
    private boolean stillApply;
    private int dontMove;

    //pentru Observer
    private boolean hasAppeared;
    private boolean wasHit;
    private boolean wasHK;
    private boolean reachedLv;
    private float bonus;
    private boolean killedByAngel;
    private int oldLvl;
    private boolean saved;
    private boolean helped;

    public Hero(final int id, final HeroType type, final int posX, final int posY) {
        this.id = id;
        this.type = type;
        this.posX = posX;
        this.posY = posY;

        this.level = 0;
        this.xp = 0;
        this.hp = this.getValueOfHp();
        this.field = TypeOfField.Land;
        this.counterR = 0;
        this.bonus = 0;
        this.isDead = false;

        this.killedByAngel = false;
        this.hasAppeared = false;
        this.wasHit = false;
        this.wasHK = false;
        this.reachedLv = false;
        this.oldLvl = 0;
        this.saved = false;
        this.helped = false;
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
    public final int getId() {
        return id;
    }
    public final float getBonus() {
        return bonus;
    }
    public final boolean isDead() {
        return isDead;
    }
    public final boolean isKilledByAngel() {
        return killedByAngel;
    }
    public final boolean isHasAppeared() {
        return hasAppeared;
    }
    public final boolean isWasHit() {
        return wasHit;
    }
    public final boolean isWasHK() {
        return wasHK;
    }
    public final boolean isReachedLv() {
        return reachedLv;
    }
    public final int getOldLvl() {
        return oldLvl;
    }
    public final boolean isSaved() {
        return saved;
    }
    public final boolean isHelped() {
        return helped;
    }

    public final void setField(final TypeOfField currentField) {
        this.field = currentField;
    }
    public final void setHp(final int hp) {
        this.hp = hp;
    }
    public final void setBonus(final float bonus) {
        this.bonus = bonus;
    }
    public final void setDead(final boolean dead) {
        isDead = dead;
    }
    public final void setXp(final int xp) {
        this.xp = xp;
    }
    public final void setKilledByAngel(final boolean killedByAngel) {
        this.killedByAngel = killedByAngel;
    }
    public final void setHasAppeared(final boolean hasAppeared) {
        this.hasAppeared = hasAppeared;
    }
    public final void setWasHK(final boolean wasHK) {
        this.wasHK = wasHK;
    }
    public final void setWasHit(final boolean wasHit) {
        this.wasHit = wasHit;
    }
    public final void setReachedLv(final boolean reachedLv) {
        this.reachedLv = reachedLv;
    }
    public final void setOldLvl(final int oldLvl) {
        this.oldLvl = oldLvl;
    }
    public final void setSaved(final boolean saved) {
        this.saved = saved;
    }
    public final void setHelped(final boolean helped) {
        this.helped = helped;
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
    public void levelUp() {
        this.setOldLvl(this.getLevel());
        final int limit = 250;
        final int fifty = 50;
        int xpLevelUp = limit + this.getLevel() * fifty;
        while (this.getXp() >= xpLevelUp) {
            this.level++;
            this.hp = this.getValueOfHp();
            xpLevelUp = limit + this.getLevel() * fifty;
        }
        //se verifica daca eroul a crescut in level pentru Observer
        if (this.getOldLvl() == this.getLevel()) {
            this.setReachedLv(false);
        } else {
            this.setReachedLv(true);
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
            this.updateDontMove();
        }
    }

    @Override
    public final String toString() {
        return "Hero{" + "id=" + id + ", type=" + type + ", posX=" + posX + ", posY=" + posY
                + ", level=" + level + ", xp=" + xp + ", hp=" + hp + ", field=" + field + '}';
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
     * Alegerea strategiei.
     */
    public final void chooseStrategy() {
        final float two = 2f;
        final float three = 3f;
        final float four = 4f;
        switch (this.getType()) {
            case Knight:
                if (((1f / three) * this.getValueOfHp()) < this.getHp()
                    && this.getHp() < ((1f / two) * this.getValueOfHp())) {
                    Strategy first = new FirstStrategy();
                    first.updateCharacteristics(this);
                }
                if (this.getHp() < ((1f / three) * this.getValueOfHp())) {
                    Strategy second = new SecondStrategy();
                    second.updateCharacteristics(this);
                }
                break;
            case Pyromancer:
                if (((1f / four) * this.getValueOfHp()) < this.getHp()
                        && this.getHp() < ((1f / three) * this.getValueOfHp())) {
                    Strategy first = new FirstStrategy();
                    first.updateCharacteristics(this);
                }
                if (this.getHp() < ((1f / four) * this.getValueOfHp())) {
                    Strategy second = new SecondStrategy();
                    second.updateCharacteristics(this);
                }
                break;
            case Rogue:
                final float five = 5f;
                final float seven = 7f;
                if (((1f / seven) * this.getValueOfHp()) < this.getHp()
                        && this.getHp() < ((1f / five) * this.getValueOfHp())) {
                    Strategy first = new FirstStrategy();
                    first.updateCharacteristics(this);
                }
                if (this.getHp() < ((1f / seven) * this.getValueOfHp())) {
                    Strategy second = new SecondStrategy();
                    second.updateCharacteristics(this);
                }
                break;
            case Wizard:
                if (((1f / four) * this.getValueOfHp()) < this.getHp()
                        && this.getHp() < ((1f / two) * this.getValueOfHp())) {
                    Strategy first = new FirstStrategy();
                    first.updateCharacteristics(this);
                }
                if (this.getHp() < ((1f / four) * this.getValueOfHp())) {
                    Strategy second = new SecondStrategy();
                    second.updateCharacteristics(this);
                }
                break;
            default:
                System.out.println("Invalid type");
        }
    }

    /**
     * Implementare design pattern-ul Visitor pentru lupta dintre eroi.
     */
    public abstract void accept(Hero hero);
    public abstract void interactWith(Hero enemy);

    /**
     * Implementare design pattern-ul Visitor pentru eroi-ingeri.
     */
    public abstract void acceptAngel(Angels angel);
}
