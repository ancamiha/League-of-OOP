package heroes;

import map.TypeOfField;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

public abstract class Hero {
    private final HeroType type;
    private int posX;
    private int posY;
    private int level;
    private int xp;
    private int hp;
    private TypeOfField field;
    public int nrOfRounds;

    private int overtimeRouds;
    private int damage;
    private boolean stillApply;

    public Hero(final HeroType type, final int posX, final int posY) {
        this.type = type;
        this.posX = posX;
        this.posY = posY;

        this.level = 0;
        this.xp = 0;
        this.hp = this.getValueOfHp();
        this.field = TypeOfField.Land;
        this.nrOfRounds = 0;
    }

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
    public final boolean notDead() {
        return this.hp > 0;
    }

    public static void printResult(final List<Hero> heroes, final String outputPath) {
        try {
            System.setOut(new PrintStream(outputPath));
            for (Hero hero : heroes) {
                if (!hero.notDead()) {
                    char c = hero.getType().toString().charAt(0);
                    System.out.println(c + " dead");
                }
                if (hero.notDead()) {
                    char c = hero.getType().toString().charAt(0);
                    System.out.println(c + " " + hero.getLevel() + " " + hero.getXp() + " "
                            + hero.getHp() + " " + hero.getPosX() + " " + hero.getPosY());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printR(final List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (!hero.notDead()) {
                char c = hero.getType().toString().charAt(0);
                System.out.println(c + " dead");
            }
            if (hero.notDead()) {
                char c = hero.getType().toString().charAt(0);
                System.out.println(c + " " + hero.getLevel() + " " + hero.getXp() + " "
                        + hero.getHp() + " " + hero.getPosX() + " " + hero.getPosY());
            }
        }
    }

    public final void moveHero(final char letter) {
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
    }

    @Override
    public final String toString() {
        return "Hero{" + "type=" + type + ", posX=" + posX + ", posY=" + posY + ", level="
                + level + ", xp=" + xp + ", hp=" + hp + ", field=" + field + '}';
    }


    public final void overTimeAbilities(final int overtimeRounds, final int overtimeDamage,
                                        final boolean apply) {
        this.overtimeRouds = overtimeRounds;
        this.damage = overtimeDamage;
        this.stillApply = apply;
    }

    public final int getOvertimeRouds() {
        return overtimeRouds;
    }
    public final int getDamage() {
        return damage;
    }
    public final boolean getStillApply() {
        return stillApply;
    }
    public final void updateStillApply() {
        this.stillApply = false;
    }
    public final void updateOvertimeRounds() {
        this.overtimeRouds--;
    }
    /**
     * Implement Visitor pattern.
     */
    public abstract void accept(Hero hero);
    public abstract void interactWith(Hero enemy);
}
