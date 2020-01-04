package heroes;

public class SecondStrategy implements Strategy {

    @Override
    public final void updateCharacteristics(final Hero hero) {
        float diff = 0;
        int hp = hero.getHp();
        switch (hero.getType()) {
            case Knight:
                final float four = 4f;
                final float bonusK = -0.2f;
                diff = hp / four;
                hp = Math.round(hp + diff);
                hero.setHp(hp);
                hero.setBonus(bonusK);
                break;
            case Pyromancer:
                final float three = 3f;
                final float bonusP = -0.3f;
                diff = hp / three;
                hp = Math.round(hp + diff);
                hero.setHp(hp);
                hero.setBonus(bonusP);
                break;
            case Rogue:
                final float two = 2f;
                final float bonusR = -0.1f;
                diff = hp / two;
                hp = Math.round(hp + diff);
                hero.setHp(hp);
                hero.setBonus(bonusR);
                break;
            case Wizard:
                final float five = 5f;
                final float bonusW = -0.2f;
                diff = hp / five;
                hp = Math.round(hp + diff);
                hero.setHp(hp);
                hero.setBonus(bonusW);
                break;
            default:
                System.out.println("Invalid type");
        }
    }
}
