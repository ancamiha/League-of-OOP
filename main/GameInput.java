package main;

import heroes.Hero;

import java.util.List;

public class GameInput {
    private int linesN;
    private int lengthM;
    private List<String> fields;
    private int nrP; //numarul de personaje
    private List<Hero> heroes; //rasa personajului
    private int rounds;
    private List<String> rDescription; //rundele cu descrierea lor


    public GameInput() {
        linesN = -1;
        lengthM = -1;
        fields = null;
        nrP = -1;
        heroes = null;
        rounds = -1;
        rDescription = null;
    }

    public GameInput(final int linesN, final int lengthM, final List<String> fields,
                     final int nrP, final List<Hero> heroes, final int rounds,
                     final List<String> rDescription) {
        this.linesN = linesN;
        this.lengthM = lengthM;
        this.fields = fields;
        this.nrP = nrP;
        this.heroes = heroes;
        this.rounds = rounds;
        this.rDescription = rDescription;
    }

    public final int getLengthM() {
        return lengthM;
    }
    public final int getLinesN() {
        return linesN;
    }
    public final List<String> getFields() {
        return fields;
    }
    public final int getNrP() {
        return nrP;
    }
    public final List<Hero> getHeroes() {
        return heroes;
    }
    public final int getRounds() {
        return rounds;
    }
    public final List<String> getrDescription() {
        return rDescription;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = fields != null && heroes != null && rDescription != null;
        boolean membersNotEmpty = fields.size() > 0 && heroes.size() > 0
                                && rDescription.size() > 0 && rounds > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
