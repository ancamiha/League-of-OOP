package heroes;

public class Knight extends Hero {
    private final int initHP = 900;
    private final int perLVHp = 80;
    private final float landAmplif = 1.15f;

    public Knight(final HeroType type, final int initPx, final int initPy) {
        super(type, initPx, initPy);
    }
}
