package heroes;

public class Pyromancer extends Hero {
    private final int initHP = 500;
    private final int perLVHp = 50;
    private final float landAmplif = 1.25f;

    public Pyromancer(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }
}
