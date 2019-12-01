package heroes;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

/**
 * Singleton class.
 */
public final class PrintResult {
    private static PrintResult instance;
    private PrintResult() {

    }
    public static PrintResult getInstance() {
        if (instance == null) {
            instance = new PrintResult();
        }
        return instance;
    }

    /**
     * Realizeaza scrierea in fisier.
     * @param heroes lista de eroi
     * @param outputPath calea spre fisierul de output
     */
    public static void print(final List<Hero> heroes, final String outputPath) {
//        try {
//            FileWriter fileWriter = new FileWriter(outputPath);
//            for (Hero hero : heroes) {
//                char c = hero.getType().toString().charAt(0);
//                if (!hero.notDead()) {
//                    fileWriter.writeCharacter(c);
//                    fileWriter.writeCharacter(' ');
//                    fileWriter.writeWord("dead");
//                    fileWriter.writeNewLine();
//                }
//                if (hero.notDead()) {
//                    fileWriter.writeCharacter(c);
//                    fileWriter.writeCharacter(' ');
//                    fileWriter.writeInt(hero.getLevel());
//                    fileWriter.writeCharacter(' ');
//                    fileWriter.writeInt(hero.getXp());
//                    fileWriter.writeCharacter(' ');
//                    fileWriter.writeInt(hero.getHp());
//                    fileWriter.writeCharacter(' ');
//                    fileWriter.writeInt(hero.getPosX());
//                    fileWriter.writeCharacter(' ');
//                    fileWriter.writeInt(hero.getPosY());
//                    fileWriter.writeNewLine();
//                }
//            }
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            System.setOut(new PrintStream(outputPath));
            for (Hero hero : heroes) {
                if (!hero.isNotDead()) {
                    char c = hero.getType().toString().charAt(0);
                    System.out.println(c + " dead");
                }
                if (hero.isNotDead()) {
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
            if (!hero.isNotDead()) {
                char c = hero.getType().toString().charAt(0);
                System.out.println(c + " dead");
            }
            if (hero.isNotDead()) {
                char c = hero.getType().toString().charAt(0);
                System.out.println(c + " " + hero.getLevel() + " " + hero.getXp() + " "
                        + hero.getHp() + " " + hero.getPosX() + " " + hero.getPosY());
            }
        }
    }
}
