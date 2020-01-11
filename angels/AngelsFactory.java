package angels;

import java.util.List;

public final class AngelsFactory {
    private static AngelsFactory instance;
    private AngelsFactory() {

    }
    public static AngelsFactory getInstance() {
        if (instance == null) {
            instance = new AngelsFactory();
        }
        return instance;
    }

    /**
     * Metada ce creeaza ingerii.
     * @param round runda in care actioneaza
     * @param angels lista de ingeri
     * @param angel tipul ingerului ce trebuie creat
     * @param xPos coordonata x de pe harta
     * @param yPos coordonata y de pe harta
     */
    public void createAngels(final int round, final List<Angels> angels, final String angel,
                             final int xPos, final int yPos) {
        switch (angel) {
            case "DamageAngel":
                angels.add(new DamageAngel(round, AngelType.DamageAngel, xPos, yPos));
                break;
            case "DarkAngel":
                angels.add(new DarkAngel(round, AngelType.DarkAngel, xPos, yPos));
                break;
            case "Dracula":
                angels.add(new Dracula(round, AngelType.Dracula, xPos, yPos));
                break;
            case "GoodBoy":
                angels.add(new GoodBoy(round, AngelType.GoodBoy, xPos, yPos));
                break;
            case "LevelUpAngel":
                angels.add(new LevelUpAngel(round, AngelType.LevelUpAngel, xPos, yPos));
                break;
            case "LifeGiver":
                angels.add(new LifeGiver(round, AngelType.LifeGiver, xPos, yPos));
                break;
            case "SmallAngel":
                angels.add(new SmallAngel(round, AngelType.SmallAngel, xPos, yPos));
                break;
            case "Spawner":
                angels.add(new Spawner(round, AngelType.Spawner, xPos, yPos));
                break;
            case "TheDoomer":
                angels.add(new TheDoomer(round, AngelType.TheDoomer, xPos, yPos));
                break;
            case "XPAngel":
                angels.add(new XPAngel(round, AngelType.XPAngel, xPos, yPos));
                break;
            default:
                System.out.println("invalid type of angel");
        }
    }
}
