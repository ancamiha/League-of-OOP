package heroes;

public class FirstStrategy implements Strategy {

    @Override
    public final void updateCharacteristics(final Hero hero) {
        float diff = 0f;
        int hp = hero.getHp();
        switch (hero.getType()) {
            case Knight:
                final float five = 5f;
                final float bonusK = 0.5f;
                diff = hp / five;
                hp = Math.round(hp - diff);
                hero.setHp(hp);
                hero.setBonus(bonusK);
                break;
            case Pyromancer:
                final float four = 4f;
                final float bonusP = 0.7f;
                diff = hp / four;
                hp = Math.round(hp - diff);
                hero.setHp(hp);
                hero.setBonus(bonusP);
                break;
            case Rogue:
                final float seven = 7f;
                final float bonusR = 0.4f;
                diff = hp / seven;
                hp = Math.round(hp - diff);
                hero.setHp(hp);
                hero.setBonus(bonusR);
                break;
            case Wizard:
                final float ten = 10f;
                final float bonusW = 0.6f;
                diff = hp / ten;
                hp = Math.round(hp - diff);
                hero.setHp(hp);
                hero.setBonus(bonusW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
