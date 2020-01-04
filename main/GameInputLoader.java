package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import angels.Angels;
import angels.AngelsFactory;
import fileio.FileSystem;
import heroes.HeroesFactory;
import heroes.Hero;

final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    GameInput load() {
        List<String> fields = new ArrayList<>();
        List<Hero> heroes = new LinkedList<>();
        List<Angels> angels = new LinkedList<>();
        List<String> rDescription = new ArrayList<>();
        int rounds = 0;
        int linesN = 0;
        int lengthM = 0;
        int nrP = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            linesN = fs.nextInt();
            lengthM = fs.nextInt();

            for (int i = 0; i < linesN; ++i) {
                fields.add(fs.nextWord());
            }

            nrP = fs.nextInt();
            for (int i = 0; i < nrP; ++i) {
                HeroesFactory.getInstance().createHeroes(i, heroes, fs.nextWord(),
                                                    fs.nextInt(), fs.nextInt());
            }

            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                rDescription.add(fs.nextWord());
            }

            for (int i = 0; i < rounds; ++i) {
                int nrAngels = fs.nextInt();
                if (nrAngels == 0) {
                    continue;
                }
                for (int j = 0; j < nrAngels; ++j) {
                    String string = fs.nextWord();
                    int k = 0;
                    while (k < string.length() && string.charAt(k) != ',') {
                        k++;
                    }

                    String angel = (String) string.subSequence(0, k);

                    k++;
                    char c1 = string.charAt(k);
                    int xPos = Character.getNumericValue(c1);
                    k = k + 2;
                    char c2 = string.charAt(k);
                    int yPos = Character.getNumericValue(c2);
                    AngelsFactory.getInstance().createAngels(i, angels, angel,
                                                            xPos, yPos);
                }
            }
            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new GameInput(linesN, lengthM, fields, nrP, heroes,
                             rounds, rDescription, angels);
    }
}

