package heroes;

public class Rogue extends Hero {
    private final int initHP = 600;
    private final int perLVHp = 40;
    private final float landAmplif = 1.15f;

    public Rogue(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }
}
