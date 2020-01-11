package main;

import angels.AngelType;
import angels.Angels;
import heroes.Hero;
import heroes.HeroType;
import heroes.PrintResult;
import map.Map;
import map.TypeOfField;
import wizard.ObserveKilled;
import wizard.ObserveKilledByAngel;
import wizard.ObserveAngelAction;
import wizard.ObserveLevelChange;
import wizard.ObserveAppearance;
import wizard.WizardSubject;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.List;

public final class Main {
    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        TypeOfField[][] map = Map.makeMap(gameInput.getLinesN(), gameInput.getLengthM(),
                gameInput.getFields());

        List<Hero> heroes = gameInput.getHeroes();
        List<Angels> angels = gameInput.getAngels();
        try {
            System.setOut(new PrintStream(args[1]));
            for (int i = 0; i < gameInput.getRounds(); i++) {
                WizardSubject subject = new WizardSubject();
                new ObserveKilled(subject);
                new ObserveAppearance(subject);
                new ObserveAngelAction(subject);
                new ObserveKilledByAngel(subject);
                new ObserveLevelChange(subject);
                //
                System.out.println("~~ Round " + (i + 1) + " ~~");
                //se seteaza tipul locatiei pentru fiecare jucator
                for (Hero hero : heroes) {
                    hero.setField(Map.getFieldType(map, hero.getPosX(), hero.getPosY()));
                }
            /*se verifica fiecare jucator pentru a se vedea daca trebuie sa primeasca
            damage overtime*/
                for (int j = 0; j < heroes.size(); j++) {
                    Hero hero = heroes.get(j);
                    if (hero.getStillApply()) {
                        hero.updateHp(hero.getDamage());
                        if (hero.getTime() == 0 || hero.getDontMove() == 0) {
                            hero.updateStillApply();
                        }
                        hero.updateTime();
                    }
                    hero.moveHero(gameInput.getrDescription().get(i).charAt(j));
                    hero.setField(Map.getFieldType(map, hero.getPosX(), hero.getPosY()));
                }
                //sunt aplicate strategiile corespunzatoare
                for (Hero hero : heroes) {
                    if (!hero.getStillApply() && hero.getDontMove() == 0) {
                        hero.chooseStrategy();
                    }
                }
                //lupta
                for (int j = 0; j < heroes.size(); j++) {
                    for (int k = j + 1; k < heroes.size(); k++) {
                        Hero hero1 = heroes.get(j);
                        Hero hero2 = heroes.get(k);
                        if (hero1.getPosX() == hero2.getPosX()
                                && hero1.getPosY() == hero2.getPosY()
                                && hero1.isNotDead() && hero2.isNotDead()) {
                        /*pentru aflarea valorii de damageReceived, jucatorul de tip Wizard
                        trebuie sa fie primul atacat*/
                            if ((hero2.getType()).equals(HeroType.Wizard)) {
                                (hero2).accept(hero1);
                                (hero1).accept(hero2);
                            } else {
                                (hero1).accept(hero2);
                                (hero2).accept(hero1);
                            }

                            if (!hero2.isNotDead() && !hero2.isKilledByAngel()) {
                                hero2.setDead(true);
                                hero2.setKilledByAngel(false);
                                hero1.increaseXP(hero2);
                            }
                            if (!hero1.isNotDead() && !hero2.isKilledByAngel()) {
                                hero1.setDead(true);
                                hero1.setKilledByAngel(false);
                                hero2.increaseXP(hero1);
                            }
                        }
                    }
                }
                //daca nu exista ingeri in joc
                if (angels.size() == 0) {
                    for (int j = 0; j < heroes.size(); j++) {
                        Hero hero1 = heroes.get(j);
                        subject.setAngel(null);
                        subject.setHero1(hero1);
                        for (int k = j + 1; k < heroes.size(); k++) {
                            Hero hero2 = heroes.get(k);
                            if (hero1.getPosX() == hero2.getPosX()
                                    && hero1.getPosY() == hero2.getPosY()) {
                                subject.setHero2(hero2);
                            }
                        }
                        subject.notifyAllObservers();
                    }
                }
                //ingerii apar pe harta si actioneaza asupra eroilor
                for (Angels angel : angels) {
                    if (angel.getActionRound() == i) {
                        for (Hero hero : heroes) {
                            if (hero.getPosX() == angel.getPosX()
                                    && hero.getPosY() == angel.getPosY()
                                    && !hero.isDead()) {
                                hero.acceptAngel(angel);
                                if (hero.getHp() <= 0) {
                                    hero.setDead(true);
                                }
                            }
                            if (hero.getPosX() == angel.getPosX()
                                    && hero.getPosY() == angel.getPosY() && hero.isDead()
                                    && (angel.getType()).equals(AngelType.Spawner)) {
                                hero.acceptAngel(angel);
                                if (hero.getHp() > 0) {
                                    hero.setDead(false);
                                }
                            }
                        }
                    }
                    if (angel.getActionRound() == i) {
                        //Marele Magician observa activitatea eroilor si a ingerilor din joc
                        subject.setAngel(angel);
                    } else {
                        /*Daca pe tura curenta nu exista ingeri, Marele
                        Magician observa doar activitatea eroilor*/
                        subject.setAngel(null);
                    }
                    for (int j = 0; j < heroes.size(); j++) {
                        Hero hero1 = heroes.get(j);
                        subject.setHero1(hero1);
                        for (int k = j + 1; k < heroes.size(); k++) {
                            Hero hero2 = heroes.get(k);
                            if (hero1.getPosX() == hero2.getPosX()
                                    && hero1.getPosY() == hero2.getPosY()) {
                                subject.setHero2(hero2);
                            }
                        }
                        subject.notifyAllObservers();
                    }

                    for (Hero hero : heroes) {
                        hero.setHelped(false);
                    }
                }
                System.out.println();
            }
        System.out.println("~~ Results ~~");
        PrintResult.printR(heroes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
