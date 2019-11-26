package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fileio.FileSystem;
import heroes.HeroType;
import heroes.Hero;
import heroes.Pyromancer;
import heroes.Knight;
import heroes.Wizard;
import heroes.Rogue;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        List<String> fields = new ArrayList<>();
        List<Hero> heroes = new LinkedList<>();
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
                switch (fs.nextWord()) {
                    case "P":
                        heroes.add(new Pyromancer(HeroType.Pyromancer, fs.nextInt(), fs.nextInt()));
                        break;
                    case "K":
                        heroes.add(new Knight(HeroType.Knight, fs.nextInt(), fs.nextInt()));
                        break;
                    case "W":
                        heroes.add(new Wizard(HeroType.Wizard, fs.nextInt(), fs.nextInt()));
                        break;
                    case "R":
                        heroes.add(new Rogue(HeroType.Rogue, fs.nextInt(), fs.nextInt()));
                        break;
                    default:
                        System.out.println("invalid type of hero");
                }
            }

            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                rDescription.add(fs.nextWord());
            }

            fs.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return new GameInput(linesN, lengthM, fields, nrP, heroes,
                             rounds, rDescription);
    }
}

