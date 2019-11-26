package heroes;

public class Wizard extends Hero {
    private final int initHP = 400;
    private final int perLVHp = 30;
    private final float landAmplif = 1.1f;

    public Wizard(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }
}
