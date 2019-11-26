package heroes;

public class Hero {
    private final HeroType type;
    private int initPx;
    private int initPy;

    public Hero(final HeroType type, final int initPx, final int initPy) {
        this.type = type;
        this.initPx = initPx;
        this.initPy = initPy;
    }

    @Override
    public final String toString() {
        return "Hero{" + "type='" + type + '\'' + ", initPx=" + initPx + ", initPy=" + initPy + '}';
    }

    public boolean isItDead(final int HP) {
        return  HP <= 0;
    }
    public void moveHero(final int x, final int y) {

    }
}
